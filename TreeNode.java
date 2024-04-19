package com.example.morsecode;

public class TreeNode<T> {
    private T data;
    protected TreeNode<T> left, right;

    public TreeNode(T dataNode) {
        data = dataNode;
        left = null;
        right = null;
    }

    public TreeNode (TreeNode<T> node) {
        data = node.data;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }
}
