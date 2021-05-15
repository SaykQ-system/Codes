#include <stdio.h>

void yerdegistir(int *x,int *y) {
	int gecici = *x;
	*x = *y ;
	*y = gecici ;
	printf("Fonksiyon calisti girdiginiz sayilar yer degisti! \n");
	printf(" Birinci sayi = %d \n ikinci sayi = %d \n",*x,*y);	
}

int main() {
	int a,b;
	printf("Birinci ve ikinci sayiyi giriniz. \n");
	scanf("%d %d",&a,&b);
	printf("\nGirdiginiz sayilar \n Birinci Sayi = %d\n Ikinci Sayi = %d \n",a,b);
	yerdegistir(&a,&b);
}
