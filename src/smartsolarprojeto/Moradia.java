package smartsolarprojeto;

import java.util.ArrayList;

public class Moradia {
    private int id;
    private String endereco;
    private double consumoEnergia;
    private ArrayList<PlacaSolar> listaPlaca;
    private double energiaGerada;
    private double ConsumoExterno;

    public Moradia(int idL, String enderecoL, double consumoL){
        this.id = idL;
        this.endereco = enderecoL;
        this.consumoEnergia = consumoL;
        this.listaPlaca = new ArrayList<>();
        this.energiaGerada = 0;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(double consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public ArrayList<PlacaSolar> getListaPlaca() {
        return listaPlaca;
    }

    public double getEnergiaGerada() {
        return energiaGerada;
    }
    
     public double getConsumoExterno() {
        return ConsumoExterno;
    }

    public void setConsumoExterno(double ConsumoExterno) {
        this.ConsumoExterno = ConsumoExterno;
    }

    public void adicionarPlaca(PlacaSolar placa){
        this.listaPlaca.add(placa);
    }

    public void calcularEnergiaGerada(){
        this.energiaGerada = 0;
        for (PlacaSolar placa : this.listaPlaca){
            this.energiaGerada += placa.GerarPotencia();
        }
    }

    public void calcularConsuExterno(){
        this.ConsumoExterno = 0;    
      this.ConsumoExterno = this.consumoEnergia - this.energiaGerada;
    }
    
    public boolean verificarConsumo(){
        return this.energiaGerada >= this.consumoEnergia;
    }
}
