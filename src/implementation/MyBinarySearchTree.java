/* Created by IntelliJ IDEA.

    Author: Prajjwal Pachauri(cypher)
    Date: 08-04-2021
    Time: 15:20
    File: implementation.MyBinarySearchTree.java
*/
package implementation;

public class MyBinarySearchTree<E extends Comparable> {
    public Node<E> root;

    public void insert(int element) {
        Node<E> node = new Node<>(element);
        if (root == null) {
            root = node;
        } else {
            Node<E> temp = root;
            Node<E> parent = null;
            while (temp != null) {
                parent = temp;
                if (element < temp.getData()) {
                    temp = temp.left;
                } else if (element > temp.getData()) {
                    temp = temp.right;
                }
            }
            if (element < parent.getData()) {
                parent.setLeft(node);
            } else if (element > parent.getData()) {
                parent.setRight(node);
            }
        }
    }

    public boolean search(int element) {
        Node<E> temp = root;
        boolean response = false;
        while (temp != null) {
            if (temp.getData() == element) {
                response = true;
                break;
            } else {
                if (element < temp.getData()) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }
        return response;
    }

    // In Order Traversal
    public void inOrder(Node<E> node) {
        if (node != null){
            // call inOrder to process left SubTree
            inOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            inOrder(node.getRight());
        }
    }

    // Pre Order Traversal
    public void preOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.getData() + ", ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    // Post Order Traversal
    public void postOrder(Node<E> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }
}