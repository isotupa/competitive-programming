package aop.P626;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P626 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int nCasos = Integer.parseInt(sc.nextLine());
			int dia, mes, year, mod;
			String s;
			String[] ss;
			for (int i = 0; i < nCasos; ++i) {
				s = sc.nextLine();
				ss = s.split("/");
				dia = Integer.parseInt(ss[0]);
				mes = Integer.parseInt(ss[1]);
				year = Integer.parseInt(ss[2]);
				
				mod = year+(4-(year%4));
				
				if(mes <= 2 && year%4 == 0) {
					if(mes != 2 || dia != 29) {
						mod = year;
					}
				}
				
				System.out.format("29/02/%04d\n", mod);
			}
		} catch (Exception e) {
			System.exit(1);
		}


	}

}
