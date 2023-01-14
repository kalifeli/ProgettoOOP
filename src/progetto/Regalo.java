package progetto;

public class Regalo {
    private final String nomeRegalo;
    private final double costoRegalo;
    private final String tipoRegalo;
    //Costruttore
    public Regalo(String nomeRegalo, double costoRegalo, String tipoRegalo) {
        this.nomeRegalo = nomeRegalo;
        this.costoRegalo = costoRegalo;
        this.tipoRegalo = tipoRegalo;
    }
    //Metodi getter e setter
    public String getNomeRegalo() {return nomeRegalo;}
    public double getCostoRegalo(){
        return costoRegalo;
    }

    public String getTipoRegalo() {
        return tipoRegalo;
    }
}
