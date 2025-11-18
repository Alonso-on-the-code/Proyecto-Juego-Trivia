package trivia.models;

public class PlanPremium {
    private String usuario;
    private double precio;
    private String fechaInicio; // ISO yyyy-MM-dd
    private int diasVigencia; // por ejemplo 30, 365

    public PlanPremium(String usuario, double precio, String fechaInicio, int diasVigencia) {
        this.usuario = usuario;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.diasVigencia = diasVigencia;
    }

    // getters y setters
    public String getUsuario() { return usuario; }
    public double getPrecio() { return precio; }
    public String getFechaInicio() { return fechaInicio; }
    public int getDiasVigencia() { return diasVigencia; }

    @Override
    public String toString(){
        return usuario + ";" + precio + ";" + fechaInicio + ";" + diasVigencia;
    }

    public static PlanPremium fromCSV(String line){
        String[] p = line.split(";");
        return new PlanPremium(p[0], Double.parseDouble(p[1]), p[2], Integer.parseInt(p[3]));
    }
}


