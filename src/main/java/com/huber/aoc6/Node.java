package com.huber.aoc6;

import java.util.List;
import java.util.Objects;

public class Node<T> {
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T data, Node<T> parent, List<Node<T>> children) {
        this.data = data;
        this.parent = parent;
        this.children = children;
    }

    public Node() {
    }

    public T getData() {
        return data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Boolean isRoot() {
        return this.parent == null;
    }

    public Node<T> findNode(final T searchParam) {
        return this.getData().equals(searchParam) ? this : this.children.stream()
                .map(childNode -> childNode.findNode(searchParam))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    public Integer findNodeWithCount(final T searchParam, final Integer currentCount) {
        return this.getData().equals(searchParam) ? currentCount : this.children.stream()
                .map(childNode -> childNode.findNodeWithCount(searchParam, currentCount + 1))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    private Integer countOwnParents() {
        Node<T> currentParent = this.parent;
        Integer count = 0;
        while(currentParent != null) {
            count++;
            currentParent = currentParent.getParent();
        }

        return count;
    }

    public Integer countParents() {
        return this.countOwnParents() + this.getChildren().stream().mapToInt(Node::countParents).sum();
    }

    public Integer distanceTo(final T otherNode) {
        return this.distanceTo(otherNode, 0) - 2;
    }

    private Integer distanceTo(final T otherNode, final Integer currentCount) {
        if (this.getData().equals(otherNode)) {
            return currentCount + 1;
        }

        final Integer nodeCount = this.findNodeWithCount(otherNode, currentCount);
        if (nodeCount != null) {
            return nodeCount;
        } else {
            return this.parent.distanceTo(otherNode, currentCount + 1);
        }
    }
}
