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

	public DTNode<T> insert(DTNode<T> node, T element){

		DTNode<T> InsertMe = new DTNode(element);  
	   
	
		if(root != null){
	 
		 // Moving on left subtree.  
		 if (element.compareTo(node.data) < 0)  
		 {  
			 if (node.hasLeftThread == false && node.left != null)  {
				return insert(node.left, element);
			 }
		}
	 
		 // Moving on right subtree.  
		 else if (element.compareTo(node.data) > 0)
		 {  
			 if (node.hasRightThread == false && node.right != null){
				return insert(node.right, element);
			 }
		 }
		}
		    
	 
	 // Create a new node  
	 if (root == null)  
	 {  
		 root = InsertMe;  
		 InsertMe.left = null;  
		 InsertMe.right = null;  
	 }  
	   
	else if (element.compareTo(node.data) < 0)  
	 {  
		 /*if (node.left != null){
			if(node.left.left == null)
			 node = node.left;
		 } */

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
	/*	if (node.right != null){
			if(node.right.right == null)
				node = node.right;
			
		}*/
		

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

		if (!contains(element)){
			return false; //handles empty tree & not found
		}
		
		root = deleteNode(root, element);

		
		return true;
	}



// Deletes a key from threaded BST with given root and 
// returns new root of BST. PRECHECKED that element EXISTS
	public DTNode<T> deleteNode(DTNode<T> root, T element){

		 // Initialize parent as NULL and ptrent 
    // Node as root. 
	DTNode<T> par = null;
	DTNode<T> ptr = root; 
  
    // Search key in BST : find Node and its 
    // parent. 
    while (ptr != null) 
    { 
        if (element == ptr.data) 
        { 
            break; 
        } 
        par = ptr; 
        if (element.compareTo(ptr.data) < 0) 
        { 
            if (ptr.hasLeftThread == false) 
                ptr = ptr.left; 
            else
                break; 
        } 
        else
        { 
            if (ptr.hasRightThread == false) 
                ptr = ptr.right; 
            else
                break; 
        } 
    } 
  
    // Two Children 
    if (ptr.hasLeftThread == false && ptr.hasRightThread == false) 
		root = caseC(root, par, ptr); 
		
	else if (ptr.hasRightThread && ptr.left == null)
		root = caseA(root, par, ptr); // no child (leftmost)

	else if (ptr.hasLeftThread && ptr.right == null)
		root = caseA(root, par, ptr); // no child (rightmost)

	else if (ptr.hasLeftThread && ptr.hasRightThread)
		root = caseA(root, par, ptr); // no child (middle)

    // Only Left Child 
    else if (ptr.hasLeftThread == false && ptr.right != null) 
        root = caseB(root, par, ptr); 
  
    // Only Right Child 
    else if (ptr.hasRightThread == false && ptr.left != null) 
        root = caseB(root, par, ptr); 
    
  
    return root; 

	}


	// no child
	DTNode<T> caseA(DTNode<T> root, DTNode<T> par, DTNode<T> ptr) 
{ 
	if (par.left == ptr){
		par.left = ptr.left;
		if (ptr.hasLeftThread)
			par.hasLeftThread = true;
	} else {
		par.right = ptr.right;
		if (ptr.hasRightThread)
			par.hasRightThread = true;
	}

    return root; 
} 


// One child
DTNode<T> caseB( DTNode<T> root, DTNode<T> par, DTNode<T> ptr) 
{ 
	if(ptr.right == null){ // only left kid
		ptr.left.right = ptr.right;
		if(par.left == ptr)
			par.left = ptr.left;
		else
			par.right = ptr.left;
	} else { // only right kid
		ptr.right.left = ptr.left;
		if(par.left == ptr)
			par.left = ptr.right;
		else
			par.right = ptr.right;
	}

    return root; 
} 

// Two children
DTNode<T> caseC(DTNode<T> root, DTNode<T> par, DTNode<T> ptr) 
{ 
		DTNode<T> temp = ptr.right;
		while(temp.left != null && !temp.hasLeftThread){ 
			temp = temp.left;
		}

		if(ptr.left.hasRightThread) 
			ptr.left.right = temp;

		if(ptr.right.left.hasLeftThread)
			ptr.right.left.hasLeftThread = false;
	
		temp.left = ptr.left;
		temp = ptr;
		ptr = ptr.right;
		par.right = ptr;
  
    return root; 
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
			if(root.hasLeftThread || root.left == null)
			{
				return contains(null, element);
			} else {
				return contains(root.left, element);
			}

		//Less than 
		if (root.data.compareTo(element) < 0)
			if(root.hasRightThread || root.right == null)
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

		boolean followedThread = true;
		while(temp != null){
			if (!followedThread)
				while(!temp.hasRightThread)
					temp = temp.right;
				
			out = out + "," + temp.data;

			if (temp.hasLeftThread && followedThread)
			{
				while(temp.hasLeftThread)
					temp = temp.left;
				followedThread = true;
			} else if(temp.hasLeftThread)
			{
				followedThread = true;
				temp = temp.left;
			}
			else 
			{
				followedThread = false;
				temp = temp.left;
			}
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
		temp = temp.left;

		boolean followedThread = true;
		while(temp != null){
			if (!followedThread)
				while(!temp.hasRightThread)
					temp = temp.right;
				
			if (followedThread)
				out = out + "|" + temp.data;
			else 
				out = out + "," + temp.data;

			if (temp.hasLeftThread && followedThread)
			{
				while(temp.hasLeftThread)
					temp = temp.left;
				followedThread = true;
			} else if(temp.hasLeftThread)
			{
				followedThread = true;
				temp = temp.left;
			}
			else 
			{
				followedThread = false;
				temp = temp.left;
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
	

	while(temp != null){

		if (temp.left != null && !temp.hasLeftThread){
			temp = temp.left;
			if(temp == null) break;
			out = out + "," + temp.data;
		} else if (temp.hasRightThread){
			while(temp.hasRightThread)
				temp = temp.right;
			temp = temp.right;
			if(temp == null) break;
			out = out + "," + temp.data;
		} else {
			temp = temp.right;
			if(temp == null) break;
			out = out + "," + temp.data;
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
		

		while(temp != null){

			if (temp.left != null && !temp.hasLeftThread){
				temp = temp.left;
				if(temp == null) break;
				out = out + "," + temp.data;
			} else if (temp.hasRightThread){
				while(temp.hasRightThread)
					temp = temp.right;
				temp = temp.right;
				if(temp == null) break;
				out = out + "|" + temp.data;
			} else {
				temp = temp.right;
				if(temp == null) break;
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
