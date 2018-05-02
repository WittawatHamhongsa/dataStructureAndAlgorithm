#include <stdio.h>
#include <stdlib.h>
//structure DoubleLinkList
struct DoubleLink{
  int item;
  struct DoubleLink *next;
  struct DoubleLink *precede;
};
//Function insert node in DoubleLinkList
struct DoubleLink *insertNode(int newItem,struct DoubleLink *nextNode,struct DoubleLink *precedeNode){
  struct DoubleLink *newNode;
  newNode = (struct DoubleLink *)malloc(sizeof(struct DoubleLink));
  newNode->item = newItem;
  newNode->next = nextNode;
  newNode->precede = precedeNode;
  return(newNode);
}
