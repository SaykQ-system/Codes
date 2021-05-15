#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main() {
int	i,n=rand();							
srand(time(NULL));

for(i=1;i<=n;i++) {
int sayi = 0+rand()%100;

if(sayi%2==0) sayi = 0;
printf("sayi = %d \n",sayi); }	
return 0;
 }
