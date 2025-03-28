package dataStc2;

public class MarketQueue {
	private int [] productCountList = {10, 4, 8, 6, 7, 1, 15, 9, 3, 2};
	 private int maxSize;
	 private int[] queArray;
	 private int front;
	 private int rear;
	 private int nItems;
	 public MarketQueue() {
			super();
			this.productCountList = productCountList;
			this.maxSize = maxSize;
			this.queArray = queArray;
			this.front = front;
			this.rear = rear;
			this.nItems = nItems;
		}
	
	 public  MarketQueue(int s) // constructor
	 {
	 maxSize = s;
	 queArray = new int[maxSize];
	 front = 0;
	 rear = -1;
	 nItems = 0;
	 }
	
	
	 public void insert(int j) 
	 {
	 if(rear == maxSize-1) 
	 rear = -1;
	 queArray[++rear] = j; 
	 nItems++; 
	 }
	
	
	 public int remove()
	 {
	 int temp = queArray[front++];
	 if(front == maxSize) 
	 front = 0;
	 nItems--;
	 return temp;
	 }
	
	 public int peekFront() {
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
	 public void calculatingCustomers() {
		 int temp;
		 double tempTime;
		 double customersWaitingTime= 0;
		 double allTime =0;
		 MarketQueue queueList= new MarketQueue(10);
		 for (int i:productCountList) {
			 queueList.insert(i);;
		 }
		 while(!queueList.isEmpty()) {
		 temp=queueList.peekFront();
		 tempTime=(temp *2.5);
		 customersWaitingTime += tempTime;
		 allTime += customersWaitingTime;
		 queueList.remove();
		 System.out.println((productCountList.length - queueList.nItems)+".  Müşterinin beklediği süre :  " + customersWaitingTime);
		 }
		 System.out.println("Bu kuyruğun müşterileri ortalama beklettiği süre: " + allTime/10);
		 
	 }


	
	 
	 
	 
	 
	 }
	
	  

