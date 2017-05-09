package anpharos.structures.Graph;

import java.util.*;

/**
 * Created on 5/6/17.
 */
public class WeightedDigraph {
    Map<GraphNode, ArrayList<Edge>> adjList;
    Map<GraphNode, Integer> nodePosition;
    Map<String, GraphNode> nodeName;
    int size, count;

    public WeightedDigraph(ArrayList<String> nodes) {
        adjList = new LinkedHashMap<>();
        nodePosition = new LinkedHashMap<>();
        nodeName = new LinkedHashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            nodeName.put(nodes.get(i), new GraphNode(nodes.get(i)));
            nodePosition.put(nodeName.get(nodes.get(i)), i);
        }
        size = nodes.size();
        count = 0;
    }

    public int getNodePosition(String name) {
        GraphNode tmpNode = this.nodeName.get(name);
        return this.nodePosition.get(tmpNode);
    }
    public int getNodePosition(GraphNode node) {
        return this.nodePosition.get(node);
    }

    public GraphNode getNodeRef(String name) {
        return this.nodeName.get(name);
    }

    public void addNodeRelationship(String origin, String destination, int weight) {
        GraphNode tmpOrigin = nodeName.get(origin);
        GraphNode tmpDestination = nodeName.get(destination);
        //System.out.println("Origin "  + tmpOrigin + " Destination " + tmpDestination);
        if (adjList.containsKey(tmpOrigin)) {
            ArrayList<Edge> tmpOriginAdj = adjList.get(tmpOrigin);
            tmpOriginAdj.add(new Edge(tmpOrigin, tmpDestination, weight));
            adjList.put(tmpOrigin, tmpOriginAdj);
        } else {
            ArrayList<Edge> tmpOriginAdj = new ArrayList<>();
            tmpOriginAdj.add(new Edge(tmpOrigin, tmpDestination, weight));
            adjList.put(tmpOrigin, tmpOriginAdj);
        }
    }

    public void addBinaryNodeRelationShip(String origin, String destination, int weight){
        addNodeRelationship(origin, destination, weight);
        addNodeRelationship(destination, origin,weight);
    }

    public int[][] toMatrix() {
        int[][] matrix = new int[size][size];
        int j = 0, i = 0;
        for (String node : nodeName.keySet()) {
            //System.out.println(node);
            if (adjList.containsKey(nodeName.get(node))) {
                for (Edge e : adjList.get(nodeName.get(node))) {
                    System.out.println(e);
                    i = this.getNodePosition(e.from);
                    j = this.getNodePosition(e.to);
                    matrix[i][j] = e.weight;
                    //matrix[j][i] = e.weight; //Only if can go back
                }
            }
        }
        return matrix;
    }

    public String toStringMatrix() {
        int[][] matrix = this.toMatrix();
        System.out.println(matrix.length);
        StringBuilder tmp = new StringBuilder();

        for (String key : nodeName.keySet()) {
            System.out.print("\t" + key);
        }
        System.out.println("");

        int i = 0, j = 0;
        for (String key : nodeName.keySet()) {
            System.out.print(key + " \t");
            for ( j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
                //System.out.print(0+" ");
            }
            System.out.println();
            i++;
        }

        System.out.println();
        for (int i2= 0; i2 < matrix.length; i2++) {
            for (int j2 = 0; j2 < matrix[i2].length; j2++) {
                System.out.print(matrix[i2][j2] + " ");
            }
            System.out.println();
        }
        //System.out.println("");
        return tmp.toString();
    }

    public String toString() {
        StringBuilder tmp = new StringBuilder();
        adjList.forEach((k, v) -> tmp.append(v + "\n"));
        return tmp.toString();
    }

    public static String hashMapToString(Map map) {
        StringBuilder tmp = new StringBuilder();
        map.forEach((k,v) -> tmp.append("Key: " + k + " Value: "+ v + "\n" ));
        return tmp.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> nodes = new ArrayList<>();
//        nodes.add(new String("Barcelona"));
//        nodes.add(new String("Madrid"));
//        nodes.add(new String("Coruña"));
//        nodes.add(new String("Valencia"));
//        nodes.add(new String("San José"));
//        nodes.add(new String("Valladolid"));
//        nodes.add(new String("León"));
//        WeightedDigraph tmp = new WeightedDigraph(nodes);
//        tmp.addBinaryNodeRelationShip("Barcelona", "Madrid", 10);
//        tmp.addBinaryNodeRelationShip("Barcelona", "Coruña", 20);
//        tmp.addNodeRelationship("Barcelona", "León", 40);
//        tmp.addNodeRelationship("Madrid", "Valencia", 30);
//        tmp.addNodeRelationship("Madrid", "San José", 40);
//        tmp.addNodeRelationship("Madrid", "Valladolid", 50);
        nodes.add("0");
        nodes.add("1");
        nodes.add("2");
        nodes.add("3");
        nodes.add("4");
        nodes.add("5");
        nodes.add("6");
        nodes.add("7");
        nodes.add("8");
        WeightedDigraph tmp = new WeightedDigraph(nodes);
        tmp.addBinaryNodeRelationShip("0","1", 4);
        tmp.addBinaryNodeRelationShip("0","7",8);
        tmp.addBinaryNodeRelationShip("1","2",8);
        tmp.addBinaryNodeRelationShip("1","7",11);
        tmp.addBinaryNodeRelationShip("2","3",7);
        tmp.addBinaryNodeRelationShip("2","8",2);
        tmp.addBinaryNodeRelationShip("2","5",4);
        tmp.addBinaryNodeRelationShip("3","4",9);
        tmp.addBinaryNodeRelationShip("3","5",14);
        tmp.addBinaryNodeRelationShip("4","5",10);
        tmp.addBinaryNodeRelationShip("5","6",2);
        tmp.addBinaryNodeRelationShip("6","7",1);
        tmp.addBinaryNodeRelationShip("6","8",6);
        tmp.addBinaryNodeRelationShip("7","8",7);
        System.out.println(tmp.hashMapToString(tmp.nodeName));
        System.out.println(tmp.hashMapToString(tmp.nodePosition));
        System.out.println(tmp.hashMapToString(tmp.adjList));
        System.out.println(tmp);
        System.out.println(tmp.toStringMatrix());
    }
}
