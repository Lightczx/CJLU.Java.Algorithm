package DGP.CJLU.Experiment4.Lab1;

import DGP.CJLU.Utils.Implementation.Exceptions.UnderflowException;

import java.util.Comparator;

/**
 * @author 16861
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;
    private Comparator<? super T> cmp;
    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<? super T> c) {
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
    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null)
            return false;
        int compareResult = myCompare(x, t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the sma11est item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree. param t the node that roots the subtree.
     * return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> t) {
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
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = myCompare(x, t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ;
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null) {
            // Item not found; do nothing
            return null;
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        // Two children
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    /**
     * Internal method to print a subtree in sorted order.param t the node that roots the subtree.
     */
    private void printTreeByPreOrder(BinaryNode<T> t) {
        if (t != null) {
            System.out.print(t.element + " ");
            printTreeByPreOrder(t.left);
            printTreeByPreOrder(t.right);
        }
    }

    private void printTreeByInOrder(BinaryNode<T> t) {
        if (t != null) {
            printTreeByInOrder(t.left);
            System.out.print(t.element + " ");
            printTreeByInOrder(t.right);
        }
    }

    private void printTreeByPostOrder(BinaryNode<T> t) {
        if (t != null) {
            printTreeByPostOrder(t.left);
            printTreeByPostOrder(t.right);
            System.out.print(t.element + " ");
        }
    }

    public long getLeavesCount() {
        return getLeavesCount(root);
    }

    private long getLeavesCount(BinaryNode<T> t) {
        long result = 0;
        if (t.left == null && t.right == null) {
            return 1;
        }
        if (t.left != null) {
            result += getLeavesCount(t.left);
        }
        if (t.right != null) {
            result += getLeavesCount(t.right);
        }
        return result;

    }

    public long getHeight() {
        return getDepth(root);
    }

    private long getDepth(BinaryNode<T> t) {
        if (t == null) {
            return -1;
        }
        return 1 + Math.max(getDepth(t.left), getDepth(t.right));
    }

    public long getSize() {
        return counts(root);
    }

    private long counts(BinaryNode<T> t) {
        if (t == null) {
            return 0;
        }
        long sum = 0;

        if (t.left != null) {
            sum += counts(t.left);
        }
        if (t.right != null) {
            sum += counts(t.right);
        }
        return ++sum;
    }

    private static class BinaryNode<E> {
        E element;
        BinaryNode<E> left;
        BinaryNode<E> right;
        //Constructors
        BinaryNode(E theElement) {
            this(theElement, null, null);
        }
        BinaryNode(E theElement, BinaryNode<E> lt, BinaryNode<E> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }
}