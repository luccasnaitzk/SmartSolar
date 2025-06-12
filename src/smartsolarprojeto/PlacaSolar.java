package smartsolarprojeto;

public class PlacaSolar {

    private int id;
    private double potencia;
    
public PlacaSolar(int idP, int potenciaProdP){
    this.id = idP;
    this.potencia = potenciaProdP;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public double getPotenciaProd() {
        return potencia;
    }

    public double GerarPotencia() {
        return potencia;
    }
  
}
