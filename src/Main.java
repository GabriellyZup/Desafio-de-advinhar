import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo do Adivinha!");

        Random random = new Random();
        int numeroSorteado = random.nextInt(10) + 1;
        System.out.println("Número sorteado (teste): " + numeroSorteado);
    }

}
