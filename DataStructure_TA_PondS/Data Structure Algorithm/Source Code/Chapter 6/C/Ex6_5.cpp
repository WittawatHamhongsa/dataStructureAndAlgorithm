#include <stdio.h>
#include <Node.h>
#define true 1
#define false 0
typedef int boolean;
struct Node *lastNode = NULL;
boolean isEmpty(){
  if(lastNode == NULL)
    return true;
  else return false;
}
void dequeueAll(){
  lastNode = NULL;
}
void enqueue(int newItem){
  struct Node *newNode;
  newNode = insertNode(newItem,NULL);
  if(isEmpty() == true){
    newNode->next = newNode;
  }else{
    newNode->next = lastNode->next;
    lastNode->next = newNode;
  }
  lastNode = newNode;
}
int dequeue(){
  if(isEmpty() == false){
    struct Node *firstNode;
    firstNode = lastNode->next;
    if(firstNode == lastNode){
       lastNode = NULL;
    }else{
       lastNode->next = firstNode->next;
    }
    return firstNode->item;
  }else return -1;
}
int peek(){
  if(isEmpty() == false){
    struct Node *firstNode;
    firstNode = lastNode->next;
    return firstNode->item;
  }else return -1;
}
void main(){
  for (int i=0; i<9; i++){
    enqueue(i);
  }
  while(isEmpty() == false){
    printf("%d\t",dequeue());
  }   
}
