package aop.P437;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P347 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int nCasos = sc.nextInt();
			for (int i = 0; i < nCasos; i++) {
				String[] time = sc.next().split(":");
				
				int secTotal = Integer.parseInt(time[0])*60*60 + Integer.parseInt(time[1])*60 + Integer.parseInt(time[2]);
				int doce = 24*60*60;
								
				int resEnSecs = doce - secTotal;
				
				int resH = (resEnSecs/3600);
				int resM = (resEnSecs/60)%60;
				int resS = resEnSecs%60;
				
				System.out.format("%02d:%02d:%02d\n", resH, resM, resS);
			}
		} catch (Exception e) {
			System.exit(1);
		}


	}

}
