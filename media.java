import java.util.Scanner;

/*
    objetivo: Descobrir o valor de C, tal que, a media de A, B e C seja igual a mediana
    obs.: 1 <= A <= B

    C pode tomar apenas 3 posições sendo elas:
        1º) Antes de A e B (C < A && C < B), entao, A é a mediana e igual a media;
        2º) Entre A e B (C > A && C < B), entao, C é a mediana e igual a media;
        3º) Depois de A e B (C > A && C > B), entao, B é a mediana e igual a media;
    
    Para o 1º caso, se considerarmos media == mediana == A e isolarmos a variavel C, desta forma:
        media = (C + A + B) / 3
        A = (C + A + B) / 3
        3A = C + A + B
        3A - A - B = C
        2A - B = C ===> C = 2A - B (assim podemos descobrir quanto vale o C)

    seguindo o mesmo processo para o 2º caso, obtemos: C = A+B/2
    E para o 3º caso: C = 2B - A

    Entao, para solucionar este problema basta descobrir o C em cada caso e ver em qual deles é o menor valor que satisfaz o Objetivo(media == mediana)
*/
public class media {

    public static void main(String[] args) {
        
        double A, B, C1, C2, C3, C = 0;
        String[] entrada;

        // entrada
        Scanner in = new Scanner(System.in);
        entrada = in.nextLine().split(" ");
        in.close();
        // split
        A = Double.parseDouble(entrada[0]);
        B = Double.parseDouble(entrada[1]);

        // 1º) se C for menor que A e B
        C1 = (2*A)-B;
        // verificação se satisfaz
        if(Media3(C1, A, B) == A){
            C = C1;
        }

        // 2º) se C esta entre A e B
        C2 = (A+B)/2;
        // verificação se satisfaz
        if(Media3(A, C2, B) == C2){
            
            // procurando a menor resposta
            if(C2 < C){
                C = C2;
            }
        }

        // 3º) se C for maior que A e B
        C3 = (2*B)-A;
        // verificação se satisfaz
        if(Media3(A, B, C3) == B){
            
            // procurando a menor resposta
            if(C3 < C){
                C = C3;
            }
        }
        System.out.println(Math.round(C)); // saida é convertida para um numero inteiro
    }
    static double Media3(double A, double B, double C) {
        return ((A+B+C)/3);
    }
}