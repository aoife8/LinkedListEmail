package activity;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head,tail;
    private int size = 0;
    public MyLinkedList() {
        head = tail = null;
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null)
        {
            head = tail = newNode;
            head.setPrevious(null);
        }
        else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail=newNode;
        }
        tail.setNext(null);
        size++;
    }
    @Override
    public E getElement(E data) {
        E element = null;
        Node<E> current = head;
        while (current != null)
        {
            if (current.getData().toString().equals((data).toString()))
                element =  current.getData();
            current = current.getNext();
        }
        if (element == null) {
            try {
                throw new NoSuchElementException("No element exists");
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
        return  element;
    }

    @Override
    public boolean delete(E data) {
        Node<E> current = head;
        if(head.getData().equals(data)){
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return true;
        }
        while (current != null) {
            if (current.getData().equals(data)) {
                current = current.getPrevious();
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    @Override
    public boolean search(E data) {
        Node<E> node = head;
        while (node != null) {
            if (node.getData().toString().equals((data).toString())) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }
    public String toString() {
        StringBuilder result = new StringBuilder("");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.getData());
            current = current.getNext();
            if (current != null) {
                result.append("\n");
            } else {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
