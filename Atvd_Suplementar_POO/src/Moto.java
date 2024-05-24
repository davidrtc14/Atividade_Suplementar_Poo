public class Moto extends Veiculo {
    private static final double TARIFF_PER_HOUR = 2.50;

    public Moto(String placa) {
        super(placa);
    }

    public double calcularValorPago() {
        long tempoEstacionado = calcularTempoEstacionamento();
        return TARIFF_PER_HOUR * (tempoEstacionado / 60.0);
    }
}