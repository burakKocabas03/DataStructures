package dataStc4;

public class MethodsApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        
        theGraph.addEdge(0, 1, 6); 
        theGraph.addEdge(0, 3, 4);
        theGraph.addEdge(1, 2, 10);
        theGraph.addEdge(1, 3, 7);
        theGraph.addEdge(1, 4, 7);
        theGraph.addEdge(2, 3, 8);
        theGraph.addEdge(2, 4, 5);
        theGraph.addEdge(2, 5, 6);
        theGraph.addEdge(3, 4, 12);
        theGraph.addEdge(4, 5, 7);
        

        System.out.print("Minimum spanning tree:"); 
        theGraph.mstw();
        System.out.println();
        System.out.println("Her Düğüm için BFT dolaşılması");
        theGraph.bft(0); 
        theGraph.bft(1); 
        theGraph.bft(2);
        theGraph.bft(3);
        theGraph.bft(4);
        theGraph.bft(5);
        
        System.out.println();
        System.out.println();
        System.out.println("Her Node için Dijkstra Short Path");
        theGraph.dijkstra(0);
        theGraph.dijkstra(1);
        theGraph.dijkstra(2);
        theGraph.dijkstra(3);
        theGraph.dijkstra(4);
        theGraph.dijkstra(5);
        
        
        
        
        
        
        
    }
}


