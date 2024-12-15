import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinha {
    // variaveis globais
    private static int nivelDificuldade = 1;
    private static ArrayList<Integer> numerosAcertados = new ArrayList<>();
    private static ArrayList<Integer> numerosErrados = new ArrayList<>();
    private static int pontuacaoTotal = 0;

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo deo Adivinha!");

        // escolher nível de dificuldade
        nivelDificuldade = obterNivelDificuldade(scanner);

        boolean continuarJogando = true;

        while (continuarJogando) {
            int numeroSorteado = sortearNumero(nivelDificuldade);
            System.out.println("Número sorteado: " + numeroSorteado);

            int palpite = obterPalpiteDoUser(scanner);
            int pontos = verificarPalpite(numeroSorteado, palpite);
            pontuacaoTotal += pontos;

            System.out.println("Pontução total: " + pontuacaoTotal);

            System.out.println("Deseja jogar novamente? (s/n): ");
            continuarJogando = scanner.next().equalsIgnoreCase("s");
        }

        // Estatisticas de final do jogo
        System.out.println("Fim do jogo!");
        System.out.println("Pontuação final: " + pontuacaoTotal);
        System.out.println("Números acertados: " + numerosAcertados);
        System.out.println("Números errados: " + numerosErrados);

    }

    // Método para escolher o nível de dificuldade

    public static int obterNivelDificuldade(Scanner scanner) {
        System.out.println("Escolha o nível de dificuldade:");
        System.out.println("1. Fácil (1 a 10)");
        System.out.println("2. Médio (1 a 50)");
        System.out.println("3. Dificil (1 a 100)");

        int nivel = scanner.nextInt();
        while (nivel < 1 || nivel > 3) {
            System.out.println("Nível inválido. Escolha novamente:");
            nivel = scanner.nextInt();
        }
        return nivel;
    }
}
// metodo sorteio de numero em intervalo apropriado
public static int sortearNumero(int nivel) {
    Random random = new Random();
    int intervaloInicio = 1;
    int intervaloFim = 10;

    switch (nivel) {
        case 2: intervaloFim = 10; break;
        case 3: intervaloFim = 100; break;
    }
    return random.nextInt(intervaloFim - intervaloInicio + 1) + intervaloInicio;

    //metodo para obter palpite do usuario
    public static int obterPalpiteDoUser(Scanner scanner) {
        System.out.println("Digite seu palpiete (1 a 10): ");
        int palpite = scanner.nextInt();

        //verf se o palpite está dentro do intervalo valido
        while (palpite < 1 || palpite > 10) {
            System.out.println("Palpite inválido.");
            palpite = scanner.nextInt();
        }
        return palpite;
    }

    //metodo para verf palpite e dar pontuação
    public static int verificarPalpite(int numeroSorteado, int papite) {
        if (papite == numeroSorteado) {
            System.out.println("Parabéns você acertou!");
            numerosAcertados.add(numeroSorteado);
            return 10;
        } else if (Math.abs(papite - numeroSorteado) == 1) {
            System.out.println("Errou por 1.");
            numerosErrados.add(numeroSorteado);
            return 5;
        } else {
            System.out.println("Errou feio!");
            numerosErrados.add (numeroSorteado);
            return 0;

        }
    }
}
