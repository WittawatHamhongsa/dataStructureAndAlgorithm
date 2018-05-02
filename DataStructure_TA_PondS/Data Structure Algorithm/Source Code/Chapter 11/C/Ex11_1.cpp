#include <stdio.h>
#include <stdlib.h>
#define size 100
void main(){
	char key[35];
	int Data[size];
	int count=0;
	//รับข้อมูลจากคีย์บอร์ดเข้ามาเก็บไว้ในอาร์เรย์ทำจนกระทั้งกด ‘q’
	while (key[0] != 'q'){
		printf("Input Data %d :",(count+1));
	    gets(key);
		if (key[0] != 'q'){
			Data[count] = atoi(key);
			++count;
		}
	}  
    
	//เรียกใช้ฟังก์ชันในการจัดการเรียงข้อมูล
	int *Datashow = ฟังก์ชันรจัดเรียงข้อมู(Data,count);  
	printf("Data for Sorting :");
	for(int i=0;i<count;i++){	                
		printf("%d\t",Datashow[i]);
	}
}
