/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 *
 * We implement the Deque
 *
 * Based on a linked bag model
 *
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    /* Static attributes of such an object */
    private Node head;
    private Node tail;
    private int N;

    /* Definition of a node ; recursive, */
    private class Node {

        private Item item;
        private Node next;
        private Node previous;
    }

    /* Constructor (initializes to a null value) */
    public Deque() {
        head = null;
        tail = null;
        N = 0;
        /*assert check();*/
    }

    public boolean isEmpty() // is the deque empty?
    {
        return head == null;
    }

    public int size() // return the number of items on the deque
    {
        return N;
    }

    public void addFirst(Item item) // add the item to the back (tail)
    {
        if (item == null) {
            throw new java.lang.NullPointerException();
        } else if (N == 0) {
            tail = new Node();
            tail.item = item;
            head = tail;
            N++;
        } else if (N > 0) {
            Node oldtail = tail;
            /* keeping the old tail in line */
            tail = new Node();
            /* creating the new node  */
            tail.next = oldtail;
            /* keeping the old tail in line */
            tail.next.previous = tail;
            tail.item = item;
            N++;
        }
    }

    public void addLast(Item item) // add the item to the front
    {
        if (item == null) {
            throw new java.lang.NullPointerException();
        } else if (N == 0) {
            addFirst(item);
        } else if (N > 0) {
            Node oldhead = head;
            /*keeping the old head in place */
            head = new Node();
            /* creating the new head */
            head.previous = oldhead;
            head.previous.next = head;
            head.item = item;
            N++;
        }
    }

    public Item removeFirst() {  // remove and return the item from the back
        if (N == 0) {
            throw new java.util.NoSuchElementException();
        } else {
            Item item = tail.item;
            if (N == 1) {
                head = null;
                tail = null;
            } else if (N >= 2) {
                tail          = tail.next;
                tail.previous = null     ;
            }
            N = N - 1;
            return item;
        }
    }

    public Item removeLast() // remove and return the item from the front
    {
        if (N == 0) {
            throw new java.util.NoSuchElementException();
        } else {
            Item item = head.item ;
            if (N == 1) {
                head = null;
                tail = null;
            } else if (N >= 2) {
                head = head.previous;
                head.next = null;
            }
            N = N - 1;
            return item;
        }
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = tail;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                Item item;
                item = current.item;
                current = current.next;
                return item;
            }
        }
    }

    public static void main(String[] args) // unit testing
    {
        int i;
        int N = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2;
        Deque<Integer> TestObject = new Deque<>();
        for (i = 0; i < N; i++) {
            TestObject.addLast(i);
        }
        System.out.println(TestObject.size());
        Iterator MyIterator = TestObject.iterator();
        while (MyIterator.hasNext()) {
            System.out.println(MyIterator.next());
        }
        for (i = 0; i < N; i++) {
            TestObject.removeLast();
            System.out.println(TestObject.size());
        }
        MyIterator = TestObject.iterator();
        while (MyIterator.hasNext()) {
            System.out.println(MyIterator.next());
        }
    }
}
