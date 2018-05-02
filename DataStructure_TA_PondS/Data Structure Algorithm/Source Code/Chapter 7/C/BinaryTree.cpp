#include <stdio.h>
#include <TreeNode.h>
#define true 1
#define false 0
typedef int boolean;
struct TreeNode *root;
struct TreeNode *newNode;
struct TreeNode *parent;
struct TreeNode *NodeDelete;
char child;
int countLevel;
//ฟังก์ชันตรวจสอบว่าทรีว่างเปล่าหรือไม่
boolean isEmpty(){
  if(root == NULL)
    return true;
  else 
    return false;
}
//ฟังก์ชันค้นหาตำแหน่งในการเพิ่มโหนดในไบนารีทรี
void insertItem(struct TreeNode *bst, int newItem){
  if(newItem < bst->item){
    if(bst->lChild == NULL){
       newNode = insertNode(newItem);
       bst->lChild = newNode;
    }else 
       insertItem(bst->lChild,newItem);
  }else{
    if(bst->rChild == NULL){
       newNode = insertNode(newItem);
       bst->rChild = newNode;
    }else 
       insertItem(bst->rChild,newItem);
  }
}
//เพิ่มข้อมูลในไบนารีทรี
struct TreeNode *insert(int newItem){
  if(isEmpty() == true){
     newNode = insertNode(newItem);
     root = newNode;
  }else{
     insertItem(root, newItem);
  }
  return root;
}
//ค้นหาโหนดในไบนารีทรีเพื่อทำการลบโหนด
void search(struct TreeNode *bst, int searchKey){
  if(searchKey == bst->item){
    NodeDelete = bst;
  }else if(searchKey < bst->item){
    parent = bst;
    child = 'l';
    search(bst->lChild,searchKey);
  }else{
    parent = bst;
    child = 'r';
    search(bst->rChild,searchKey);
  }
}
//ค้นหาโหนดด้วยหลักการ inordersuccessor
void inordersuccessor(struct TreeNode *bst){
  if(bst->lChild != NULL){
     parent = bst;
     ++countLevel;
     inordersuccessor(bst->lChild);
  }else{
     NodeDelete->item = bst->item;
     if(countLevel == 0){
        NodeDelete->rChild = NULL;
     }else{
        parent->lChild = NULL;
     }
  }
}
//ลบโหนดในไบนารีทรี
void deleteTree(int deleteItem){
  if(isEmpty()== true){
     printf("Tree Empty");
  }else{
     parent = root;
     NodeDelete = NULL;
     search(root, deleteItem);
     struct TreeNode *lChild = NodeDelete->lChild;
     struct TreeNode *rChild = NodeDelete->rChild;
    if((lChild==NULL)&&(rChild==NULL)){
       //leaf Node
       if(child == 'l')
          parent->lChild = NULL;
       else 
          parent->rChild = NULL;
    }if((lChild!=NULL)&&(rChild!=NULL)){
       //treeNode have two Children
       countLevel = 0;
       inordersuccessor(NodeDelete->rChild);
    }else{//treeNode has one Children
       if(NodeDelete->lChild != NULL){
         if(child == 'l')
           parent->lChild = NodeDelete->lChild;
         else 
           parent->rChild = NodeDelete->lChild;
       }else{ 
         if(child == 'l')
            parent->lChild = NodeDelete->rChild;
         else 
            parent->rChild = NodeDelete->rChild;
       }
    }
  }
}
//travel in binary tree by preOrder
void preOrder(struct TreeNode *rootNode){
  if(rootNode != NULL){
     printf("%d\t",rootNode->item);
     preOrder(rootNode->lChild);
     preOrder(rootNode->rChild);
  }
}
//travel in binary tree by inOrder
void inOrder(struct TreeNode *rootNode){
  if(rootNode != NULL){
     inOrder(rootNode->lChild);
     printf("%d\t",rootNode->item);
     inOrder(rootNode->rChild);
  }
}
//travel in binary tree by postOrder
void postOrder(struct TreeNode *rootNode){
  if(rootNode != NULL){
     postOrder(rootNode->lChild);
     postOrder(rootNode->rChild);
     printf("%d\t",rootNode->item);
  }
}
void main(){
   struct TreeNode *root;
   root = insert(60);
   insert(20);
   insert(10);
   insert(40);
   insert(30);
   insert(50);
   insert(70);
   printf("Insert: 60 20 10 40 30 50 70 ");
   printf("\nPreorder: ");
   preOrder(root);
   deleteTree(20);
   printf("\nDelete: 20");
   printf("\nPreorder: ");
   preOrder(root);
   printf("\nInorder: ");
   inOrder(root);
   printf("\nPostorder: ");
   postOrder(root);
}
