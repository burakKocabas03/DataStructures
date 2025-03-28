package dataStc3;

import java.util.Arrays;

import java.util.PriorityQueue;
public class MinHeap {
	 private int capacity;
	    private int size;
	    private int[] heap;

	    public MinHeap(int capacity) {
	        this.capacity = capacity;
	        this.size = 0;
	        this.heap = new int[capacity];
	    }

	    private int getParentIndex(int index) {
	        return (index - 1) / 2;
	    }

	    private int getLeftChildIndex(int index) {
	        return 2 * index + 1;
	    }

	    private int getRightChildIndex(int index) {
	        return 2 * index + 2;
	    }

	    private boolean hasParent(int index) {
	        return getParentIndex(index) >= 0;
	    }

	    private boolean hasLeftChild(int index) {
	        return getLeftChildIndex(index) < size;
	    }

	    private boolean hasRightChild(int index) {
	        return getRightChildIndex(index) < size;
	    }

	    private int parent(int index) {
	        return heap[getParentIndex(index)];
	    }

	    private int leftChild(int index) {
	        return heap[getLeftChildIndex(index)];
	    }

	    private int rightChild(int index) {
	        return heap[getRightChildIndex(index)];
	    }

	    private void swap(int index1, int index2) {
	        int temp = heap[index1];
	        heap[index1] = heap[index2];
	        heap[index2] = temp;
	    }

	    public void insert(int value) {
	        if (size == capacity) {
	            ensureCapacity();
	        }

	        heap[size] = value;
	        size++;
	        heapifyUp();
	    }

	    public int peek() {
	        if (size == 0) {
	            throw new IllegalStateException("Heap is empty");
	        }
	        return heap[0];
	    }

	    public int extractMin() {
	        if (size == 0) {
	            throw new IllegalStateException("Heap is empty");
	        }

	        int min = heap[0];
	        heap[0] = heap[size - 1];
	        size--;
	        heapifyDown();
	        return min;
	    }

	    private void heapifyUp() {
	        int index = size - 1;
	        while (hasParent(index) && parent(index) > heap[index]) {
	            swap(getParentIndex(index), index);
	            index = getParentIndex(index);
	        }
	    }

	    private void heapifyDown() {
	        int index = 0;
	        while (hasLeftChild(index)) {
	            int smallerChildIndex = getLeftChildIndex(index);
	            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
	                smallerChildIndex = getRightChildIndex(index);
	            }

	            if (heap[index] < heap[smallerChildIndex]) {
	                break;
	            } else {
	                swap(index, smallerChildIndex);
	            }

	            index = smallerChildIndex;
	        }
	    }

	    private void ensureCapacity() {
	        capacity *= 2;
	        heap = Arrays.copyOf(heap, capacity);
	    }

		    public PriorityQueue<UM_Alanı2>  UM_AlanıHeap(BinarySearchTree btree) {
		    	UM_Alanı2[]umAlaniList = new UM_Alanı2[21];
		    	umAlaniList = btree.addToArrayPreOrder(btree.root, umAlaniList);
		    	PriorityQueue<UM_Alanı2> minHeap = new PriorityQueue<>(UM_Alanı2.AlanAdiComparator);
		    	for (UM_Alanı2 umAlanı: umAlaniList) {
		            minHeap.add(umAlanı);
		    	
		    	}
		    	 return minHeap;
		    }
		       
	
	  
	    public void print(PriorityQueue<UM_Alanı2> minHeap) {
	    	PriorityQueue<UM_Alanı2> firstThree = new PriorityQueue<>(UM_Alanı2.AlanAdiComparator);

	        int count = 0;
	        while (count < 3 && !minHeap.isEmpty()) {
	            UM_Alanı2 umAlani = minHeap.poll();
	            firstThree.add(umAlani); 
	            count++;
	    	
			
		}
	        while (!firstThree.isEmpty()) {
	            UM_Alanı2 umAlani = firstThree.poll();
	            System.out.println(umAlani.toString());
	            System.out.println("");
	        }
}
}

	


