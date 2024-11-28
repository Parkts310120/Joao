import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Resido {
    private String tipo;
    private float quantidade;
    private Date dataRegistro;
    private List<String> dicasEspecificas;

    public Resido(String tipo, float quantidade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.dataRegistro = new Date();
        this.dicasEspecificas = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public List<String> getDicasEspecificas() {
        return dicasEspecificas;
    }

    public void adicionarDica(String dica) {
        this.dicasEspecificas.add(dica);
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Quantidade: " + quantidade + "kg, Registrado em: " + dataRegistro;
    }
}
