#include <stdio.h>
#include <stdlib.h>
static int nextInt() {
    int nums;
    int prim = getchar_unlocked() - '0';
    while ((nums = getchar_unlocked()) >= '0')
        prim = 10*prim + nums-'0';

    return prim;
}
int main() {
	int a1, b1, c1, a2, b2, c2;
	int nCasos = nextInt(), i;
	for( i = 0; i < nCasos; ++i) {
		// scanf("%d.%d.%d %d.%d.%d\n", &a1, &b1, &c1, &a2, &b2, &c2);
		a1 = nextInt();
		b1 = nextInt();
		c1 = nextInt();
		a2 = nextInt();
		b2 = nextInt();
		c2 = nextInt();
		if(a2 == (a1+1) && b2 == 0 && c2 == 0) {
			printf("SI\n");
			continue;
		} else if(a2 == a1) {
			if(b2 == (b1+1) && c2 == 0) {
				printf("SI\n");
				continue;
			}
			else if(b2 == b1 && c2 == (c1+1)) {
				printf("SI\n");
				continue;
			} else {
				printf("NO\n");
				continue;
			}
		} else {

			printf("NO\n");
			continue;
		}
	}
}
