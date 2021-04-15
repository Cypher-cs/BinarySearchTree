/* Created by IntelliJ IDEA.

    Author: Prajjwal Pachauri(cypher)
    Date: 08-04-2021
    Time: 15:20
    File: implementation.MyBinarySearchTree.java
*/
package implementation;

public class MyBinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }

    private boolean isEmpty() {
        return root == null;
    }

    public void insert(E element) {
        Node<E> node = new Node<>(element);
        if (isEmpty()) {
            root = node;
        } else {
            Node<E> temp = root;
            Node<E> parent = null;
            while (temp != null) {
                parent = temp;
                if (element.compareTo(temp.getData()) <= 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
            if (element.compareTo(parent.getData()) <= 0) {
                parent.setLeft(node);
            } else if (element.compareTo(parent.getData()) > 0) {
                parent.setRight(node);
            }
        }
    }

    public boolean search(E element) {
        Node<E> temp = root;
        boolean response = false;
        while (temp != null) {
            if (temp.getData() == element) {
                response = true;
                break;
            } else {
                if (element.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        return response;
    }

    // In Order Traversal
    public void inOrder(Node<E> node) {
        if (node != null) {
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

    public void delete(E deletingElement) {
        Node<E> temp = root;
        Node<E> parent = null;
        while (temp != null) {
            if (deletingElement.compareTo(temp.getData()) == 0) {
                break;
            } else {
                parent = temp;
                if (deletingElement.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        if (temp != null) {
            // case 1
            if (isLeaf(temp)) {
                // root node
                if (parent == null) {
                    root = null;
                } else {
                    if (deletingElement.compareTo(parent.getData()) < 0) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }
            }
            // case 2
            // check hasLeftNode in temp then true
            else if (temp.getLeft() != null && temp.getRight() == null) {
                if (parent == null) {
                    root = root.getLeft();
                }
                else {
                    if (deletingElement.compareTo(parent.getData()) < 0) {
                        parent.setLeft(temp.getLeft());
                    }
                    else {
                        parent.setRight(temp.getLeft());
                    }
                }
            }
            // check hasRightNode in temp then true
            else if (temp.getRight() != null && temp.getLeft() == null) {
                if (parent == null) {
                    root = root.getRight();
                }
                else {
                    if (deletingElement.compareTo(parent.getData()) < 0) {
                        parent.setLeft(temp.getRight());
                    }
                    else {
                        parent.setRight(temp.getRight());
                    }
                }
            }

            // case 3 two children
            else {
                Node<E> successor = getSuccessor(temp);
                // delete successor
                delete(successor.getData());

            }

        } else {
            System.out.println("element cannot be deleted");
        }
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> response = null;
        Node<E> temp = node.getRight();
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        response = temp;
        return response;
    }

    private boolean hasRightNode(Node<E> temp) {
        if (temp.getRight() != null && temp.getLeft() == null) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isLeaf(Node<E> temp) {

    }
}