#include <stdio.h>
int seritor(int a){
	int i,islem=0;
		for(i=1;i<=a;i++) {
		islem+=i*i;      
		}
	printf("Karelerin toplami = %d",islem);
} 
int main(){
	int n;
	printf("N'e kadar olan sayilarin karesini almak i�in sayi giriniz. \n");
	scanf("%d",&n);
	seritor(n) ;
	return 0;
}
