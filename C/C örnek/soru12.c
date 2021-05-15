#include <stdio.h>
#include <stdlib.h>
int main(){
	int dizi[3]={10,20,30};
	char *p;
	p=dizi;
	printf("%d, ", *p);
	p=(int *)(p+2);
	printf("%d", *p);
	return 0;
}
