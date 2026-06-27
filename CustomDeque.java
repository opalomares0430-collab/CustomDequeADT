package module7_PortfolioMilestone;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class CustomDeque {

    private Deque<Integer> deque;

    public CustomDeque() {
        deque = new LinkedList<>();
    }

    // Insert at front
    public void enqueueFront(int data) {
        deque.addFirst(data);
    }

    // Insert at rear
    public void enqueueRear(int data) {
        deque.addLast(data);
    }

    // Remove from front
    public int dequeueFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeFirst();
    }

    // Remove from rear
    public int dequeueRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeLast();
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Return iterator
    public Iterator<Integer> iterator() {
        return new DequeIterator();
    }

    // Inner Iterator Class
    private class DequeIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator = deque.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Integer next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return iterator.next();
        }
    }

    public static void main(String[] args) {

        CustomDeque customDeque = new CustomDeque();

        Random random = new Random();

        int[] numbers = new int[10];

        System.out.println("Random Numbers:");

        for (int i = 0; i < numbers.length; i++) {

            numbers[i] = random.nextInt(100);

            System.out.print(numbers[i] + " ");

            if (i % 2 == 0)
                customDeque.enqueueFront(numbers[i]);
            else
                customDeque.enqueueRear(numbers[i]);
        }

        System.out.println("\n");

        System.out.println("Deque Traversal:");

        Iterator<Integer> iterator = customDeque.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n");

        System.out.println("Remove Front: " + customDeque.dequeueFront());

        System.out.println("Remove Rear: " + customDeque.dequeueRear());

        System.out.println("\nDeque After Deletions:");

        iterator = customDeque.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
