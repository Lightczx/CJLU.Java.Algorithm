package DGP.CJLU.Experiment8.Lab1;

import java.util.*;

/**
 * @author 16861
 */
public class Graph<T extends Comparable<? super T>> {
    private static final int INFINITY = -1;
    private final int size;
    private final Map<T, Vertex> entries = new HashMap<>();
    private final Map<T, Integer> dictionary = new HashMap<>();
    private int usedNum = 0;

    public Graph(int maxVertexCount) {
        this.size = maxVertexCount;
    }

    private int lookUp(T key) {
        if (!dictionary.containsKey(key)) {
            dictionary.put(key, usedNum++);
        }
        return dictionary.get(key);
    }

    private T getKey(int value) {
        for (Map.Entry<T, Integer> entry : dictionary.entrySet()) {
            if (value == entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void link(T from, T to) {
        link(from, to, 1);
    }

    public void link(T from, T to, int dist) {
        if (usedNum > size) {
            throw new IllegalStateException("插入的元素超出限制个数");
        }
        if (dist <= 0) {
            throw new IllegalStateException("插入元素间距不能小于等于0");
        }

        lookUp(from);
        lookUp(to);

        if (!entries.containsKey(from)) {
            entries.put(from, new Vertex(from));
        }
        Vertex entry = entries.get(from);
        entry.link(to, dist);
    }

    public Object[] topSort() {
        Queue<Vertex> q = new LinkedList<>();
        Object[] result = new Object[size];
        int counter = 0;

        for (Map.Entry<T, Vertex> mapEntry : entries.entrySet()) {
            Vertex entry = mapEntry.getValue();
            if (entry.degree == 0) {
                q.offer(entry);
            }
        }
        while (!q.isEmpty()) {
            Vertex entry = q.poll();
            result[counter++] = entry.getElement();

            for (Vertex vertex : entry.getAdjacentVertex()) {
                if (--vertex.degree == 0) {
                    q.offer(vertex);
                }
            }
        }
        if (counter != size) {
            //throw new IllegalStateException("发现闭环");
        }
        return result;
    }

    public void dijkstra(Vertex start) {
        start.dist = 0;
        while (containsUnknownDistanceVertex()) {
            Vertex v = getSmallestDistanceVertex();
            v.known = true;
            for (Vertex w : v.getAdjacentVertex()) {
                if (!w.known) {
                    int cvw = v.getLinkLengthTo(w);
                    if (v.dist + cvw < w.dist) {
                        w.dist = v.dist + cvw;
                        w.path = v;
                    }
                }
            }
        }
    }

    public void printPath(Vertex v) {
        if (v.path != null) {
            printPath(v.path);
            System.out.print(" -> ");
        }
        System.out.print(v);
    }

    private boolean containsUnknownDistanceVertex() {
        for(Map.Entry<T, Vertex> e:entries.entrySet()){
            Vertex v=e.getValue();
            if(!v.known){
                return true;
            }
        }
        return false;
    }

    private Vertex getSmallestDistanceVertex() {
        return null;
    }

    public class Vertex {
        private final int[] linked;
        public int dist = INFINITY;
        public Vertex path;
        public boolean known = false;
        public int degree = 0;
        /**
         * which element it based on
         */
        private final T element;

        public T getElement() {
            return element;
        }

        public Vertex(T from) {
            this.element = from;
            linked = new int[size];
            Arrays.fill(linked,INFINITY);
        }

        public void link(T to) {
            link(to, 1);
        }

        public void link(T to, int dist) {
            if (0 == linked[lookUp(to)]) {
                if (!entries.containsKey(to)) {
                    entries.put(to, new Vertex(to));
                }
                entries.get(to).degree++;
                linked[lookUp(to)] = dist;
            }
        }

        public Iterable<Vertex> getAdjacentVertex() {
            LinkedList<Vertex> entryList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (0 < linked[i]) {
                    entryList.add(entries.get(getKey(i)));
                }
            }
            return entryList;
        }

        public int getLinkLengthTo(Vertex vertex) {
            return linked[lookUp(vertex.element)];
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This Graph:\n");
        for (Map.Entry<T, Vertex> line : entries.entrySet()) {
            for (int element : line.getValue().linked) {
                sb.append(element).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}