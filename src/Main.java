import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo do Adivinha!");
        Scanner scanner = new Scanner(System.in);
        int pontuacaoTotal = 0;
        boolean continuarJogando = true;

        while (continuarJogando) {
            Random random = new Random();
            int numeroSorteado = random.nextInt(10) + 1;

            // Para testes, descomente a linha abaixo para ver o número sortedo:
            System.out.println("Número sorteado ): " + numeroSorteado);

            int palpite = obterPalpiteDoUsuario(scanner);
            pontuacaoTotal += verificarPalpite(numeroSorteado, palpite);

            System.out.println("Pontuação total: " + pontuacaoTotal);
            System.out.println("Deseja jogar novamente? (s/n): ");
            continuarJogando = scanner.next().equalsIgnoreCase("s");
        }
        System.out.println("Fim do jogo! Sua pontuação final foi: " + pontuacaoTotal);
    }

    public static int obterPalpiteDoUsuario(Scanner scanner) {
        int palpite = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Digite seu palpite (1 a 10): ");

            try{
                palpite = scanner.nextInt();//tenta ler numeor
                if (palpite >= 1 && palpite <= 10) {
                    entradaValida = true;
                } else {
                    System.out.println("Número fora do intervalo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite apenas númeoros.");
                scanner.next(); //limpa entrada inválida
            }
        }
        return palpite;
    }
    public static int verificarPalpite(int numeroSorteado, int palpite) {
        if (palpite == numeroSorteado) {
            System.out.println("Parabéns! Você acertou!");
            return 10;
        } else if (Math.abs(palpite - numeroSorteado) == 1) {
            System.out.println("Errou por um! Tente novamente");
            return 5;
        } else {
            System.out.println("Errou feio! Tente novamente");
            return 0;
        }
    }
}