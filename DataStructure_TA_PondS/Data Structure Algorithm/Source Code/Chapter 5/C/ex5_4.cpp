#include <stdio.h>
#define MAX_STACK 50
#define true 1
#define false 0
typedef int boolean;
int item[MAX_STACK];
int top = -1;
boolean isEmpty(){
  if(top < 0)
	 return true;
  else return false;
}
boolean isFull(){
  if(top != MAX_STACK-1)
	 return false;
  else return true;
}
boolean push(int newItem){
  if(isFull() == false){
	 item[++top] = newItem;
	 return true;
  }else return false;
}
void popAll(){
  top = -1;
}
int pop(){
  if(isEmpty() == false)
	 return item[top--];
  else return -1;
}
int peek(){
  if(isEmpty() == false)
	 return item[top];
  else return -1;
}
void main(){
	int MAX_ITEMS = 15;
	int items[15];
	for(int i=0; i < MAX_ITEMS; i++){
	  items[i] = i;
	  if(isFull() == false){
		 push(items[i]);
	  }
	}
	while(isEmpty() == false){
		 printf("%d\t",pop());
	}
}