import java.io.BufferedInputStream;
import java.util.Scanner;

public class ES525 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024));

            int length = sc.nextInt();

            for(int i = 0; i < length; i++) {
                int x1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y1 = sc.nextInt();
                int y2 = sc.nextInt();

                if(x1 > x2)
                {
                    int aux = x1;
                    x1 = x2;
                    x2 = aux;
                }

                if(y1 > y2)
                {
                    int aux = y1;
                    y1 = y2;
                    y2 = aux;
                }

                if(x1 >= y2 || (x1 <= y1 && x2 <= y1))
                {
                    System.out.println("SEPARADOS");
                }

                else {
                    System.out.println("SOLAPADOS");
                }




            }

    }
}
