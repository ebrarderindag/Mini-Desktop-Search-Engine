/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

public class EbrarDerindagHeap {

     EbrarDerindagNodeLinkedList[] heap;
     int size;

    public EbrarDerindagHeap(int capacity) {
        heap =  new EbrarDerindagNodeLinkedList[capacity];
        size = 0;
    }

    private int parent(int i) {
        i = (i-1)/2;
        return i;
    }

    private void swap(int i, int j) {
        EbrarDerindagNodeLinkedList temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void insert(EbrarDerindagNodeLinkedList data) {
        int current=0;
        boolean update=false;   
        if (size < heap.length) {
            
            for (EbrarDerindagNodeLinkedList heap1 : heap) {
                if (heap1 == null) {  
                    break;
                } else if (heap1.data.equals(data.data)) {
                    heap1.count += data.count;
                    update=true;    
                }
            }
            if(update==false){  
                heap[size] = data;  
                current = size++;
            }
            
            while (heap[current].count>(heap[parent(current)].count)) { 
                swap(current, parent(current));
                current = parent(current);
            }
        } else {
            System.out.println("array is full.");
        }
    }

    

    void printArray() {
        System.out.print("The Count of Word/s in Files: ");
        for (EbrarDerindagNodeLinkedList element : heap) {
            if(element!=null){
                System.out.print(element.data + ": ("+ element.count + ") ");
            } 
        }
        System.out.println();
    }

    

}
