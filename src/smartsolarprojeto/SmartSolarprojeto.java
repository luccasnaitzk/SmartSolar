package smartsolarprojeto;

import java.util.Scanner;

public class SmartSolarprojeto {

    public static void main(String[] args) {

        SistemaMonitoramento SistemMoni = new SistemaMonitoramento();
        Scanner ler = new Scanner(System.in);
        int opcaoMenu1 = -1;

        while (opcaoMenu1 != 3) {
            SistemMoni.exibirMenuInicial();
            opcaoMenu1 = ler.nextInt();
            ler.nextLine();

            if (opcaoMenu1 == 1) {
                System.out.println("\n╔════════════════════════════════════╗");
                System.out.println("║        CADASTRO DE CLIENTE           ║");
                System.out.println("╚══════════════════════════════════════╝");
                System.out.println("Insira o Id: ");
                int id = ler.nextInt();
                ler.nextLine();
                System.out.println("Insira o nome: ");
                String nome = ler.nextLine();
                System.out.println("Insira a senha: ");
                String senha = ler.nextLine();
                SistemMoni.cadastrarCliente(id, nome, senha);
                System.out.println("Cliente cadastrado com sucesso!\n");


            } else if (opcaoMenu1 == 2) {
                System.out.println("\n╔════════════════════════════════════╗");
                System.out.println("║              LOGIN                   ║");
                System.out.println("╚══════════════════════════════════════╝");
                System.out.println("Insira o Id: ");
                int idL = ler.nextInt();
                ler.nextLine();
                System.out.println("Insira a senha: ");
                String senhaL = ler.nextLine();

                if (SistemMoni.realizarLogin(idL, senhaL)) {
                    int opcaoMenu2 = -1;
                    while (opcaoMenu2 != 4) {
                        SistemMoni.exibirMenuOpcoes();
                        opcaoMenu2 = ler.nextInt();
                        ler.nextLine();

                        if (opcaoMenu2 == 1) {
                            int opcaoCadas = -1;
                            while (opcaoCadas != 3) {
                                SistemMoni.exibirOpcoesCadastro();
                                opcaoCadas = ler.nextInt();
                                ler.nextLine();

                                if (opcaoCadas == 1) {
                                    System.out.println("\n╔════════════════════════════════════╗");
                                    System.out.println("║       CADASTRO DE PLACA SOLAR        ║");
                                    System.out.println("╚══════════════════════════════════════╝");

                                    System.out.println("Insira o id da placa: ");
                                    int id = ler.nextInt();
                                    System.out.println("Insira a potencia da placa: ");
                                    double potencia = ler.nextDouble();
                                    ler.nextLine();
                                    SistemMoni.cadastrarPlacaSolar(id, potencia);
                                    System.out.println("Placa cadastrada com sucesso!\n");



                                } else if (opcaoCadas == 2) {
                                     System.out.println("\n╔══════════════════════════════════╗");
                                    System.out.println("║         CADASTRO DE MORADIA         ║");
                                    System.out.println("╚═════════════════════════════════════╝");
                                    System.out.println("Insira o Id da Moradia: ");
                                    int id = ler.nextInt();
                                    ler.nextLine();
                                    System.out.println("Insira o Endereço da Moradia: ");
                                    String end = ler.nextLine();
                                    System.out.println("Insira o Consumo da Moradia: ");
                                    double consumo = ler.nextDouble();
                                    ler.nextLine();
                                    SistemMoni.cadastrarMoradia(id, end, consumo);
                                    System.out.println("Moradia cadastrada com sucesso!\n");

                                }
                            }

                        } else if (opcaoMenu2 == 2) {
                            int opcaoLista = -1;
                            while (opcaoLista != 3) {
                                SistemMoni.exibirOpcoesLista();
                                opcaoLista = ler.nextInt();
                                ler.nextLine();

                                if (opcaoLista == 1) {
                                    SistemMoni.listarPlacasCadastradas();
                                } else if (opcaoLista == 2) {
                                    SistemMoni.listarMoradiasCadastradas();
                                }
                            }

                        } else if (opcaoMenu2 == 3) {
                            int opcaoMenu3 = -1;
                            while (opcaoMenu3 != 3) {
                                SistemMoni.exibirMenuOpcoes2();
                                opcaoMenu3 = ler.nextInt();
                                ler.nextLine();

                                if (opcaoMenu3 == 1) {
                                    System.out.println("\n╔═══════════════════════════════════╗");
                                    System.out.println("║     VINCULAR PLACA À MORADIA        ║");
                                    System.out.println("╚════════════════════════════════ ════╝");
                                    System.out.println("Insira o Id da Placa: ");
                                    int idPlaca = ler.nextInt();
                                    System.out.println("Insira o Id da Moradia: ");
                                    int idMoradia = ler.nextInt();
                                    ler.nextLine();

                                    SistemMoni.instalarPlaca(idPlaca, idMoradia); // Método presumido
                                } else if (opcaoMenu3 == 2) {
                                    SistemMoni.gerarRelatorioConsumoMoradias();
                                }
                            }
                        }
                    }

                } else {
                    System.out.println("╔════════════════════════════╗");
                    System.out.println("║   ID ou senha incorretos!  ║");
                    System.out.println("╚════════════════════════════╝\n");
                }
            }
        }

        ler.close();
    }
}
