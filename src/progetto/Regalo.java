package progetto;

public class Regalo {
    private String nomeRegalo;
    private double costoRegalo;
    private TipoRegalo tipoRegalo;
    //Costruttore
    public Regalo(String nomeRegalo, double costoRegalo, TipoRegalo tipoRegalo) {
        this.nomeRegalo = nomeRegalo;
        this.costoRegalo = costoRegalo;
        this.tipoRegalo = tipoRegalo;
    }
    //Metodi getter e setter
    public String getNomeRegalo() {return nomeRegalo;}
    public void setNomeRegalo(String nomeRegalo) {
        this.nomeRegalo = nomeRegalo;
    }
    public double getCostoRegalo(){
        return costoRegalo;
    }
    public void setCostoRegalo(double costoRegalo){this.costoRegalo = costoRegalo;}
    //metodo setter per tipoRegalo?

}
