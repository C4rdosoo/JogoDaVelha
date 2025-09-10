import java.util.Scanner;
import Campo.campo;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        campo[][] velha = new campo[3][3];
        iniciar(velha);

        char simboloAtual = 'X';
        String vitoria;

        while (true) {
            desenhaJogo(velha);

            // verifica se houve algum ganhador
            vitoria = VAR(velha);
            if (!vitoria.isEmpty()) {
                System.out.printf("Jogador %s venceu!%n", vitoria);
                break;
            }

            // verifica se houve empate
            if (empate(velha)) {
                System.out.println("!! Deu velha !!");
                break;
            }

            try {
                int[] jogada = jogar(scan, simboloAtual);

                if (verificarJogada(velha, jogada, simboloAtual)) {
                    simboloAtual = (simboloAtual == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Jogada inválida, tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scan.nextLine(); // limpa buffer
            }
        }

        desenhaJogo(velha);
        scan.close();
    }

    // inicia tabuleiro
    private static void iniciar(campo[][] velha) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                velha[i][j] = new campo();
            }
        }
    }

    // imprime o tabuleiro
    public static void desenhaJogo(campo[][] velha) {
        System.out.println("    0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d   %c | %c | %c%n",
                    i,
                    velha[i][0].getSimbolo(),
                    velha[i][1].getSimbolo(),
                    velha[i][2].getSimbolo());
            if (i < 2) System.out.println("   ---+---+---");
        }
        System.out.println();
    }

    // lê a jogada
    public static int[] jogar(Scanner scan, char jogador) {
        int[] p = new int[2];
        System.out.printf("Quem joga: %c%n", jogador);
        System.out.print("Informe a linha (0-2): ");
        p[0] = scan.nextInt();
        System.out.print("Informe a coluna (0-2): ");
        p[1] = scan.nextInt();
        return p;
    }

    // registra a jogada (valida posição)
    public static boolean verificarJogada(campo[][] velha, int[] p, char simboloAtual) {
        if (p[0] < 0 || p[0] > 2 || p[1] < 0 || p[1] > 2) return false;
        return velha[p[0]][p[1]].setSimbolo(simboloAtual);
    }

    // checa vitória
    public static String VAR(campo[][] velha) {
        // linhas
        for (int i = 0; i < 3; i++) {
            char a = velha[i][0].getSimbolo();
            if (a != ' ' && a == velha[i][1].getSimbolo() && a == velha[i][2].getSimbolo()) return String.valueOf(a);
        }
        // colunas
        for (int j = 0; j < 3; j++) {
            char a = velha[0][j].getSimbolo();
            if (a != ' ' && a == velha[1][j].getSimbolo() && a == velha[2][j].getSimbolo()) return String.valueOf(a);
        }
        // diagonais
        char c = velha[1][1].getSimbolo();
        if (c != ' ' && velha[0][0].getSimbolo() == c && velha[2][2].getSimbolo() == c) return String.valueOf(c);
        if (c != ' ' && velha[0][2].getSimbolo() == c && velha[2][0].getSimbolo() == c) return String.valueOf(c);

        return "";
    }

    // verifica empate
    private static boolean empate(campo[][] velha) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (velha[i][j].getSimbolo() == ' ') return false;
            }
        }
        return VAR(velha).isEmpty();
    }
}
