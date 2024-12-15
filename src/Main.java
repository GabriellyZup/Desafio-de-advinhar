
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
/*
    private static int nivelDificuldade = 1;
    private static ArrayList<Integer> numerosAcertados = new ArrayList<>();
    private static ArrayList<Integer> numerosErrados = new ArrayList<>();
    private static int pontuacaoTotal = 0;
*/



        int nivelDificuldade = escolherNivelDificuldade(scanner);


        while (continuarJogando) {
            int numeroSorteado = sortearNumero(nivelDificuldade);
            //System.out.println("Número sorteado: " + numeroSorteado);

            int palpite = obterPalpiteDoUsuario(scanner, nivelDificuldade);
            int pontos = verificarPalpite(numeroSorteado, palpite);

            pontuacaoTotal += pontos;
            if (pontos == 10) {
                acertos.add(numeroSorteado);
            } else {
                erros.add(numeroSorteado);
            }

            System.out.println("Pontuação total: " + pontuacaoTotal);
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
/*
        int intervaloInicio = 1;
        int intervaloFim = 10;

        switch (intervalo) {
            case 2:
                intervaloFim = 50;
                break;
            case 3:
                intervaloFim = 100;
                break;
        }

        return random.nextInt(intervaloFim - intervaloInicio + 1) + intervaloInicio;
    }

 */

    public static int obterPalpiteDoUsuario(Scanner scanner, int intervalo) {
        System.out.println("Digite seu palpite: (entre 1 e" + intervalo + "): ");
        return scanner.nextInt();
        //int maxPalpite = (nivelDificuldade == 1) ? 10 : (nivelDificuldade == 2) ? 50 : 100;
       // while (palpite < 1 || palpite > intervalo) {
       //     System.out.println("Palpite inválido. Tente novamente!");
        //    palpite = scanner.nextInt();
        //}
        //return palpite;
    }

    public static int verificarPalpite(int numeroSorteado, int palpite) {
        if (palpite == numeroSorteado) {
            System.out.println("Parabéns, você acertou!");
            //numerosAcertados.add(numeroSorteado);
            return 10;
        } else if (Math.abs(palpite - numeroSorteado) == 1) {
            System.out.println("Errou por 1!");
            //numerosErrados.add(numeroSorteado);
            return 5;
        } else {
            System.out.println("Errou feio!");
            //numerosErrados.add(numeroSorteado);
            return 0;
        }
    }
}