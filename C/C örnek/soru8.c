#include <stdio.h>
void faktoriyel(int *x) {
int i,sonuc=1; 
for(i=1;i<=*x;i++) sonuc*=i; 
printf("Faktoriyel = %d", sonuc); }


int main() {
int a;
printf("Pozitif sayiyi giriniz. \n");
scanf("%d",&a);
if(a>0) faktoriyel(&a);
else printf("Sayi pozitif degil!");
return 0;
}
