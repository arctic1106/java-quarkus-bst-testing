package dev.arcticsoft;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class BinarySearchTree {

    private Node root = null;

    public Node getRoot() {
        return root;
    }

    public Node insert(int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else
            return insertRecursive(key, root);
    }

    private Node insertRecursive(int key, Node node) {
        if (key < node.value()) {
            if (node.left() == null)
                return node.setLeft(new Node(key));
            else
                return insertRecursive(key, node.left());
        } else if (key > node.value()) {
            if (node.right() == null)
                return node.setRight(new Node(key));
            else
                return insertRecursive(key, node.right());
        } else
            return node;
    }

    public int findNextInnorder(Node node) {
        Objects.requireNonNull(node);

        // Búsqueda hacia abajo
        if (node.right() != null) {
            while (node.right() != null) {
                node = node.right();
                if (node.left() != null) {
                    while (node.left() != null) {
                        node = node.left();
                    }
                    return node.value();
                }
            }
            return node.value();
        }

        // Búsqueda hacia arriba
        while (node.getParent() != null) {
            if (node == node.getParent().left())
                return node.getParent().value();
            node = node.getParent();
        }
        return -1;
    }

    public List<Integer> listInOrder() {
        var list = new ArrayList<Integer>();
        if (root != null)
            listInOrderRec(root, list);
        return list;
    }

    private void listInOrderRec(Node n, List<Integer> list) {
        if (n.left() != null)
            listInOrderRec(n.left(), list);
        list.add(n.value());
        if (n.right() != null)
            listInOrderRec(n.right(), list);
    }
}