package chapter11;

public class MergeSort {
    public Comparable[] mergeSort(Comparable[] theArray,int first,int last){
        if(first < last){
            int mid = (first + last)/2;
            mergeSort(theArray,first,mid);
            mergeSort(theArray,mid+1,last);
            merge(theArray,first,mid,last);
        }
        return theArray;
    }
    
    public void merge(Comparable[] theArray, int first,int mid,int last){
        int maxSize = theArray.length;
        Comparable[] tempArray = new Comparable[maxSize];
        int first1 = first;
        int last1 = mid;
        int first2 = mid+1;
        int last2 = last;
        int index = first1;
        while((first1<=last1)&&(first2<=last2)){
            if(theArray[first1].compareTo(theArray[first2])<0){
                tempArray[index] = theArray[first1];
                first1++;
            }else{
                tempArray[index] = theArray[first2];
                first2++;
            }
            index++;
        }
  
        while(first1 <= last1){
            tempArray[index] = theArray[first1];
            first1++;
            index++;
        }
        while(first2 <= last2){
            tempArray[index] = theArray[first2];
            first2++;
            index++;
        }
        for (index = first;index <= last;index++){
            theArray[index] = tempArray[index];
        }
    }
    
}
