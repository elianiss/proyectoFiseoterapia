import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FisioterapiaApp {
    private List<Paciente> pacientes;
    private List<Terapeuta> terapeutas;

    public FisioterapiaApp() {
        this.pacientes = new ArrayList<>();
        this.terapeutas = new ArrayList<>();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido a FISIOTERAPIA ONLINE");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar terapeuta");
            System.out.println("3. Agregar sesión a paciente");
            System.out.println("4. Ver progreso de paciente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> registrarPaciente();
                case 2 -> registrarTerapeuta();
                case 3 -> agregarSesion();
                case 4 -> verProgresoPaciente();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
        scanner.close();
    }

    private void registrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID del paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del paciente: ");
        String nombre = scanner.nextLine();
        Paciente paciente = new Paciente(id, nombre);
        pacientes.add(paciente);
        System.out.println("Paciente registrado con éxito.");
    }

    private void registrarTerapeuta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID del terapeuta: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del terapeuta: ");
        String nombre = scanner.nextLine();
        Terapeuta terapeuta = new Terapeuta(id, nombre);
        terapeutas.add(terapeuta);
        System.out.println("Terapeuta registrado con éxito.");
    }

    private void agregarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID del paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = pacientes.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (paciente != null) {
            System.out.print("Ingrese progreso de la sesión: ");
            String progreso = scanner.nextLine();
            Sesion sesion = new Sesion(new Date(), progreso);
            paciente.agregarSesion(sesion);
            System.out.println("Sesión agregada con éxito.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private void verProgresoPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID del paciente: ");
        int id = scanner.nextInt();

        Paciente paciente = pacientes.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (paciente != null) {
            paciente.mostrarProgreso();
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    public static void main(String[] args) {
        FisioterapiaApp app = new FisioterapiaApp();
        app.iniciar();
    }
}

