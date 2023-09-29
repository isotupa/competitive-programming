package aop.P361;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P361 {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {

      int k;
      int[] n = new int[5];

      while(sc.hasNext()) {
        k = sc.nextInt();
        for(int i = 0; i < n.length; i++) {
          n[i] = sc.nextInt();
        }

        System.out.println(posible(n, 1, n[0], k) ? "SI" : "NO");
      }
    } catch (Exception e) {
      System.exit(1);
    }
  }

  private static boolean posible(int[] l, int i, int acum, int k) {
    if (acum == k && i == l.length) return true;
    if (i >= l.length) return false;

    boolean divi = false;
    if (l[i] != 0 && acum%l[i] == 0) {
      divi = true;
    }
    if (!posible(l, i+1, acum+l[i], k)) {
      if (!posible(l, i+1, acum-l[i], k)) {
        if (!posible(l, i+1, acum*l[i], k)) {
          if (!divi || (divi && !posible(l, i+1, acum/l[i], k))) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
