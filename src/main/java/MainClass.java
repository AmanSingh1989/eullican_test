import elluican.test.SingleSortedLinkedList;

import java.util.Iterator;

public class MainClass{

    public static void main(String ars[]){
        checkString();
        checkInteger();

    }

	private static void checkString() {
		SingleSortedLinkedList<String> test= new SingleSortedLinkedList<>(1);

        test.addElement("Deepak");
        test.addElement("Aman");
        test.addElement("Test");

        Iterator<String> itr=test.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());

        }
	}
	
	private static void checkInteger() {
		SingleSortedLinkedList<Integer> test= new SingleSortedLinkedList<>();

        test.addElement(2);
        test.addElement(3);
        test.addElement(5);
        test.addElement(4);

        Iterator<Integer> itr=test.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());

        }
	}
}
