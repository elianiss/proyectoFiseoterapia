import java.util.Date;

public class Sesion {
    private Date fecha;
    private String progreso; // Puede ser texto descriptivo o un puntaje

    public Sesion(Date fecha, String progreso) {
        this.fecha = fecha;
        this.progreso = progreso;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getProgreso() {
        return progreso;
    }
}

