package sistema;

import dao.PersonagemDAO;
import enums.Profissoes;
import enums.Racas;
import models.Personagem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* TODO JAVADOCS, RAs, try and catch para as strings */

/**
 * Classe concreta que representa o sistema principal. Ela que vai executar o sistema.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/12/2020
 * @version 1.0
 */
public class Sistema {
    PersonagemDAO personagemDAO = new PersonagemDAO();

    /**
     * Método run, ele vai ser o principal metodo do programa e vai funcionar até escolherem a opção 0.
     */
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
                    String nome;

                    while(true) {
                        try {
                            nome = scanner.nextLine();
                            if(nome.isEmpty()){
                                throw new Exception();
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Por favor inserir um nome valido!!");

                        }
                    }
                    Racas raca = perguntaRacas();
                    Profissoes profissao = perguntaProfissao();
                    System.out.print("Qual a mana? ");
                    int mana;
                    while(true) {
                        try {
                            mana = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }
                    System.out.print("Qual o ataque? ");
                    int ataque;
                    while(true) {
                        try {
                            ataque = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }
                    System.out.print("Qual o ataque mágico? ");
                    int ataqueM;
                    while(true) {
                        try {
                            ataqueM = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }
                    System.out.print("Qual a defesa? ");
                    int defesa;
                    while(true) {
                        try {
                            defesa = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }
                    System.out.print("Qual a defesa mágica? ");
                    int defesaM;
                    while(true) {
                        try {
                            defesaM = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }
                    System.out.print("Qual a velocidade? ");
                    int velocidade;
                    while(true) {
                        try {
                            velocidade = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }
                    System.out.print("Qual a destreza? ");
                    int destreza;
                    while(true) {
                        try {
                            destreza = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }
                    System.out.print("Qual a experiência? ");
                    int exp;
                    while(true) {
                        try {
                            exp = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }
                    System.out.print("Qual o Nível Atual? ");
                    int nivelAtual;
                    while(true) {
                        try {
                            nivelAtual = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor inserir um numero valido: ");

                        }
                    }

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
                                personagem.setRaca(perguntaRacas());
                                break;
                            case 3:
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
                    personagemDAO.update(personagem);
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
    /**
     * Pergunta quais alterações o usuário deseja fazer no personagem
     * @return String[] contendo as alterações desejadas pelo usuário
     */
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

    /**
     * Pergunta qual a profissão do personagem
     * @return Enum Profissões referente à profissão escolhida
     */

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

    /**
     * Pergunta qual a raça do personagem
     * @return Enum Racas referente à raça escolhida
     */
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
