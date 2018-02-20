package engine;

import structure.*;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public CSVReader(Graph g,String gi) {
    	
    	

        String csvFile = "A:/work/MST GRAD COURSES/Fall17/Pervasive/NewProject/BikersGuide3/src/data/"+gi+".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] nodes = line.split(cvsSplitBy);
                List<Vertex> list = new ArrayList<Vertex>();
                System.out.println(nodes[0] + " : ");
                for(int i=1;i<nodes.length-2;i=i+3)
                {
                	if(i>=nodes.length)
                		break;
                	System.out.println("["+nodes[i]+","+nodes[i+1]+","+nodes[i+2]+"]");
                	list.add(new Vertex(Integer.parseInt(nodes[i]),Integer.parseInt(nodes[i+1]),Integer.parseInt(nodes[i+2])));
                }
                g.addVertex(Integer.parseInt(nodes[0]), list);

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

    }

}