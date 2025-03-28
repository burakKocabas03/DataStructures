package dataStc3;

import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

public class BinarySearchTree {
	Node root;
	int n = -1;
	
	public BinarySearchTree() {
		root = null;
	}
	
	
	public Node newNode(UM_Alanı2 umAlanıData) {
		root = new Node(umAlanıData);
		return root;
	}
	public Node createTree(Node root , UM_Alanı2 umAlanıData) {
		Collator collator = Collator.getInstance(new Locale("tr", "TR"));

		
		int compare;
		if (root!= null) {
			compare = collator.compare(root.umAlani.getAlanAdi(), umAlanıData.getAlanAdi());
			 if (compare>0) {
				 root.left =createTree(root.left,umAlanıData);
			 }
			 else {
				 root.right = createTree(root.right,umAlanıData);
			 }
		}
		else {
			root = newNode(umAlanıData);
		}
		
		
		
		
		
		return root;

}
	
	public void inOrder(Node root) {
		if (root!= null) {
			
			inOrder(root.left);
			System.out.println(root.umAlani.toString());
			System.out.println("");
			inOrder(root.right);
			
		}
	
	}
	public void preOrder(Node root) {
		if (root!= null) {
			System.out.println(root.umAlani.toString());
			System.out.println("");
			preOrder(root.left);
			preOrder(root.right);
			
		}
	
	}
	
	
public UM_Alanı2 [] addToArrayPreOrder(Node node,UM_Alanı2[] umAlanList) {
		
		if (node!=null) {
		n++;
		umAlanList[n] = node.umAlani;
		addToArrayPreOrder(node.left,umAlanList);
		addToArrayPreOrder(node.right,umAlanList);
		return umAlanList;
		
		}
		else {
			return umAlanList;}
}
	
	
	
	public int depth(Node root) {
		if(root==null) {
			return 0;
		}
		else {
		int lDepth = depth(root.left);
		int rDepth = depth(root.right);
		if(lDepth>rDepth) {
			return lDepth+1;
		}
		else {
			return rDepth+1;
		}
			
		}
	}
	
	public int size(Node root) {
		if(root==null) {
			return 0;
		}
		else {
			return size(root.left)+1+size(root.right);
		}
	}
	
	
	public  int calculateBalancedHeight(Node root){
		int numberOfNodes = size(root);
        if (numberOfNodes <= 0) {
            return 0;
        }
        return (int) Math.ceil(Math.log(numberOfNodes + 1) / Math.log(2)) - 1;
    }
	
	
	
	
	public void findDepthAndPrintInfo(BinarySearchTree bstree) {
		inOrder(bstree.root);
		int bstDepth = depth(bstree.root);
		System.out.println("Height of the tree = "+ bstDepth );
		int bstSize = size(bstree.root);
		System.out.println("Size of the tree = "+ bstSize );
		int bstBalancedHeight = calculateBalancedHeight(bstree.root);
		System.out.println("Height if the tree were balanced = "+ bstBalancedHeight );
	}
	public void	findInsideTwoLetter(Node root,String letter1,String letter2) {
		if (root!= null) {
			 Collator turkceCollector = Collator.getInstance(new Locale("tr", "TR"));
			int smallNum,bigNum;
			 bigNum =turkceCollector.compare(root.umAlani.getAlanAdi(),letter2);
			 smallNum = turkceCollector.compare(root.umAlani.getAlanAdi(),letter1);
			if (smallNum >= 0 & bigNum <= 0 ) {
				System.out.println(root.umAlani.toString());
				System.out.println("");
			}
			findInsideTwoLetter(root.left,letter1,letter2);
			findInsideTwoLetter(root.right,letter1,letter2);
			
			
		}
	
	}
	
	public void takeTwoLetter(BinarySearchTree btree) {
		 Scanner scanner = new Scanner(System.in);
	     System.out.print("Please enter the first letter ");
	     String userInput1 = scanner.next();
	     System.out.print("Please enter the seccond letter ");
	     String userInput2 = scanner.next();
	     findInsideTwoLetter(btree.root,userInput1.toUpperCase(),userInput2.toUpperCase());
	     
	}
		public UM_Alanı2 [] addToArrayAlphabetic(Node node,UM_Alanı2[] umAlanList) {
			
			if (node!=null) {
			addToArrayAlphabetic(node.left,umAlanList);
			n++;
			umAlanList[n] = node.umAlani;
			addToArrayAlphabetic(node.right,umAlanList);
			return umAlanList;
			
			}
			else {
				return umAlanList;}
	}
		
		
		public Node arrayToTree(UM_Alanı2 [] umAlanıList, int start,int end) {
			if(start<=end) {
			int middle = (start+end)/2;
			Node root = new Node(umAlanıList[middle]);
			
		
			root.left = arrayToTree(umAlanıList,start,middle-1);
			root.right = arrayToTree(umAlanıList,middle+1,end);
			return root;
			}
			
			return null;
			}
	
		public void createNewListTree(BinarySearchTree bstree) {
			UM_Alanı2[] umAlanList = new UM_Alanı2[21];
			umAlanList = bstree.addToArrayAlphabetic(bstree.root, umAlanList);
			BinarySearchTree newTree = new BinarySearchTree();
			newTree.root =newTree.arrayToTree(umAlanList, 0, 20);
			 newTree.preOrder(newTree.root);;
			
			
			
		}
	
	
	
	
		
	
	
	
}
