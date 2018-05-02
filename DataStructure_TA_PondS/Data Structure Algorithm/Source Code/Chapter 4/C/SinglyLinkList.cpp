#include <stdio.h>
#include <Node.h>
#define true 1
#define false 0
typedef int boolean;
struct Node *newNode;
struct Node * head;
struct Node * curr;
struct Node * prev;
//เพิ่มโหนดในลิงค์ลิสต์
void add(int newItem) {
  if (head == NULL) {
    newNode = insertNode(newItem, NULL);
  } else {
	 newNode = insertNode(newItem, head);
  }
  head = newNode;
}
//ค้นหาข้อมูลในลิงค์ลิสต์
boolean searchItem(int item) {
  curr = head;
  prev = NULL;
  boolean status = false;
  while (curr != NULL) {
    if (curr->item == item) {
      status = true;
      break;
	 } else {
      prev = curr;
      curr = curr->next;
    }
  }
  if (status) {
    return true;
  } else {
    return false;
  }
}
//ลบข้อมูลในลิงค์ลิสต์
void deleteNode(int item) {
  if (searchItem(item)) {
    if (prev == NULL) {
      head = curr->next;
    } else {
      prev->next = curr->next;
    }
  } else { printf("Not found item.\n");}
}
//แทรกโหนดในลิงค์ลิสต์
void insert(int iteminsert, int newItem) {
  newNode = insertNode(newItem,NULL);
  if (searchItem(iteminsert)) {
    if (prev == NULL) {
		newNode->next = curr;
      head = newNode;
    } else {
      newNode->next = curr;
      prev->next = newNode;
    }
  }else {
    if (head == NULL) {
      newNode->next = curr;
      head = newNode;
    } else if (curr == NULL) {
      prev->next = newNode;
    }
  }
}
//แสดงข้อมูลในลิงค์ลิสต์
void showdata() {
  curr = head;
  while (curr != NULL) {
    printf("%d ",curr->item);
    curr = curr->next;
  }
  printf("\n");
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
  printf("insert 19 at last Link List:");
  showdata();
  scanf("%d");
}
