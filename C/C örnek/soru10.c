#include <stdio.h>
void ucgen(int a,int b);
int main(){
	int g=6,h=5;
	ucgen(g,h);
	return 0;
}
void ucgen(int a,int b){
	int yaz,satir,bos,k=0;
	for(satir=1;satir<a;satir++){
		for(bos=0;bos<satir;bos++){
			printf(" ");
		}
		for(yaz=10-(k+satir);yaz>0;yaz--){
		printf("*");
		}
		printf("\n");
		k++;
	}
	k=3;
	for(satir=b;satir>0;satir--){
		for(bos=satir;bos>0;bos--){
			printf(" ");
		}
	for(yaz=1;yaz<10-(k+satir);yaz++){
		printf("*");
	}
	printf("\n");
	k--;
	}
}



