/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

public class EbrarDerindagLinkedListFile {

    EbrarDerindagNodeFile head;
    
    void addList(String veri){  //addFirst for file names
        EbrarDerindagNodeFile newNode = new EbrarDerindagNodeFile(veri);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    
    boolean inIgnoreList(String data){ //checks the word is in ignoreList
            EbrarDerindagNodeFile tmp=head;
            while(tmp!=null){
                if(tmp.data.equals(data)){  
                    return true;
                }else{
                    tmp=tmp.next;
                }
            }
            return false;
    }
    
    int size() {
        EbrarDerindagNodeFile temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
