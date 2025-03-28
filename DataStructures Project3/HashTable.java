package dataStc3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTable {
	
	 public static HashMap<String, UM_Alanı2> createHashFromUM_AlaniTree(BinarySearchTree binarySearchTree) {
	        HashMap<String, UM_Alanı2> umAlaniHash = new HashMap<>();
	        UM_Alanı2[] treeArray = new UM_Alanı2[21];
	        
	        treeArray = binarySearchTree.addToArrayAlphabetic(binarySearchTree.root,treeArray);
	        for (UM_Alanı2 umAlani :treeArray) {
	            umAlaniHash.put(umAlani.getAlanAdi(),umAlani);
	        }
	        return umAlaniHash;
	    }
	 public static UM_Alanı2 getUM_AlanıByAd(HashMap<String, UM_Alanı2> umAlaniHash) {
		 Scanner scanner = new Scanner(System.in);
	     System.out.print("Please enter name of the which UM Area you  want to change ");
	     String name= scanner.nextLine().trim();
	     
	        return umAlaniHash.get(name);
	    }

	    public static void updateUM_AlaniAd(HashMap<String, UM_Alanı2> umAlaniHash) {
	    	HashTable hashTable = new HashTable();
	    	 String eskiAd = hashTable.getUM_AlanıByAd(umAlaniHash).getAlanAdi();
	    	 Scanner scanner = new Scanner(System.in);
	    	 System.out.print("Please enter name of the new UM Area ");
	    	 String yeniAd = scanner.nextLine().trim();
	    	
	        UM_Alanı2 umAlanı = umAlaniHash.remove(eskiAd);
	        if (umAlanı != null) {
	            umAlanı.setAlanAdi(yeniAd);
	            umAlaniHash.put(yeniAd, umAlanı);
	            System.out.println("UM_Alanı adı başarıyla güncellendi.");
	            hashTable.printHashMap(umAlaniHash);
	            
	        } else {
	            System.out.println("Güncellenecek UM_Alanı bulunamadı.");
	        }
	    }
	    public static void printHashMap(HashMap<String, UM_Alanı2> umAlaniHash) {
	        System.out.println("Hash Table Content:");
	        for (Map.Entry<String, UM_Alanı2> entry : umAlaniHash.entrySet()) {
	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	            System.out.println(" ");
	        }
	    }
	        
	        
	        
	    }


