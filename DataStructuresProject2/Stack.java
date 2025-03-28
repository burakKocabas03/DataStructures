package dataStc2;

import java.util.ArrayList;

public class Stack {
	
	
	 
	 private int maxSize;
	 private UM_Alanı[] stackArray;
	 private int top;
	
	
	 public Stack() {
		this.maxSize = maxSize;
		this.stackArray = stackArray;
		this.top = top;
	}


	public Stack(int max) // 
	 {
	 maxSize = max;
	 stackArray = new UM_Alanı[maxSize];
	 top = -1;
	 }
	
	
	 public void push(UM_Alanı object) // put item on top of stack
	 {
	 stackArray[++top] = object;
	 }
	
	
	 public UM_Alanı pop() // take item from top of stack
	 {
	 return stackArray[top--];
	 }
	//
	
	 public UM_Alanı peek() // peek at top of stack
	 {
		 return stackArray[top];
		 }
		
		
		 public boolean isEmpty() // true if stack is empty
		 {
		 return (top == -1);
		 }
	public void popAndPrintStack() {
		UM_Alanı temp;
		int totalSize = 0;
	
		ArrayList<UM_Alanı>[] umAlanlarıDizisi = new ArrayList[7];
		umAlanlarıDizisi = UNESCOExample.returnListMetod();
		for (ArrayList<UM_Alanı> list : umAlanlarıDizisi) {
            	totalSize += list.size();
		}
		Stack stackList = new Stack(totalSize);
		for (ArrayList<UM_Alanı> list : umAlanlarıDizisi) {
            for (UM_Alanı umAlan : list) {
            	stackList.push(umAlan);
            }
		}
		while(!stackList.isEmpty()){
			temp = stackList.peek();
			stackList.pop();
			System.out.println("Listeden Son Çıkarlıan UM ALANI : " + temp.getAlanAdi() + " - " + temp.getIlAdlari() + " - " + temp.getIlanYili()+"  ");
		
	}	
	
	}
	
}