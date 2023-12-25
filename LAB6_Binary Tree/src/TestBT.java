public class TestBT {
 
    public static void main(String[] args) {

        // Testing one-argument constructor
        BT<String> tree1 = new BT<String>(new BTNode<String>("Yo"));

        // Testing three-argument constructor
        BT<Integer> subtree1 = new BT<Integer>(new BTNode<Integer>(4), new BT<Integer>(2), new BT<Integer>(3));

        BTNode<Integer> subtree_root = new BTNode<Integer>(6);
        BT<Integer> subtree2 = new BT<Integer>(subtree_root, new BT<Integer>(1), new BT<Integer>(8));

        BTNode<Integer> root2 = new BTNode<Integer>(5);
        BT<Integer> myTree = new BT<Integer>(root2, subtree1, subtree2);

        //============================ Ex.1 ============================
        //Uncomment this part of code to test your result in Ex.2
 
        System.out.println("The height of tree1 is : " + tree1.findHeight());
        System.out.println("The correct result is 1");

        System.out.println("The height of myTree is : " + myTree.findHeight());
        System.out.println("The correct result is 3");
        System.out.println();
        //============================ Ex.2 ============================
        //============================ Ex.2(a) ============================
        //Uncomment this part of code to test your result in Ex.2(a)
        //Uncomment this part of code to test your result in Ex.2(b)

        System.out.print("Ex2 a) Your inorder traversal is : ");
        myTree.inorder();
         System.out.println();
        System.out.println( "The correct result is : 2 4 3 5 1 6 8");
        System.out.println();
        //============================ Ex.2(b) ============================
        //Uncomment this part of code to test your result in Ex.2(b)

        System.out.print("Ex2 b) Your postorder traversal is : ");
        myTree.postorder();
         System.out.println();
        System.out.println("The correct result is : 2 3 4 1 8 6 5");
        System.out.println();

        //============================ Ex.3 ============================
        //Uncomment this part of code to test your result in Ex.3

        System.out.println("Ex3 Your DFT is :    ");
        myTree.PrintDFT();
        System.out.println("The correct result is : 5 4 2 3 6 1 8");
        System.out.println();
 
        //============================ Ex.4 ============================
        //Uncomment this part of code to test your result in Ex.4(b)
        System.out.println("Ex4 Your BFT is :     ");
        myTree.PrintBFT();
        System.out.println("The correct result is : 5 4 6 2 3 1 8");
        System.out.println();

        //============================ Ex.5 ============================
        //Uncomment this part of code to test your result in Ex.5
        System.out.print("Ex5 making Expression Tree from an infix expression  A + ( B * ( C - D ) ) / E      ");
        String [] infixArray = {"A","+","(", "B", "*","(", "C", "-", "D", ")", ")", "/", "E"};
        BT<String> result =BT.makeExpressionTree(infixArray);
        System.out.print("\nYour Breadth First Traversal of this expression tree is :");
        result.PrintBFT();
        System.out.println("\nThe correct result is :  + A / * E B - C D\n");
        System.out.print("Your Depth First Traversal of this expression tree is :");
        result.PrintDFT();
        System.out.println("\nThe correct result is :+ A / * B - C D E");

        System.out.println("\nThe height of this expression tree is " + result.findHeight());
        System.out.println("The correct result is 5");
    }
}