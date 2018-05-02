#include <stdio.h>
#include <stdlib.h>

struct NodeChar{
  char item;
  struct NodeChar *next;
};

struct NodeChar *insertNode(char newItem,struct NodeChar *nextNode){

  struct NodeChar *newNode;

  newNode = (struct NodeChar *)malloc(sizeof(struct NodeChar));
  newNode->item = newItem;
  newNode->next = nextNode;
  return(newNode);

}

void printlist (struct NodeChar *head){
  struct NodeChar *curr;
  curr = head;
  while (curr != NULL){
    printf("%d\t",curr->item);
    curr = curr->next;
  }
}
