package dataStc4;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private final int MAX_VERTS = 20;
	private final int INFINITY = 	1000000;
	private Vertex vertexList[];
	private int adjMat[][]; 
	private int nVerts;
	private int currentVert;
	private PriorityQ thePQ;
	private int nTree;
	
	public Graph() {
	vertexList = new Vertex[MAX_VERTS];
	adjMat = new int[MAX_VERTS][MAX_VERTS];
	nVerts = 0;
	for(int j=0; j<MAX_VERTS; j++)
	for(int k=0; k<MAX_VERTS; k++) adjMat[j][k] = INFINITY;
	thePQ = new PriorityQ();
	
	} 
	
	public void addVertex(char lab) {
	vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end, int weight) {
	adjMat[start][end] = weight;
	adjMat[end][start] = weight; }
	public void displayVertex(int v)
	{ System.out.print(vertexList[v].label); }
	
	
	public void mstw() {
	    currentVert = 0;
	    int totalWeight = 0;
	    while (nTree < nVerts - 1) {
	        vertexList[currentVert].isInTree = true;
	        nTree++;
	        for (int j = 0; j < nVerts; j++) {
	            if (j == currentVert) { // skip if it’s us
	                continue;
	            }
	            if (vertexList[j].isInTree) { // skip if in the tree
	                continue;
	            }
	            int distance = adjMat[currentVert][j];
	            if (distance == INFINITY) {
	                continue;
	            }
	            putInPQ(j, distance);
	        }
	        if (thePQ.size() == 0) {
	            System.out.println("GRAPH NOT CONNECTED");
	            return;
	        }
	        Edge theEdge = thePQ.removeMin();
	        int sourceVert = theEdge.srcVert;
	        currentVert = theEdge.destVert;
	        System.out.print(vertexList[sourceVert].label);
	        System.out.print(vertexList[currentVert].label);
	        System.out.print(" ");
	        totalWeight += theEdge.distance; 
	    }
	    System.out.println("\nToplam Agirlik: " + totalWeight);
	    for (int j = 0; j < nVerts; j++) {
	        vertexList[j].isInTree = false;
	    }
	}
	public void putInPQ(int newVert, int newDist)
	{
	 int queueIndex = thePQ.find(newVert);
	if(queueIndex != -1) 
	{
	Edge tempEdge = thePQ.peekN(queueIndex); 
	int oldDist = tempEdge.distance;
	if(oldDist > newDist)
	{
	thePQ.removeN(queueIndex);  
	Edge theEdge =new Edge(currentVert, newVert, newDist); 
	thePQ.insert(theEdge);
	}
	 } 
	else
	{ 
		Edge theEdge = new Edge(currentVert, newVert, newDist); 
		thePQ.insert(theEdge);
	}
	
	} 
	 public void bft(int start) {
	        boolean[] visited = new boolean[nVerts];
	        Queue<Integer> queue = new LinkedList<>();

	        visited[start] = true;
	        displayVertex(start);
	        queue.add(start);

	        while (!queue.isEmpty()) {
	            int currentVertex = queue.poll();

	            for (int j = 0; j < nVerts; j++) {
	                if (adjMat[currentVertex][j] != INFINITY && !visited[j]) {
	                    visited[j] = true;
	                    displayVertex(j);
	                   
	                    queue.add(j);
	                }
	            }
	        }
	        System.out.println("");
	    }
	 public void dijkstra(int startVertex) {
	        int[] distance = new int[nVerts];
	        boolean[] visited = new boolean[nVerts];

	        // Initialize distances and visited array
	        for (int i = 0; i < nVerts; i++) {
	            distance[i] = INFINITY;
	            visited[i] = false;
	        }

	        distance[startVertex] = 0;

	        for (int count = 0; count < nVerts - 1; count++) {
	            int currentVertex = minDistance(distance, visited);
	            visited[currentVertex] = true;

	            for (int j = 0; j < nVerts; j++) {
	                if (!visited[j] && adjMat[currentVertex][j] != INFINITY
	                        && distance[currentVertex] != INFINITY
	                        && distance[currentVertex] + adjMat[currentVertex][j] < distance[j]) {
	                    distance[j] = distance[currentVertex] + adjMat[currentVertex][j];
	                }
	            }
	        }

	        // Print the shortest distances
	        System.out.println("Dijkstra's Shortest Paths from vertex " + vertexList[startVertex].label + ":");
	        for (int i = 0; i < nVerts; i++) {
	            System.out.println("To " + vertexList[i].label + ": " + distance[i]);
	        }
	    }

	    private int minDistance(int[] distance, boolean[] visited) {
	        int min = INFINITY;
	        int minIndex = -1;

	        for (int v = 0; v < nVerts; v++) {
	            if (!visited[v] && distance[v] <= min) {
	                min = distance[v];
	                minIndex = v;
	            }
	        }

	        return minIndex;
	    }

	
	
	
	}
		                                        

	