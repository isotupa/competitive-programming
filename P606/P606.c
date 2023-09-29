#include <stdio.h>
#include <stdlib.h>

#define MAX(X, Y) (((X) > (Y)) ? (X) : (Y))

inline static int nextInt()
{
    int nums;
    int prim = getchar_unlocked() - '0';
    while ((nums = getchar_unlocked()) >= '0')
        prim = 10*prim + nums-'0';

    return prim;
}

int main() {
    int n, i, j, max;
    while(1) {
        n = nextInt();
        if(n == 0) break;

        int precios[n];
        int crec[n];

        for(i = 0; i < n; ++i) precios[i] = nextInt();

        crec[0] = 1;

        for(i = 0; i < n; ++i) {
            max = 1;
            for(j = 0; j < i; ++j) if(precios[j] < precios[i]) max = MAX(max, crec[j] + 1);
            crec[i] = max;
        }

        int mejor = 1;

        for(i = 0; i < sizeof(crec)/sizeof(crec[0]); ++i) mejor = MAX(mejor, crec[i]);

        printf("%d\n", mejor);

    }
}
