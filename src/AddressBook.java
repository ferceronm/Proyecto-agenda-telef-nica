import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    private HashMap<String, String> contacts;
    private String filePath;

    public AddressBook(String filePath) {
        this.contacts = new HashMap<>();
        this.filePath = filePath;
    }

    /**
     * Carga los contactos desde el archivo CSV.
     */
    public void load() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                int commaIndex = line.indexOf(',');
                if (commaIndex > 0 && commaIndex < line.length() - 1) {
                    String number = line.substring(0, commaIndex).trim();
                    String name = line.substring(commaIndex + 1).trim();
                    contacts.put(number, name);
                }
            }
            System.out.println("Contactos cargados: " + contacts.size());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Guarda los contactos en el archivo CSV.
     */
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
            System.out.println("Cambios guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los contactos de la agenda.
     */
    public void list() {
        if (contacts.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        System.out.println("\nContactos:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * Crea un nuevo contacto.
     */
    public void create(String number, String name) {
        if (contacts.containsKey(number)) {
            System.out.println("Ya existe un contacto con ese número. Se actualizará el nombre.");
        }
        contacts.put(number, name);
        System.out.println("Contacto agregado: " + number + " : " + name);
    }

    /**
     * Elimina un contacto por su número telefónico.
     */
    public void delete(String number) {
        if (contacts.containsKey(number)) {
            String name = contacts.remove(number);
            System.out.println("Contacto eliminado: " + number + " : " + name);
        } else {
            System.out.println("No se encontró un contacto con el número: " + number);
        }
    }
}
