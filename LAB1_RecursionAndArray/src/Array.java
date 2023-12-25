public class Array {
    final int size;  //The maximum capacity of A
    int [] A ;
    int load=0;  //number of elements in A

    Array(int n)
    { size = n;
        A = new int[size];
    }

    //Ex3 a
    void addFirst(int e)
    {
//        addAtIndex(e, 0);
        if (load < size) {
            for (int i = load; i > 0; i--){ //i is the index starts from the back
                A[i] = A[i-1]; //we have to move the rest first, this moves from front to back (right to left)
            }
            A[0] = e; //add the number to the first index
            load++; //add 1 more load b/c we add 1 more value
        }
    }
    //Ex3 b
    void addLast(int e)
    {
        addAtIndex(e, load);
    }

    //Ex3 c
    void addAtIndex(int e, int index)
    {
        for (int i = load; i > index; i--) { //i must greater than index in order to move those after index to back
            A[i] = A[i-1]; //move the rest(after index) to the back
        }
        A[index] = e; //Add value e to index index
        load++; //b/c we add 1 more value
    }

    //Ex4 a
    int removeFirst()
    {
//        removeAtIndex(0);
        if (load == 0){ //we can't remove anything when load = 0
            return -1;
        }
        int temp = A[0]; //we want to move the first index
        for (int i = 0; i < load - 1; i++) { // i < load - 1 because we remove first index and the rest that will be moved will be < load -1 numbers
            A[i] = A[i+1]; //move the rest to the front
        }
        A[load-1] = 0; //just make the last index = 0 to make sure that the last position at first will be empty
        // (because we moved the rest to the front after we removeFistIndex)
        load--;
        return temp;
    }

    //Ex4 b
    int removeLast()
    {
        int temp = A[load - 1]; //Logically correct, but it's also fine when we use A[load] to A[load + 3] (not exceeding arrays' size, which is 10)
                                // this will also get the same output as using A[load - 1].
        // maybe because it will eventually use the latest index even if the indexing is beyond the last index
        removeAtIndex(load - 1);
        return temp;
    }

    //Ex4 c
    int removeAtIndex(int index)
    {
        if (load == 0){ //we can't remove anything when load = 0
            return -1;
        }
        int temp = A[index];  //we want to remove this index
        for (int i = index; i < load - 1; i++) {
            A[i] = A[i+1];
        }
        A[load-1] = 0;
        load--;
        return temp;
    }

    //Ex5 a
    int  getElementAtIndex(int index)
    {
        return A[index];
    }

    //Ex5 b
    void  setElementAtIndex(int val, int index)
    {
        A[index] = val;

    }


    void printArray( )
    {  for (int i=0; i< load; i++ )
    {  System.out.print(A[i]+" ");
    }
        System.out.println("\nArray load is " +load);
    }

    public static void main(String [] args)
    {
        Array A = new Array(10);

        //Uncomment this section to test Ex3 a

        A.addFirst(9);
        A.addFirst(1);
        A.addFirst(4);
        System.out.println("After addFirst 9, 1, and 4 to A");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n4 1 9 \nArray load is 3");


        //Uncomment this section to test Ex3 b

        System.out.println("----------------------------------");
        A.addLast(2);
        A.addLast(5);
        A.addLast(8);
        System.out.println("After addLast 2, 5, and 8 to A");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n4 1 9 2 5 8 \nArray load is 6");

        //Uncomment this section to test Ex3 c

        System.out.println("----------------------------------");
        A.addAtIndex(6, 2);
        A.addAtIndex(3, 4);
        System.out.println("After add 6 at index 2, and add 3 at index 4 to A ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n4 1 6 9 3 2 5 8 \nArray load is 8");


        //Uncomment this section to test Ex4 a

        System.out.println("----------------------------------");
        A.removeFirst();
        A.removeFirst();
        System.out.println("After removeFirst twice ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 9 3 2 5 8 \nArray load is 6");


        //Uncomment this section to test Ex4 b

        System.out.println("----------------------------------");
        A.removeLast();
        A.removeLast();
        System.out.println("After removeLast twice ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 9 3 2 \nArray load is 4");


        //Uncomment this section to test Ex4 c

        System.out.println("----------------------------------");
        A.removeAtIndex(1);
        A.removeAtIndex(1);
        System.out.println("After removeAtIndex 1 twice ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 2 \nArray load is 2");


        //Uncomment this section to test Ex5 a

        System.out.println("----------------------------------");
        A.setElementAtIndex(7, 1);
        System.out.println("After set value at index 1 to 7 ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 7 \nArray load is 2");


        //Uncomment this section to test Ex5 b

        System.out.println("----------------------------------");
        System.out.println("Your Answer is");
        System.out.println("Value at A[1]= " + A.getElementAtIndex(1));
        System.out.println("Correct Answer is\nValue at A[1]= 7");

    }

}