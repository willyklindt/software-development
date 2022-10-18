import java.util.ArrayList;
import java.util.Arrays;

public class App {
    //Forelæser anbefaler at bruge AdjacencyListGraph, til at lave minimumSpanningTree, da man kan sortere Vertices på baggrund af distances, ved bruge af en queue
    public static void main(String[] args) {
	
        AdjGraph adjgraph = new AdjGraph(); //man behøver ikke at parse noget til denne, altså vi behøves ikke at angave hvor mange Vertixes der er her
        Vertex A     = new Vertex("0");
        adjgraph.addVertex(A);

        Vertex B = new Vertex("1");
        adjgraph.addVertex(B);

        Vertex C = new Vertex("2");
        adjgraph.addVertex(C);

        Vertex D = new Vertex("3");
        adjgraph.addVertex(D);

        Vertex E = new Vertex("4");
        Vertex F = new Vertex("5");

        Vertex G = new Vertex("6");
        adjgraph.addVertex(E);
        adjgraph.addVertex(F);
        adjgraph.addVertex(G);
        adjgraph.newEdge(A, B, 1);
        adjgraph.newEdge(A, C, 5);
        adjgraph.newEdge(A, E, 3);

        adjgraph.newEdge(B, E, 1);
        adjgraph.newEdge(B, F, 7);

        adjgraph.newEdge(C, D, 1);

        adjgraph.newEdge(D, E, 1);
        adjgraph.newEdge(D, G, 1);

        adjgraph.newEdge(E, C, 1);
        adjgraph.newEdge(E, D, 3);
        adjgraph.newEdge(E, F, 3);
        adjgraph.newEdge(E, G, 4);

        adjgraph.newEdge(F, G, 1);

        adjgraph.printGraph();

        // Nedenstående er Djirty shortest path, som køres på AdjancencyList
        int n = adjgraph.vertices.size();
        boolean[] done = new boolean[n];
        Vertex[] prev = new Vertex[n];
        int[] weight = new int[n];
        Arrays.fill(weight, 1000000);
        Arrays.fill(done, false);
        weight[0] = 0;
        prev[0] = adjgraph.vertices.get(0);


        Vertex cur = null;
        int wgt = 10000;
        for (int i = 0; i < n; i++) {
            if (weight[i] < wgt && !done[i])
            {
                cur = adjgraph.vertices.get(i);
                wgt = weight[i];
            }
            System.out.println("cur " + cur);
        }


        for (int i = 0; i < n ; i++) {
            System.out.println(i + " " + done[i] + " " + prev[i] + " " + weight[i]); //Mangler toString i klasse AdjancencyListGraph. Se forelæsers kode, 13-10
        }

    }
}
