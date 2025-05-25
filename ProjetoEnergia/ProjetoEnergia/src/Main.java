import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o consumo mensal em KWh: ");
        double consumo = scanner.nextDouble();

        ConsumoEnergia energia = new ConsumoEnergia(consumo);
        energia.exibirDetalhes();

        scanner.close();
    }
}
