import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private int capacidade;
    private List<Veiculo> veiculosEstacionados;

    public Estacionamento(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.veiculosEstacionados = new ArrayList<>();
    }

    public boolean adicionarVeiculo(Veiculo veiculo) {
        if (veiculosEstacionados.size() < capacidade) {
            veiculosEstacionados.add(veiculo);
            return true;
        }
        return false;
    }

    public boolean verificarEspacoDisponivel() {
        return veiculosEstacionados.size() < capacidade;
    }

    public boolean removerVeiculo(String placa) {
        for (Veiculo veiculo : veiculosEstacionados) {
                veiculosEstacionados.remove(veiculo);
                return true;
        }
        return false;
    }

    public int vagasDisponiveis() {
        return capacidade - veiculosEstacionados.size();
    }
}
