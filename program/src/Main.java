import java.util.Scanner;
import Campo.campo;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        campo[][] velha = new campo[3][3];
        iniciar(velha);

        char simboloAtual = 'X';
        boolean game = true;
        String vitoria = " " ;


        while (game) {
            desenhaJogo(velha);



            }
            try{
                int[] jogada = jogar(scan, simboloAtual);

                if (verificarJogada(velha, jogada, simboloAtual)) {
                    simboloAtual = (simboloAtual == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Jogada inválida, tente novamente.");
                }

            } catch (Exception e){
                System.out.println("Erro");
                scan.nextLine(); // limpa buffer
            }

        }
        System.out.print("Fim de jogo ");
        scan.close();
    }

    //iniciando o tabuleiro

    private static void iniciar (campo[][] velha){
        for (int i = 0; i <  3; i++){
            for (int j = 0; j <  3; j++){
                velha[i][j] = new campo();
            }
        }
    }

    //imprimindo o tabuleiro
    public static void desenhaJogo (campo[][] velha){
        for (int i = 0; i <  3; i++){

       System.out.printf("%d %c | %c | %c%n" , i ,
               velha[i][0].getSimbolo(),
               velha[i][1].getSimbolo(),
               velha[i][2].getSimbolo());
       if (i < 2 ){
           System.out.println("     ---------");
       }
        }
        System.out.println("");
    }

// jogada do jogador
    public static int[] jogar(Scanner scan , char sa ) {

        int [] p  = new int[2];
        System.out.printf("%s %c%n", "Quem joga : ",sa );
        System.out.print("Informa a linha ");
        p[0] = scan.nextInt();
        System.out.print("Informa a coluna ");
        p[1] = scan.nextInt();
        return p;
    }
// registro de jogada
    public static boolean verificarJogada(campo[][] velha, int[] p, char simboloAtual) {
        if (p[0] < 0 || p[0] > 2 || p[1] < 0 || p[1] > 2) {
            return false; // posição inválida
        }
        return velha[p[0]][p[1]].setSimbolo(simboloAtual);
    }



// implementar verificar  vitória


