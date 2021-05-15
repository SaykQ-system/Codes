#include <stdio.h>
#include <ctype.h>
#include <conio.h>
int main(){
    char a;
    printf("Bir harf girin: ");
    scanf("%c",&a);
	while(isalpha(a)==0) {
		printf("Bir harf giriniz\n");
		a=getch();
	}
	printf("Girdiginiz harf %c \n",a);
    if(isupper(a))
       printf("%c buyuk harftir", a );
    else 
       printf("%c kucuk harftir", a );
    return 0;
}
