public class TestGraph {

	public static void main(String[] args) {
		Graph<String> G = new Graph<String>();

		// Testing insertVertex()
		// The correct answer is
		// A
		// B
		// C
		// D
		// E
		// The graph consists of 5 vertices and 0 edges.
		System.out.println("Testing insertVertex()");
		G.insertVertex("A");
		G.insertVertex("B");
		G.insertVertex("C");
		G.insertVertex("D");
		G.insertVertex("E");
		G.print();

		// Testing insertEdge()
		// The correct answer is
		// A-->E,7-->D,8-->C,3-->B,1
		// B-->D,9-->A,4-->C,5
		// C
		// D-->A,1-->C,6
		// E-->A,2
		// The graph consists of 5 vertices and 10 edges.
		System.out.println("\nTesting insertEdge()");
		G.insertEdge("A", "B", 1);
		G.insertEdge("A", "C", 3);
		G.insertEdge("A", "D", 8);
		G.insertEdge("A", "E", 7);
		G.insertEdge("D", "C", 6);
		G.insertEdge("E", "A", 2);
		G.insertEdge("D", "A", 1);
		G.insertEdge("B", "C", 5);
		G.insertEdge("B", "A", 4);
		G.insertEdge("B", "D", 9);
		G.print();

		// Testing deleteEdge()
		System.out.println("\nTesting delete edge AE");
		// The correct answer is
		// A-->D,8-->C,3-->B,1
		// B-->D,9-->A,4-->C,5
		// C
		// D-->A,1-->C,6
		// E-->A,2
		// The graph consists of 5 vertices and 9 edges.
		G.deleteEdge("A", "E");
		G.print();

		System.out.println("\nTesting delete edge DC");
		// The correct answer is
		// A-->D,8-->C,3-->B,1
		// B-->D,9-->A,4-->C,5
		// C
		// D-->A,1
		// E-->A,2
		// The graph consists of 5 vertices and 8 edges.
		G.deleteEdge("D", "C");
		G.print();

		System.out.println("\nTesting delete edge AC");
		// The correct answer is
		// A-->D,8-->B,1
		// B-->D,9-->A,4-->C,5
		// C
		// D-->A,1
		// E-->A,2
		// The graph consists of 5 vertices and 7 edges.
		G.deleteEdge("A", "C");
		G.print();

		// Testing deleteVertex()
		System.out.println("\nTesting delete vertex E");
		// The correct answer is
		// A-->D,8-->B,1
		// B-->D,9-->A,4-->C,5
		// C
		// D-->A,1
		// The graph consists of 4 vertices and 6 edges.
		G.deleteVertex("E");
		G.print();

		System.out.println("\nTesting delete vertex B");
		// The correct answer is
		// A-->D,8
		// C
		// D-->A,1
		// The graph consists of 3 vertices and 2 edges.
		G.deleteVertex("B");
		G.print();

		System.out.println("\nTesting delete vertex A");
		// The correct answer is
		// C
		// D
		// The graph consists of 2 vertices and 0 edges.
		G.deleteVertex("A");
		G.print();

	}

}