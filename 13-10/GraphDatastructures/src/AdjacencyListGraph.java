import java.util.ArrayList;

public class AdjacencyListGraph {
    private ArrayList<Vertex> vertices;
    //Forelæser anbefaler at bruge AdjacencyListGraph, til at lave minimumSpanningTree, da man kan sortere Vertices på baggrund af distances, ved bruge af en queue
    public AdjacencyListGraph(){
        vertices = new ArrayList<Vertex>();
    }
    public void addVertex(Vertex v){
        vertices.add(v);
    }
    public void newEdge(Vertex from, Vertex to, Integer dist){
        if ( ! (vertices.contains(from) && vertices.contains(to)) ) //Tjekker om vertices allerede har en from og to
        {
            System.out.println(" Vertex not found ");
            return;
        }
        Edge newedge = new Edge(from, to, dist);

    }

    public void printGraph(){
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            System.out.println(" Edges from Vertex: " + currentv.getName() );
            for (int j = 0; j < currentv.getOutEdges().size(); j++) { //kører på både edges og vertices
                Edge currente = currentv.getOutEdges().get(j);
                System.out.println("To " + currente.getToVertex().getName() + " weight " + currente.getWeight()); //vi har currentv, og getToVertex er så næste Vertex i rækken
            }
            System.out.println(" ");
        }
    }
}

class Vertex implements Comparable<Vertex>{ //Comparables bruges så vi kan sortere Vertex (edges), når vi skal bruge priority queues
    private String Name;
    private ArrayList<Edge> outEdges;
    private Integer distance = Integer.MAX_VALUE;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Edge> getOutEdges() {
        return outEdges;
    }

    public void setOutEdges(ArrayList<Edge> outEdges) {
        this.outEdges = outEdges;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Vertex(String id) //Constructor
    {
        this.Name = id;
        outEdges = new ArrayList<>();

    }
    public void addOutEdge (Edge outEdge){
        outEdges.add(outEdge);
    }

    @Override
    public int compareTo(Vertex o) { //Bruges til sortering
        if (this.distance < o.distance)
        {
            return -1;
        }
        if (this.distance > o.distance)
        {
            return 1;
        }
        return 0;
    }
}

class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    private Integer weight;

    public Edge (Vertex from, Vertex to, Integer cost){ //Constructor
        fromVertex = from;
        toVertex = to;
        weight = cost;
        from.addOutEdge(this); //denne gør at vi i main kan oprettet Edge, uden også at skulle kalde på addOutEdge
    }
}
