package DGP.CJLU.Experiment5.Lab1;

/**
 * Given input {4371, 1223, 6173, 4199, 4344, 9679, 1989} and a hash function h(x) = x % 11 ,collision should be resolved by the following solutions
 * a)	Draw the results with the following different hash tables, calculate the average search lengths in successful searches and load factors.
 * b)	Write programs to implement the following different hash tables and test it with the above data sequence;
 * i.	    Separate chaining hash table, and the class SeparateChainingHashTable in the textbook must be used.
 * ii.	    Open addressing hash table using linear probing, f(i)=i, and the class QuadraticProbingHashTable in the textbook must be modified and used.
 * iii.    Open addressing hash table using quadratic probing, f(i) = f(i-1) + 2i – 1, and the class QuadraticProbingHashTable in the textbook must be used.
 * iv.	    Open addressing hash table with double hashing, h2(x) = 7 – ( X % 7 ), f(i)=i*h2(x), and the class QuadraticProbingHashTable in the textbook must be modified and used.
 * v.	    Open addressing hash table using rehashing.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        HashTable<Integer> table;

        table = new SeparateChainingRehashingHashTable<>();
        doTest(table);
        table = new LinearProbingRehashingHashTable<>();
        doTest(table);
        table = new QuadraticProbingRehashingHashTable<>();
        doTest(table);
        table = new DoubleHashingRehashingHashTable<>();
        doTest(table);
    }

    private static void doTest(HashTable<Integer> table) {
        table.insert(4371);
        table.insert(1223);
        table.insert(6173);
        table.insert(4199);
        table.insert(4344);
        table.insert(9679);
        table.insert(1989);
        System.out.println(table);
    }
}
