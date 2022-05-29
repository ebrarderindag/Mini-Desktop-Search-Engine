/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class EbrarDerindagTest {
    public static void main(String[] args) throws FileNotFoundException {
        EbrarDerindagBinaryTree bst= new EbrarDerindagBinaryTree();
        bst.insertIgnore();
       
        bst.readFile("src\\files");
       // bst.preorder();
        bst.print();
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the word you want to search for: ");
        String input = s.nextLine();
        bst.search(input);
    }
}
