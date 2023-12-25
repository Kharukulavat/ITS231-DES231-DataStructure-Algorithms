
public class TestBST {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();

		// Ex1. Uncomment below to test insert() //////////////////////////////
		System.out.println("Testing insert()...");
		bst.insert(8);
		bst.insert(19);
		bst.insert(3);
		bst.insert(9);
		bst.insert(5);
		bst.insert(1);
		bst.insert(15);
		System.out.print("BFT of your BST is    ");
		bst.PrintBFT();
		System.out.println("\nThe correct answer is 8 3 19 1 5 9 15\n\n");

		System.out.print("Preorder of your BST is ");
		bst.preorder();
		System.out.println("\nThe correct answer is   8 3 1 5 19 9 15\n\n");

		System.out.print("Inorder of your BST is ");
		bst.inorder();
		System.out.println("\nThe correct answer is  1 3 5 8 9 15 19\n\n");

		System.out.print("Postorder of your BST is ");
		bst.postorder();
		System.out.println("\nThe correct answer is    1 5 3 15 9 19 8\n\n");
		System.out.println("Height of your BST =  " + bst.findHeight());
		System.out.println("The correct answer is 4");

		// Ex2. Uncomment below to test delete() //////////////////////////////
		/*System.out.println("\nTesting delete()...");

		if (bst.delete(2) == null) {
			System.out.println("bst.delete(2) is null");
		}
		System.out.println("The correct answer is null\n");

		bst.delete(1);
		System.out.print("BFT of your BST is    ");
		bst.PrintBFT();
		System.out.println("\nThe correct answer is 8 3 19 5 9 15\n");

		bst.delete(19);
		System.out.print("BFT of your BST is    ");
		bst.PrintBFT();
		System.out.println("\nThe correct answer is 8 3 9 5 15\n");

		bst.delete(8);
		System.out.print("BFT of your BST is    ");
		bst.PrintBFT();
		System.out.println("\nThe correct answer is 5 3 9 15\n");

		bst.delete(3);
		System.out.print("BFT of your BST is    ");
		bst.PrintBFT();
		System.out.println("\nThe correct answer is 5 9 15\n");

		bst.delete(5);
		System.out.print("BFT of your BST is    ");
		bst.PrintBFT();
		System.out.println("\nThe correct answer is 9 15\n");

		System.out.println("Height of your BST =  " + bst.findHeight());
		System.out.println("The correct answer is 2");*/

		// Ex3. Uncomment below to test search() //////////////////////////////
		/*System.out.println("\nTesting search()...");
		if (bst.search(12)) {
			System.out.println("12 is found");
		} else {
			System.out.println("12 is not found");
		}
		System.out.println("The correct answer is 12 is not found\n");

		if (bst.search(15)) {
			System.out.println("15 is found");
		} else {
			System.out.println("15 is not found");
		}
		System.out.println("The correct answer is 15 is found\n");*/

		// Ex4. Uncomment below to test findSmallest() //////////////////////////////
		/*bst.insert(1);
		bst.insert(3);
		bst.insert(19);
		System.out.println("\nTesting findSmallest()...");
		System.out.println("The smallest element is " + bst.findSmallest(bst.root).element);
		System.out.println("The correct answer is 1\n");*/

		// Ex5. Uncomment below to test findLargest() //////////////////////////////
		/*System.out.println("\nTesting findLargest()...");
		System.out.println("The largest element is " + bst.findLargest(bst.root).element);
		System.out.println("The correct answer is 19");*/

	}

}