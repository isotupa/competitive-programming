package aop.examen;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P298 {

	static boolean res;
	static Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024));

	static void aux(int a, int b) {
		int nodo = sc.nextInt();

		if(nodo==-1) return ;
		if (nodo<a || nodo>b)
			res = false;
		aux(a, nodo-1);
		aux(nodo+1, b);
	}

	public static void main(String[] args) {
		int nCasos = sc.nextInt();
		for (int i = 0; i < nCasos; ++i) {
			res = true;
			aux(Integer.MIN_VALUE, Integer.MAX_VALUE);
			if(res) System.out.println("SI");
			else System.out.println("NO");
		}

	}

}
/*
#include <bits/stdc++.h>
using namespace std;

bool res;

void solve(int min, int max){
 int value;
 scanf("%d",&value);
 if(value==-1) return ;
   if (value<min || value>max)
       res = false;
   solve(min, value-1);
   solve(value+1, max);
}

int main(){
    int cases; scanf("%d",&cases);
    while(cases--){
      res = true;
      solve(-0x3f3f3f,0x3f3f3f);
      if(res) printf("SI\n");
      else printf("NO\n");
    }
    return 0;
}
 */