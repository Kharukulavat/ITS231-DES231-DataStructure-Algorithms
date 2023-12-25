/**
 * The {@code SList} class represents a singly linked list that can hold
 * elements of a generic type {@code T}. It provides methods for adding elements
 * to the beginning and end of the list, adding elements at a specified index,
 * removing elements from the beginning and end of the list, removing elements
 * at a specified index, checking if the list is empty, obtaining the size of
 * the list, and searching for elements within the list.
 *
 * @param <T> The type of elements stored in the singly linked list.
 */
public class SList<T> {
	/**
	 * The number of elements currently stored in the singly linked list.
	 */
	int size;
	/**
	 * The reference to the first node in the singly linked list.
	 */
	Node<T> first;
	/**
	 * The reference to the last node in the singly linked list.
	 */
	Node<T> last;

	/**
	 * Constructs an empty singly linked list with size 0.
	 */
	SList() {
		size = 0;
		first = null;
		last = null;
	}

	/**
	 * Adds a new element to the beginning of the singly linked list.
	 *
	 * @param element The element to be added to the list.
	 */
	void addFirst(T element) {
		Node<T> newNode = new Node<T>(element);
		newNode.next = first; //connect with the previous first
		first = newNode; //update first
		size++;
		if (last == null)
			last = first;
	}

	/**
	 * Adds a new element to the end of the singly linked list.
	 *
	 * @param element The element to be added to the list.
	 */
	void addLast(T element) {
		// Ex.1 complete the method
		if (size == 0){
			addFirst(element);
		}

		if (size > 0){
			Node<T> newnode = new Node<T>(element);
			last.next = newnode; //connect last with newnode
			last = newnode; //update last
			size++;
		}
	}

	/**
	 * Adds a new element at the specified index in the singly linked list. If the
	 * index is 0, the element is added to the beginning of the list. If the index
	 * is greater than or equal to the size, the element is added to the end of the
	 * list.
	 *
	 * @param index   The index at which to add the element.
	 * @param element The element to be added to the list.
	 */
	void addAtIndex(int index, T element) {
		// Ex.2 complete the method
		if (index <= 0){
			addFirst(element); //add at index 0 is equal to addFirst(element)
		}
//		else if(index < 0){ (optional)
//			return;
//		}
		else if(index >= size){
			addLast(element); //add at last index or futher is equal to addLast(element)
		}
		else {
			Node<T> current = first;
			for (int i = 0; i < index-1; i++){
				current = current.next; //access attributes of the node @i-1
			}
			Node<T> newnode = new Node<T>(element);
			newnode.next = current.next; //connect newnode to the next one
			current.next = newnode; //newnode is set to current.next
			size++;
		}
	}

	/**
	 * Removes and returns the first element from the singly linked list.
	 *
	 * @return The removed element, or {@code null} if the list is empty.
	 */
	T removeFirst() {
		if (size == 0) { //there's nothing to remove
			return null;
		} else if (size == 1) {
			Node<T> temp = first;
			first = null;
			last = null; //if there's nothing left after removed, update last = null
			size = 0;
			return temp.element;
		}
		else if (size > 1){
			Node<T> temp = first; //create temp node
			first = first.next; //move first to the next one
			size--;
			return temp.element;
		}
		return null;
	}

	/**
	 * Removes and returns the last element from the singly linked list.
	 *
	 * @return The removed element, or {@code null} if the list is empty.
	 */
	T removeLast() {
		// Ex.3 complete the method
		if (size == 0) {
			return null;
		} else if (size == 1){ //has just only one to remove, need to update first, last = null and size = 0
			Node<T> temp = first;
			first = null;
			last = null;
			size = 0;
			return temp.element;
		} else if (size > 1) {
			Node<T> current = first;
			for (int i = 0; i < size - 1; i++){ //access attributes of the 2nd last node
				current = current.next;
			}
			//or access attributes of 2nd node by while loop
//			while(current.next != last){
//				current = current.next;
//			}
			Node<T> temp = last; //create temp node for removing
			last = current; //update last to current (2nd last index)
			last.next = null;  //unlink with the last node
			size--;
			return temp.element;
		}
		return null;
	}

	/**
	 * Removes and returns the element at the specified index in the singly linked
	 * list.
	 *
	 * @param index The index of the element to be removed.
	 * @return The removed element, or {@code null} if the index is out of bounds.
	 */
	T removeAtIndex(int index) {
		// Ex.4 complete the method
		if (index <= 0){
			return removeFirst();
		} else if (index >= size) {
			return removeLast();
		}
		else{
			Node<T> current = first;
			for(int i = 0; i < index - 1; i++){ //access attributes before the index node)
				current = current.next;
			}
			Node<T> temp = current.next; //create temp node for index to be removed
			current.next = temp.next; //connect the previous node with the next node (from temp)
			temp.next = null; //break the link of nextnode
			size--;
			return temp.element;
		}
	}

	/**
	 * Searches for the first occurrence of a specified item in the singly linked
	 * list and returns its index.
	 *
	 * @param item The item to search for.
	 * @return The index of the first occurrence of the item, or {@code -1} if not
	 *         found.
	 */
	int search(T item) {
		// Ex.5 complete the method
		Node<T> current = first;
		int i = 0;
		while(i < size && current.element != item){
			current = current.next;
			i++;
		}
		if (i <= size - 1) {
			// The item was found in the list
			return i;
		} else {
			// The item was not found in the list
			return -1;
		}

	}

	/**
	 * Checks whether the singly linked list is empty.
	 *
	 * @return {@code true} if the list is empty, {@code false} otherwise.
	 */
	boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns the current size of the singly linked list.
	 *
	 * @return The number of elements in the list.
	 */
	int getSize() {

		return size;
	}
	T getElementAtIndex(int index){
		Node<T> current = first;
		for (int i = 0; i < index - 1; i++){
			current = current.next;
		}
		return current.element;
	}

	/**
	 * Prints the elements of the singly linked list horizontally, followed by a
	 * horizontal line separator. This method is primarily used for debugging and
	 * displaying the contents of the list.
	 */
	void printHorizontal() {
		Node<T> walker = first;
		for (int i = 0; i < size; i++) {
			System.out.print(walker.element);
			System.out.print(" ");
			walker = walker.next;
		}
		System.out.println("\n-----");
	}
}