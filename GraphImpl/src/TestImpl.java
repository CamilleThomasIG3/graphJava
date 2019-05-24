package GraphImpl;
import graph.Graph;
import graph.Vertex;
import graph.Edge;
import graph.DirectedEdge;
import graph.UndirectedEdge;

public class TestImpl{
	public static void main(String... args){
		GraphImpl g = new GraphImpl();
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		UndirectedEdge e = new UndirectedEdge();
		g.addVertex(v1);
		g.addVertex(v2);
		g.addEdge(e,v1,v2);
		System.out.print(g.existsEdge(v1,v2) + "\n");
		System.out.print(g.existsVertex(v1) + "\n");
		g.deleteEdge(e,v1,v2);
		g.deleteVertex(v1);
		System.out.print(g.existsEdge(v1,v2) + "\n");
		System.out.print(g.existsVertex(v1) + "\n");
	}
}