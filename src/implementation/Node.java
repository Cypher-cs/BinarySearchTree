/* Created by IntelliJ IDEA.

    Author: Prajjwal Pachauri(cypher)
    Date: 08-04-2021
    Time: 15:18
    File: implementation.Node.java
*/
package implementation;

public class Node<E extends Comparable<E>> {
    E data;
    Node<E> left;
    Node<E> right;

    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}