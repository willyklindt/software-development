public class MatrixGraph {
    int[][] matrixedgegraph; //liste som indholder edges
    int [][]matrixweightgraph;

    MatrixGraph(int vertices){ //Constructor, har parameter vertices, altså antallet af vertices
        matrixedgegraph = new int[vertices][vertices];
        matrixweightgraph = new int [vertices][vertices];
    }
    public void addEdge(int from, int to, int weight) //from = hvor edge kommer fra, to = hvor edge går til
    {
        matrixedgegraph[from][to] = 1;
        matrixweightgraph[from][to] = weight;
    }

    public void printGraph(){
        for (int fromi = 0; fromi < matrixedgegraph.length; fromi++) {
            System.out.println("Edges from vertex " + fromi);
            for (int toj = 0; toj < matrixedgegraph.length; toj++) {
                if (matrixedgegraph[fromi][toj] ==1)
                {
                    System.out.println( " To " + toj);
                    System.out.println(" weight " + matrixweightgraph[fromi][toj]);
                }
            }
            System.out.println(" ");
        }
    }
}
