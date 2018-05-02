#include <stdio.h>
#include <DoubleLink.h>
#define true 1
#define false 0
typedef int boolean;
struct DoubleLink *newNode;
struct DoubleLink *head;
struct DoubleLink *last;
struct DoubleLink *curr;
struct DoubleLink *prev1;
struct DoubleLink *prev2;

void add(int newItem) {
  if (head == NULL) {
    newNode = insertNode(newItem, NULL, NULL);
    last = newNode;
  } else {
    newNode = insertNode(newItem, head, NULL);
    head->precede = newNode;
    head = newNode;
  }
  head = newNode;
}

boolean searchItem(int item) {
  curr = head;
  prev1 = NULL;
  boolean status = false;
  while (curr != NULL) {
    if (curr->item == item) {
      prev2 = curr->next;
      status = true;
      break;
    } else {
      prev1 = curr;
      curr = curr->next;
    }
 }
 if (status) {
   return true;
 } else {
   return false;
 }
}

void deleteNode(int item) {
  if (searchItem(item)) {
    if (prev1 == NULL) {
      head = curr->next;
      if (prev2 != NULL) {
        prev2->precede = NULL;
      }
    } else if (prev2 == NULL) {
      prev1->next = NULL;
      curr->precede = NULL;
      last = prev1;
    } else {
      prev1->next = curr->next;
      prev2->precede = curr->precede;
    }
  } else {
    printf("Not found data");
  }
}

void insert(int iteminsert, int newItem) {
  newNode = insertNode(newItem, NULL, NULL);
  if (searchItem(iteminsert)) {
    prev2 = curr;
    if (prev1 == NULL) {
      newNode->next = curr;
      curr->precede = newNode;
      head = newNode;
    } else {
      newNode->next = prev1->next;
      prev1->next = newNode;
      newNode->precede = prev2->precede;
      prev2->precede = newNode;
    }
  } else {
     if (head == NULL) {
       newNode = insertNode(newItem,NULL,NULL);
      last = newNode;
    } else {
      newNode = insertNode(newItem,NULL,last);
      last->next = newNode;
      last = newNode;
    }
  }
}

void showdata() {
  curr = head;
  while (curr != NULL) {
    printf("%d ",curr->item);
    curr = curr->next;
  }
  if (head != NULL) {
    printf(" backward : ");
    curr = last;
    while (curr != NULL) {
      printf("%d ",curr->item);
      curr = curr->precede;
    }
    printf("\n");
  }
}

void main() {
  add(9);
  printf("add 9  : ");
  showdata();
  add(10);
  printf("add 10 : ");
  showdata();
  add(11);
  printf("add 11 : ");
  showdata();
  add(12);
  printf("add 12 : ");
  showdata();
  deleteNode(10);
  printf("delete  10 : ");
  showdata();
  deleteNode(12);
  printf("delete  12 : ");
  showdata();
  insert(11, 15);
  printf("insert 15 before 11 : ");
  showdata();
  insert(11, 17);
  printf("insert 17 before 11 : ");
  showdata();
  insert(18, 19);
  printf("insert 19 at last Link List : ");
  showdata();
  scanf("%d");
}


