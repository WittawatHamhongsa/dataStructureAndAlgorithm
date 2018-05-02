#include <stdio.h>
#define MAX_QUEUE 5
#define true 1
#define false 0
typedef int boolean;
int items[MAX_QUEUE];
int front = 0;
int back = MAX_QUEUE-1;
int count = 0;
boolean isEmpty(){
  if(count == 0)
    return true;
  else return false;
}
boolean isFull(){
  if(count == MAX_QUEUE)
    return true;
  else return false;
}
boolean enqueue(int newItem){
  if(!isFull()){
     back = (back+1) % MAX_QUEUE;
     items[back] = newItem;
     ++count;
     return true;
  }else return false;
}
int dequeue(){
  if(isEmpty() == false){
    int queueFront = items[front];
    front = (front+1) % MAX_QUEUE;
    count--;
    return queueFront;
  }else return -1;
}
void dequeueAll(){
  front = 0;
  back = MAX_QUEUE-1;
  count = 0;
}
int peek(){
  if(isEmpty() == false){
    return items[front];
  }else return -1;
}

void main(){
  enqueue(1);
  enqueue(2);
  enqueue(3);
  enqueue(4);
  enqueue(5);
  enqueue(6);
  while (isEmpty() == false){
    printf("%d\t",dequeue());
  }

  int n;
  scanf("%d",&n);

}
