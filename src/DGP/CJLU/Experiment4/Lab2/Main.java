package DGP.CJLU.Experiment4.Lab2;

import DGP.CJLU.Experiment4.Lab1.TreeTraversalType;

/**
 * b)	Design a class of AVL tree by using the class of avlNode in the textbook,
 * i.	Write a program to calculate the number of leaves.
 * ii.	Write methods of preorder, inorder and postorder traversal.
 * iii.	Write a method to calculate the height of a binary search tree.
 * iv.	Write a method to calculate the number of nodes.
 */
public class Main {
    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(9);
        tree.insert(7);
        tree.insert(5);
        tree.insert(2);
        tree.printTree(TreeTraversalType.preOrder);
        tree.printTree(TreeTraversalType.inOrder);
        tree.printTree(TreeTraversalType.postOrder);
        long l = tree.getLeavesCount();
        System.out.println((l > 1 ? "Leaves : " : "Leaf : ") + l);
        System.out.println("Height : " + tree.getHeight());
        System.out.println("Node Count :" + tree.getSize());
    }
}
