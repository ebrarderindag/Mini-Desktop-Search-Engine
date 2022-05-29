/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

public class EbrarDerindagLinkedList {
    EbrarDerindagNodeLinkedList head;
    
    void addToList(String fileName){ //creates a list for every word according to existing file
        EbrarDerindagNodeLinkedList newNode = new EbrarDerindagNodeLinkedList(fileName);
        if(head==null){ 
            newNode.count=1;   
            head = newNode;
        }else{
            newNode.count=1;   
            newNode.next = head;
            head = newNode;
        }
    }
    void updateList(String fileName, EbrarDerindagLinkedList list){  //if the same word comes to BST, changes the count value and updates the list
        EbrarDerindagNodeLinkedList tmp = list.head;   
        while(tmp!=null){   
            if(tmp.data.equals(fileName)){
                tmp.count=tmp.count+1;  
                break;  
            }
            tmp=tmp.next;
        }   
        if(tmp==null){ 
            list.addToList(fileName);
        }
    }
    
    String print(){
        EbrarDerindagNodeLinkedList tmp=head;
        String a="";   
        while(tmp!=null){
            a+=tmp.data+" , "+tmp.count+" -> ";
            tmp=tmp.next;
        }
        a+="null";
        return a;
    }
    
    String words(){
        EbrarDerindagNodeLinkedList tmp=head;
        String a="";    
        while(tmp!=null){
            a+=tmp.data+" ";
            tmp=tmp.next;
        }
        return a;
    }
    
    int wordCount(){
        EbrarDerindagNodeLinkedList tmp=head;
        int a=0;    
        while(tmp!=null){
            a+=tmp.count;
            tmp=tmp.next;
        }
        return a;
    }
    
    void addLast(String data, int count) {
        EbrarDerindagNodeLinkedList newNode = new EbrarDerindagNodeLinkedList(data,count);

        if (head == null) {
            head = newNode;
        } else {
            EbrarDerindagNodeLinkedList temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
}
