import java.util.Scanner;

/**
 * media
 */
public class media {

    public static void main(String[] args) {
        
        Integer A, B, C;
        String[] entrada;
        Float media;
        boolean decrement = false;

        Scanner in = new Scanner(System.in, "utf-8");
        entrada = in.nextLine().split(" ");
        in.close();

        A = Integer.parseInt(entrada[0]);
        B = Integer.parseInt(entrada[1]);

        // init
        C = 0;
        media = Media3(A, B, C);

        if(media > A){
            decrement = true;
        }
        // loop
        while (C < 1000000000) {
            if (C < A && media == (A*1.0f)) {
                break;
            }
            if (C > B && media == (B*1.0f)) {
                break;
            }
            if ((C < A && C > B) && media == (C*1.0f)) {
                break;
            }
            media = Media3(A, B, C);
            if(decrement){
                C-=1;
            }else {
                C+=1;
            }
        }
        if(C != 0){
            if(decrement){
                C+=1;
            }else {
                C-=1;
            }
        }
        System.out.println(C);
    }
    static Float Media3(Integer A, Integer B, Integer C) {
        return ((A+B+C)/3.0f);
    }
}