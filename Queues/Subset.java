
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import static java.lang.Integer.parseInt;


/*
 * A simple illustration of a Queue data structure
 * Further information on the libraries may be found at http://algs4.cs.princeton.edu/code/
 * 
 * author : David Kremer
 *
 */

public class Subset 
{
    public static void main(String[] args) 
    {
        RandomizedQueue<String> s;
        int k;
        String new_token;
        s = new RandomizedQueue<>();
        try 
        {
            k = parseInt(args[0]);
        } catch (java.util.NoSuchElementException x) 
        {
            return;
        }

        while (true) 
        {
            try 
            {
                new_token = StdIn.readString();
            } catch (java.util.NoSuchElementException x) 
            {
                break;
            }
            s.enqueue(new_token);
        }
        for (int i = 0; i < k; i++) 
        {
            StdOut.println(s.dequeue());
        }
    }
}
