/*
Complete your details...
Name and Surname: Giovanni Joubert 
Student/staff Number: u18009035
*/

public class DTNode<T extends Comparable<? super T>>
{
	
	//Constructor
	public DTNode(T data){
		this.data = data;
		left = null;
		right = null;
		hasLeftThread = false;
		hasRightThread = false;
	}
	
	protected T data;
	protected DTNode<T> left, right; // left child and right child
	protected boolean hasLeftThread, hasRightThread; // flags that indicate whether the left and the right pointers are threads
	
}
