#include <stdio.h>
#include <conio.h>
#include <StackLinkedListChar.h>

void main(){
    char infix[] = "a-(b+c*d)/e";
    int length = sizeof(infix);
    char postfix[50];
    int countpostfix = 0;

    for (int i=0; i<length-1; i++){
      if((infix[i]=='+')||(infix[i]=='-')|| (infix[i]=='*')||(infix[i]=='/')||(infix[i]=='%')||(infix[i]=='(')){
        push(infix[i]);
      }else if(infix[i] == ')'){
        char stackBuffer = pop();
        while (stackBuffer != '('){
          postfix[countpostfix] = stackBuffer;
          countpostfix++;
          stackBuffer = pop();
        }
      }else{
        postfix[countpostfix] = infix[i];
        countpostfix++;
      }
    }
    while (isEmpty() == false){
      char buff = peek();
      postfix[countpostfix] = pop();
      countpostfix++;
    }
    postfix[countpostfix] = '\0';
    printf("Infix:%s\n",infix);
    printf("Postfix:%s",postfix);

    int n;
    scanf("%d",&n);
}

