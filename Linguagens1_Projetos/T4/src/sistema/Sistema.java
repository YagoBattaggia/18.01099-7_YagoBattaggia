package sistema;

import dao.PersonagemDAO;
import enums.Profissoes;
import enums.Racas;
import models.Personagem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    PersonagemDAO personagemDAO = new PersonagemDAO();

    public void run() throws IOException, InterruptedException {
        boolean alive = true;
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            menu();
            while(true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor inserir um numero valido: ");

                }
            }
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:
                    System.out.print("Qual o nome do personagem? ");
                    String nome = scanner.nextLine();
                    Racas raca = perguntaRacas();
                    Profissoes profissao = perguntaProfissao();
                    System.out.print("Qual a mana? ");
                    int mana = Integer.parseInt(scanner.nextLine());
                    System.out.print("Qual o ataque? ");
                    int ataque = Integer.parseInt(scanner.nextLine());
                    System.out.print("Qual o ataque mágico? ");
                    int ataqueM = Integer.parseInt(scanner.nextLine());
                    System.out.print("Qual a defesa? ");
                    int defesa = Integer.parseInt(scanner.nextLine());
                    System.out.print("Qual a defesa mágica? ");
                    int defesaM = Integer.parseInt(scanner.nextLine());
                    System.out.print("Qual a velocidade? ");
                    int velocidade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Qual a destreza? ");
                    int destreza = Integer.parseInt(scanner.nextLine());
                    System.out.print("Qual a experiência? ");
                    int exp = Integer.parseInt(scanner.nextLine());
                    System.out.print("Qual o Nível Atual? ");
                    int nivelAtual = Integer.parseInt(scanner.nextLine());

                    personagemDAO.create(new Personagem(0, nome, raca, profissao, mana, ataque, ataqueM, defesa, defesaM, velocidade, destreza, exp, nivelAtual));


                    break;
                case 2:
                    System.out.print("Qual o ID do personagem que deseja alterar? ");
                    int id;
                    while(true) {
                        try {
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um ID valido!!");
                        }
                    }
                    Personagem personagem = personagemDAO.getOneData(id);
                    System.out.println(personagem.toString());
                    String[] listaAlteracao = perguntaAlteracao();
                    for (String s : listaAlteracao) {
                        int op = Integer.parseInt(s);
                        switch (op){
                            case 1:
                                System.out.print("Qual deve ser o novo Nome? ");
                                personagem.setNome(scanner.nextLine());
                                break;
                            case 2:
                                System.out.print("Qual deve ser a nova Raça? ");
                                personagem.setRaca(perguntaRacas());
                                break;
                            case 3:
                                System.out.print("Qual deve ser a nova Profissão? ");
                                personagem.setProfissao(perguntaProfissao());
                                break;
                            case 4:
                                System.out.print("Qual deve ser a nova Mana? ");
                                personagem.setMana(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 5:
                                System.out.print("Qual deve ser o novo Ataque? ");
                                personagem.setAtaque(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 6:
                                System.out.print("Qual deve ser o novo Ataque Mágico? ");
                                personagem.setAtaqueM(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 7:
                                System.out.print("Qual deve ser a nova Defesa? ");
                                personagem.setDefesa(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 8:
                                System.out.print("Qual deve ser a nova Defesa Mágico? ");
                                personagem.setDefesaM(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 9:
                                System.out.print("Qual deve ser a nova Velocidade? ");
                                personagem.setVelocidade(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 10:
                                System.out.print("Qual deve ser a nova Destreza? ");
                                personagem.setDestreza(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 11:
                                System.out.print("Qual deve ser a nova Experiência? ");
                                personagem.setExperiencia(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 12:
                                System.out.print("Qual deve ser o novo Nível? ");
                                personagem.setNivelAtual(Integer.parseInt(scanner.nextLine()));
                                break;
                            default:
                                System.out.println("Opcao invalida!!");
                                break;
                        }
                    }
                    






                    break;
                case 3:
                    System.out.println("Lista de personagens existentes: ");
                    personagemDAO.getAll().forEach(System.out::println);;
                    break;
                case 4:
                    System.out.print("Qual o ID do personagem que deseja apagar? ");
                    while(true) {
                        try {
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um ID valido!!");
                        }
                    }
                    boolean isDeleted = personagemDAO.delete(id);
                    if (isDeleted){
                        System.out.println("Personagem deletado");
                    } else {
                        System.out.println("Erro ao deletar");
                    }
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (alive);
    }

    /**
     * Mostra um menu de opcoes para a tela inicial
     */
    private void menu() {
        System.out.println("Qual ação deseja realizar?");
        System.out.println("1 - Criar um novo personagem.");
        System.out.println("2 - Alterar um personagem existente.");
        System.out.println("3 - Consultar os personagens existentes.");
        System.out.println("4 - Deletar algum personagem.");
        System.out.println("0 - Sair do programa.");
    }
    private String[] perguntaAlteracao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("O que deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Raça");
        System.out.println("3 - Profissao");
        System.out.println("4 - Mana");
        System.out.println("5 - Ataque");
        System.out.println("6 - Ataque Mágico");
        System.out.println("7 - Defesa");
        System.out.println("8 - Defesa Mágico");
        System.out.println("9 - Velocidade");
        System.out.println("10 - Destreza");
        System.out.println("11 - Esperiência");
        System.out.println("12 - Nivel atual");
        System.out.println("Insira os valores que deseja alterar, separados por uma virgula (1,4,7)");
        String mudanca;
        while(true) {
            try {
                mudanca = scanner.nextLine().replace(" ","");
                String[] arrayMudanca = mudanca.split(",");
                if(arrayMudanca.length > 12){
                    throw new Exception();
                } else {
                    return arrayMudanca;
                }
            } catch (Exception e) {
                System.out.println("Por favor inserir uma opção valida e com no máximo 12 valores separados por virgula");
            }
        }
    }

    private Profissoes perguntaProfissao() {
        System.out.println("Qual a profissão?");
        System.out.println("1 - AGRICULTOR");
        System.out.println("2 - VENDEDOR");
        System.out.println("3 - FERREIRO");
        System.out.println("4 - MINERADOR");
        System.out.println("5 - ASSASSINO");
        System.out.println("6 - MERCENARIO");
        System.out.println("7 - LADINO");
        System.out.println("8 - PIRATA");
        System.out.println("9 - ALQUIMISTA");
        System.out.println("10 - MEDICO");
        System.out.println("11 - MAGO");
        System.out.println("12 - FEITICEIRO");
        System.out.println("13 - ARQUEIRO");
        System.out.println("14 - SOLDADO");
        System.out.println("15 - DESEMPREGADO");
        boolean alive = true;
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            while(true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor inserir um numero valido!!");
                }
            }
            switch (opcao){
                case 1:
                    return Profissoes.AGRICULTOR;
                case 2:
                    return Profissoes.VENDEDOR;
                case 3:
                    return Profissoes.FERREIRO;
                case 4:
                    return Profissoes.MINERADOR;
                case 5:
                    return Profissoes.ASSASSINO;
                case 6:
                    return Profissoes.MERCENARIO;
                case 7:
                    return Profissoes.LADINO;
                case 8:
                    return Profissoes.PIRATA;
                case 9:
                    return Profissoes.ALQUIMISTA;
                case 10:
                    return Profissoes.MEDICO;
                case 11:
                    return Profissoes.MAGO;
                case 12:
                    return Profissoes.FEITICEIRO;
                case 13:
                    return Profissoes.ARQUEIRO;
                case 14:
                    return Profissoes.SOLDADO;
                case 15:
                    return Profissoes.DESEMPREGADO;

                default:
                    System.out.println("Opcao invalida!!");
                    break;
            }
        } while (alive);
        return null;
    }

    private Racas perguntaRacas() {
        System.out.println("Qual a raça?");
        System.out.println("1 - DRACONATO");
        System.out.println("2 - ANAO");
        System.out.println("3 - ELFO");
        System.out.println("4 - GNOMO");
        System.out.println("5 - MEIO ELFO");
        System.out.println("6 - HOBBIT");
        System.out.println("7 - MEIO ORC");
        System.out.println("8 - HUMANO");
        System.out.println("9 - METAMORFO");
        boolean alive = true;
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            while(true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor inserir um numero valido!!");
                }
            }
            switch (opcao){
                case 1:
                    return Racas.DRACONATO;
                case 2:
                    return Racas.ANAO;
                case 3:
                    return Racas.ELFO;
                case 4:
                    return Racas.GNOMO;
                case 5:
                    return Racas.MEIO_ELFO;
                case 6:
                    return Racas.HOBBIT;
                case 7:
                    return Racas.MEIO_ORC;
                case 8:
                    return Racas.HUMANO;
                case 9:
                    return Racas.METAMORFO;
                default:
                    System.out.println("Opcao invalida!!");
                    break;
            }
        } while (alive);
        return null;
    }
}
