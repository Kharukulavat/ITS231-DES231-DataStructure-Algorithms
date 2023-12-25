/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Math.max;

public class BT<T> {

	int size;
	BTNode<T> root = null;

	BT() {
		root = null;
		size = 0;
	}

	BT(T data) { //Similar to creating BTNode, it is eventually to create a node
		this(new BTNode<T>(data));
	}

	BT(BTNode<T> root) { //create a node by using root of the stack we have
		this.root = root;
		size = 1;
	}

	BT(BTNode<T> root, BT<T> Lsubtree, BT<T> Rsubtree) {
		this.root = root;
		root.left = Lsubtree.root;
		root.right = Rsubtree.root;
		size = Lsubtree.size + Rsubtree.size + 1;
	}

	int findHeight() {
		return findHeight(root);
	}

	int findHeight(BTNode<T> root) {
		// Exercise 1 ////////////////
		if (root == null) {
		// Replace the following statement with your code.
			return 0;
		} else if (isLeaf(root)) {
		// Replace the following statement with your code.
			return 1;
		} else {	
		// Replace the following statement with your code.
			return 1 + max(findHeight(root.left), findHeight(root.right));
		}		
	}

	boolean isLeaf(BTNode<T> root) {
		if (root != null && root.left == null && root.right == null) {
			return true;
		} 
		else {
			return false;
		}
	}

	boolean isBalanced() {
		return isBalanced(root);
	}

	boolean isBalanced(BTNode<T> root) {
		if (root == null) {
			return true;
		}
		int LH = findHeight(root.left);
		int RH = findHeight(root.right);
		int B = Math.abs(LH - RH);
		
		if (B <= 1) {
			return (isBalanced(root.left) && isBalanced(root.right));
		} 
		else {
			return false;
		}
	}

	/* Inorder traversal from the root */
	public void inorder() { //for the other classes to access and use this method
		inorder(root);
	}

	/* Inorder traversal from a subtree */
	protected void inorder(BTNode<T> root) {
		// Exercise 2 (a) Complete this method
		if (root != null) {
			if (isLeaf(root)){
				System.out.println(root.element + " ");
			} else{
				inorder(root.left);
				System.out.println(root.element + " ");
				inorder(root.right);
			}
		}
	}

	/* Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	/* Postorder traversal from a subtree */
	protected void postorder(BTNode<T> root) {
		// Exercise 2 (b) Complete this method
		if (root != null){
			if(isLeaf(root)){
				System.out.println(root.element + " ");
			} else {
				postorder(root.left);
				postorder(root.right);
				System.out.println(root.element + " ");
			}
		}
	}

	/* Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	/* Preorder traversal from a subtree */
	protected void preorder(BTNode<T> root) {
	    if (root != null) {
	       if (isLeaf(root)) {
	    	   System.out.print(root.element + " ");
	       } 
	       else {
	    	   System.out.print(root.element + " ");
	    	   preorder(root.left);
	    	   preorder(root.right);
	       }
	    }
	}

	void PrintDFT() {
		// Exercise 3 ////////////////
		Stack<BTNode<T>> S = new Stack<BTNode<T>>();

		BTNode<T> tmp;
		S.push(root); //insert the root to S
		//insert your code here
		while(!S.isEmpty()){
			tmp = S.pop();
			if (tmp.right != null){
				S.push(tmp.right);
			}
			if (tmp.left != null){
				S.push(tmp.left);
			}
			System.out.print(tmp.element + " ");
		}
	}

	void PrintBFT() {
		// Exercise 4 ////////////////
		Queue<BTNode<T>> Q = new Queue<BTNode<T>>();

		BTNode<T> tmp;
		Q.enqueue(root); //Insert the root to Q
		//insert your code here
		while(!Q.isEmpty()){
			tmp = Q.dequeue();
			if (tmp.left != null){
				Q.enqueue(tmp.left);
			}
			if (tmp.right != null){
				Q.enqueue(tmp.right);
			}
			System.out.println(tmp.element);
		}
	}

	static boolean hasHigherPriority(String sign1, String sign2) {
		if (sign2.equals("("))
			return true;
		else if (sign1.equals("*") && sign2.equals("+"))
			return true;
		else if (sign1.equals("*") && sign2.equals("-"))
			return true;
		else if (sign1.equals("/") && sign2.equals("+"))
			return true;
		else if (sign1.equals("/") && sign2.equals("-"))
			return true;
		else if (sign1.equals("%") && sign2.equals("+"))
			return true;
		else if (sign1.equals("%") && sign2.equals("-"))
			return true;
		else
			return false;

	}

	// Exercise 5 ///////////////////////////////////////////////
	public static boolean isOperator(String item)
	{ 
		if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/") || item.equals("%"))
			return true;
		else
			return false;
	}
     

 
    public static BT<String> makeExpressionTree(String [] infixArr)
	{   
		Stack<BT<String>> BTStack = new Stack<BT<String>>(); //for keeping tree stack (value)
        Stack<BTNode<String>> parent = new Stack<BTNode<String>>(); //for keeping parent nodes, which is operator
        String item;
        int i=0;
        while(i!=infixArr.length){
        	item = infixArr[i]; //read item from array 
        	// Case 1: if item it is an open parenthesis
        	if (item.equals("(")) {
        		//add your code here
				parent.push(new BTNode<String>(item)); //create an operator stack, push it to the stack
        	} 
        	else if (isOperator(item)){ //if item is an operator
        		BTNode<String> temp = new BTNode<String>(item); //temp is an item node
        		if (parent.isEmpty()) { // stack is empty
        			// add your code here
					parent.push(temp);
        		}
        		else {// stack is not empty
              
        			if(hasHigherPriority(item, parent.peek().element)) {  
        				// add your code here
						parent.push(temp);
        			}
        			else { //if it isn't higher priority, then we have to calculate it
        				// add your code here
						BTNode<String> root = parent.pop(); //root is an operator
						BT<String> Right = BTStack.pop(); //top is Y as the right operand
						BT<String> Left = BTStack.pop(); //below top is X as the left operand
						//operation: X (operator) P
						BTStack.push(new BT<String>(root, Left, Right)); //push this node to tree stack

						parent.push(new BTNode<String>(item)); //push item to operand stack

        			}
        		}
        	}
        	// Case3: if item is a close parenthesis  
        	else if (item.equals(")")) {
        		while (parent.peek().element.equals("(") == false) {
        			BTNode<String> root = parent.pop();
        			BT<String> Rsubtree = BTStack.pop();
        			BT<String> Lsubtree = BTStack.pop();
        			BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
        			BTStack.push(newBT);
        		}
        		parent.pop(); //pop from operand stack
        	}
        	else {// Case 4: it is not an operator (it is a value)
        		BT<String> newTree = new BT<String>(item);
        		// add your code here
				BTStack.push(newTree);

        	}
        	i++;
        }
        while (!parent.isEmpty()) { //if operator stack is not empty
        	BTNode<String> root = parent.pop();
        	BT<String> Rsubtree = BTStack.pop();
        	BT<String> Lsubtree = BTStack.pop();
        	BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
        	// add your code here
			BTStack.push(newBT);
        }
        return BTStack.pop(); //return the last result value
    }
}