package DGP.CJLU.Experiment5.Lab1;

/**
 * Given input {4371, 1223, 6173, 4199, 4344, 9679, 1989} and a hash function h(x) = x % 11 ,collision should be resolved by the following solutions
 * a)	Draw the results with the following different hash tables, calculate the average search lengths in successful searches and load factors.
 * b)	Write programs to implement the following different hash tables and test it with the above data sequence;
 * i.	    Separate chaining hash table, and the class SeparateChainingHashTable in the textbook must be used.
 * ii.	    Open addressing hash table using linear probing, f(i)=i, and the class QuadraticProbingHashTable in the textbook must be modified and used.
 * iii.     Open addressing hash table using quadratic probing, f(i) = f(i-1) + 2i – 1, and the class QuadraticProbingHashTable in the textbook must be used.
 * iv.	    Open addressing hash table with double hashing, h2(x) = 7 – ( X % 7 ), f(i)=i*h2(x), and the class QuadraticProbingHashTable in the textbook must be modified and used.
 * v.	    Open addressing hash table using rehashing.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        HashTable<Integer> table;
        table = new SeparateChainingHashTable<>();
        doTest(table);
        table = new LinearProbingHashTable<>();
        doTest(table);
        table = new QuadraticProbingHashTable<>();
        doTest(table);
        table = new DoubleHashingHashTable<>();
        doTest(table);
        table=new RehashingHashTable<>();
        doTest(table);
        //SeparateChainingHashTable:
        //[],[],[1223, 6173],[],[4371],[],[],[],[4199],[1989],[4344, 9679]
        //LinearProbingHashTable:
        //[9679,null,1223,6173,4371,null,null,null,4199,1989,4344]
        //QuadraticProbingHashTable:
        //[9679,null,1223,6173,4371,null,null,null,4199,1989,4344]
        //DoubleHashingHashTable:
        //[null,6173,1223,null,4371,null,9679,null,4199,1989,4344]
        //RehashingHashTable:
        //[null,4371,null,null,1223,null,null,null,null,6173,null,1989,null,4199,null,null,null,null,null,9679,4344,null,null]
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
