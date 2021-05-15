#include <stdio.h>
int main() {
int i,n,faktor=1;
float toplam=0;			

printf("Bir sayi giriniz");				
scanf("%d",&n);							

for(i=2;i<=n;i++){
faktor*=i; 
toplam+= (float) 1 / faktor;
}
printf("Faktoriyel =%d\nToplam = %.2f",faktor,toplam);
return 0;
}
