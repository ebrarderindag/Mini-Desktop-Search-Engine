/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

public class EbrarDerindagNode { 
    String data;
    EbrarDerindagLinkedList list;   //every node/word has a list that contains how many word in which files information 
    EbrarDerindagNode left;  
    EbrarDerindagNode right;
    
    public EbrarDerindagNode(String data) {
        this.data = data;
        this.list=new EbrarDerindagLinkedList();
    }
    
}
