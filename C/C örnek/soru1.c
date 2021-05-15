#include <stdio.h>

int main() {
	
	int not;
printf("Not gir :");
scanf("%d",&not);

switch(not>100){
case 1: printf("gecersiz deger"); 
break;
}

switch(not>=90 && not<=100){
case 1: printf("AA"); 
break;
}

switch(not>=80 && not<=89) {
case 1: printf("BA"); 
break;
}

switch(not>=70 && not<=79) {
case 1: printf("BB"); 
break;
}

switch(not>=60 && not<=69) {
case 1: printf("CB"); 
break;
}

switch(not>=50 && not<=59) {
case 1: printf("CC"); 
break;
}

switch(not>=40 && not<=49) {
case 1: printf("DC"); 
break;
}

switch(not>=30 && not<=39) {
case 1: printf("DD"); 
break;
}

switch(not>=0 && not<=29) {
case 1: printf("FF"); 
break;
}
}
	
	
	
	

