#include <stdio.h>
#include <Node.h>
#define true 1
#define false 0
typedef int boolean;
struct Node *top = NULL;
boolean isEmpty(){
  if(top == NULL)
    return true;
  else return false;
}
void push(int newItem){
  top = insertNode(newItem,top);
}
int pop(){
  if(isEmpty() == false){
    struct Node *temp = top;
    top = top->next;
    return temp->item;
  }else return -1;
}
void popAll(){
  top = NULL;
}
int peek(){
  if(isEmpty() == false){
    return top->item;
  }return -1;
}
