import java.util.ArrayList;
import java.util.List;

public class Terapeuta { private int id;
    private String nombre;
    private List<Paciente> pacientes;

    public Terapeuta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.pacientes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void revisarProgresoPaciente(int pacienteId) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == pacienteId) {
                System.out.println("Progreso de " + paciente.getNombre() + ":");
                paciente.mostrarProgreso();
                return;
            }
        }
        System.out.println("Paciente no encontrado.");
    }
}

