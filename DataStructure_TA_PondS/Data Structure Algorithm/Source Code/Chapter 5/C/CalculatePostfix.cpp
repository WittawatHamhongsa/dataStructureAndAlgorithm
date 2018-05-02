#include <stdio.h>
#include <conio.h>
#include <iostream>
#include <stackLinkedListChar.h>

void main(){
  char ch[] = "abcd*+e/-"; //Postfix input
  int length = sizeof(ch);
  float a = 20, b = 5, c = 3, d = 5, e = 4;
  float Op1=0,Op2=0,f=0;
  char chOp1,chOp2;
  for (int i=0; i < length; i++){
    if((ch[i]=='+')||(ch[i]=='-')||(ch[i]=='*')||(ch[i]=='/')||(ch[i]=='%')){
      chOp2 = pop();
      chOp1 = pop();
      if (chOp1 == 'a')
        Op1 = a;
      else if(chOp1 == 'b')
        Op1 = b;
      else if(chOp1 == 'c')
        Op1 = c;
      else if(chOp1 == 'd')
        Op1 = d;
      else if(chOp1 == 'e')
        Op1 = e;
      else if(chOp1 == 'f')
        Op1 = f;

      if(chOp2 == 'a')
        Op2 = a;
      else if(chOp2 == 'b')
        Op2 = b;
      else if(chOp2 == 'c')
        Op2 = c;
      else if(chOp2 == 'd')
        Op2 = d;
      else if(chOp2 == 'e')
        Op2 = e;
      else if(chOp2 == 'f')
        Op2 = f;

      if(ch[i] == '+')
        f = Op1 + Op2;
      else if(ch[i] == '-')
        f = Op1 - Op2;
      else if(ch[i] == '*')
        f = Op1 * Op2;
      else if(ch[i] == '/')
        f = Op1 / Op2;
      push('f');

    }else push(ch[i]);
  }
  printf("Posfix Calculate:%f",f);
  int n;
  scanf("%d",&n);
}