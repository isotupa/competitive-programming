package aop.P606;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P606 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024));
        int n;
        
        while(true) {
        	n = sc.nextInt();
        	if(n == 0) break;
        	int[] precios = new int[n];
        	int[] crec = new int[n];
        	
        	for(int i = 0; i < n; i++) {
        		precios[i] = sc.nextInt();
        	}
        	
        	crec[0] = 1;
        	
        	for(int i = 0; i < n; i++) {
        		int max = 1;
        		for(int j = 0; j < i; j++) {
        			if (precios[j] < precios[i]) max = Math.max(max, crec[j] + 1);
        		}
        		crec[i] = max;
        	}
        	int mejor = 1;
        	for(int i = 0; i < crec.length; i++) {
        		mejor = Math.max(mejor, crec[i]);
        	}
        	
        	System.out.println(mejor);
        }
    }

}
