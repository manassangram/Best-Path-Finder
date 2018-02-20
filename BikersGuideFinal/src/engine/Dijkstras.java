package engine;

import structure.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstras {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Graph input");
		String graphfile = sc.next();
		System.out.println("Enter Test input");
		String test = sc.next();
		
		long startTime = System.currentTimeMillis();
		int counter = 0;
		
		Graph g = new Graph();
		new CSVReader(g,graphfile);
		Integer source;
		Integer destination;
		String csvFile = "A:/work/MST GRAD COURSES/Fall17/Pervasive/NewProject/BikersGuide3/src/data/"+test+".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	counter++;

                // use comma as separator
                String[] ids = line.split(cvsSplitBy);
                source = Integer.parseInt(ids[0]); 
                destination = Integer.parseInt(ids[1]);
                System.out.println("Source : "+source + "	Destination : "+destination);
                
        		List<Integer> l = g.getShortestPath(source, destination);
        		l.add(source);
        		Integer c;
        		for(int i=l.size();i>0;i--)
        		{
        			c = l.remove(i-1);
        			l.add(c);
        		}
        		System.out.println(l);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		/*
		g.addVertex('A', Arrays.asList(new Vertex('B', 700,200), new Vertex('C', 800,10)));
		g.addVertex('B', Arrays.asList(new Vertex('A', 700,-200), new Vertex('F', 200,-70)));
		g.addVertex('C', Arrays.asList(new Vertex('A', 800,-10), new Vertex('F', 600,-20), new Vertex('G', 400,-10)));
		g.addVertex('D', Arrays.asList(new Vertex('F', 800,100)));
		g.addVertex('E', Arrays.asList(new Vertex('H', 100,-50)));
		g.addVertex('F', Arrays.asList(new Vertex('B', 200,70), new Vertex('C', 600,20), new Vertex('D', 800,-100), new Vertex('G', 900,-10), new Vertex('H', 300,-35)));
		g.addVertex('G', Arrays.asList(new Vertex('C', 400,10), new Vertex('F', 900,10)));
		g.addVertex('H', Arrays.asList(new Vertex('E', 100,50), new Vertex('F', 300,35)));
		*/
        
/*		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter source");
		Integer source = Integer.parseInt(sc.next());
		System.out.println("Enter destination");
		Integer destination = Integer.parseInt(sc.next());
*/

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("No. of Test Cases: "+counter);
        System.out.println("Execution Time:"+totalTime);
	}
	
	
}



