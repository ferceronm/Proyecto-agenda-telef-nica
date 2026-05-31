import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook agenda = new AddressBook("contactos.csv");

        // Cargar contactos al iniciar
        agenda.load();

        boolean running = true;

        while (running) {
            System.out.println("\n===== AGENDA TELEFÓNICA =====");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar cambios");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    agenda.list();
                    break;

                case "2":
                    System.out.print("Ingrese el nombre del contacto: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Ingrese el número telefónico: ");
                    String number = scanner.nextLine().trim();

                    if (name.isEmpty() || number.isEmpty()) {
                        System.out.println("El nombre y el número no pueden estar vacíos.");
                    } else {
                        agenda.create(number, name);
                    }
                    break;

                case "3":
                    System.out.print("Ingrese el número telefónico a eliminar: ");
                    String deleteNumber = scanner.nextLine().trim();

                    if (deleteNumber.isEmpty()) {
                        System.out.println("El número no puede estar vacío.");
                    } else {
                        agenda.delete(deleteNumber);
                    }
                    break;

                case "4":
                    agenda.save();
                    break;

                case "5":
                    agenda.save();
                    System.out.println("¡Hasta luego!");
                    running = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
