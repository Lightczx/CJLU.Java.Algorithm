package DGP.CJLU.Experiment4.Lab2;

import DGP.CJLU.Experiment4.Lab1.TreeTraversalType;
import DGP.CJLU.Utils.Implementation.Exceptions.UnderflowException;

import java.util.Comparator;

public class AvlTree<T extends Comparable<? super T>> {
    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<T> root;
    private Comparator<? super T> cmp;

    public AvlTree() {
        root = null;
    }

    public AvlTree(Comparator<? super T> c) {
        this();
        cmp = c;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return findMin(root).element;
    }

    public T findMax() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree(TreeTraversalType type) {
        if (isEmpty()) {
            System.out.print("Empty tree");
        } else {
            switch (type) {
                case preOrder -> System.out.print("PreOrder :\t");
                case inOrder -> System.out.print("InOrder :\t");
                case postOrder -> System.out.print("PostOrder :\t");
            }
        }
        switch (type) {
            case preOrder -> printTreeByPreOrder(root);
            case inOrder -> printTreeByInOrder(root);
            case postOrder -> printTreeByPostOrder(root);
        }
        System.out.print('\n');
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return true if the item is found; false otherwise.
     */
    private boolean contains(T x, AvlNode<T> t) {
        if (t == null) {
            return false;
        }
        int compareResult = myCompare(x, t.element);

        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    /**
     * Return the height of node t,or -1，if null.
     */
    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null) {
            return new AvlNode<>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        }
        return balance(t);
    }

    //Assume t is either balanced or within one of being balanced
    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null) {
            return t;
        }

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * Rotate binary tree node with left child.
     * For AvL trees，this is a single rotation for case 1.
     * Update heights，then return new root.
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AvL trees，this is a single rotation for case 1.
     * Update heights，then return new root.
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k4) {
        AvlNode<T> k1 = k4.right;
        k4.right = k1.left;
        k1.left = k4;
        k4.height = Math.max(height(k4.left), height(k4.right)) + 1;
        k1.height = Math.max(height(k1.right), k4.height) + 1;
        return k1;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left chi1d.
     * For AVL trees，this is a double rotation for case 2.
     * Update heights,then return new root.
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k3 with new right chi1d.
     * For AVL trees，this is a double rotation for case 2.
     * Update heights,then return new root.
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    protected AvlNode<T> findMin(AvlNode<T> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    private int myCompare(T lhs, T rhs) {
        return cmp != null ? cmp.compare(lhs, rhs) : lhs.compareTo(rhs);
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null) {
            // Item not found; do nothing
            return null;
        }

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {// Two children
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return balance(t);
    }

    /**
     * Internal method to print a subtree in sorted order.param t the node that roots the subtree.
     */
    private void printTreeByPreOrder(AvlNode<T> t) {
        if (t != null) {
            System.out.print(t.element + " ");
            printTreeByPreOrder(t.left);
            printTreeByPreOrder(t.right);
        }
    }

    private void printTreeByInOrder(AvlNode<T> t) {
        if (t != null) {
            printTreeByInOrder(t.left);
            System.out.print(t.element + " ");
            printTreeByInOrder(t.right);
        }
    }

    private void printTreeByPostOrder(AvlNode<T> t) {
        if (t != null) {
            printTreeByPostOrder(t.left);
            printTreeByPostOrder(t.right);
            System.out.print(t.element + " ");
        }
    }

    public long getLeavesCount() {
        return getLeavesCount(root);
    }

    private long getLeavesCount(AvlNode<T> t) {
        long result = 0;
        if (t.left == null && t.right == null)
            return 1;
        if (t.left != null)
            result += getLeavesCount(t.left);
        if (t.right != null)
            result += getLeavesCount(t.right);
        return result;

    }

    public long getHeight() {
        return getDepth(root);
    }

    private long getDepth(AvlNode<T> t) {
        if (t == null) {
            return -1;
        }
        return 1 + Math.max(getDepth(t.left), getDepth(t.right));
    }

    public long getSize() {
        return counts(root);
    }

    private long counts(AvlNode<T> t) {
        if (t == null)
            return 0;
        long sum = 0;

        if (t.left != null) {
            sum += counts(t.left);
        }
        if (t.right != null) {
            sum += counts(t.right);
        }
        return ++sum;
    }

    private static class AvlNode<E> {
        E element;
        AvlNode<E> left;
        AvlNode<E> right;
        int height;

        AvlNode(E e) {
            this(e, null, null);
        }

        AvlNode(E e, AvlNode<E> lt, AvlNode<E> rt) {
            this.element = e;
            this.left = lt;
            this.right = rt;
        }
    }

}
