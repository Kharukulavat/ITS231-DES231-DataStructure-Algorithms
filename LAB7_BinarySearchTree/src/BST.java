public class BST<T extends Comparable<T>> extends BT<T> {
	/** Create an empty binary tree */
	public BST() {

	}

	/** Create a binary tree from an object */
	public BST(T object) {
		root.element = object;
	}

	/** Create a binary tree from an array of objects */
	public BST(T[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	// ----------------------------------------------
	/**
	 * Insert newdata into the binary search tree
	 */
	public void insert(T newdata) {
		// Ex1: Complete this program
		if (root == null) {
			// Create a new root
			root = new BTNode<T>(newdata);
		} else {
			// Locate the parent node
			BTNode<T> parent = null;
			BTNode<T> current = root;
			// insert your code
			while(current != null){
				parent = current;
				if (newdata.compareTo(current.element) <= 0){ //if newdata <= current, go left
					current = current.left;
				}
				else if (newdata.compareTo(current.element) > 0){ //if newdata > current, go right
					current = current.right;
				}
			}
			//when current == null (the leaf node)
			if (newdata.compareTo(parent.element) <= 0){ //to insert the newnode
				parent.left = new BTNode<T>(newdata); //if newnode <= its parent, assign newnode to left
			}
			else {
				parent.right = new BTNode<T>(newdata); //if newnode > its parent, assign newnode to right
			}
		}

		size++;
	}

	// ----------------------------------------------
	/**
	 * Delete data from the binary search tree
	 */
	// Ex2. Complete This Program
	public T delete(T item) {
		// Locate the node to be deleted and also locate its parent node
		BTNode<T> parent = null;
		BTNode<T> current = root;

		boolean currentIsLeftChild = true;

		while (current != null) {
			// insert your code
			//we need to search for the deleted node first
			if(item.compareTo(current.element) < 0){ //if item < current element, go left
				parent = current;
				current = current.left;
				currentIsLeftChild = true;

			}
			else if (item.compareTo(current.element) > 0){ //if item > current element, go right
				parent = current;
				current = current.right;
				currentIsLeftChild = false;
			}
			else {
				break;
			}
		}

		// Case 0: item is not in the tree
		if (current == null) {
			return null;
		}

		T temp = current.element;
		// Case 1: current is the leave

		if (current.left == null && current.right == null) {
			// insert your code
			if(currentIsLeftChild){
				parent.left = null;
			}
			else {
				parent.right = null;
			}
		}

		// Case 2: If the deleted node has one child
		// Case 2.1: if its child node is on the right
		if ((current.left == null)) { // If only has one right child or no children.
			if (currentIsLeftChild) {
				// insert your code
				if(parent == null){ //it is the root (if deleting root)
					root = current.right; //there's no leftsub for the previous root, so when it deleted the root,
					// the right child of the root will be the next root
				}
				else { //it is not the root, current is left child, it has no current.left so when it deleted current,
					// it has to link parent.left with the current.right
					parent.left = current.right;
					current.right = null; //disconnect the link of temp(current)
				}

			} else { //current is right child
				// insert your code
				if(parent == null){ //it is the root (if deleting root)
					root = current.right; //there's no leftsub for the previous root, so when it deleted the root,
					// the right child of the root will be the next root
				}
				else { //it is not root, current is right child, it has np current.left so when it deleted current,
					// it has to link parent.right with the current.right
					parent.right = current.right;
					current.right = null; //disconnect the link of temp(current)
				}
			}
		}
		// Case 2.2: If its child node is on the left
		else if ((current.right == null)) { // Only one left child
			if (currentIsLeftChild) {
				// insert your code
				if (parent == null){ //it is the root (if deleting root)
					root = current.left; //there's no rightsub for the previous root, so when it deleted the root,
					// the left child of the root will be the next root
				}
				else{ //it is not root, current is left child, it has no current.right so when it deleted current,
					// it has to link parent.left with the current.left
					parent.left = current.left;
					current.left = null; //disconnect the link of temp(current)

				}
			} else { //current is right child
				// insert your code
				if (parent == null){ //it is the root (if deleting root)
					root = current.left; //there's no rightsub for the previous root, so when it deleted the root,
					// the left child of the root will be the next root
				}
				else{ //it is not root, current is right child, it has no current.right so when it deleted current,
					// it has to link parent.right with the current.left
					parent.right = current.left;
					current.left = null; //disconnect the link of temp(current)
				}
			}
		} else { // Case 3: Have both children
			BTNode<T> maxleft = current.left;
			BTNode<T> maxleftParent = current;
			while (maxleft.right != null) {
				maxleftParent = maxleft;
				maxleft = maxleft.right;
			}
			current.element = maxleft.element; //replace the temp(current) with maxleft
			if (maxleft.left == null && maxleft.right == null) { // Case 3.1 if maxleft is a leave,
				// then replace the temp(current) with maxleft, then set maxleftParent to have no child (unlink)
				//insert your code
				maxleftParent.right = null; //unlink maxleftParent with maxleft
			} 
			else if (maxleft.left != null) { // Case 3.2 if maxleft has a left child,
				// then replace the temp(current) with maxleft, make maxleft.left be the right child of maxleftParent
				//insert your code
				maxleftParent.right = maxleft.left; //connect maxleftParent with maxleft.left
				maxleft.left = null; //unlink maxleft with maxleft.left
			} 
			else if (maxleftParent == current) { // Case 3.3 if maxleft is leftchild of current,
				// then replace the temp(current) with maxleft, make maxleft.left be the leftchild of temp(current.left)
				//insert your code
				current.left = maxleft.left; //connect temp(current) with maxleft.left
				maxleft.left = null; //unlink maxleft with maxleft.left
			}
		}
		size--;
		return temp;
	}
	// ---------------------------------------------------------

	// Search for the data returns true if it finds the data or otherwise false
	public boolean search(T data) { 
		// Ex 3: Complete this section.
		//replace the following line with your code
		BTNode<T> current = root;
		while (current != null){
			if (data.compareTo(current.element) < 0) { //if data <= current, go left in search we compare just for < 0
				//if we use <= 0 it'll haas a problem when it matches, it will continue going left but it should stop there so we need to use < 0zsz
				current = current.left;
			}
			else if (data.compareTo(current.element) > 0) { //if newdata > current, go right
				current = current.right;
			}
			else { //element matches with current.element
				return true;
			}
		}
		return false;
	}

	// ---------------------------------------------------------

	BTNode<T> findSmallest() {
		return findSmallest(root);
	}

	// ----------------------------------------------
	BTNode<T> findSmallest(BTNode<T> start) {
		// Ex 4: Complete this section.
		//replace the following line with your code
		BTNode<T> smallest = start;
		while (smallest.left != null) {
			smallest = smallest.left;
		}
		if (smallest.left == null){
			return smallest;
		}
		else {
			return null;
		}
	}

	// ----------------------------------------------
	BTNode<T> findLargest() {
		return findLargest(root);
	}

	// ----------------------------------------------
	BTNode<T> findLargest(BTNode<T> start) { 
		// Ex 5: Complete this section.
		//replace the following line with your code
		BTNode<T> largest = start;
		while (largest.right != null){
			largest = largest.right;
		}
		if (largest.right == null){
			return largest;
		}
		else {
			return null;
		}
	}

	/** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public BTNode getRoot() {
		return root;
	}

	/** Returns a path from the root leading to the specified element */
	public java.util.ArrayList<BTNode<T>> path(T e) {
		java.util.ArrayList<BTNode<T>> list = new java.util.ArrayList<BTNode<T>>();
		BTNode<T> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Retur