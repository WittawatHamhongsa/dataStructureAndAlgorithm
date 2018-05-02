package chapter11;

public class HeapSort {
    public Comparable[] heapSort(Comparable[] theArray,int n){
        for(int last = n-1;last > 0;last--){
            heapRebuild(theArray, 0, last);
            Comparable temp = theArray[last];
            theArray[last] = theArray[0];
            theArray[0] = temp;
        }
        return theArray;
    }

    public void heapRebuild(Comparable[] theArray,int root,int n){
        int child = 2*root+1;
        int rightChild = child+1;
        if(rightChild <= n){
            if(theArray[rightChild].compareTo(theArray[child])>0){
                child = rightChild;   
            } 
        if(theArray[root].compareTo(theArray[child])<0){
            Comparable temp = theArray[root];
            theArray[root] = theArray[child];
            theArray[child] = temp;
            heapRebuild(theArray, child, n);   
        }
        }else if(child <= n){
            if(theArray[root].compareTo(theArray[child])<0){
                Comparable temp = theArray[root];
                theArray[root] = theArray[child];
                theArray[child] = temp;
                heapRebuild(theArray,child,n);   
            }
        }     
    }    
}