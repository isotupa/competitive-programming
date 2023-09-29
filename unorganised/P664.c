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
	int p, j, dev, mem, n, i;
	int alt[5];
	while(1) {
		p = nextInt();
		if(p == 0) break;
		mem = 0;
		for(i = 0; i < p; i++) {
			dev = 0;
			n = nextInt();
			for(j = 0; j < n; j++) {
				alt[j] = nextInt();
				if(alt[j] > dev) {
					dev = alt[j];
				}
			}
			if(i == 0 || mem > dev) {
				mem = dev;
			}
		}
		printf("%d\n", mem);

	}
}
