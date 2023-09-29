package aop.examen;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P664 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int p = 1;
			while(true) {
				p = Integer.parseInt(sc.nextLine());
				if(p == 0) break;
				int dev = 0;
				int mem = 0;
				for(int i = 0; i < p; i++) {
					String alt1 = sc.nextLine();
					String[] alt = alt1.split(" ");
					for(int j = 1; j < alt.length; j++) {
						if(Integer.parseInt(alt[j]) > dev) {
							dev = Integer.parseInt(alt[j]);
						}
					}
					if(i == 0) {
						mem = dev;
					} else {
						if(mem > dev) {
							mem = dev;
						}
					}
					dev = 0;
				}
				System.out.println(mem);
				
			}
		} catch (Exception e) {
			System.out.println("error");
			System.exit(1);
		}


	}

}
