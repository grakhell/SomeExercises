package ru.exercises.loop;

public class LinkedLst <T>{


    public Node head = null;
    public Node tail = null;

    public void addNode(T value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
    }

    public boolean containsNode(T searchValue) {

        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode.nextNode != null);
            return false;
        }
    }

    public void deleteNode(T valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode.nextNode != null);
    }

    public class Node {
        T value;
        public Node nextNode;

        public Node(T value) {
            this.value = value;
        }

    }
}
