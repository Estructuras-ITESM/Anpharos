package anpharos.structures.Graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created on 5/6/17.
 */
public class GraphNode {
    private String name = "";
    //private Map<String, Integer> adjacentGraphNodes;

    GraphNode(String name) {
        this.name = name;
        //adjacentGraphNodes = new HashMap<>();
    }

    /*public void addAdjNode(String name, int weight) {
        adjacentGraphNodes.put(name, weight);
    }*/

    public String getName(){
        return name;
    }

   /* public Integer getWeight(String destCity){
        System.out.println(adjacentGraphNodes.containsKey(destCity));
        return adjacentGraphNodes.get(destCity);
    }*/

  /*  public Map<String, Integer> getAdjacentGraphNodes() {
        return adjacentGraphNodes;
    }*/

    public String toString() {
        /*StringBuilder tmp = new StringBuilder();
        tmp.append(this.name);
        //adjacentGraphNodes.forEach((k,v) -> tmp.append("-> " + v + " " + k ));
        adjacentGraphNodes.forEach((key, value) -> {
            //tmp.append("\n Key: " + key + " Type:" + key.getClass().getName() + " Value: " + value + " type: " + value.getClass().getName() );
            tmp.append("-> " + key + " " + value );
        });
        return tmp.toString();
        //return "Bye";*/
        return name;
    }


    public static void main(String[] args) {
        /*GraphNode tmp = new GraphNode("Barcelona");
        tmp.addAdjNode( "Madrid", 10);
        tmp.addAdjNode( "Coruña", 20);
        tmp.addAdjNode( "Valencia", 30);
        tmp.addAdjNode( "San José", 40);
        tmp.addAdjNode( "Santa fe", 40);
        System.out.println(tmp);
        System.out.println(tmp.getWeight("San José"));*/
    }

}
