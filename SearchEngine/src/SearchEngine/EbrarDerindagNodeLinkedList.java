/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

public class EbrarDerindagNodeLinkedList {
    String data;   
    int count;  
    EbrarDerindagNodeLinkedList next;  

    public EbrarDerindagNodeLinkedList(String data) {
        this.data = data;
    }
    public EbrarDerindagNodeLinkedList(String data,int count){
        this.data=data;
        this.count=count;
    }

    public EbrarDerindagNodeLinkedList() {
    }
    
}
