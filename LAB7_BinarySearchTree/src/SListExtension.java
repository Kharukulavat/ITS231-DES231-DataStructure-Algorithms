/**
 * The {@code SListExtension} class provides utility methods for working with singly
 * linked lists, specifically for printing the elements vertically.
 */
public class SListExtension {

    /**
     * Prints the elements of a singly linked list vertically.
     *
     * @param list The singly linked list to be printed vertically.
     * @param <T>   The type of elements in the linked list.
     */
    public static <T> void printVertical(SList<T> list) {
        Node<T> walker = list.first;
        while (walker != null) {
            System.out.println(walker.element);
            walker = walker.next;
        }
        System.out.println("-----");
    }
    
}