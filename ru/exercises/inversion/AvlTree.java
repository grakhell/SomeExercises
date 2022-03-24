package ru.exercises.inversion;

import java.util.Collection;
import java.util.Iterator;

public class AvlTree<T extends Comparable<T>> {

    public class Node {
        T key;
        int height;
        int size;
        Node left;
        Node right;

        Node(T key) {
            this.key = key;
        }
    }

    private Node root;
    private int inversionCount;

    public int getInversionCount() {
        return inversionCount;
    }

    public Node find(T key) {
        Node curr = root;
        while (curr != null) {
            if (curr.key == key) {
                break;
            }
            curr = curr.key.compareTo(key) < 0 ? curr.right : curr.left;
        }
        return curr;
    }


    public void insert(T key) {
        root = insert(root, key);
    }

    public void insertAll(Collection<T> coll) {
        Iterator<T> it = coll.iterator();
        while (it.hasNext()) {
            insert(it.next());
        }
    }

    public void delete(T key) {
        root = delete(root, key);
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }


    private Node insert(Node node, T key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key);
            inversionCount = inversionCount + size(root.right) + 1;
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    private Node delete(Node node, T key) {
        if (node == null) {
            return null;
        } else if (node.key.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        updateSize(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateSize(y);
        updateHeight(x);
        updateSize(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateSize(y);
        updateHeight(x);
        updateSize(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private void updateSize(Node n) {
        n.size = 1 + size(n.left) + size(n.right);
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    private int size(Node n) {
        return n == null ? 0 : n.size;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
}

