int* quickSort(int theArray[],int first, int last){
  int pivotIndex;
  if(first < last){
   pivotIndex = partition(theArray,first,last);
   quickSort(theArray,first,pivotIndex-1);
   quickSort(theArray,pivotIndex+1,last);
  }
  return theArray;
}
int partition(int theArray[],int first, int last){
  int tempItem;
  int pivot = theArray[first];
  int lastS1 = first;
  for(int firstUnknown = first+1; firstUnknown <= last; firstUnknown++){
   if(theArray[firstUnknown] < pivot){
     ++lastS1;
     tempItem = theArray[firstUnknown];
     theArray[firstUnknown] = theArray[lastS1];
     theArray[lastS1] = tempItem;
   }
  }
  tempItem = theArray[first];
  theArray[first] = theArray[lastS1];
  theArray[lastS1] = tempItem;
  return lastS1;
}
