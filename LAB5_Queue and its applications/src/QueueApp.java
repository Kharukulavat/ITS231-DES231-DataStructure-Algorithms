public class QueueApp {
	/**
	 * Checks if a given string represents an integer.
	 *
	 * @param s The string to be checked.
	 * @return True if the string is an integer, false otherwise.
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if the given strings form a prefix expression (operator followed by
	 * two integers).
	 *
	 * @param x The first string.
	 * @param y The second string.
	 * @param z The third string.
	 * @return True if the strings form a prefix expression, false otherwise.
	 */
	static boolean isPrefix(String x, String y, String z) {
		if (!isInteger(x) && isInteger(y) && isInteger(z))
			return true;
		else
			return false;
	}

	/**
	 * Evaluates a binary operation represented by two integers and an operator.
	 *
	 * @param opt The operator ('+', '-', '*', '/', or '%') to perform the
	 *            operation.
	 * @param x   The first operand as a string.
	 * @param y   The second operand as a string.
	 * @return The result of the binary operation as a string, or "can't be
	 * evaluated" if the operator is invalid or the operands are not valid
	 * integers.
	 */
	static String evalPrefixString(String opt, String x, String y) {
		if (opt.equals("+"))
			return "" + (Integer.parseInt(x) + Integer.parseInt(y));
		else if (opt.equals("-"))
			return "" + (Integer.parseInt(x) - Integer.parseInt(y));
		else if (opt.equals("*"))
			return "" + Integer.parseInt(x) * Integer.parseInt(y);
		else if (opt.equals("/"))
			return "" + Integer.parseInt(x) / Integer.parseInt(y);
		else if (opt.equals("%"))
			return "" + Integer.parseInt(x) % Integer.parseInt(y);
		else
			return "can't be evaluated";
	}

	/**
	 * Evaluates a prefix expression represented by an array of strings.
	 *
	 * @param input The array of strings representing the prefix expression.
	 * @return The result of the evaluated prefix expression.
	 */
	static String prefixEval(String[] input) {
		Queue<String> Q = new Queue<String>();
		for (int i = 0; i < input.length; i++) {
			Q.enqueue(input[i]);
		}
		// Exercise 4
		// add your code here
		String x, y, z;
		Q.printHorizontal();

		x = Q.dequeue();
		y = Q.dequeue();
		z = Q.dequeue();

		String temp;

		if (Q.isEmpty()) { // a prefix contains only three items
			if (isPrefix(x, y, z) == true) {
				return evalPrefixString(x, y, z);
			}
		}

		else { //there are more items in the queue
			do {
				if (isPrefix(x, y, z) == true) {
					temp = evalPrefixString(x, y, z);
					Q.enqueue(temp);

					if (!Q.isEmpty()) {
						x = Q.dequeue();
						y = Q.dequeue();
						z = Q.dequeue();
					}

				} else { //the sequence of x y z doesn't form a prefix
					Q.enqueue(x);
					x = y;
					y = z;
					if (!Q.isEmpty()) {
						z = Q.dequeue();
					}
				}
			}
			while (!Q.isEmpty()); //Handle a special case, Q is empty but there are still numbers stored in x,y,z
				while (!isPrefix(x, y, z)) {
					Q.enqueue(x);
					x = y;
					y = z;
					z = Q.dequeue();
				}
			temp = evalPrefixString(x, y, z);
			Q.enqueue(temp);
		}
		//Handle the last result
		if (!Q.isEmpty()) {
			return Q.dequeue(); //return the last result
		} else {
			return null;
		}
	}
	/**
	 * Simulates the Round Robin scheduling algorithm with given queues of tasks and
	 * their execution times, and a specified resource limit.
	 *
	 * @param Q           The queue of task execution times.
	 * @param P           The queue of task names.
	 * @param limit       The resource limit.
	 * @param resourceAmt The remaining resource amount.
	 */
	static void makeRoundRobin(Queue<Integer> Q, Queue<String> P, int limit, int resourceAmt) { // Exercise 5
		printRoundRobin(Q, P, resourceAmt);
		while (!Q.isEmpty() && resourceAmt != 0) {
			int temp = Q.dequeue();
			String name = P.dequeue();
			if (limit <= resourceAmt) { //when quota <= resourceAmt
				if (temp >= limit) { //when amount >= quota
					// add your codes here
					temp -= limit; // total resource demands = resource demands - quota
					resourceAmt -= limit; // total amount = amount - quota
					if(temp > 0) { //if resource demands still > 0, put back to the queue
						Q.enqueue(temp);
						P.enqueue(name);
					}
					printRoundRobin(Q, P, resourceAmt);
				}

				else { //when temp < limit, when resource demands < quota
					// add your code here
					resourceAmt -= temp; //total amount = amount - resource demands
					printRoundRobin(Q, P, resourceAmt);
				}
			}
			else { //when limit > resourceAmt, -> quota > resourceAmt
				if (temp > resourceAmt) { //resource demands > resource amount
					// add your code here
					temp -= resourceAmt; //total resource demands = resource demands - resourceAmt
					resourceAmt = 0; //resourceAmt must left zero b/c resource demands > resource amount
					Q.enqueue(temp);
					P.enqueue(name);
				} else { //temp < resourceAmt, -> resource demands < resourceAmt
					// add your code here
					resourceAmt -= temp; //total resourceAmt = resourceAmt - resource demands
					temp = 0; //resource demands must left zero b/c resource demands < resourceAmt
				}
				printRoundRobin(Q, P, resourceAmt);
			}
		}
	}

	/**
	 * Prints the Round Robin scheduling status, including remaining resource amount
	 * and tasks.
	 *
	 * @param Q      The queue of task execution times.
	 * @param N      The queue of task names.
	 * @param remain The remaining resource amount.
	 */
	static void printRoundRobin(Queue<Integer> Q, Queue<String> N, int remain) {
		System.out.print(remain + ": ");
		for (int i = 0; i < Q.list.size; i++) {
			String name = N.dequeue();
			Integer need = Q.dequeue();
			System.out.print(name + "-" + need + " ");
			N.enqueue(name);
			Q.enqueue(need);
		}
		System.out.println();
	}

}