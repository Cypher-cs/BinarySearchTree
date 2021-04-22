package myinterface;

import implementation.Node;

public interface BinarySearchTreeADT<E extends Comparable<E>> {
    void insert(E element);
    boolean isEmpty();
    boolean search(E element);
    void inOrder(Node<E> node);
    void preOrder(Node<E> node);
    void postOrder(Node<E> node);
    void delete(E element);
    int height(Node<E> node);
}