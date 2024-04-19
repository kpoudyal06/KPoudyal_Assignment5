package com.example.morsecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
    private static MorseCodeTree tree;



    public static String printTree() {
        tree = new MorseCodeTree();
        String treeData = "";
        ArrayList<String> treeList = new ArrayList<String>();
        treeList = tree.toArrayList();

        for (int i = 0; i < treeList.size(); i++) {
            treeData += treeList.get(i) + " ";
        }
        return treeData.substring(0, treeData.length() - 1);
    }

    public static String convertToEnglish(String code) {
        tree = new MorseCodeTree();
        String[] codeWords = code.split(" / ");
        String[] codeLetters;
        String english = "";

        for (int i = 0; i < codeWords.length; i++) {
            codeLetters = codeWords[i].split(" ");
            for (int j = 0; j < codeLetters.length; j++) {
                english += tree.fetch(codeLetters[j]);
            }
            english += " ";
        }
       english = english.trim();
        return english;
    }

    public static String convertToEnglish(File file) throws FileNotFoundException {
        Scanner fileIn = new Scanner(file);
        String treeData = "";
        while (fileIn.hasNext()) {
            treeData += convertToEnglish(fileIn.nextLine());
        }
        return treeData;
    }
}
