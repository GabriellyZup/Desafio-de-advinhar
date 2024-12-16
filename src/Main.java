
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo de Adivinha!");
        Scanner scanner = new Scanner(System.in);
        int pontuacaoTotal = 0;
        List<Integer> acertos = new ArrayList<>();
        List<Integer> erros = new ArrayList<>();
        boolean continuarJogando = true;

        int nivelDificuldade = escolherNivelDificuldade(scanner);
        while (continuarJogando) {
            int numeroSorteado = sortearNumero(nivelDificuldade);
            System.out.println("Número sorteado para teste " + numeroSorteado);

            int palpite = obterPalpiteDoUsuario(scanner, nivelDificuldade);
            int pontos = verificarPalpite(numeroSorteado, palpite, nivelDificuldade);
            pontuacaoTotal += pontos;
            if (pontos == 10) {
                acertos.add(numeroSorteado);
            } else {
                erros.add(numeroSorteado);
            }
            System.out.println("Pontuação total: " + pontuacaoTotal);

            if (pontuacaoTotal % 50 == 0) {
                System.out.println("Você atingiu " + pontuacaoTotal + " pontos!");
                nivelDificuldade = escolherNivelDificuldade(scanner);
            }

            System.out.println("Deseja jogar novamente? (s/n): ");
            continuarJogando = scanner.next().equalsIgnoreCase("s");
        }
        System.out.println("Fim do jogo!");
        System.out.println("Pontuação final: " + pontuacaoTotal);
        System.out.println("Números acertados: " + acertos);
        System.out.println("Números errados: " + erros);
    }
    public static int escolherNivelDificuldade(Scanner scanner) {
        System.out.println("Escolha o nível de dificuldade:");
        System.out.println("1. Fácil (1 a 10)");
        System.out.println("2. Médio (1 a 50)");
        System.out.println("3. Difícil (1 a 100)");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                return 10;
            case 2:
                return 50;
            case 3:
                return 100;
            default:
                System.out.println("Opção inválida, selecinando fácil como padrão.");
                return 10;
        }
    }

    public static int sortearNumero(int intervalo) {
        Random random = new Random();
        return random.nextInt(intervalo) + 1;
    }

    public static int obterPalpiteDoUsuario(Scanner scanner, int intervalo) {
        int palpite = -1;
        while (true){
            System.out.println("Digite seu palpite: (entre 1 e " + intervalo + "): ");
            if (scanner.hasNext()) {
                palpite = scanner.nextInt();
                if (palpite >= 1 && palpite <= intervalo) {
                    break;
                } else {
                    System.out.println("Palpite inválido. Tente novamente!");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro");
                scanner.next(); //clear
            }
        }
        return palpite;
    }

    public static int verificarPalpite(int numeroSorteado, int palpite, int nivelDificuldade) {
        if (palpite == numeroSorteado) {
            System.out.println("Parabéns, você acertou!");
            return 10;
        } else if (Math.abs(palpite - numeroSorteado) == 1) {
            System.out.println("Errou por 1!");
            return 5;
        } else {
            System.out.println("Errou feio!");
            return 0;
        }
    }
}