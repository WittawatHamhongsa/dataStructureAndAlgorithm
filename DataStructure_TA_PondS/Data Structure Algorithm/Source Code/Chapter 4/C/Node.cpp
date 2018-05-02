#include <stdio.h>
#include <stdlib.h>
//structure Link List
struct Node{
  int item;
  struct Node *next;
};
//Function insert new node in Link List
struct Node *insertNode(int newItem,struct Node *nextNode){
  struct Node *newNode;
  newNode = (struct Node *)malloc(sizeof(struct Node));
  newNode->item = newItem;
  newNode->next = nextNode;
  return(newNode);
}
