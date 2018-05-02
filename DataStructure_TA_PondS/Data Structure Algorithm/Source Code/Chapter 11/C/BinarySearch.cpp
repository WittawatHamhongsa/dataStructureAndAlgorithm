boolean BinarySearch(int theArray[], int key,int n){
  int first = 0;
  int last = n;
  int mid = ceil((first+last)/2);
  while(first < last){
    if (key == theArray[mid]){
      return true;
    }else if(key < theArray[mid]){
      last = mid-1;
    }else first = mid+1;
       mid = ceil((first+last)/2);
  }
  return false;
}