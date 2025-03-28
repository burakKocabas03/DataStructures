package dataStc3;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		HashMap<String,UM_Alanı2> map = new HashMap<>();
		PriorityQueue<UM_Alanı2> minHeap = new PriorityQueue<>();
		BinarySearchTree btree = new BinarySearchTree();
		ReadAndCreate rac = new ReadAndCreate();
		btree = rac.returnTreeMetod();
		System.out.println("AĞAÇ İLE ALAKALI BİLGİLERİN YAZDIRILMASI, DERİNLİK VE SIZE BULDURMASI");
		btree.findDepthAndPrintInfo(btree);
		System.out.println("- - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("VERİLEN İKİ HARF ARASINDAKİ UM ALAN BİLGİLERİNİ  YAZDIRMA İŞLEMİ");
		btree.takeTwoLetter(btree);
		System.out.println("- - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("ARRAYDE ALFABETİK OLARAK TUTULAN UM ALANLARININ RECURSIVE ÇAĞRILARAK OLUŞTURULAN AĞACIN PREORDER ŞEKLİNDE YAZDIRILMASI ");	
		btree.createNewListTree(btree);
		
		
		
		
		BinarySearchTree btree3 = new BinarySearchTree();
		ReadAndCreate rac3 = new ReadAndCreate();
		btree3 = rac3.returnTreeMetod();
		HashTable hashMap = new HashTable();
		System.out.println("- - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		map = hashMap.createHashFromUM_AlaniTree(btree3);
		System.out.println(" HASH MAPİN YAZDIRILMASI");
		hashMap.printHashMap(map);
		System.out.println("- - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("HASHMAPTE DEĞİŞTİRMEK İSTEDİĞİN UM ALANI ADI İÇİN");
		hashMap.updateUM_AlaniAd(map);

		
		
		
		
		BinarySearchTree btree2 = new BinarySearchTree();
		ReadAndCreate rac2 = new ReadAndCreate();
		btree2 = rac2.returnTreeMetod();
		MinHeap heap = new MinHeap(21);
		minHeap = heap.UM_AlanıHeap(btree2);
		System.out.println("- - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("MİN HEAPTEKİ 3 UM ALANININ YAZDIRILMASI");
		heap.print(minHeap);
	}

}
