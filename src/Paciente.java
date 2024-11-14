import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id;
    private String nombre;
    private List<Sesion> sesiones; // Registro de las sesiones

    public Paciente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.sesiones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void agregarSesion(Sesion sesion) {
        sesiones.add(sesion);
    }

    public void mostrarProgreso() {
        for (Sesion sesion : sesiones) {
            System.out.println("Fecha: " + sesion.getFecha() + " - Progreso: " + sesion.getProgreso());
        }
    }
}

