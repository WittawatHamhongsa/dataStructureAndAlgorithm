#include <stdlib.h>
struct TreeNode{
  int item;
  struct TreeNode *lChild;
  struct TreeNode *rChild;
};
struct TreeNode *insertNode(int newItem){
  struct TreeNode *newNode;
  newNode =(struct TreeNode *) malloc(sizeof(struct TreeNode));
  newNode->item = newItem;
  newNode->lChild = NULL;
  newNode->rChild = NULL;
  return(newNode);
}
struct TreeNode *insertNode(int newItem,   struct TreeNode *newlChild, struct TreeNode *newrChild){
  struct TreeNode *newNode;
  newNode =(struct TreeNode *)malloc(sizeof(struct TreeNode));
  newNode->item = newItem;
  newNode->lChild = newlChild;
  newNode->rChild = newrChild;
  return(newNode);
}
