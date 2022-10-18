import java.util.ArrayList;

public class AdjGraph {
    ArrayList<Vertex> Vertices;
    
    public AdjGraph(){
        Vertices = new ArrayList<Vertex>();
    }
    public void addVertex(Vertex v){
        Vertices.add(v);
    }
    public void addEdge(Vertex from, Vertex to, Integer weight){
        if(!(Vertices.contains(from) && Vertices.contains(to)))
        {
            System.out.println("Vertices missing from graph");
            return;
        }
        Edge newE = new Edge(from, to, weight);

    }
    public void addUnDirectedEdge(Vertex from, Vertex to, Integer weight){
        if(!(Vertices.contains(from) && Vertices.contains(to)))
        {
            System.out.println("Vertices missing from graph");
            return;
        }
        Edge newE = new Edge(from, to, weight);
        Edge newE2 = new Edge(to, from, weight);
    }
    public void PrintGraph(){
        /*for(int i=0;i<Vertices.size();i++){
            System.out.println(" Vertex "+Vertices.get(i).name+" is connecte to: ");
            Vertex current=Vertices.get(i);
            for (Edge e: current.OutEdge) {
                System.out.println(e.to.name +" with weight: "+e.weight);
            }
        }*/
    }
}
