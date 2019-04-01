/*
Complete your details...
Name and Surname: 
Student/staff Number:
*/


public class DoubleThreadedBST<T extends Comparable<? super T>>
{
	private DTNode<T> root; // the root node of the tree

	/*
	TODO: You must complete each of the methods in this class to create
	your own double threaded BST. You may add any additional methods
	or data fields which you might need to accomplish your task. You
	must NOT change the signatures of any methods given to you with this
	class.
	*/
	
	public DoubleThreadedBST()
	{
		/*
		The default constructor
		*/
	}
	
	public DoubleThreadedBST(DoubleThreadedBST<T> other)
	{
		/*
		The copy constructor
		*/
	}
	
	public DoubleThreadedBST<T> clone()
	{
		/*
		The clone method should return a copy/clone
		of this tree.
		*/
		
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
		
		return false;
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
		
		return false;
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
		
		return "";
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
		
		return "";
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
		
		return "";
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
		
		return "";
	}
	
	public int getNumberOfNodes()
	{
		/*
		This method should count and return the number of nodes 
		currently in the tree.
		*/
		
		return 0;
	}
	
	public int getHeight()
	{
		/*
		This method should return the height of the tree. The height 
		of an empty tree is 0; the height of a tree with nothing but
		the root is 1.
		*/
		
		return 0;
	}
}
