package com.example.morsecode;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
    private TreeNode<String> root;

    public MorseCodeTree() {
        root = new TreeNode<String>("");
        buildTree();
    }

    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = new TreeNode<String>(newNode);
    }

    @Override
    public void insert(String code, String result) {
        addNode(root, code, result);
    }

    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        //Base Case
        if (code.length() == 1) {
            if(code.equals(".")) {
                root.left = new TreeNode<String>(letter);
            }
            else if(code.equals("-")) {
                root.right = new TreeNode<String>(letter);
            }
        }

        //Recursive
        else if (code.length() > 1) {
            if (code.charAt(0) == '.') {
                addNode(root.left, code.substring(1), letter);
            }
            if (code.charAt(0) == '-') {
                addNode(root.right, code.substring(1), letter);
            }
        }
    }

    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        String letter = "";

        //Base Case
        if (code.length() == 1) {
            if(code.equals(".")) {
                letter += root.left.getData();
            }

            if(code.equals("-")) {
                letter += root.right.getData();
            }
        }

        //Recursive
        else if (code.length() > 1) {
            if (code.charAt(0) == '.') {
                letter += fetchNode(root.left, code.substring(1));
            }
            if (code.charAt(0) == '-') {
                letter += fetchNode(root.right, code.substring(1));
            }
        }
        return letter;
    }

    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void buildTree() {
        //root level
        insert("","");
        //level one
        insert(".", "e");
        insert("-","t");
        //level two
        insert("..","i");
        insert(".-","a");
        insert("-.", "n");
        insert("--", "m");
        //level three
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---","o");
        //level four
        insert("....","h");
        insert("...-","v");
        insert("..-.","f");
        insert(".-..","l");
        insert(".--.","p");
        insert(".---","j");
        insert("-...","b");
        insert("-..-","x");
        insert("-.-.","c");
        insert("-.--","y");
        insert("--..","z");
        insert("--.-","q");
    }

    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> arrList = new ArrayList<String>();
        LNRoutputTraversal(root, arrList);
        return arrList;
    }

    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        //Base Case
        if(root.left == null && root.right == null) {
            list.add(root.getData());
        }

        //Recursive
        else {
            if (root.left != null) {
                LNRoutputTraversal(root.left, list);
                list.add(root.getData());
            }
            if (root.right != null) {
                LNRoutputTraversal(root.right, list);
            }
        }
    }
}
