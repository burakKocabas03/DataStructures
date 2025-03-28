package dataStc2;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueueCopy {
	private int[] productCountList = {10, 4, 8, 6, 7, 1, 15, 9, 3, 2};
	 private List<Integer> queArray;
	 private int nItems ;
	 
	 public PriorityQueueCopy() 
	 {
	 queArray = new LinkedList<>();
	 nItems = 0;
	 }

	 public void insert(int i) {
     queArray.add(i);
	 nItems++; 
	 
	 }
	 public void calculatingCustomersPriorityQueue (PriorityQueueCopy prioCopy){
		 for(int i:productCountList) {
			 prioCopy.insert(i);
		 }
		 int temp;
		 double tempTime;
		 double customersWaitingTime= 0;
		 double allTime =0; 
		 int compareToValue ;
		 
		 while(!prioCopy.isEmpty()){
		 int tempIndex = 0;
		 
		 if(queArray.size()>0) {
			 for(int i=0;i<queArray.size()-1;i++) {
			 compareToValue = queArray.get(tempIndex).compareTo(queArray.get(i+1));
			 if(compareToValue<0) {
				 tempIndex = tempIndex;
			 }
			 else {
				 tempIndex = i+1;
			 }
			 
			 }
			 temp= queArray.get(tempIndex);
			 tempTime = 2.5*temp;
			 customersWaitingTime+= tempTime;
			 allTime += customersWaitingTime;
			 queArray.remove(tempIndex);
			 nItems--;
			 System.out.println((productCountList.length-prioCopy.nItems)+". Müşterinin Beklediği Süre : "+ customersWaitingTime); 
			 
		 }
		
		 }
		 System.out.println("Müşterilerin tümü için öncelikli kuyruktaki ortalama bekleme süresi : " + (allTime/10));
	
	 }

	 public boolean isEmpty() 
	 {
	 return (nItems==0);
	 }
	
	
	
	 public int size() 
	 {
	 return nItems;
	 }
	 
	 
	 



}
