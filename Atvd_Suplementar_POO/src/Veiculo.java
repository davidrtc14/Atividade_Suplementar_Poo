import java.time.Duration;
import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public void registrarEntrada(LocalDateTime time) {
        this.horaEntrada = time;
    }

    public void registrarSaida(LocalDateTime time) {
        this.horaSaida = time;
    }

    public long calcularTempoEstacionamento() {
        if (horaSaida != null) {
            Duration duration = Duration.between(horaEntrada, horaSaida);
            return duration.toMinutes();
        } else {
            System.out.println("Veículo não está estacionado.");
            return 0;
        }
    }
}
