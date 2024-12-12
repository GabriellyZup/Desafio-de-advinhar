import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo do Adivinha!");

        Random random = new Random();
        int numeroSorteado = random.nextInt(10) + 1;
        System.out.println("Número sorteado ): " + numeroSorteado);

        int palpite = obterPalpiteDoUsuario();
        verificarPalpite(numeroSorteado, palpite);
    }

    public static int   obterPalpiteDoUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu palpite (1 a 10): ");
        return scanner.nextInt();
    }

    public static void verificarPalpite (int numeroSorteado, int palpite) {
        if (palpite == numeroSorteado) {
            System.out.println(" Parabéns! Você acertou!");
        } else if (palpite == numeroSorteado - 1 || palpite == numeroSorteado + 1) {
            System.out.println("Errou por um! Tente novamente");
        } else {
            System.out.println("Errou feio! Tente novamente");
        }
    }
}
