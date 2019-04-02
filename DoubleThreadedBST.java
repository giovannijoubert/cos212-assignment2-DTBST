/*
Complete your details...
Name and Surname: Giovanni Joubert 
Student/staff Number: u18009035
*/


public class DoubleThreadedBST<T extends Comparable<? super T>>
{
	private DTNode<T> root; // the root node of the tree

	
	public DoubleThreadedBST()
	{
		/*
		The default constructor
		*/
		root = null;
	}
	
	public DoubleThreadedBST(DoubleThreadedBST<T> other)
	{
		/*
		The copy constructor
		*/
		root = other.root;
	}
	
	public DoubleThreadedBST<T> clone()
	{
		/*
		The clone method should return a copy/clone
		of this tree.
		*/
		DoubleThreadedBST<T> newTree = new DoubleThreadedBST<T>();
		
		if (root != null) {
			newTree.root = root;
			return newTree;
		}
		
		return null;
	}
	
	public DTNode<T> getRoot()
	{
		/*
		Return the root of the tree.
		*/
		
		return root;
	}
	
	public boolean insert(T element)
	{
		/*
		The element passed in as a parameter should be
		inserted into this tree. Duplicates are not allowed.
		Left and right threads in the corresponding branch 
		must be updated accordingly, as necessary. 
		If the insert was successfull, the method should 
		return true. If the operation was unsuccessfull, 
		the method should return false.
		
		NB: Do not throw an exception.
		*/

		if (contains(element)){
			return false;
		}

		root = insert(root, element);

		return true;
	}

	public DTNode<T> insert(DTNode<T> root, T element){

	 DTNode<T> node = root;  

	 if (node != null){
	 
		 // Moving on left subtree.  
		 if (element.compareTo(node.data) < 0)  
		 {  
			 if (node.hasLeftThread == false && node.left != null)  {
				node = node.left;  
			 }
		}
	 
		 // Moving on right subtree.  
		 else
		 {  
			 if (node.hasRightThread == false && node.right != null){
				 node = node.right;
			 }
		 }  
		}
	   
	 
	 // Create a new node  
	 DTNode<T> InsertMe = new DTNode(element);  
	   
	 if (node == null)  
	 {  
		 root = InsertMe;  
		 InsertMe.left = null;  
		 InsertMe.right = null;  
	 }  
	 else if (element.compareTo(node.data) < 0)  
	 {  
		 InsertMe.left = node.left;
		 if (node.hasLeftThread)
			 InsertMe.hasLeftThread = true;
			 
		 InsertMe.right = node;
		 InsertMe.hasRightThread = true;

		 node.left = InsertMe;
		node.hasLeftThread = false;
	 }  
	 else
	 {  
		InsertMe.right = node.right;
		if (node.hasRightThread)
			InsertMe.hasRightThread = true;
			
		InsertMe.left = node;
		InsertMe.hasLeftThread = true;

		node.right = InsertMe;
	   node.hasRightThread = false;
	 }  
	 
	 return root;
       

	}

	
	public boolean delete(T element)
	{
		/*
		The element passed in as a parameter should be
		deleted from this tree. If the delete was successfull,
		the method should return true. If the operation was
		unsuccessfull, the method should return false. Eg, if
		the requested element is not found, return false.
		
		You have to implement the mirror case of delete by merging 
		as discussed in the textbook. That is, for a deleted node,
		its right child should replace it in the tree and not its
		left child as in the textbook examples. Relevant left and
		right threads must be updated accordingly.
		
		NB: Do not throw an exception.
		*/
		
		return false;
	}
		
	public boolean contains(T element)
	{
		/*
		This method searches for the element passed in as a
		parameter. If the element is found, true should be 
		returned. If the element is not in the tree, the
		method should return false.
		*/
		if (contains(root, element) == null) { 
			return false;
		} else {
			return true;
		}
	}

	public DTNode<T> contains( DTNode<T> root, T element)
	{
		//Base case
		if (root == null || root.data == element)
			return root;

		//Greater than 
		if (root.data.compareTo(element) > 0)
			if(root.hasLeftThread)
			{
				return contains(null, element);
			} else {
				return contains(root.left, element);
			}

		//Less than 
		if (root.data.compareTo(element) < 0)
			if(root.hasRightThread)
			{
				return contains(null, element);
			} else {
				return contains(root.right, element);
			}
		
		return null;
			
	}

	
	public String inorderReverse()
	{
		/*
		This method must return a string representation
		of the elements in the tree inorder, right to left. 
		This function must not be recursive. Instead, left 
		threads must be utilised to perform a depth-first 
		inorder traversal.
		
		Note that there are no spaces in the string, and
		the elements are comma-separated.
		
		If the tree looks like:
		
		   B
		  / \
		 A   D
		    / \
		   C   E
		
		The following string must be returned:
		
		E,D,C,B,A
		*/
		if (root == null)
			return "";

		DTNode<T> temp = root;
		while (temp.right != null){
			temp = temp.right;
		}

		String out = "";

		out = out + temp.data;
		temp = temp.left;

		while(temp != null){
			out = out + "," + temp.data;
			temp = temp.left;
		}
		
		return out;
	}
	
	public String inorderReverseDetailed()
	{
		/*
		This method must return a string representation
		of the elements in the tree inorder, right to left. 
		This function must not be recursive. Instead, left 
		threads must be utilised to perform a depth-first 
		inorder traversal.
		
		Note that there are no spaces in the string, and
		the elements are comma-separated. Additionally,
		whenever a thread is followed during the
		traversal, a pipe symbol should be printed
		instead of a comma.
		
		If the tree looks like:
		
		   B
		  / \
		 A   D
		    / \
		   C   E
		
		In this tree, there is a thread linking the left
		branch of node E to node D, and a thread linking
		the left branch of node C to node B.
		
		This means the following string must be returned:
		
		E|D,C|B,A
		*/

		if (root == null)
			return "";

		DTNode<T> temp = root;
		while (temp.right != null){
			temp = temp.right;
		}

		String out = "";

		out = out + temp.data;
	

		while(temp.left != null){
			if (temp.hasLeftThread){
				temp = temp.left;
				out = out + "|" + temp.data;
			} else {
				temp = temp.left;
				out = out + "," + temp.data;
			}
			
		}
		
		return out;
	}
	
	public String preOrder()
	{
		/*
		This method must return a string representation
		of the elements in the tree in preorder, left to right. 
		This function must not be recursive. Instead, right 
		threads must be utilised to perform a depth-first 
		preorder traversal.
		
		Note that there are no spaces in the string, and
		the elements are comma-separated.
		
		If the tree looks like:
		
		   B
		  / \
		 A   D
		    / \
		   C   E
		
		The following string must be returned:
		
		B,A,D,C,E
		*/
		if (root == null)
			return "";

		DTNode<T> temp = root;
		String out = "";

		out = out + temp.data;
		if (temp.left != null) {
			temp = temp.left;
		} else if (temp.right != null){
			temp = temp.right;
		}

		while(temp != null){
			out = out + "," + temp.data;

			if(temp.left != null && ! temp.hasLeftThread){
				temp = temp.left;
				
			} else if (temp.right != null){
				if (temp.right.left == temp)
				temp = temp.right.right;

			} else {
				temp = temp.right;
			}
		}
		
		return out;
	}
	
	public String preorderDetailed()
	{
		/*
		This method must return a string representation
		of the elements in the tree in preorder, right to left. 
		This function must not be recursive. Instead, right 
		threads must be utilised to perform a depth-first 
		preorder traversal (see the last paragraph on page 240
		of the textbook for more detail on this procedure).
		
		Note that there are no spaces in the string, and
		the elements are comma-separated. Additionally,
		whenever a thread is followed during the
		traversal, a pipe symbol should be printed
		instead of a comma.
		
		If the tree looks like:
		
		   B
		  / \
		 A   D
		    / \
		   C   E
		
		In this tree, there is a thread linking the right
		branch of node A to node B, and a thread linking
		the right branch of node C to node D.
		
		This means the following string must be returned:
		
		B,A|D,C|E
		*/
		
		if (root == null)
			return "";

		DTNode<T> temp = root;
		String out = "";

		out = out + temp.data;

		

		while(temp.right != null){

			if (temp.hasRightThread){
				if(temp.left != null && ! temp.hasLeftThread){
					temp = temp.left;
				} else if (temp.right != null){
	
	
				 if (temp.right.left == temp)
					temp = temp.right.right;
				} else {
					temp = temp.right;
				}



				out = out + "|" + temp.data;
			} else {

				if(temp.left != null && ! temp.hasLeftThread){
					temp = temp.left;
				} else if (temp.right != null){
	
	
				 if (temp.right.left == temp)
					temp = temp.right.right;
				} else {
					temp = temp.right;
				}
				out = out + "," + temp.data;
			}
			

			
		}
		
		return out;
	}
	
	public int getNumberOfNodes()
	{
		/*
		This method should count and return the number of nodes 
		currently in the tree.
		*/
		if (root != null){
			return getNumberOfNodes(root);
		}

		return 0;
	}

	public int getNumberOfNodes(DTNode<T> root){
		int count = 1;
		if (root.left != null && ! root.hasLeftThread)
			count += getNumberOfNodes(root.left);
		if (root.right != null && ! root.hasRightThread)
			count += getNumberOfNodes(root.right);
		
		return count;
	}
	
	public int getHeight()
	{
		/*
		This method should return the height of the tree. The height 
		of an empty tree is 0; the height of a tree with nothing but
		the root is 1.
		*/

		return getHeight(root);
	}

	public int getHeight(DTNode<T> root){
		if (root == null)
			return 0;

			int hLeftSub;
			int hRightSub ;
		if (root.hasLeftThread){
			 hLeftSub = getHeight(null);
		} else {
			 hLeftSub = getHeight(root.left);
		}

		if (root.hasRightThread){
			 hRightSub = getHeight(null);
		} else {
			 hRightSub = getHeight(root.right);
		}
		return Math.max(hLeftSub, hRightSub) + 1;
	}
}
