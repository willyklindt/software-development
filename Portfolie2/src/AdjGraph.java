import java.util.ArrayList;
import java.util.Collections;

public class AdjGraph {
    public ArrayList<Vertex> vertices;
    ArrayList<Integer> TEUlist = new ArrayList<Integer>();

    public void allTEU() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            int TEU = (currentv.getTEUsent() - currentv.getTEUreceived());
            TEUlist.add(i, TEU);
        }
        System.out.println(TEUlist);
    }

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

    public void printTEU() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            /*
             * System.out.println(" Antal af TEU sendt fra Vertex: " + currentv.getName());
             * // kører på både edges og vertices
             * 
             * System.out.println(currentv.getTEUsent());
             * System.out.println(" Antal af TEU modtaget af Vertex: " +
             * currentv.getName());
             * System.out.println(currentv.getTEUreceived());
             */
            System.out.println(currentv.getName() + ": Total of surplus (TEU) = "
                    + (-(currentv.getTEUsent() - currentv.getTEUreceived())));
        }
    }

    public void reversingFlowCost() {
        Vertex currentv;
        int surplus = 0;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            for (int j = 0; j < currentv.getOutEdges().size(); j++) {
                Edge currente = currentv.getOutEdges().get(j);
                surplus += currente.getWeight();
            }
        }
        System.out.println("Reversing the flow costs: " + surplus * 100 + "$");
    }

    public void cheapestFlow() {
        ArrayList<Integer> TEUplus = new ArrayList<>();
        ArrayList<Integer> TEUminus = new ArrayList<>();
        for (int i = 0; i < TEUlist.size(); i++) {
            if (TEUlist.get(i) > 0) {
                TEUplus.add(TEUlist.get(i));
            } else {
                TEUminus.add(TEUlist.get(i));
            }
        }
        Collections.sort(TEUplus);
        Collections.sort(TEUminus);
        int i = 0;
        int j = 0;
        while (TEUminus.get(i) < TEUminus.size() && TEUplus.get(j) > TEUplus.size()) {
            if (TEUminus.get(i) == 0) {
                i++;
            }
            if (TEUplus.get(j) == 0) {
                j++;
            }
            int tempM = TEUminus.get(i);
            int tempP = TEUplus.get(j);
            // System.out.println(tempM);
            // System.out.println(tempP);
            int calculate = tempM + tempP;
            TEUminus.add(i, calculate);
            // System.out.println(calculate);
        }

        // System.out.println(TEUplus);
        System.out.println(TEUminus);
    }
}

class Vertex implements Comparable<Vertex> { // Comparables bruges så vi kan sortere Vertex (edges), når vi skal bruge
                                             // priority queues
    private String Name;
    private ArrayList<Edge> outEdges;
    private Integer distance = Integer.MAX_VALUE;
    private Integer TEUsent = 0;
    private Integer TEUreceived = 0;

    public Integer getTEUsent() {
        return TEUsent;
    }

    public Integer getTEUreceived() {
        return TEUreceived;
    }

    public void setTEUsent(Integer teu) {

        TEUsent += teu;
    }

    public void setTEUreceived(Integer teu) {
        TEUreceived += teu;
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

    /*
     * public Integer getDistance() {
     * return distance;
     * }
     * 
     * public void setDistance(Integer distance) {
     * this.distance = distance;
     * }
     */

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
        fromVertex.setTEUsent(weight);
        toVertex.setTEUreceived(weight);
    }

}
