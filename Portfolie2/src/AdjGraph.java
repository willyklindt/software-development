import java.util.ArrayList;

public class AdjGraph { //Defines the AdjancencyGraph class

    private ArrayList<Vertex> vertices; //ArrayList which containers all our vertices in our AdjencencyGraph
    private int pricePerUnit = 100;

    private int priceOfReversing; //int variable to store price of Reversing flow. 
    private int priceOfMinimizing;

    public AdjGraph() { //Class constructur

        vertices = new ArrayList<Vertex>(); //Initializes a new Arraylist 
    }

    public void addVertex(Vertex v) { //Method that add vertices to our ArrayList, takes a Vertex as a parameter

        vertices.add(v); //Adds Vertex v, to our ArrayList vertices
    }

    public void newEdge(Vertex from, Vertex to, Integer TEU) { //Adds a new edge between two Vertices, and adds the weights of the note (TEU)

        if (!(vertices.contains(from) && vertices.contains(to))) // Checks wheither or not the two vertices exists
        {
            System.out.println(" Vertex not found "); //if the two vertices doesn't exist, then return. 
            return;
        }
        Edge newedge = new Edge(from, to, TEU); //Otherwise create a new edge 
    }


    public void calcTEUStock() { //Method that calculates the surplus/deficit of the ports
        Vertex currentv; //Local temporary vertex

        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            currentv.setTEUtotal(-currentv.getTEUsent(), -currentv.getTEUreceived()); //Uses the method setTEUtotal(parses the two arguments requiered). The total TEU is set to sent-received TEU.
        }
    }

    public void printTEU() { //Method that prints the surplus/deficit of the ports
        
        //Adding space, making it more readable in the console
        System.out.println(" ");
        System.out.println("-------------");
        System.out.println(" ");

        Vertex currentv; //Local temporary vertex
        
        for (int i = 0; i < vertices.size(); i++) { //For loop that iterates over list of our list of vertices, and prints the name and total TEU stock to console
            currentv = vertices.get(i);
            System.out.println(currentv.getName() + ": Total of surplus/deficit (TEU) = "
                    + (currentv.getTEUtotal())); 
        }
    }

    
    public void reversingFlowCost() { //Method that calculates cost of reversing flow
        Vertex currentv; //Local temporary vertex

        System.out.println(" ");
        System.out.println("-------------");
        System.out.println(" ");
        

        for (int i = 0; i < vertices.size(); i++) { // Doublenestet for loop. 
            currentv = vertices.get(i);
            for (int j = 0; j < currentv.getOutEdges().size(); j++) {
                Edge currente = currentv.getOutEdges().get(j);
                priceOfReversing += currente.getWeight()*pricePerUnit; //cost is updated with the values from method getWeight, which is the TEU of ports
            }
        }
        System.out.println("Reversing the flow costs: " + priceOfReversing + "$");
    }

    public void cheapestFlow() { //Method to calculate cheapest flow (solving the minimum cashflow problem)
      
       
        ArrayList<Vertex> TEUplus = new ArrayList<>(); // used to store vertices with TEU surplus
        ArrayList<Vertex> TEUminus = new ArrayList<>(); // used to store vertices with TEU deficit
      
       Vertex currentvertex; //Local temporary vertex
     

        //For loop that adds vertices to correct list, either surplus or deficit 
        for (int i = 0; i < vertices.size(); i++) {
            currentvertex = vertices.get(i);
            if (currentvertex.getTEUtotal() > 0) {
                TEUplus.add(currentvertex);
            } else if (currentvertex.getTEUtotal() < 0) {
                TEUminus.add(currentvertex);
            }
        }

        System.out.println("(Minus) Ports with containers to be moved: " + TEUminus);
        System.out.println("(Plus) Ports with containers to be moved: " + TEUplus);

        while(TEUminus.size() > 0 && TEUplus.size() > 0) { //Whle TEUminus and TEUplus list is greater than 0 (meaning list is not empty)
            //Temp strings that stores the current iteration of the TEUminus and TEUplus names, that we're comparing
            String TEUminusTemp = TEUminus.get(TEUminus.size() -1 ).getName();
            String TEUplusTemp = TEUplus.get(TEUplus.size() -1 ).getName();

            //Temp ints that stores the current iteration of the TEUminus and TEUplus stock, that we're comparing
            int tempM = -TEUminus.get(TEUminus.size() - 1).getTEUtotal();
            int tempP = TEUplus.get(TEUplus.size() - 1).getTEUtotal();
          
             //Finds the min value of the comparison of tempM and tempP.    
            int findMinimum = Math.min(tempM, tempP);
            
        System.out.println(" ");
        System.out.println("-------------");
        

            System.out.println(TEUplusTemp + " in stock: " + tempP);
            System.out.println(TEUminusTemp + " in stock: "  + -tempM);
            
            System.out.println(" ");

            System.out.println("Transfering " + findMinimum + " TEU from: " + TEUplusTemp + " to: " + TEUminusTemp);
            priceOfMinimizing += findMinimum*pricePerUnit; //Total cost is updated
        
    
            //Updates TEU values of TEUminus and TEUplus. In other words, transfering containers between the ports
           TEUminus.get(TEUminus.size() - 1).updateTEUtotal(TEUminus.get(TEUminus.size() - 1).getTEUtotal()+findMinimum);
           TEUplus.get(TEUplus.size() - 1).updateTEUtotal(TEUplus.get(TEUplus.size() - 1).getTEUtotal()-findMinimum);

           System.out.println(" ");
           System.out.println(TEUplusTemp + " new stock is: " + TEUplus.get(TEUplus.size() - 1).getTEUtotal());
           System.out.println(" ");
           System.out.println(TEUminusTemp + " new stock is: "  + TEUminus.get(TEUminus.size() - 1).getTEUtotal());

            if(TEUminus.get(TEUminus.size() -1 ).getTEUtotal() == 0) {
                
                System.out.println("Now removing: " + TEUminusTemp + " from list... Initial stock amount have been satisfied..");
                TEUminus.remove(TEUminus.size() - 1);
             //if current iteration of TEUminus TEU value == 0, then it got correct amount of stock and is removed.
               
            }
            if(TEUplus.get(TEUplus.size() -1 ).getTEUtotal() == 0 && TEUplus.size() > 0 ) {
                
                System.out.println("Now removing: " + TEUplusTemp + " from list... Initial stock amount have been satisfied..");
                TEUplus.remove(TEUplus.size() - 1);
             
               
             
        }
        System.out.println(" ");
        System.out.println("-------------");
        System.out.println("Ports with minus stock: " + TEUminus);
        System.out.println("Ports with plus stock: " + TEUplus);
        System.out.println("The total cost of transfer was: " + priceOfMinimizing + "$");
        System.out.println("Money saved by using minimum cashflow " + (priceOfReversing - priceOfMinimizing) + "$");
        

       
        
    }

}

}

class Vertex  { 

    //Instance variables. Private and is set/received with get/setter methods
    private String Name; //name of vertex
    private ArrayList<Edge> outEdges; //ArrayList of vertices edges
    private Integer TEUsent = 0; //Counter for amount of TEU sent
    private Integer TEUreceived = 0; //Counter for TEU received
    private Integer TEUtotal = 0; //counter for TEU in total (TEUsent-TEUreceived)

    public Integer getTEUsent() { //Getter
        return TEUsent;
    }

    public Integer getTEUreceived() { //Getter
        return TEUreceived;
    }

    public Integer getTEUtotal (){ //Getter
        return TEUtotal;
    }

    public String getName() { //Getter
        return Name;
    }

    public ArrayList<Edge> getOutEdges() { //Getter
        return outEdges;
    }

    public void setTEUsent(Integer teu) { //Setter

        TEUsent += teu;
    }

    public void setTEUreceived(Integer teu) { //Setter
        TEUreceived += teu;
    }

   
    public void setTEUtotal (Integer teusent, Integer teurecieved){ //Setter. Used to initially set TEUtotal
        TEUtotal = teusent - teurecieved;
    }

    public void updateTEUtotal (Integer teu){ //Setter. Used to update TEUtotal, only after it already has been initialized
        TEUtotal = teu;
    }

    public void setName(String name) { //Setter
        Name = name;
    }

    public void setOutEdges(ArrayList<Edge> outEdges) { //Setter
        this.outEdges = outEdges;
    }
    @Override
    public String toString() { //toString methods that overrides Java's toString. Used to define how we want to print our object to the console
        return " || " + this.Name + ", stock: " +Integer.toString(TEUtotal) + " || ";
        
    }

    public Vertex(String Origin) // Constructor
    {
        this.Name = Origin;
        outEdges = new ArrayList<>();
    }

    public void addOutEdge(Edge outEdge) {
        outEdges.add(outEdge);

    }

  
}

class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;
    private Integer weight;

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

    
    public Edge(Vertex from, Vertex to, Integer cost) { // Constructor
        fromVertex = from;
        toVertex = to;
        weight = cost;
        
        fromVertex.addOutEdge(this); // Calls the method addOutEdge with arguments (Vertex from, Vertex to, Integer cost). IE. constructs a new edge object
        fromVertex.setTEUsent(weight); //Calls method setTEUsent, with arguments (weight). This sets the sent TEU of the edge
        toVertex.setTEUreceived(weight); //calls the method set TEUreceived, with the argument (weight). This sets the received TEU of the edge
    }

}
