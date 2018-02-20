package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {
	
	private final Map<Integer, List<Vertex>> vertices;
	
	public Graph() {
		this.vertices = new HashMap<Integer, List<Vertex>>();
	}
	
	public void addVertex(Integer character, List<Vertex> vertex) {
		this.vertices.put(character, vertex);
	}
	
	public List<Integer> getShortestPath(Integer start, Integer finish) {
		final Map<Integer, Float> distances = new HashMap<Integer, Float>();
		final Map<Integer, Vertex> previous = new HashMap<Integer, Vertex>();
		PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();
		
		for(Integer vertex : vertices.keySet()) {
			if (vertex == start) {
				distances.put(vertex, (float) 0);
				nodes.add(new Vertex(vertex, 0,0));
			} else {
				distances.put(vertex, Float.MAX_VALUE);
				nodes.add(new Vertex(vertex, Integer.MAX_VALUE,Integer.MAX_VALUE));
			}
			previous.put(vertex, null);
		}
		
		while (!nodes.isEmpty()) {
			Vertex smallest = nodes.poll();
			if (smallest.getId() == finish) {
				final List<Integer> path = new ArrayList<Integer>();
				while (previous.get(smallest.getId()) != null) {
					path.add(smallest.getId());
					smallest = previous.get(smallest.getId());
				}
				return path;
			}

			if (distances.get(smallest.getId()) == Float.MAX_VALUE) {
				break;
			}
						
			for (Vertex neighbor : vertices.get(smallest.getId())) {
				Float alt = distances.get(smallest.getId()) + neighbor.getWeight();
				if (alt < distances.get(neighbor.getId())) {
					distances.put(neighbor.getId(), alt);
					previous.put(neighbor.getId(), smallest);
					
					forloop:
					for(Vertex n : nodes) {
						if (n.getId() == neighbor.getId()) {
							nodes.remove(n);
							n.setWeight(alt);
							nodes.add(n);
							break forloop;
						}
					}
				}
			}
		}
		
		return new ArrayList<Integer>(distances.keySet());
	}
	
}