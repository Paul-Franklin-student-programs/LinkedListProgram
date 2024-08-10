import java.util.Iterator;

/**
 * this class contains the main method
 */
public class LinkedListManager {
    /**
     * main method  creates, populates, and prints
     * LinkedLists, as well as reading data from an
     * external file and adding Integer contents in file
     * to LinkedList
     * @param args
     */
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.insert(101);
        linkedList.insert(24);
        linkedList.insert(3089);
        String filePath;
//        try(Scanner scnr = new Scanner(System.in)){
//            System.out.println("Enter file path");
//            filePath = scnr.nextLine();
//            linkedList.fileReadIntegers(filePath);}
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}

