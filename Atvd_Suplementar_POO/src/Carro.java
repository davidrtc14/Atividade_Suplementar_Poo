public class Carro extends Veiculo {
    private static final double TARIFF_PER_HOUR = 5.00;

    public Carro(String placa) {
        super(placa);
    }

    public double calcularValorPago() {
        long tempoEstacionado = calcularTempoEstacionamento();
        return TARIFF_PER_HOUR * (tempoEstacionado / 60.0);
    }
}