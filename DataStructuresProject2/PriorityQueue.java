package dataStc2;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {
	 private List<UM_Alanı> queArray;
	 private int nItems ;
	 
	 public PriorityQueue() 
	 {
	 queArray = new LinkedList<>();
	 nItems = 0;
	 }

	 public void insert(UM_Alanı object) {
	 
     queArray.add(object);
	 nItems++; 
	 
	 }
	 public UM_Alanı remove() 	 {
		 UM_Alanı tempObject = null;
		 int tempIndex =0;
		if(queArray.size()>1) {
		 for(int i=0; i<queArray.size()-1;i++) {
			 int value = queArray.get(tempIndex).getAlanAdi().compareToIgnoreCase(queArray.get(i+1).getAlanAdi());
			 if (value <0) {
				 tempIndex = tempIndex;
			 }
			 else if (value>0) {
				 tempIndex = i+1;
			 }	 
		 }
		 tempObject = queArray.get(tempIndex);
		 queArray.remove(tempIndex);
		 nItems--;
		 return tempObject;
		 
		}
		else {
			 tempObject = queArray.get(tempIndex);
			 queArray.remove(tempIndex);
			 nItems--;
			 return tempObject;
			
			
		}
		
		
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
