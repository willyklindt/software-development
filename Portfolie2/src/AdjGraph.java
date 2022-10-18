import java.util.ArrayList;

public class AdjGraph {
    public ArrayList<Vertex> vertices;

    // Forelæser anbefaler at bruge AdjacencyListGraph, til at lave
    // minimumSpanningTree, da man kan sortere Vertices på baggrund af distances,
    // ved bruge af en queue
    public AdjGraph() {
        vertices = new ArrayList<Vertex>();
        // int TEUsent;
    }

    public void addVertex(Vertex v) {
        vertices.add(v);

    }

    public void newEdge(Vertex from, Vertex to, Integer TEU) {
        if (!(vertices.contains(from) && vertices.contains(to))) // Tjekker om vertices allerede har en from og to
        {
            System.out.println(" Vertex not found ");
            return;
        }
        Edge newedge = new Edge(from, to, TEU);

    }

    public void printGraph() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            System.out.println(" Edges from Vertex: " + currentv.getName());
            for (int j = 0; j < currentv.getOutEdges().size(); j++) { // kører på både edges og vertices
                Edge currente = currentv.getOutEdges().get(j);
                System.out.println("To " + currente.getToVertex().getName() + " weight " + currente.getWeight());
            }
            System.out.println(" ");
        }
    }

    public void printSurplus() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            int surplus = 0;
            int recived = 0;
            currentv = vertices.get(i);
            System.out.println("Surplus of vertex: " + currentv.getName());
            for (int j = 0; j < currentv.getOutEdges().size(); j++) {
                Edge currente = currentv.getOutEdges().get(j);
                surplus += currente.getWeight();
                
            }
            System.out.println(surplus);
        }
    }
}

class Vertex implements Comparable<Vertex> { // Comparables bruges så vi kan sortere Vertex (edges), når vi skal bruge
                                             // priority queues
    private String Name;
    private ArrayList<Edge> outEdges;
    private Integer distance = Integer.MAX_VALUE;
    private Integer TEUsent;

    public void TEUsent() {
        Vertex currentv;
    }

    public void setTEUsent(Integer teu) {
        TEUsent = teu;
    }

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

    /*public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }*/

    public Vertex(String Origin) // Constructor
    {
        this.Name = Origin;
        outEdges = new ArrayList<>();
    }

    public void addOutEdge(Edge outEdge) {
        outEdges.add(outEdge);
       
    }

    @Override
    public int compareTo(Vertex o) { // Bruges til sortering
        if (this.distance < o.distance) {
            return -1;
        }
        if (this.distance > o.distance) {
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

    public Edge(Vertex from, Vertex to, Integer cost) { // Constructor
        fromVertex = from;
        toVertex = to;
        weight = cost;
        from.addOutEdge(this); // denne gør at vi i main kan oprettet Edge, uden også at skulle kalde på
        // addOutEdge
        from.setTEUsent(this.weight);
    }

}
