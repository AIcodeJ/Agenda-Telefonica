import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class AddressBook {

    File archivo = new File("Seccion_Amarilla.csv");
    String llave, line;

    public void list(HashMap<String, String> diccionario){
        Iterator<String> iterator = diccionario.keySet().iterator(); // Creo un iterador para poder recorrer el hashmap

        System.out.println("Contactos:\n" + "  Telefono\t|\tNombre   ");
        System.out.println("------------------------");
        while(iterator.hasNext()){  // En un ciclo recorremos el hashmap
             llave = iterator.next(); // Llave es actua como referencia en el key del hashmap
            System.out.println(" " + llave + "\t|\t" + diccionario.get(llave)); // Se muestra en pantalla el contenido del diccionario
        }
    }

    // Metodo de añadir contaacto
    public void create(HashMap<String, String> diccionario, String tel, String nom) {
        if (diccionario.containsKey(tel)){
            System.out.println("\nError!\nNo se puede registrar dos veces el mismo telefono\n"); // Mensaje si el telefono ya existe
        } else {
            diccionario.put(tel, nom);  // Si no existe se crea el contacto
            System.out.println("\nContacto agregado");
        }
    }

    // Metodo de borrar
    public void delete(HashMap<String, String> diccionario, String tel) {
        if (diccionario.containsKey(tel)) {
            System.out.println("\nContacto eliminado: " + diccionario.get(tel)+"\n");
            diccionario.remove(tel); // Se remueven las coincidencias con la info clave si es que se encontro
        } else {
            System.out.println("\nEl Telefono no existe\n");
        }
    }

    // Metodo de cargar datos y crear un archivo csv
    public void load(HashMap<String, String> diccionario) {

        String [] lista; // Array auxiliar
        BufferedReader bufferedReader = null;

        try {

            if (!archivo.exists()){
                archivo.createNewFile();
            }

            bufferedReader = new BufferedReader(new FileReader(archivo));

            while ((line = bufferedReader.readLine()) != null) {
                lista = line.split(","); // Se llena el array con los datos separados por la ","
                diccionario.put(lista[0], lista[1]); // Se llena el diccionario con los datos del array
            }
        } catch(IOException e) {
            System.out.println("Ocurrio un error");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                    System.out.println("\nContactos cargados");
                }
            } catch (IOException e) {
                System.out.println("Ocurrio un error");
            }
        }
    }

    // Metodo de guardar datos en archivo csv
    public void save(HashMap<String, String> diccionario) {

        Iterator<String> iterator = diccionario.keySet().iterator();
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(archivo));

            while(iterator.hasNext()) {
                llave = iterator.next();
                bufferedWriter.write(llave+"," + diccionario.get(llave)+ "\n"); // Se sobreescribe el diccionario en el archivo
            }

        }
        catch(IOException e) {
            System.out.println("Ocurrio un error");
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    System.out.println("\nCambios guardados");
                }
            } catch (IOException e) {
                System.out.println("Ocurrio un error");
            }
        }
    }

}
