public class Tester 
{
	public static void main(String[] args) throws Exception
	{
		

		DoubleThreadedBST<Integer> myDTBST = new DoubleThreadedBST<Integer>();
		myDTBST.insert(9);
		myDTBST.insert(6);
		myDTBST.insert(12);
		myDTBST.insert(4);
		myDTBST.insert(8);
		myDTBST.insert(10);
		myDTBST.insert(16);
		myDTBST.insert(14);
		myDTBST.insert(11);
		myDTBST.insert(5);
		myDTBST.insert(2);
		
		
	

		


		
		DoubleThreadedBST<Integer> myDTBST2 = new DoubleThreadedBST<Integer>(myDTBST);


		myDTBST2.delete(2);
		
		System.out.println("INORDER REVERSE DETAILED: \t" + myDTBST.inorderReverseDetailed());

		System.out.println("INORDER REVERSE DETAILED: \t" + myDTBST2.inorderReverseDetailed());


		myDTBST.delete(14);

		System.out.println("NUMBER OF NODES: \t\t" + myDTBST.getNumberOfNodes());
		System.out.println("HEIGHT OF TREE: \t\t" + myDTBST.getHeight());
		System.out.println("ROOT OF TREE: \t\t\t" + myDTBST.getRoot().data);


		System.out.println("INORDER REVERSE NORMAL: \t" + myDTBST.inorderReverse());
		System.out.println("INORDER REVERSE DETAILED: \t" + myDTBST.inorderReverseDetailed());

		System.out.println("PREORDER NORMAL: \t\t" + myDTBST.preOrder());
		System.out.println("PREORDER DETAILED: \t\t" + myDTBST.preorderDetailed());

		
	}
}
