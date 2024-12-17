import java.util.Scanner;

public class velhaFinal {
    public static void main(String[] args) {
        char tabuleiro[][] = new char[3][3];
        inicializarTabulerio(tabuleiro);
        exibirTabulerio(tabuleiro);
        jogadas(tabuleiro);

    }

    public static void inicializarTabulerio(char tabuleiro[][]) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                tabuleiro[l][c] = '*';
            }
        }
    }

    public static void exibirTabulerio(char tabuleiro[][]) {
        System.out.println("    0   1   2");
        System.out.println();
        System.out.println("0   " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        System.out.println("   ───────────");
        System.out.println("1   " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        System.out.println("   ───────────");
        System.out.println("2   " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
        System.out.println();
    }

    public static void jogadas(char tabuleiro[][] ) {
        Scanner ler = new Scanner(System.in);
        boolean finalizarJogo = false;

        for (int Vez = 0; Vez < 9; Vez++) {
            if (finalizarJogo) break;

            System.out.println("Jogada " + (Vez + 1));
            int linha, coluna;
            do {
                linha = ler.nextInt();
                coluna = ler.nextInt();

                if (tabuleiro[linha][coluna] != '*') {
                    System.out.println("Esta posição já está ocupada, tente outra.");
                }
            } while (tabuleiro[linha][coluna] != '*');

            if (Vez % 2 == 0) {
                tabuleiro[linha][coluna] = 'X';
            }
            if (Vez % 2 == 1) {
                tabuleiro[linha][coluna] = 'O';
            }
            exibirTabulerio(tabuleiro);

            if (resultados(tabuleiro, Vez)){
                finalizarJogo = true;
            }

            if (Vez == 8 && !finalizarJogo){
                System.out.println("Empate!");
            }
        }
        ler.close();
    }

    public static boolean resultados(char tabuleiro[][], int Vez) {

        String X = "O jogador X ganhou";
        String O = "O jogador O ganhou";

        if (// Jogador 1 linha
        (tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X') ||
                (tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X') ||
                (tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X') ||

                // Jogador 1 coluna
                (tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X') ||
                (tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X') ||
                (tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X') ||

                // jogador 1 diagonal
                (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') ||
                (tabuleiro[2][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[0][2] == 'X')) {
            System.out.println(X);
            return true;

        } else if (// Jogador 2 linha0
        (tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O') ||
                (tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O') ||
                (tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O') ||

                // Jogador 2 coluna
                (tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O') ||
                (tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O') ||
                (tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O') ||

                // jogador 2 diagonal
                (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') ||
                (tabuleiro[2][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[0][2] == 'O')) {
            System.out.println(O);
            return true;
            
        }
       return false;
    }
}