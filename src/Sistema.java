import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Usuario> usuarios;
    private List<Dica> dicasGerais;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.dicasGerais = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarDicaGeral(String conteudoDica) {
        Dica novaDica = new Dica(conteudoDica);
        dicasGerais.add(novaDica);
    }

    public List<Dica> gerarDicas(List<Resido> residuos) {
        List<Dica> dicas = new ArrayList<>();
        for (Resido resido : residuos) {
            Dica dica = new Dica("Dica sobre " + resido.getTipo());
            dicas.add(dica);
        }
        return dicas;
    }

    public List<Dica> obterDicasGerais() {
        return dicasGerais;
    }

    public void gerarRelatorios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            System.out.println("Relatório do usuário " + usuario.getNome());
            System.out.println("Resíduos registrados:");
            for (Resido resido : usuario.getResiduos()) {
                System.out.println(resido);
            }
        }
    }
}
