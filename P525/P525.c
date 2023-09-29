#include <stdio.h>
#include <stdlib.h>
#pragma GCC optimize("O2")


#define MIN(X, Y) (((X) < (Y)) ? (X) : (Y))
#define MAX(X, Y) (((X) > (Y)) ? (X) : (Y))

#define MAXEQUALS(T1, T2, T3, T4) ((T1 >= T4) || (T1 <= T3 && T2 <= T3))

inline static int nextInt()
{
    int nums;
    int prim = getchar_unlocked() - '0';
    while ((nums = getchar_unlocked()) >= '0')
        prim = 10*prim + nums-'0';

    return prim;
}

int main() {
    unsigned int t1, t2, t3, t4;

    int length = nextInt();

    while(length-- > 0) {
        t1 = nextInt();
        t2 = nextInt();
        t3 = nextInt();
        t4 = nextInt();

        if(MAXEQUALS(MIN(t1,t2), MAX(t1, t2), MIN(t3, t4), MAX(t3, t4))) fputs("SEPARADOS\n", stdout);
        else fputs_unlocked("SOLAPADOS\n", stdout);
        /* if(MAXEQUALS(MIN(t1,t2), MAX(t1, t2), MIN(t3, t4), MAX(t3, t4))) printf("SEPARADOS\n"); */
        /* else printf("SOLAPADOS\n"); */
    }

    return 0;
}


