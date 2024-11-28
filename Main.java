import java.util.Scanner;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.random.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();
        Usuario usuario = null;
        Random random = new Random();
        int id = Math.abs(random.nextInt());
        String nome = "";
        String email = "";

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Resíduos!");

        while (usuario == null) {
            System.out.print("Digite seu nome: ");
            nome = scanner.nextLine();

            System.out.print("Digite seu e-mail: ");
            email = scanner.nextLine();

            if (nome.isEmpty() || !email.contains("@")) {
                System.out.println("Dados inválidos. O nome não pode estar vazio e o e-mail deve ser válido.");
                System.out.println("Deseja tentar novamente ou finalizar o programa?");
                System.out.println("1. Tentar novamente");
                System.out.println("2. Finalizar programa");

                int escolha = scanner.nextInt();
                scanner.nextLine(); 

                if (escolha == 2) {
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                }
            } else {
                usuario = new Usuario(1, nome, email);
                sistema.adicionarUsuario(usuario);
                System.out.println("Usuário registrado com sucesso! Id: " + id);
            }
        }

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Registrar Resíduo");
            System.out.println("2. Receber Dicas de Consumo Responsável");
            System.out.println("3. Monitorar Resíduos Recicláveis");
            System.out.println("4. Agendar Coleta");
            System.out.println("5. Exibir Coletas Agendadas");
            System.out.println("6. Inserir Dicas");
            System.out.println("7. Dados do usuario");
            System.out.println("8. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1:
                    System.out.print("Digite o tipo de resíduo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite a quantidade (em kg): ");
                    float quantidade = scanner.nextFloat();
                    Resido resido = new Resido(tipo, quantidade);
                    usuario.registrarResiduos(resido);
                    break;

                case 2:
                    System.out.println("Escolha o tipo de dica que deseja receber:");
                    System.out.println("1. Dica Geral sobre o projeto");
                    System.out.println("2. Dica Específica sobre um resíduo");

                    int tipoDicaReceber = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoDicaReceber == 1) {
                        System.out.println("\nDicas gerais sobre o projeto:");
                        for (Dica dica : sistema.obterDicasGerais()) {
                            System.out.println(dica.getConteudo());
                        }
                    } else if (tipoDicaReceber == 2) {
                        if (usuario.getResiduos().isEmpty()) {
                            System.out.println("Você não tem resíduos registrados para receber dicas específicas.");
                        } else {
                            System.out.println("Escolha um resíduo para receber a dica específica(Numero do residuo):");
                            for (int i = 0; i < usuario.getResiduos().size(); i++) {
                                System.out.println((i + 1) + ". " + usuario.getResiduos().get(i));
                            }

                            int indiceResido = scanner.nextInt() - 1;
                            scanner.nextLine();
                            if (indiceResido >= 0 && indiceResido < usuario.getResiduos().size()) {
                                Resido residoEscolhido = usuario.getResiduos().get(indiceResido);
                                List<String> dicasEspecificas = residoEscolhido.getDicasEspecificas();
                                if (dicasEspecificas.isEmpty()) {
                                    System.out.println("Não há dica específica para este resíduo.");
                                } else {
                                    System.out.println("Dicas específicas para o resíduo " + residoEscolhido.getTipo() + ":");
                                    for (String dica : dicasEspecificas) {
                                        System.out.println(dica);
                                    }
                                }
                            } else {
                                System.out.println("Escolha inválida.");
                            }
                        }
                    }
                    break;


                case 3:
                    usuario.monitorarResiduos();
                    break;

                case 4:
                    System.out.print("Digite a data da coleta (dd/MM/yyyy): ");
                    String dataStr = scanner.nextLine();
                    System.out.print("Digite o horário da coleta (HH:mm): ");
                    String horario = scanner.nextLine();
                    System.out.print("Digite a localização da coleta: ");
                    String localizacao = scanner.nextLine();
                    Date data = new Date();
                    Coleta coleta = new Coleta(data, horario, localizacao);
                    usuario.agendarColeta(coleta);
                    break;

                case 5:
                    usuario.exibirColetasAgendadas();
                    break;

                case 6:
                    System.out.println("Escolha o tipo de dica a ser adicionada:");
                    System.out.println("1. Dica Geral sobre o projeto");
                    System.out.println("2. Dica Específica sobre um resíduo");
                
                    int tipoDica = scanner.nextInt();
                    scanner.nextLine();
                
                    if (tipoDica == 1) {
                        System.out.print("Digite a dica geral: ");
                        String conteudoDica = scanner.nextLine();
                        sistema.adicionarDicaGeral(conteudoDica);
                        System.out.println("Dica geral inserida com sucesso!");
                
                    } else if (tipoDica == 2) {
                        if (usuario.getResiduos().isEmpty()) {
                            System.out.println("Você não tem resíduos registrados para adicionar dicas específicas.");
                        } else {
                            System.out.println("Escolha um resíduo para adicionar a dica(Numero do residuo):");
                            for (int i = 0; i < usuario.getResiduos().size(); i++) {
                                System.out.println((i + 1) + ". " + usuario.getResiduos().get(i));
                            }
                
                            int indiceResido = scanner.nextInt() - 1;
                            scanner.nextLine();
                
                            if (indiceResido >= 0 && indiceResido < usuario.getResiduos().size()) {
                                Resido residoEscolhido = usuario.getResiduos().get(indiceResido);
                                System.out.print("Digite a dica para o resíduo " + residoEscolhido.getTipo() + ": ");
                                String dicaEspecifica = scanner.nextLine();
                                residoEscolhido.adicionarDica(dicaEspecifica);
                                System.out.println("Dica específica para o resíduo adicionada com sucesso!");
                            } else {
                                System.out.println("Escolha inválida.");
                            }
                        }
                    }
                    break;
                
                case 7:
                    System.out.println("Nome:" + nome);
                    System.out.println("Email: " + email);
                    System.out.println("Id: " + id);
                    break;

                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
