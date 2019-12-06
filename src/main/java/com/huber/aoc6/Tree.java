package com.huber.aoc6;

import java.util.ArrayList;
import java.util.Objects;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        this.root = new Node<>(rootData, null, new ArrayList<>());
    }

    public Node<T> getRoot() {
        return root;
    }

    public Node<T> findNode(final T searchParam) {
        return this.root.getData().equals(searchParam) ? this.root :
                this.root.getChildren().isEmpty() ? null : this.root.getChildren().stream().map(childNode -> childNode.findNode(searchParam))
                        .filter(Objects::nonNull)
                        .findFirst().orElse(null);
    }
}
