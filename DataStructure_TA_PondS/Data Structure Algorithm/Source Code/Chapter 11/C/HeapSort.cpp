int* heapSort(int theArray[],int n){
  for(int last = n-1;last > 0;last--){
    heapRebuild(theArray, 0, last);
    int temp = theArray[last];
    theArray[last] = theArray[0];
    theArray[0] = temp;
  }
  return theArray;
}

void heapRebuild(int theArray[], int root,int n){
  int child = 2*root+1;
  int rightChild = child+1;
  if(rightChild <= n){
    if(theArray[rightChild] > theArray[child]){
      child = rightChild;
    }
    if(theArray[root] < theArray[child]){
      int temp = theArray[root];
      theArray[root] = theArray[child];
      theArray[child] = temp;
      heapRebuild(theArray, child, n);
    }
  }else if(child <= n){
    if(theArray[root]< theArray[child]){
      int temp = theArray[root];
      theArray[root] = theArray[child];
      theArray[child] = temp;
      heapRebuild(theArray, child, n);
    }
  }
}
