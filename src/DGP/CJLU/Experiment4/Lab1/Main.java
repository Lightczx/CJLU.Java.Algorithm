package DGP.CJLU.Experiment4.Lab1;

/**
 * b)	Use the class of BinarySearchTree in the textbook,
 * i.	Write a method to calculate the number of leaves.
 * ii.	Write methods of preorder, inorder and postorder traversal.
 * iii.	Write a method to calculate the height of a binary search tree.
 * iv.	Write a method to calculate the number of nodes.
 *
 * @author 16861
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
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
        System.out.println(l > 1 ? "Leaves : " + l : "Leaf : " + l);
        System.out.println("Height : " + tree.getHeight());
        System.out.println("Node Count :" + tree.getSize());
    }
}
