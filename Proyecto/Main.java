import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String> diccionario = new HashMap<String, String>(); // Creacion del objeto de tipo hashmap
        AddressBook c = new AddressBook();
        Scanner input = new Scanner(System.in);

        int opcion;
        boolean salir = false;
        String telefono, nombre;
        System.out.println("Bienvenido a la agenda telefonica sección amarilla\n");

        do{
            try{
                System.out.println("\nSeleccione la opción deseada:\n");
                System.out.println("1. ---> Cargar información");
                System.out.println("2. ---> Guardar datos");
                System.out.println("3. ---> Mostrar contactos");
                System.out.println("4. ---> Crear un nuevo contacto");
                System.out.println("5. ---> Eliminar un contacto");
                System.out.println("0. ---> Salir");

                opcion = input.nextInt();
                /// Menu de opciones
                switch(opcion) {
                    case 0:
                        System.out.println("Hasta pronto\n");
                        salir = true;
                        break;
                    case 1:
                        c.load(diccionario); // llamado a metodo cargar datos
                        break;
                    case 2:
                        c.save(diccionario); // llamado a metodo guardar datos
                        break;
                    case 3:
                        c.list(diccionario);  // llamado a mostrar datos de hasmap
                        break;
                    case 4:
                        System.out.println("Inserte el nuevo telefono: ");
                        telefono = input.next();
                        System.out.println("Inserte el nombre del contacto: ");
                        nombre = input.next();
                        c.create(diccionario, telefono, nombre);  // llamado a metodo crear contacto
                        break;
                    case 5:
                        System.out.println("Inserte el telefono a eliminar: ");
                        telefono = input.next();
                        c.delete(diccionario, telefono);  // llamado a metodo de eliminar contacto
                        break;
                    default:
                        System.out.println("\nOpción incorrecta\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebe seleccionar un opción del menú, por favor intentelo otra vez\n");
                input.next();
            }
        }while(!salir);
    }
}
