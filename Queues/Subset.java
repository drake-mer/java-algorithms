
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import static java.lang.Integer.parseInt;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author david
 */
public class Subset {

    public static void main(String[] args) {
        RandomizedQueue<String> s;
        int k;
        String new_token;
        s = new RandomizedQueue<>();
        try {
            k = parseInt(args[0]);
            // StdOut.println("reading int");
        } catch (java.util.NoSuchElementException x) {
            return;
        }

        while (true) {
            try {
                new_token = StdIn.readString();
                // StdOut.println("reading string");
            } catch (java.util.NoSuchElementException x) {
                break;
            }
            s.enqueue(new_token);
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(s.dequeue());
        }
    }

}
