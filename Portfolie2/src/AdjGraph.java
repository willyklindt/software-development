import java.util.ArrayList;
import java.util.Collections;

public class AdjGraph {
 
    public ArrayList<Vertex> vertices;
    ArrayList<Integer> TEUlist = new ArrayList<Integer>();

    public void allTEU() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            int TEU = -(currentv.getTEUsent() - currentv.getTEUreceived()); //har tilføjet - foran ligesom i printTEU
            TEUlist.add(i, TEU);
        }
        Collections.sort(TEUlist);
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
                    + (-(currentv.getTEUsent() - currentv.getTEUreceived()))); //Hvorfor minus foran currentv, men det ser ud til at virke???
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
        System.out.println("minus " + TEUminus + "plus " + TEUplus);
        int i = 0;
        int j = 0;
        
       // Integer desiredStock = 0;
        
        while (i < TEUminus.size()-1 && j < TEUplus.size()-1) { //Virkede ikke med den anden i lavede boys. Men nu er problemet, at TEUMinus listen er på 3, TEUPlus er på 4. Så den stopper før den har løbet alt igennem
           
           
            if (TEUminus.get(i) == 0 ) {
               //TEUminus.remove(i);
               System.out.println("Tjek om TEUminis == 0 virker"); 
               i++;
                
                
            }
           if (TEUplus.get(j) == 0) {
               // TEUplus.remove(j);
                System.out.println("Tjek om TEUPlus == 0 virker");
                j++;
                
            }
            int tempM = TEUminus.get(i);
            int tempP = TEUplus.get(j);
            int min = Math.min(tempP, tempM );
            //int calculate;

            System.out.println("tempM is: " + tempM);
             System.out.println("tempP is: " + tempP);

             if (tempP > tempM*-1) // Forsøg på at tjekke om temP er større end tempM, hvis den er så skal tempP sættes til samme som tempM. Altså så man ikke putter fx. 5000 TEU i en med -2000
             {
                
               tempP = tempP-tempM*-1;
               
                System.out.println( "Værdi af nye tempP" + tempP);
             } 
             
            int calculate = tempM + tempP; // Vi mangler basically en calculate til TEUplus. Hvordan regner vi ud, hvor meget TEU der er i TEUplus, efter den har puttet TEU i TEUminus?
            
             
            TEUplus.set(j,0); // virker ikke ift at opdatere TEUPlus, den bliver altid sat til 0, uanset om der var flere TEU i den
            TEUminus.set(i, calculate);
          
          //  TEUplus.set(j,tempP);
             System.out.println(calculate);

           //  i++;
          //  j++;

           
             
        }

         System.out.println("Listen af TEUPlus: " + TEUplus);
       System.out.println("Listen af TEUMinu: " + TEUminus);
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
