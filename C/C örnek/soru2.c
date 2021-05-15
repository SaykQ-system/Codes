#include <stdio.h>
int main(){
int x,y,z,enb;
printf("sayýalr girin\n");
scanf("%d %d %d",&x,&y,&z);
if(x==y || x==z || z==y){
	printf("sayýlar ayný");
}
 else{
 if(x>y){
 	if(x>z)	enb=x;
 	else enb=z;
 }
 else{
 	if(y>z) enb=y;
 	else enb=z;
 }
 printf("girilen en buyuk sayi %d",enb);
 }
 return 0;
 }
