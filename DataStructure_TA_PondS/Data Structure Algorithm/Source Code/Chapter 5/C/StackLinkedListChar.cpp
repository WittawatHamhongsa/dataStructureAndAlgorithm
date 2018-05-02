#include <stdio.h>
#include <NodeChar.h>
#define true 1
#define false 0
typedef int boolean;

struct NodeChar *top = NULL;
boolean isEmpty(){
  if(top == NULL)
    return true;
  else return false;
}
void push(char newItem){
  top = insertNode(newItem,top);
}
char pop(){
  if(isEmpty() == false){
    struct NodeChar *temp = top;
    top = top->next;
    return temp->item;
  }else return '1';
}
void popAll(){
  top = NULL;
}
char peek(){
  if(isEmpty() == false){
    return top->item;
  }return -1;
}