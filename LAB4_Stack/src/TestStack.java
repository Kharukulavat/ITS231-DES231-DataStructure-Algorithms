class TestStack {

	public static void main(String[] args) {

		// ============================ Ex.1(a) ============================
		// The result should be :
		// 1
		// 7
		// 5
		// 2
		// Uncomment this part of code to test your result in Ex.1(a)
		System.out.println("***Testing Push for Ex1a***");
		Stack<Integer> S = new Stack<Integer>();
		S.push(2);
		S.push(5);
		S.push(7);
		S.push(1);
		System.out.println("Your result is : ");
		S.printVertical();

		// ============================ Ex.1(b) ============================
		// continue from the previous exercise
		// The result should be :
		// 5
		// 2
		// uncomment the lines below
		System.out.println("\n***Testing Pop for Ex1b***");
		S.pop();
		S.pop();
		System.out.println("Your result is : ");
		S.printVertical();

		// ============================ Ex.1(c) ============================
		// continue from the previous exercise
		// The result should be :
		// 5
		// uncomment the lines below
		System.out.println("\n***Testing Peek for Ex1c***");
		System.out.println("Your result is : ");
		System.out.println(S.peek());
		System.out.println();
		System.out.println();

		// ============================ Ex.2 ============================

		System.out.println("----------------Ex2: Binary Conversion------------");
		// You may comment previous testing of Ex1
		// The correct answer should be :
		// 1 0 0 1 1

		System.out.println("Finding the binary value of 19 ");
		System.out.print("Your result is : ");
		Stack.binaryConversion(19);

		// The correct answer should be :
		// 0
		System.out.println("Finding the binary value of 0");
		System.out.print("Your result is : ");
		Stack.binaryConversion(0);

		// The correct answer should be :
		// 1
		System.out.println("Finding the binary value of 1");
		System.out.print("Your result is : ");
		Stack.binaryConversion(1);

		// System.out.println("----------------Ex.3 Inverse Stack------------");
		// The result should be :
		// 9
		// 8
		// 7
		// 6
		Stack<Integer> S2 = new Stack<Integer>();
		for (int i = 9; i > 5; i--)
			S2.push(i);
		System.out.println("Original Stack ");
		S2.printVertical();
		System.out.println("After Reverse ");
		Stack<Integer> rvS2 = S2.reverseStack();
		System.out.println("Your result is : ");
		rvS2.printVertical();

		System.out.println("----------------Ex4 : isPalindrome------------");
		String word1 = "gatemannametag";
		String word2 = "A";
		String word3 = "12340321";
		String word4 = "Reliefpfeiler";

		// The result should be : gatemannametag is a palindrome.
		System.out.println("Your result is : ");
		System.out.print(word1 + " is ");
		if (!Stack.isPalindrome(word1))
			System.out.print("not ");
		System.out.println("a palindrome.");
		System.out.println();

		// The result should be : A is a palindrome.
		System.out.println("Your result is : ");
		System.out.print(word2 + " is ");
		if (!Stack.isPalindrome(word2))
			System.out.print("not ");
		System.out.println("a palindrome.");
		System.out.println();

		// The result should be : 12340321 is not a palindrome.
		System.out.println("Your result is : ");
		System.out.print(word3 + " is ");
		if (!Stack.isPalindrome(word3))
			System.out.print("not ");
		System.out.println("a palindrome.");
		System.out.println();
		
		// The result should be : Reliefpfeiler is a palindrome.
		System.out.println("Your result is : ");
		System.out.print(word4 + " is ");
		if (!Stack.isPalindrome(word4))
			System.out.print("not ");
		System.out.println("a palindrome.");
		System.out.println();

		System.out.println("----------------Ex 5: PostfixEvaluation ------------");
		String[] postfix1 = { "2", "4", "6", "+", "*" };
		String[] postfix2 = { "4", "5", "+", "6", "3", "/", "-" };
		String[] postfix3 = { "5", "3", "+", "4", "*", "2", "-", "6", "/", "7", "%" };

		int answer = Stack.evalPostfix(postfix1);
		// The result should be : 20
		System.out.println("Your answer for postfix1 : " + answer);

		int answer1 = Stack.evalPostfix(postfix2);
		// The result should be : 7
		System.out.println("Your answer for postfix2 : " + answer1);

		int answer2 = Stack.evalPostfix(postfix3);
		// The result should be : 5
		System.out.println("Your answer for postfix3 : " + answer2);

	}

}