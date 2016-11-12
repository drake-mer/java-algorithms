/*
 *
 * @author: David Kremer
 *
 * Here the concept is simply summarized in the data structure ;
 * 
 * For an array, we set up a size (and a max_size to avoid too huge memory consumption)
 * 
 * The instanciation of the Randomized Queue initializes the array aiming to contain
 * the data.
 *
 * To enqueue an item, one simply appends it at the top of the stack
 *
 * To dequeue an item, one element is taken randomly and the array is 
 * kept in order by copying the last element in the place of the removed 
 * element.
 *
 * This data structure is well suited when :
 * 1) You don't mind about the order in which you put your elements
 * 2) You want a dynamic size allocation but you want for the copies and 
 *    memory allocations to keep a low profile
 */
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    /* Static attributes of such an object */
    private int N;
    private int max_size;
    private Item[] bag;

    /* Constructor (initializes to a null value) */
    public RandomizedQueue() 
    {
        N = 0;
        max_size = 1;
        bag = (Item[]) new Object[max_size];
    }

    public boolean isEmpty() 
    {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) 
    {
        if (item == null) 
        {
            throw new java.lang.NullPointerException();
        } else 
        {
            if (N == max_size) 
            {
                Item[] old_bag = bag;
                int i;
                max_size *= 2;
                bag = (Item[]) new Object[max_size];
                for (i = 0; i < N; i++) 
                {
                    bag[i] = old_bag[i];
                }
                bag[N] = item;
            } else 
            {
                bag[N] = item;
            }
            N++;
        }
    }

    public Item dequeue() 
    {
        if (N == 0) 
        {
            throw new java.util.NoSuchElementException();
        } else 
        {
            int random_index;
            Item return_result;
            random_index = StdRandom.uniform(N);
            return_result = bag[random_index];
            bag[random_index] = bag[N - 1];
            if (N < max_size / 2 && max_size > 1) 
            {
                Item[] old_bag = bag;
                int i;
                max_size /= 2;
                bag = (Item[]) new Object[max_size];
                for (i = 0; i < N - 1; i++) {
                    bag[i] = old_bag[i];
                }
                old_bag = null ;
            }
            N--;
            return return_result;
        }
    }

    private RandomizedQueue RandomizedQueueCopy() {
        RandomizedQueue s = new RandomizedQueue();
        for (int i = 0; i < N; i++) {
            s.enqueue(bag[i]);
        }
        return s;
    }

    public Item sample() {  // remove and return the item from the back
        if (N == 0) {
            throw new java.util.NoSuchElementException();
        }
        return bag[StdRandom.uniform(N)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {

        private final RandomizedQueue s = RandomizedQueueCopy();

        @Override
        public boolean hasNext() {
            return s.size() > 0;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return (Item) s.dequeue();
            }
        }
    }

    public static void main(String[] args) // unit testing
    {
        int i;
        int N = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2;
        RandomizedQueue<Integer> TestObject = new RandomizedQueue<>();
        for (i = 0; i < N; i++) {
            TestObject.enqueue(i);
        }
        System.out.println(TestObject.size());
        Iterator MyIterator = TestObject.iterator();
        while (MyIterator.hasNext()) {
            System.out.println(MyIterator.next());
        }
        for (i = 0; i < N; i++) {
            System.out.println(TestObject.dequeue());
        }
        MyIterator = TestObject.iterator();
        while (MyIterator.hasNext()) {
            System.out.println(MyIterator.next());
        }
    }
}
