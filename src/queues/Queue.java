package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The class Queue, that implements Iterable, manages items in a single linked list,
 * where we can enqueue() items to the end and dequeue() items from the from of the queue.
 *
 * @param <T> Type of data to be stored.
 * @author Pires, Marilize.
 */
public class Queue<T> implements Iterable<T> {

    // Class attributes.
    private String name; // Test and debugging purposes.
    private Node head; // It points to the front of the queue.
    private Node tail; // It points to the end of the queue.
    private int size; // Size of the queue.

    /**
     * Constructor that initializes some of the class attributes and it takes in the user assigned name.
     *
     * @param name String that stores the name of the list.
     */
    Queue(String name) {
        this.name = name;
        this.size = 0;
    }

    /**
     * Enqueue() takes a genetic item as the argument and ass the item to the end of the queue.
     *
     * @param item genetic type to be added.
     */
    public void enqueue(T item) {
        if (item == null)
            return;

        Node newNode = this.tail;
        this.tail = new Node(item);
        this.tail.next = null;

        if (isEmpty()) {
            this.head = this.tail;
        } else {
            newNode.next = this.tail;
        }
        this.size++;
    }

    /**
     * dequeue() method receives no arguments and removes the item from the front of the queue.
     *
     * @return genetic type item dequeue-ed
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node node = this.head;
        this.head = this.head.getNext();

        if (this.head == null) {
            this.tail = null;
        }
        this.size--;
        return node.getData();
    }

    /**
     * peek() method looks at the least recently added item of the queue.
     *
     * @return an object of the generic type for the data seen at the front of the queue.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.head.getData();
    }

    /**
     * isEmpty() method checks for empty queue.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size <= 0;
    }

    /**
     * size() method returns the size of the list.
     *
     * @return size of list.
     */
    public int size() {
        return this.size;
    }

    /**
     * toString() method returns the list of songs and its contents.
     *
     * @return a string containing the name and elements of the given list of songs.
     */
    public String toString() {

        //It concatenates strings.
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append("\n[");

        if (this.head != null) {
            Node current = this.head;
            stringBuilder.append(current.getData());

            while (current.getNext() != null) {
                stringBuilder.append("\n");
                current = current.getNext();
                stringBuilder.append(current.getData());
            }
        } else {
            stringBuilder.append(this.name + " has " + this.size + " songs.");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * Accessor method.
     *
     * @return the name of the string.
     */
    public String getName() {
        return this.name;
    }

    /**
     * It calls the inner QueueIterator class.
     *
     * @return iterator.
     */
    public Iterator<T> iterator() {
        return new QueueIterator();
    }


    // INNER CLASSES: Node & QueueIterator

    /**
     * Inner class Node stores data list entries.
     */
    private class Node {

        // Class attributes.
        private Node next;
        private final T data;

        /**
         * Constructor that initializes the class attributes.
         *
         * @param dataItem data to be stored.
         */
        Node(T dataItem) {
            this.data = dataItem;
            this.next = null;
        }

        /**
         * Accessor.
         *
         * @return the next node.
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Accessor.
         *
         * @return the data stored in the current node.
         */
        public T getData() {
            return this.data;
        }
    }


    /**
     * The class QueueIterator, that implements the Iterator and has a genetic type paramenter,
     * iterates over Queue.
     */
    private class QueueIterator implements Iterator<T> {

        // Class attribute.
        private Node mCurrentNode;

        /**
         * Default constructor.
         */
        QueueIterator() {
            this.mCurrentNode = head;
        }

        /**
         * It checks to see if the iterator has more elements in the list.
         *
         * @return boolean true if there is an element, false otherwise.
         */
        public boolean hasNext() {
            return this.mCurrentNode != null;
        }

        /**
         * Genetic type method that will return the next element in the list.
         *
         * @return next element. It moves the iterator up one.
         */
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = (T) this.mCurrentNode.data;
            this.mCurrentNode = this.mCurrentNode.next;

            return data;
        }
    }
}
