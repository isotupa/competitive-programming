package aop.P490;

import java.io.BufferedInputStream;
import java.util.Scanner;


// id Usuario: 26362
public class P490 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int[] inicial;
			int result = 0, mejor, n, k;
			while(sc.hasNext()) {
				n = sc.nextInt();
				k = sc.nextInt();

				inicial = new int[n];
				result = 0;

				for(int i = 0; i < k-1; ++i) {
					inicial[i] = sc.nextInt();
					if(i >= 1){
						result = result + inicial[i] - inicial[i-1];
					}
				}
				mejor = 0;
				for(int i = k-1; i < n; ++i) {
					inicial[i] = sc.nextInt();
					result = result + inicial[i] - inicial[i-1];
					if(result > mejor){
						mejor = result;
					}
					else if(-result > mejor){
						mejor = -result;
					}
					result = result + (inicial[i - (k-1)] - inicial[i - (k-2)]);
				}

				System.out.println(mejor);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}


	}
}