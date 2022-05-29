/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class EbrarDerindagBinaryTree {

    private EbrarDerindagNode root;

    EbrarDerindagLinkedListFile ignore_list = new EbrarDerindagLinkedListFile(); //creates linkedlist for ignore list file
    EbrarDerindagLinkedListFile files = new EbrarDerindagLinkedListFile();    //files ending ".html"

    void insertIgnore() {    //add to IgnoreList
        try {
            BufferedReader in;
            in = new BufferedReader(new FileReader("src\\files\\ignoreList.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                ignore_list.addList(str);
            }
            in.close();
        } catch (IOException e) {
        }
    }

    // iterative search method
    void search(String searchData) {
        String words[] = searchData.split(" ");    
        EbrarDerindagHeap heap = new EbrarDerindagHeap(files.size());    
        for (String word : words) {
            if (root == null) {
                System.out.println("empty tree");
            } else {
                EbrarDerindagNode temp = root;
                while (temp != null) {
                    if (word.compareTo(temp.data) > 0) {
                        temp = temp.right;
                    } else if (word.compareTo(temp.data) < 0) {
                        temp = temp.left;
                    } else {   
                        EbrarDerindagNodeLinkedList head = temp.list.head;
                        EbrarDerindagNodeLinkedList tmp = head;
                        while (tmp != null) {
                            heap.insert(tmp);   
                            tmp = tmp.next;
                        }
                        break;   
                    }
                }
            }
        }
        heap.printArray();
    }

    void readFile(String Files) {
        File file = new File(Files);
        File[] b = file.listFiles();

        for (File b1 : b) {
            if (!b1.getName().equals("ignoreList.txt")) {
                Scanner s;
                try {
                    s = new Scanner(b1);
                    files.addList(b1.getName());
                    while (s.hasNext()) {
                        String word = s.next();
                        if (word.charAt(0) != '<' && !ignore_list.inIgnoreList(word) && !Pattern.matches("\\p{Punct}", word)) {
                            insertBST(word, b1.getName()); 
                        }
                    }
                }catch (FileNotFoundException ex) {
                    Logger.getLogger(EbrarDerindagBinaryTree.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    void insertBST(String word, String fileName) {
        EbrarDerindagNode newNode = new EbrarDerindagNode(word);    
        if (root == null) {
            newNode.list.addToList(fileName);    
            root = newNode;
        } else {    
            EbrarDerindagNode temp = root;

            while (temp != null) {
                if (newNode.data.compareTo(temp.data) > 0) {   
                    if (temp.right == null) {
                        newNode.list.addToList(fileName);    
                        temp.right = newNode;
                        return;
                    }
                    temp = temp.right;
                } else if (newNode.data.compareTo(temp.data) < 0) { 
                    if (temp.left == null) {
                        newNode.list.addToList(fileName);    
                        temp.left = newNode;
                        return;
                    }

                    temp = temp.left;
                } else {    //word==word in bst
                    newNode.list.updateList(fileName, temp.list);  
                    return;
                }
            }
        }
    }

    private void preorder(EbrarDerindagNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            node.list.print();
            preorder(node.left);
            preorder(node.right);
        }
    }

    void preorder() {
        System.out.println("preorder: ");
        preorder(root);
        System.out.println();
    }

    void print() {
        File file = new File("src\\output.txt");
        try {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
                bf.write("preorder: ");
                bf.newLine();
            }
            print(root);
        } catch (IOException ex) {
            Logger.getLogger(EbrarDerindagBinaryTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void print(EbrarDerindagNode node) {
        if (node != null) {
            File file = new File("src\\output.txt");    //creates a new file
            BufferedWriter bw;
            try {
                bw = new BufferedWriter(new FileWriter(file, true));
                bw.write(node.data + " ");
                bw.write(node.list.print());
                bw.newLine();
                bw.close();
                print(node.left);
                print(node.right);
            } catch (IOException ex) {
                Logger.getLogger(EbrarDerindagBinaryTree.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
