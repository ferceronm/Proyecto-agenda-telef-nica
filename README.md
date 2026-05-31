# Agenda Telefónica (AddressBook)

Aplicación en Java que permite gestionar una agenda de contactos telefónicos. Los contactos se almacenan en un archivo CSV y se manipulan en memoria mediante un `HashMap`.


## Cómo funciona

### AddressBook.java

Es la clase principal de la lógica. Contiene:

- Un `HashMap<String, String>` donde la **llave** es el número telefónico y el **valor** es el nombre del contacto.
- **`load()`** — Lee el archivo `contactos.csv` línea por línea, separa cada línea por coma y carga los datos al HashMap.
- **`save()`** — Recorre el HashMap y escribe cada contacto en el archivo CSV con el formato `número,nombre`.
- **`list()`** — Muestra todos los contactos en consola con el formato `Número : Nombre`.
- **`create(número, nombre)`** — Agrega un nuevo contacto al HashMap.
- **`delete(número)`** — Elimina un contacto del HashMap usando el número como llave.

### Main.java

Presenta un menú interactivo con las siguientes opciones:

```
===== AGENDA TELEFÓNICA =====
1. Listar contactos
2. Crear contacto
3. Eliminar contacto
4. Guardar cambios
5. Salir
```

Al iniciar, el programa carga automáticamente los contactos del archivo CSV. Al salir, guarda los cambios automáticamente.

### Formato del archivo CSV

Cada línea del archivo contiene un contacto con el formato:

```
número,nombre
```

Ejemplo:

```
5512345678,Juan Pérez
5587654321,Ana López
5555512345,Carlos Ruiz
```

### Ejemplo de uso

```
Contactos cargados: 3

===== AGENDA TELEFÓNICA =====
1. Listar contactos
2. Crear contacto
3. Eliminar contacto
4. Guardar cambios
5. Salir
Seleccione una opción: 1

Contactos:
5512345678 : Juan Pérez
5587654321 : Ana López
5555512345 : Carlos Ruiz

===== AGENDA TELEFÓNICA =====
Seleccione una opción: 2
Ingrese el nombre del contacto: María García
Ingrese el número telefónico: 5544332211
Contacto agregado: 5544332211 : María García

===== AGENDA TELEFÓNICA =====
Seleccione una opción: 3
Ingrese el número telefónico a eliminar: 5555512345
Contacto eliminado: 5555512345 : Carlos Ruiz

===== AGENDA TELEFÓNICA =====
Seleccione una opción: 5
Cambios guardados exitosamente.
¡Hasta luego!
```
