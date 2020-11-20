package DGP.CJLU.Experiment5.Lab2;

import java.util.*;

/**
 * Add some same data to HashMap, HashSet, TreeMap and TreeSet objects, then delete 1~2 datas and print all datas in those objects.
 * Try to understand these two data structures: binary trees and hash tables
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        testMap(map);
        map = new TreeMap<>();
        testMap(map);

        Set<Integer> set = new HashSet<>();
        testSet(set);
        set = new TreeSet<>();
        testSet(set);
    }

    private static void testMap(Map<Integer, Integer> map) {
        map.put(34, 345);
        map.put(234234, 4353);
        map.put(37884, 67867);
        map.put(38956, 9458076);
        map.remove(34);
        System.out.println(map);
    }

    private static void testSet(Set<Integer> set) {
        set.add(3456890);
        set.add(3495734);
        set.add(3490458);
        set.add(5896745);
        set.remove(3456890);
        System.out.println(set);
    }
}
