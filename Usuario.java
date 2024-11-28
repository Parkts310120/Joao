import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private List<Resido> residuos;
    private List<Dica> dicas;
    private List<Coleta> coletas;

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.residuos = new ArrayList<>();
        this.dicas = new ArrayList<>();
        this.coletas = new ArrayList<>();
    }

    public void registrarResiduos(Resido resido) {
        this.residuos.add(resido);
        System.out.println("Resíduo registrado com sucesso!");
    }

    public void receberDicas(Sistema sistema) {
        System.out.println("\nDicas gerais sobre o projeto:");
        for (Dica dica : sistema.obterDicasGerais()) {
            System.out.println(dica.getConteudo());
        }
    
        System.out.println("\nDicas baseadas nos seus resíduos:");
        for (Dica dica : sistema.gerarDicas(this.residuos)) {
            this.dicas.add(dica);
            System.out.println("Dica recebida: " + dica.getConteudo());
        }
    }
    
    public void monitorarResiduos() {
        if (residuos.isEmpty()) {
            System.out.println("Não há resíduos registrados.");
        } else {
            System.out.println("Resíduos registrados:");
            for (Resido resido : residuos) {
                System.out.println(resido);
            }
        }
    }

    public void agendarColeta(Coleta coleta) {
        this.coletas.add(coleta);
        System.out.println("Coleta agendada para " + coleta.getData() + " às " + coleta.getHorario() + " no Local " + coleta.getLocalizacao());
    }

    public void exibirColetasAgendadas() {
        if (coletas.isEmpty()) {
            System.out.println("Não há coletas agendadas.");
        } else {
            System.out.println("Coletas agendadas:");
            for (Coleta coleta : coletas) {
                System.out.println(coleta);
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Resido> getResiduos() {
        return residuos;
    }

    public List<Dica> getDicas() {
        return dicas;
    }

    public List<Coleta> getColetas() {
        return coletas;
    }
}
