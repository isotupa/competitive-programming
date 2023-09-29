#include <stdio.h>

static int nextInt() {
    int nums;
    int prim = getchar_unlocked() - '0';
    int sign = 1;
    if (prim == '-') {
        sign = -1;
        prim = getchar_unlocked() - '0';
    }
    while ((nums = getchar_unlocked()) >= '0') {
        prim = 10*prim + nums-'0';
    }
    return prim * sign;
}
int vf;
void aux(int a, int b){
	int nodo = nextInt();

	if(nodo==-29) return;
	if (nodo<a || nodo>b)
		vf = 0;
	aux(a, nodo-1);
	aux(nodo+1, b);
}

int main(){
	int nCasos = nextInt(); 
	while(nCasos--){
		vf = 1;
		aux(-4000,4000);
		if(vf) printf("SI\n");
		else printf("NO\n");
	}
	return 0;
}

