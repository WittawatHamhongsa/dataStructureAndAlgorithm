package chapter11;

public class SelectionSort {
    public Comparable[] selectionSort (Comparable[] theArray,int n){   
        for(int last=n-1; last>=1; last--){	
            int largest=indexofLargest(theArray,last+1);            
            Comparable temp = theArray[largest];	
            theArray[largest] = theArray[last];	            
            theArray[last] = temp;			
        }
        return theArray;				
    } 

    public static int indexofLargest(Comparable[] theArray,int size){
        int indexSoFar = 0;
        for(int currIndex=1;currIndex<size;currIndex++){
            if(theArray[currIndex].compareTo(theArray[indexSoFar])>0){     
                indexSoFar = currIndex;
            }
        }
        return indexSoFar;
    }    
}
