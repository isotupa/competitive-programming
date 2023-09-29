package aop.examen;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P665 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int nCasos = sc.nextInt();
			int a1, a2, b1, b2, c1, c2;
			System.out.println("asd");
			for (int i = 0; i < nCasos; ++i) {
				String s1 = sc.next();
				String[] s2 = s1.split(".");
				a1 = Integer.parseInt(s2[0]);
				
				b1 = sc.nextInt();
				c1 = sc.nextInt();
				a2 = sc.nextInt();
				b2 = sc.nextInt();
				c2 = sc.nextInt();

				if(a2 > a1 && b2 == 0 && c2 == 0) {
					System.out.println("SI");
					break;
				} else {
					if(a2 == a1) {
						if(b2 == b1+1) {
							if(c2 == 0) {
								System.out.println("SI");
								break;
							} else {
								System.out.println("NO");
								break;
							}
						} else if(b2 == b1) {
							if(c2 == c1+1) {
								System.out.println("SI");
								break;
							} else {
								System.out.println("NO");
								break;
							}
						}
					}
				}

			}
		} catch (Exception e) {
			System.exit(1);
		}


	}

}
