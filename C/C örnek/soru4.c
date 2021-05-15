#include <stdio.h>
int main(){
	int i,j,k=1;
	while(j<6){
		j++;
		for(i=1;i<j;i++){
			printf("%d",k);
		}
		if(k==1){
			k=0;
		}
		else {
			k=1;
		}
		printf("\n");
	}
	return 0;
	}

