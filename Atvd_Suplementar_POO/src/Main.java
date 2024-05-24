import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estacionamento estacionamento = new Estacionamento(10);

        while (true) {
            System.out.println("Digite a ação desejada:\n1- Estacionar Moto\n2- Estacionar Carro\n3- Remover Veículo\n0- Sair");
            int acao = scanner.nextInt();
            scanner.nextLine();

            if (acao == 0) {
                System.out.println("Encerrando o programa.");
                break;
            }

            switch (acao) {
                case 1:
                case 2:
                    Veiculo veiculo = null;

                    if (acao == 1) {
                        System.out.print("Digite a placa da moto: ");
                        String placaMoto = scanner.nextLine();
                        veiculo = new Moto(placaMoto);
                    } else {
                        System.out.print("Digite a placa do carro: ");
                        String placaCarro = scanner.nextLine();
                        veiculo = new Carro(placaCarro);
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
                    break;

                case 3:
                    System.out.print("Digite a placa do veículo a ser removido: ");
                    String placa = scanner.nextLine();
                    if (estacionamento.removerVeiculo(placa)) {
                        System.out.println("Veículo removido do estacionamento.");
                    } else {
                        System.out.println("Veículo não encontrado no estacionamento.");
                    }
                    break;

                default:
                    System.out.println("Digite um número válido.");
            }
        }

        scanner.close();
    }
}
