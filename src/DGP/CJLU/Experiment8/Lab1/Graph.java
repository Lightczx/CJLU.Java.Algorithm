package DGP.CJLU.Experiment8.Lab1;

import java.util.*;

/**
 * @author 16861
 */
public class Graph<T> {
    /**
     * we use it to represent unlinked
     */
    private static final int INFINITY = Integer.MAX_VALUE;
    /**
     * we use it to represent linked to itself
     */
    private static final int TO_SELF = 0;

    private final int size;
    private final Map<T, Vertex> vertices = new HashMap<>();
    private final Map<T, Integer> dictionary = new HashMap<>();
    private final boolean isOriented;
    private int usedNum = 0;

    /**
     * oriented graph is built by default
     *
     * @param maxVertexCount the max vertex count you intend to insert
     */
    public Graph(int maxVertexCount) {
        this(maxVertexCount, true);
    }

    /**
     * build a graph
     *
     * @param maxVertexCount the max vertex count you intend to insert
     * @param isOriented     config whether to create an  oriented graph or not
     */
    public Graph(int maxVertexCount, boolean isOriented) {
        this.size = maxVertexCount;
        this.isOriented = isOriented;
    }

    /**
     * look up for the mapped vertex index
     *
     * @param key the vertex's name
     * @return the index of vertex
     */
    private int indexOf(T key) {
        if (!dictionary.containsKey(key)) {
            dictionary.put(key, usedNum++);
        }
        return dictionary.get(key);
    }

    private T elementOf(int index) {
        for (Map.Entry<T, Integer> entry : dictionary.entrySet()) {
            if (index == entry.getValue()) {
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
            throw new IllegalArgumentException("插入的元素超出限制个数");
        }
        if (dist <= 0) {
            throw new IllegalArgumentException("插入元素间距不能小于等于0");
        }

        indexOf(from);
        indexOf(to);

        if (!vertices.containsKey(from)) {
            vertices.put(from, new Vertex(from));
        }
        if (!vertices.containsKey(to)) {
            vertices.put(to, new Vertex(to));
        }

        Vertex vertexFrom = vertices.get(from);
        vertexFrom.link(to, dist);
        if (!isOriented) {
            Vertex vertexTo = vertices.get(to);
            vertexTo.link(from, dist);
        }
    }

    public void forEachVertex(LoopFunction<T> loopFunction) {
        for (Map.Entry<T, Vertex> e : vertices.entrySet()) {
            Vertex v = e.getValue();
            loopFunction.invoke(v);
        }
    }

    public Object[] topSort() {
        Queue<Vertex> q = new LinkedList<>();
        Object[] result = new Object[size];
        int counter = 0;

        forEachVertex((v) -> {
            if (v.inDegree == 0) {
                q.offer(v);
            }
        });

        while (!q.isEmpty()) {
            Vertex entry = q.poll();
            result[counter++] = entry.getElement();

            for (Vertex vertex : entry.adjacent()) {
                if (--vertex.inDegree == 0) {
                    q.offer(vertex);
                }
            }
        }
        if (counter != size) {
            throw new IllegalStateException("发现闭环");
        }
        return result;
    }

    /**
     * dijkstra algorithm
     *
     * @param element start element
     */
    public void shortestPath(T element) {
        shortestPath(vertices.get(element));
    }

    private void shortestPath(Vertex start) {
        //prepare for every method call
        forEachVertex((v) -> {
            v.dist = INFINITY;
            v.known = false;
        });
        start.dist = 0;

        while (containsUnknownDistanceVertex()) {
            Vertex v = smallestUnknownDistanceVertex();
            v.known = true;
            for (Vertex w : v.adjacent()) {
                if (!w.known) {
                    int cvw = v.distanceTo(w);
                    if ((long) v.dist + cvw < (long) w.dist) {
                        w.dist = v.dist + cvw;
                        w.path = v;
                    }
                }
            }
        }
    }

    public void printAllPath() {
        forEachVertex((v) -> {
            System.out.print(v + ":");
            printPath(v);
            System.out.print("\n");
        });
    }

    private void printPath(Vertex v) {
        if (v.path != null) {
            printPath(v.path);
            System.out.print(" -> ");
        }
        System.out.print(v);
    }

    private boolean containsUnknownDistanceVertex() {
        //cannot use forEachVertex method here
        for (Map.Entry<T, Vertex> e : vertices.entrySet()) {
            Vertex v = e.getValue();
            if (!v.known) {
                return true;
            }
        }
        return false;
    }

    private Vertex smallestUnknownDistanceVertex() {
        Vertex smallest = null;
        for (Map.Entry<T, Vertex> entry : vertices.entrySet()) {
            Vertex v = entry.getValue();
            //w is unknown
            if (!v.known) {
                if (smallest == null) {
                    smallest = v;
                }
                if (v.dist <= smallest.dist) {
                    smallest = v;
                }
            }
        }
        return smallest;
    }

    public void printTree() {
        forEachVertex((v) -> {
            //System.out.println(v.element.toString()+v.known+v.dist+v.path);
            if (v.path == null) {
                System.out.println(v + " is root");
            } else {
                System.out.println(v + " -> " + v.path);
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This Graph:\n \t");
        for (int i = 0; i < size; i++) {
            sb.append(elementOf(i)).append('\t');
        }
        sb.append('\n');
        for (int j = 0; j < size; j++) {
            sb.append(elementOf(j)).append('\t');
            for (int distance : vertices.get(elementOf(j)).linked) {
                sb.append(distance == Integer.MAX_VALUE ? "∞" : distance).append('\t');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public class Vertex {
        private final int[] linked;
        /**
         * which element
         */
        private final T element;
        public int dist = INFINITY;
        public Vertex path;
        public boolean known = false;
        public int inDegree = 0;

        public Vertex(T from) {
            this.element = from;
            linked = new int[size];
            Arrays.fill(linked, INFINITY);
            linked[indexOf(from)] = TO_SELF;
        }

        public T getElement() {
            return element;
        }

        public void link(T to, int distance) {
            if (INFINITY == linked[indexOf(to)]) {
                vertices.get(to).inDegree++;
                linked[indexOf(to)] = distance;
            }
        }

        public Iterable<Vertex> adjacent() {
            LinkedList<Vertex> entryList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (TO_SELF < linked[i] && linked[i] != INFINITY) {
                    entryList.add(vertices.get(elementOf(i)));
                }
            }
            return entryList;
        }

        public int distanceTo(Vertex vertex) {
            return linked[indexOf(vertex.element)];
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}