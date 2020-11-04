package elluican.test;

public class Node<T extends Comparable<T>> {

	private T data;
    private Node<T> nextElement;

    T getData() {
        return this.data;
    }

    void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node<T> nextElement) {
        this.nextElement = nextElement;
    }


}
