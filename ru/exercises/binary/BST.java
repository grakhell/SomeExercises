package ru.exercises.binary;

import java.util.*;

public class BST {
    public static List<Integer> getAllElements(BinaryTree<Integer> tree1, BinaryTree<Integer> tree2) {
        Stack<BinaryTree<Integer>.Node<Integer>> stack1 = new Stack<>();
        Stack<BinaryTree<Integer>.Node<Integer>> stack2 = new Stack<>();

        BinaryTree<Integer>.Node<Integer> tr1 = tree1.root;
        BinaryTree<Integer>.Node<Integer> tr2 = tree2.root;

        LinkedList<Integer> lst = new LinkedList<>();
        while (tr1!=null || tr2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while (tr1 != null) {
                stack1.push(tr1);
                tr1 = tr1.left;
            }
            while (tr2 != null) {
                stack2.push(tr2);
                tr2 = tr2.left;
            }
            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().value < stack2.peek().value)) {
                tr1 = stack1.pop();;
                lst.push(tr1.value);
                tr1 = tr1.right;
            } else {
                tr2 = stack2.pop();;
                lst.push(tr2.value);
                tr2 = tr2.right;
            }
        }
        return lst;
    }
}
