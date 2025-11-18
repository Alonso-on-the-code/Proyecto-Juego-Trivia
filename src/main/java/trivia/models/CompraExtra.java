package trivia.models;

public class CompraExtra {
    private String usuario;
    private String servicio;
    private double precio;
    private String fecha; // ISO yyyy-MM-dd

    public CompraExtra(String usuario, String servicio, double precio, String fecha) {
        this.usuario = usuario;
        this.servicio = servicio;
        this.precio = precio;
        this.fecha = fecha;
    }

    // getters
    public String getUsuario() { return usuario; }
    public String getServicio() { return servicio; }
    public double getPrecio() { return precio; }
    public String getFecha() { return fecha; }

    @Override
    public String toString(){
        return usuario + ";" + servicio + ";" + precio + ";" + fecha;
    }

    public static CompraExtra fromCSV(String line){
        String[] p = line.split(";");
        return new CompraExtra(p[0], p[1], Double.parseDouble(p[2]), p[3]);
    }
}
