public class Main {
    //Forelæser anbefaler at bruge AdjacencyListGraph, til at lave minimumSpanningTree, da man kan sortere Vertices på baggrund af distances, ved bruge af en queue
    public static void main(String[] args) {
	MatrixGraph thisGraph = new MatrixGraph(7);
    thisGraph.addEdge(0, 1, 1 );
    thisGraph.addEdge(0, 2, 5);
    thisGraph.addEdge(0, 4, 5);
        thisGraph.addEdge(1, 4, 1);
        thisGraph.addEdge(1, 5, 7);
        thisGraph.addEdge(2, 3, 1);
        thisGraph.addEdge(3, 4, 1);
        thisGraph.addEdge(3, 6, 1);
        thisGraph.addEdge(4, 2, 1);
        thisGraph.addEdge(4, 3, 3);
        thisGraph.addEdge(4, 5, 3);
        thisGraph.addEdge(4, 6, 4);
        thisGraph.addEdge(5, 6, 1);
        thisGraph.printGraph();

        AdjacencyListGraph adjgraph = new AdjacencyListGraph(); //man behøver ikke at parse noget til denne, altså vi behøves ikke at angave hvor mange Vertixes der er her
        Vertex A = new Vertex("0");
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

    }
}
