boolean SequentialSearch(int theArray[], int key,int n){
  for(int count=0; count<n; count++){
    if(theArray[count] == key){
      return true;
    }  
  }
  return false;
}
