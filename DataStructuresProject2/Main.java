package dataStc2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<UM_Alanı>[] umAlanlarıDizisi = new ArrayList[7];
		umAlanlarıDizisi = UNESCOExample.returnListMetod();
		for (ArrayList<UM_Alanı> list : umAlanlarıDizisi) {
            for (UM_Alanı umAlan : list) {
                System.out.print(umAlan.getAlanAdi() + " - " + umAlan.getIlAdlari() + " - " + umAlan.getIlanYili()+"  ");
                
                
            }
            System.out.println("/// Bölgedeki Unesco Miran Alanı Sayısı:  " + list.size());
            System.out.println("");
		// TODO Auto-generated method stub

	}
		System.out.println("--------------------------------------------------");
		System.out.println("Stackten çıkarıan elemanları sırayla yazdırma");
	
		Stack stack = new Stack();
		stack.popAndPrintStack();
		System.out.println("--------------------------------------------------");
		System.out.println("Queue dan çıkarıan elemanları sırayla yazdırma");
		
		Queue queue = new Queue();
		queue.popAndPrintQueue();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Priority Queue dan çıkarılan elemanları sırayla yazdırma");
		PriorityQueue  prioQueue = new PriorityQueue();
			for (ArrayList<UM_Alanı> list : umAlanlarıDizisi) {
	            for (UM_Alanı umAlan : list) {
	            	prioQueue.insert(umAlan);
	            		}					}
			while(!prioQueue.isEmpty()) {
				UM_Alanı popElement = prioQueue.remove();
				System.out.println(" Listeden alfabetik olarak çıkarılanlar : "+ popElement.getAlanAdi()+"-"+popElement.getIlAdlari()+"-"+popElement.getIlanYili() );
		
			}	
			
			System.out.println("--------------------------------------------------");
			System.out.println("Market kuyruğunda normal kuyrukla her müşterinin beklediği süre ve kuyruğun beklettiği ortalama süre");
			
			MarketQueue marketqueue = new MarketQueue();
			marketqueue.calculatingCustomers();
			
			System.out.println("--------------------------------------------------");
			System.out.println("Market kuyruğunda öncelikli kuyrukla her müşterinin beklediği süre ve kuyruğun beklettiği ortalama süre");
			PriorityQueueCopy prioCopy = new PriorityQueueCopy();
			prioCopy.calculatingCustomersPriorityQueue(prioCopy);
			
}
	
}