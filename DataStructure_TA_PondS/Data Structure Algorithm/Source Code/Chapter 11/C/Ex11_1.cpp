#include <stdio.h>
#include <stdlib.h>
#define size 100
void main(){
	char key[35];
	int Data[size];
	int count=0;
	//�Ѻ�����Ũҡ��������������������������Ө���з�駡� �q�
	while (key[0] != 'q'){
		printf("Input Data %d :",(count+1));
	    gets(key);
		if (key[0] != 'q'){
			Data[count] = atoi(key);
			++count;
		}
	}  
    
	//���¡��ѧ��ѹ㹡�èѴ������§������
	int *Datashow = �ѧ��ѹèѴ���§�����(Data,count);  
	printf("Data for Sorting :");
	for(int i=0;i<count;i++){	                
		printf("%d\t",Datashow[i]);
	}
}
