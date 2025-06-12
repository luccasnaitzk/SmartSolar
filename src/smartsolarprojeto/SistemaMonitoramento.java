package smartsolarprojeto;

import java.util.ArrayList;

public class SistemaMonitoramento {
    private ArrayList<Cliente> listaClientesCadastrados;
    private ArrayList<PlacaSolar> listaPlacasCadastrados;
    private ArrayList<Moradia> listaMoradiasCadastradas;
    
    public SistemaMonitoramento(){
        this.listaClientesCadastrados = new ArrayList<Cliente>();
        this.listaPlacasCadastrados = new ArrayList<PlacaSolar>();
        this.listaMoradiasCadastradas = new ArrayList<Moradia>();
    }

    public void cadastrarPlacaSolar(int id, double potencia){
        PlacaSolar placa = new PlacaSolar(id, (int) potencia);
        this.listaPlacasCadastrados.add(placa);
    }
    
    public void listarPlacasCadastradas(){
        System.out.println("\n╔═════════════════════════════════════════╗");
        System.out.println("║         LISTA DE PLACAS CADASTRADAS       ║");
        System.out.println("╚═══════════════════════════════════════════╝");

        if (listaPlacasCadastrados.isEmpty()) {
            System.out.println("Nenhuma placa cadastrada.\n");

        }else{
            for(PlacaSolar placa : this.listaPlacasCadastrados) {
                System.out.println("Id: "+ placa.getId() + " - Potência: "+ placa.GerarPotencia() + "kW/n");
        }
            System.out.println("───────────────────────────────────────────\n");
    }
}
    
    public void cadastrarMoradia(int id, String endereco, double consumo){
        Moradia morada = new Moradia(id, endereco, consumo);
        this.listaMoradiasCadastradas.add(morada);
    }

    public void listarMoradiasCadastradas(){
        System.out.println("\n╔═════════════════════════════════════════╗");
        System.out.println("║       LISTA DE MORADIAS CADASTRADAS       ║");
        System.out.println("╚═══════════════════════════════════════════╝"); 

        if (listaMoradiasCadastradas.isEmpty()) {
            System.out.println("Nenhuma moradia cadastrada.\n");
        } else {
               for(Moradia morada : this.listaMoradiasCadastradas){
                    System.out.println("Id: "+ morada.getId() + " - Endereço: " + morada.getEndereco());
        }
            System.out.println("───────────────────────────────────────────\n");
    }
}

    public void cadastrarCliente(int id, String nome, String senha){
        Cliente client = new Cliente(id, nome, senha);
        this.listaClientesCadastrados.add(client);
    }

    public PlacaSolar buscarPlaca(int id){
        for(PlacaSolar p : this.listaPlacasCadastrados){
            if(p.getId() == id){
                return p;
            } 
        }
        return null;
    }

    
    public Moradia buscarMoradia(int id){
        for(Moradia m : this.listaMoradiasCadastradas){
            if(m.getId() == id){
                return m;
            } 
        }
        return null;
    }

     public double mostrarConsuExt(){
        double valor = 0;
         for(Moradia mo : this.listaMoradiasCadastradas){
         mo.calcularConsuExterno();
         valor = mo.getConsumoExterno();
        }
        return valor;
    }
    
    public void instalarPlaca(int idPlaca, int idMoradia){
        PlacaSolar placa = this.buscarPlaca(idPlaca);
        Moradia moradia = this.buscarMoradia(idMoradia);

        if(placa == null && moradia == null){
            System.out.println("Painel e Residência não cadastrados!");
        } else if(placa == null){
            System.out.println("Painel não cadastrado!");
        } else if(moradia == null){
            System.out.println("Residência não cadastrada!");
        } else{
            moradia.adicionarPlaca(placa); // método suposto da classe Moradia
            System.out.println("Painel instalado com sucesso!");
        }
    }   
    
    public void gerarRelatorioConsumoMoradias(){
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║     RELATÓRIO DE CONSUMO DAS MORADIAS     ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        if (listaMoradiasCadastradas.isEmpty()) {
            System.out.println("Nenhuma moradia cadastrada para gerar relatório.\n");
            return;
        }

        for(Moradia m : this.listaMoradiasCadastradas){
            m.calcularEnergiaGerada(); 
            boolean geracaoSuficiente = m.verificarConsumo();
            if(geracaoSuficiente){
                System.out.println("Moradia: " + m.getId() + " - Geração de energia suficiente para o Consumo!");
            } else {
                System.out.println("Moradia: " + m.getId() + " - Alerta! Geração de energia insuficiente!");
                System.out.println("Foi necessário o consumo de: "+ this.mostrarConsuExt() +" de energia externa");
             } 
             System.out.println("-------------------------------------------");
            }

    }
    
    public Cliente buscarCliente(int id){
        for(Cliente c : this.listaClientesCadastrados){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public boolean realizarLogin(int id, String senha){
        Cliente client = this.buscarCliente(id);

        if(client != null && client.getSenha().equals(senha)){
            System.out.println("Logado com sucesso!");
            System.out.println("Bem-vindo(a), " + client.getNome() + "!/n");
            return true;
        }
        return false;
    }
    
    public void exibirMenuInicial() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE MONITORAMENTO SOLAR - INÍCIO  ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1 - Cadastrar Cliente                       ║");
        System.out.println("║  2 - Realizar Login                          ║");
        System.out.println("║  3 - Sair                                    ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
    
    public void exibirMenuOpcoes() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║        MENU PRINCIPAL - OPÇÕES DO SISTEMA    ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1 - Cadastro                                ║");
        System.out.println("║  2 - Lista                                   ║");
        System.out.println("║  3 - Opções Avançadas                        ║");
        System.out.println("║  4 - Sair                                    ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
    
    public void exibirOpcoesCadastro() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║               MENU DE CADASTROS              ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1 - Cadastrar Placa Solar                   ║");
        System.out.println("║  2 - Cadastrar Moradia                       ║");
        System.out.println("║  3 - Voltar                                  ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
    
    public void exibirOpcoesLista() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║               LISTAGEM DE DADOS              ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1 - Listar Placas Solares                   ║");
        System.out.println("║  2 - Listar Moradias                         ║");
        System.out.println("║  3 - Voltar                                  ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
    
    

    public void exibirMenuOpcoes2() {
        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║           SISTEMA DE MONITORAMENTO          ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║ 1 - Vincular Placa à Moradia                ║");
        System.out.println("║ 2 - Gerar Relatório de Consumo de residência║");
        System.out.println("║ 3 - Voltar                                  ║");
        System.out.println("╚═════════════════════════════════════════════╝");
    }
    
}
