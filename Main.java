 //Josselin Nayeli Lanza Ramos 202110020022

package empleados;

        
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Empleado {
    private final String nombre;
    private int edad;
    private final double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void imprimirDetalles() {
        System.out.println("Nombre: " + nombre +
                           ", Edad: " + edad +
                           ", Salario: $" + salario);
    }
}

class GestorEmpleados {
    private final List<Empleado> listaEmpleados;

    public GestorEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public void mostrarDetallesEmpleados() {
        for (Empleado empleado : listaEmpleados) {
            empleado.imprimirDetalles();
        }
    }

    public void buscarEmpleadoPorNombre(String nombre) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNombre().equals(nombre)) {
                empleado.imprimirDetalles();
                return;
            }
        }
        System.out.println("No se encontro un empleado con ese nombre.");
    }

    public void eliminarEmpleadoPorNombre(String nombre) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNombre().equals(nombre)) {
                listaEmpleados.remove(empleado);
                System.out.println("Empleado eliminado.");
                return;
            }
        }
        System.out.println("No se encontro un empleado con ese nombre.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados(); 


        while (true) {
            System.out.println("--------Opciones:---------");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar detalles de empleados");
            System.out.println("3. Buscar empleado por nombre");
            System.out.println("4. Eliminar empleado por nombre");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese nombre del empleado: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese edad del empleado: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese salario del empleado: ");
                    double salario = scanner.nextDouble();
                    Empleado empleado = new Empleado(nombre, edad, salario);
                    gestor.agregarEmpleado(empleado);
                }
                case 2 -> gestor.mostrarDetallesEmpleados();
                case 3 -> {
                    System.out.print("Ingrese nombre del empleado a buscar: ");
                    String nombreBuscar = scanner.next();
                    gestor.buscarEmpleadoPorNombre(nombreBuscar);
                }
                case 4 -> {
                    System.out.print("Ingrese nombre del empleado a eliminar: ");
                    String nombreEliminar = scanner.next();
                    gestor.eliminarEmpleadoPorNombre(nombreEliminar);
                }
                case 5 -> {
                    System.out.println("----*Adios*----");
                           
                    return;
                }
                default -> System.out.println("Opción invalida. Intente de nuevo.");
            }
        }
    }
}
