#include <stdio.h>
int main(){ int enb, enk, i,toplam;
int dizi[9],a;

for (i = 1; i <= 10; i++){	  
printf("%d . elememani giriniz : ", i);
scanf("%d", &a);
if(a>0) dizi[i] = a;
else { printf("Pozitif sayi girmedin program sonlandi");
return 0;} }

enk = dizi[1];
enb = dizi[1];
for (i = 2; i <= 10; i++){
if (dizi[i] < enk)
enk = dizi[i];
else if (dizi[i] > enb)
enb = dizi[i];}
toplam = enb + enk;
printf("\nEn buyuk sayi : %d En kucuk sayi : %d Sayilar arasindaki toplam : %d",enb, enk, toplam);
return 0; }
