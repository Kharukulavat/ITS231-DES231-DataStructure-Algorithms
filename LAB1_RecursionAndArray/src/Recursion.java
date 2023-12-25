public class Recursion {

    static int subsum(int n) {
        //Ex1. Complete the content of this method
        // Base case: If n is less than or equal to 0, return 0
        if (n <= 0) {
            return 0;
        }
        // Recursive case
        if (n % 2 == 0) {
            // If n is even, subtract the sum of subsum(n-1) from -n
            return -n + subsum(n - 1);
        } else {
            // If n is odd, add the sum of subsum(n-1) to n
            return n + subsum(n - 1);
        }
    }

    static int sumDigit(int n) {
        //Ex2. Complete the content of this method
        if (n == 0) { //Base case: when there's no digit left (n = 0)
            return 0;
        } else{ //Recursive case: continue adding digit and divide the digit with 10 to next
            return n % 10 + sumDigit(n/10);
        }

    }

    public static void main(String[] args) {


        // Test Uncomment these lines below to test your subsum code

        System.out.println("Calculating subsum(10):");
        System.out.println("Your answer is "+subsum(10));
        System.out.println("The correct answer is -5");
        System.out.println("-----------------------");

        // Uncomment these lines below to test your sumDigit code

        System.out.println("sumDigit(123456789)");
        System.out.println("Your answer is "+ sumDigit(123456789));
        System.out.println("The correct answer is 45");
    }

}