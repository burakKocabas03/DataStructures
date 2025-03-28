package dataStc2;

import java.util.ArrayList;

public class Queue {
	
	 private int maxSize;
	 private UM_Alanı[] queArray;
	 private int front;
	 private int rear;
	 private int nItems;
	
	 public Queue() {
			super();
			this.maxSize = maxSize;
			this.queArray = queArray;
			this.front = front;
			this.rear = rear;
			this.nItems = nItems;
		}
	 public Queue(int s) 
	 {
	 maxSize = s;
	 queArray = new UM_Alanı[maxSize];
	 front = 0;
	 rear = -1;
	 nItems = 0;
	 }
	
	
	 public void insert(UM_Alanı object) 
	 {
	 if(rear == maxSize-1) 
	 rear = -1;
	 queArray[++rear] = object; 
	 
	 nItems++; 
	 }
	
	
	 public UM_Alanı remove() 	 {
	 UM_Alanı temp = queArray[front++]; 
	 if(front == maxSize) 
	 front = 0;
	 nItems--; 
	 return temp;
	 }
	
	
	 public UM_Alanı peekFront() 
	 {
		return queArray[front];
	 }
	
	
	 public boolean isEmpty() 
	 {
	 return (nItems==0);
	 }
	
	
	 public boolean isFull() 
	 {
	 return (nItems==maxSize);
	 }
	
	 public int size() 
	 {
	 return nItems;
	 }
	 public void popAndPrintQueue() {
			UM_Alanı temp;
			int totalSize = 0;
		
			ArrayList<UM_Alanı>[] umAlanlarıDizisi = new ArrayList[7];
			umAlanlarıDizisi = UNESCOExample.returnListMetod();
			for (ArrayList<UM_Alanı> list : umAlanlarıDizisi) {
	            	totalSize += list.size();
			}
			Queue queueList = new Queue(totalSize);
			for (ArrayList<UM_Alanı> list : umAlanlarıDizisi) {
	            for (UM_Alanı umAlan : list) {
	            	queueList.insert(umAlan);
	            }
			}
			while(!queueList.isEmpty()){
				temp = queueList.peekFront();
				queueList.remove();
				System.out.println("Listenin Başından Çıkarlıan UM ALANI : " + temp.getAlanAdi() + " - " + temp.getIlAdlari() + " - " + temp.getIlanYili()+"  ");
			
		}	
		
		}


	
		
	

}