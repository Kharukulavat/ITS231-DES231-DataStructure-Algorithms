public class TestQueue {
	public static void main(String[] args) {
		// Exercise 1.a
		// Your Q content should be: 0 1 2 3 4
		// Your Q size should be: 5
		System.out.println("Testing Queue basic operations");
		System.out.println("After enqueue 0 1 2 3 4 to the queue");
		Queue<Integer> Q = new Queue<Integer>();
		for (int i = 0; i < 5; i++) {
			Q.enqueue(i);
		}
		System.out.print("Your Q content is :");
		Q.printHorizontal();
		System.out.println("Your Q size is :" + Q.list.size);
		System.out.println("----------");

		// Exercise 1.b
		// Your Q content should be: 1 2 3 4
		// Your Q size should be: 4
		System.out.println("\nAfter dequeue this Q");
		Q.dequeue();
		System.out.print("Your Q content is :");
		Q.printHorizontal();
		System.out.println("Your Q size is :" + Q.list.size);
		System.out.println("----------");

		// Exercise 1.c
		// The result of queuefront should be: 1
		// The result of queuerear should be: 4
		// Your Q size should be: 4
		// Your Q content should be: 1 2 3 4
		System.out.println("\nTesting queuefront of this Q");
		System.out.println("The front of the Q is: " + Q.queuefront());
		System.out.println("\nTesting queuerear of this Q");
		System.out.println("The rear of the Q is: " + Q.queuerear());
		System.out.println("\nYour Q size is :" + Q.list.size);
		System.out.print("Your Q content is :");
		Q.printHorizontal();
		System.out.println("----------");

		// Exercise 2
		// Your Q content should be: 1 2 3 4
		// Your Q size should be: 4
		// Your Q2 content should be: 1 2 3 4
		// Your Q2 size should be: 4
		System.out.println("\nTesting copyQueue");
		Queue<Integer> Q2 = Q.copyQueue();
		System.out.print("Your Q content is: ");
		Q.printHorizontal();
		System.out.println("Your Q size is :" + Q.list.size);
		System.out.print("Your Q2 content is: ");
		Q2.printHorizontal();
		System.out.println("Your Q2 size is :" + Q.list.size);
		System.out.println("----------");

		// Exercise 3
		// The result should be: Q3 and Q4 are not identical.
		// The result should be: Q5 and Q6 are identical.
		// The result should be: Q7 and Q8 are not identical.
		// NOTE: All of elements in the queue should remains the same.
		System.out.println("\nTesting isIdentical");
		Queue<Integer> Q3 = new Queue<Integer>();
		Q3.enqueue(1);
		Q3.enqueue(2);
		Q3.enqueue(3);
		Queue<Integer> Q4 = new Queue<Integer>();
		Q4.enqueue(1);
		Q4.enqueue(2);
		Q4.enqueue(3);
		Q4.enqueue(4);
		System.out.print("Q3: ");
		Q3.printHorizontal();
		System.out.print("Q4: ");
		Q4.printHorizontal();
		System.out.print("Evaluation: Q3 and Q4 are ");
		if (Q4.isIdentical(Q3)) {
			System.out.println("identical.");
		} else {
			System.out.println("not identical.");
		}
		System.out.println("After the evaluation the content, of Q3 and Q4 are ");
		System.out.print("Q3: ");
		Q3.printHorizontal();
		System.out.print("Q4: ");
		Q4.printHorizontal();

		System.out.println("\nTesting copyQueue and isIdentical");
		Queue<String> Q5 = new Queue<String>();
		Q5.enqueue("Alice");
		Q5.enqueue("Bob");
		Q5.enqueue("Chalie");
		System.out.print("Q5: ");
		Queue<String> Q6 = Q5.copyQueue();
		Q6.printHorizontal();
		System.out.print("Q6: ");
		Q6.printHorizontal();
		System.out.print("Evaluation: Q5 and Q6 are ");
		if (Q5.isIdentical(Q6)) {
			System.out.println("identical.");
		} else {
			System.out.println("not identical.");
		}
		System.out.println("After the evaluation, the content of Q5 and Q6 are ");
		System.out.print("Q5: ");
		Q5.printHorizontal();
		System.out.print("Q6: ");
		Q6.printHorizontal();

		System.out.println("\nTesting isIdentical");
		Queue<Integer> Q7 = new Queue<Integer>();
		Q7.enqueue(3);
		Q7.enqueue(5);
		Q7.enqueue(6);
		Queue<Integer> Q8 = new Queue<Integer>();
		Q8.enqueue(3);
		Q8.enqueue(4);
		Q8.enqueue(5);
		System.out.print("Q7: ");
		Q7.printHorizontal();
		System.out.print("Q8: ");
		Q8.printHorizontal();
		System.out.print("Evaluation: Q7 and Q8 are ");
		if (Q7.isIdentical(Q8)) {
			System.out.println("identical.");
		} else {
			System.out.println("not identical.");
		}
		System.out.println("After the evaluation, the content of Q7 and Q8 are ");
		System.out.print("Q7: ");
		Q7.printHorizontal();
		System.out.print("Q8: ");
		Q8.printHorizontal();

		// Exercise 4.a
		// The result should be: + 2 3 is a prefix expression
		// The result should be: 2 + 3 is not a prefix expression
		// The result should be:2 3 + is not a prefix expression
		System.out.println("\n\nTesting isPrefix");
		System.out.println("Expression: + 2 3");
		if (QueueApp.isPrefix("+", "2", "3"))
			System.out.println("Your result is + 2 3 is a prefix expression");
		else
			System.out.println("Your result is + 2 3 is not a prefix expression");

		System.out.println("\nExpression: 2 + 3");
		if (QueueApp.isPrefix("2", "+", "3"))
			System.out.println("Your result is : 2 + 3 is a prefix expression");
		else
			System.out.println("Your result is : 2 + 3 is not a prefix expression");

		System.out.println("\nExpression: 2 3 +");
		if (QueueApp.isPrefix("2", "3", "+"))
			System.out.println("Your result is : 2 3 + is a prefix expression");
		else
			System.out.println("Your result is : 2 3 + is not a prefix expression");

		// Exercise 4.b
		// The result should be 5
		// The result should be 40
		// The result should be 1
		System.out.println("\nTesting prefixEval");
		String[] input1 = { "+", "2", "3" };
		System.out.println("Your Result is " + QueueApp.prefixEval(input1));
		System.out.println();

		String[] input2 = { "*", "+", "2", "3", "+", "1", "7" };
		System.out.println("Your Result is " + QueueApp.prefixEval(input2));
		System.out.println();

		String[] input3 = { "/", "+", "-", "3", "1", "2", "4" };
		System.out.println("Your result is " + QueueApp.prefixEval(input3));
		System.out.println();

		// Exercise 5
		// The correct result should be
		// 40: P1-6 P2-12 P3-4 P4-5 P5-7 P6-9
		// 37: P2-12 P3-4 P4-5 P5-7 P6-9 P1-3
		// 34: P3-4 P4-5 P5-7 P6-9 P1-3 P2-9
		// 31: P4-5 P5-7 P6-9 P1-3 P2-9 P3-1
		// 28: P5-7 P6-9 P1-3 P2-9 P3-1 P4-2
		// 25: P6-9 P1-3 P2-9 P3-1 P4-2 P5-4
		// 22: P1-3 P2-9 P3-1 P4-2 P5-4 P6-6
		// 19: P2-9 P3-1 P4-2 P5-4 P6-6
		// 16: P3-1 P4-2 P5-4 P6-6 P2-6
		// 15: P4-2 P5-4 P6-6 P2-6
		// 13: P5-4 P6-6 P2-6
		// 10: P6-6 P2-6 P5-1
		// 7: P2-6 P5-1 P6-3
		// 4: P5-1 P6-3 P2-3
		// 3: P6-3 P2-3
		// 0: P2-3
		System.out.println("\nTesting Round Robin");
		Queue<Integer> RRB = new Queue<Integer>();
		RRB.enqueue(6);
		RRB.enqueue(12);
		RRB.enqueue(4);
		RRB.enqueue(5);
		RRB.enqueue(7);
		RRB.enqueue(9);
		Queue<String> P = new Queue<String>();
		P.enqueue("P1");
		P.enqueue("P2");
		P.enqueue("P3");
		P.enqueue("P4");
		P.enqueue("P5");
		P.enqueue("P6");
		int amount = 40;
		int quota = 3;
		System.out.println("Your result is ");
		QueueApp.makeRoundRobin(RRB, P, quota, amount);
	}

}