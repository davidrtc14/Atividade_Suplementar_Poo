import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estacionamento estacionamento = new Estacionamento(10);

        while (true) {
            System.out.println("Digite o tipo de Veiculo que você deseja estacionar:\n1- Moto\n2- Carro\n0- Sair");
            int tipoVeiculo = scanner.nextInt();
            scanner.nextLine();

            if (tipoVeiculo == 0) {
                System.out.println("Encerrando o programa.");
                break;
            }

            Veiculo veiculo = null;

            switch (tipoVeiculo) {
                case 1:
                    System.out.print("Digite a placa da moto: ");
                    String placaMoto = scanner.nextLine();
                    veiculo = new Moto(placaMoto);
                    break;

                case 2:
                    System.out.print("Digite a placa do carro: ");
                    String placaCarro = scanner.nextLine();
                    veiculo = new Carro(placaCarro);
                    break;

                default:
                    System.out.println("Digite um número válido.");
                    continue;
            }

            System.out.print("Digite a hora de entrada (formato: yyyy-MM-dd HH:mm): ");
            String entradaStr = scanner.nextLine();
            LocalDateTime entrada = LocalDateTime.parse(entradaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            veiculo.registrarEntrada(entrada);

            if (estacionamento.adicionarVeiculo(veiculo)) {
                System.out.println("Veículo adicionado ao estacionamento.");
            } else {
                System.out.println("Estacionamento lotado. Não foi possível adicionar o veículo.");
                continue;
            }

            System.out.print("Digite a hora de saída (formato: yyyy-MM-dd HH:mm): ");
            String saidaStr = scanner.nextLine();
            LocalDateTime saida = LocalDateTime.parse(saidaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            veiculo.registrarSaida(saida);

            double valorPago;
            if (veiculo instanceof Carro) {
                valorPago = ((Carro) veiculo).calcularValorPago();
            } else {
                valorPago = ((Moto) veiculo).calcularValorPago();
            }

            System.out.println("Tempo de estacionamento: " + veiculo.calcularTempoEstacionamento() + " minutos");
            System.out.println("Valor a ser pago: R$" + valorPago);
            System.out.println("Vagas disponíveis no estacionamento: " + estacionamento.vagasDisponiveis());
        }

        scanner.close();
    }
}
