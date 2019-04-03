public class Tester 
{
	public static void main(String[] args) throws Exception
	{
		

		DoubleThreadedBST<String> myDTBST = new DoubleThreadedBST<String>();
		myDTBST.insert("B");
		myDTBST.insert("A");
		myDTBST.insert("D");
		myDTBST.insert("C");
		myDTBST.insert("E");
		
		
	

	//	myDTBST.delete(36);

		System.out.println("NUMBER OF NODES: \t\t" + myDTBST.getNumberOfNodes());
		System.out.println("HEIGHT OF TREE: \t\t" + myDTBST.getHeight());
		System.out.println("ROOT OF TREE: \t\t\t" + myDTBST.getRoot().data);


		System.out.println("INORDER REVERSE NORMAL: \t" + myDTBST.inorderReverse());
		System.out.println("INORDER REVERSE DETAILED: \t" + myDTBST.inorderReverseDetailed());

		System.out.println("PREORDER NORMAL: \t\t" + myDTBST.preOrder());
		System.out.println("PREORDER DETAILED: \t\t" + myDTBST.preorderDetailed());
	}
}
