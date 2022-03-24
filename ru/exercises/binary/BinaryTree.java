package ru.exercises.binary;

public class BinaryTree<T extends Comparable<T>> {

    public class Node<K extends Comparable<K>> {
        K value;
        Node<K> left;
        Node<K> right;

        Node(K value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node<T> root;

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Node<T> addRecursive(Node<T> current, T value) {

        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node<T> current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(T value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node<T> current, T value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value.compareTo(current.value) < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private Node<T> deleteRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            T smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private T findSmallestValue(Node<T> root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
}
