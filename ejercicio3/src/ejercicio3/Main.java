package ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Casa
 */

public class Main {

    /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado=new Scanner(System.in);
        Agenda agenda = new Agenda();
        
        System.out.println("Por favor, ingrese la opción deseada para operar:");
        System.out.println("1) Agregar contacto");
        System.out.println("2) Verificar contacto existente");
        System.out.println("3) Listar contactos");
        System.out.println("4) Mostrar info de contacto");
        System.out.println("5) Mostrar info por telefono");
        System.out.println("6) Eliminar contacto");
        System.out.println("7) Guardar contactos");
        System.out.println("8) Cargar contactos");
        System.out.println("0tro) Finalizar");

        int opcion = teclado.nextInt();  
        
        while(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5 || opcion == 6 || opcion == 7 || opcion == 8)
        {
            switch (opcion) {
                case 1:  
                         System.out.println("Agregando contacto...");
                         System.out.println("Ingrese un nombre");
                         String nombre = teclado.next();
                         System.out.println("Ingrese un telefono");
                         String telefono = teclado.next();
                         System.out.println("Ingrese un email");
                         String email = teclado.next();

                         Contacto contactoNuevo = new Contacto(nombre, telefono, email);

                         if(agenda.agregarContacto(contactoNuevo)){
                            System.out.println("ERROR: Este contacto ya existe.");   
                         }                     
                         break;
                case 2:  
                         System.out.println("Verificando si el contacto existe...");
                         System.out.println("Ingrese un nombre");
                         nombre = teclado.next();
                         contactoNuevo = new Contacto(nombre, "", "");
                         agenda.existeContacto(contactoNuevo);
                         break;
                case 3:  
                         System.out.println("Listando todos los contactos...");
                         agenda.listarContactos();
                         break;
                case 4:  
                         System.out.println("Mostrando info de contacto...");
                         System.out.println("Ingrese un nombre");
                         nombre = teclado.next();
                         System.out.println(agenda.buscaContacto(nombre));
                         break;
                case 5:  
                         System.out.println("Mostrando info por telefono...");
                         System.out.println("Ingrese un telefono");
                         telefono = teclado.next();
                         agenda.buscaContactoPorTelefono(telefono).listarContactos();
                         break;
                case 6:  
                         System.out.println("Eliminando contacto...");
                         System.out.println("Ingrese un nombre");
                         nombre = teclado.next();
                         agenda.eliminarContacto(nombre);                            
                         break;
                case 7:  
                         System.out.println("Guardando contactos...");
                         agenda.guardarContactos();
                         System.out.println("Contactos guardados!");
                         break;
                case 8:  
                         System.out.println("Cargando contactos...");
                         System.out.println("Ingrese el nombre del archivo que quiera cargar");
                         String archivo = teclado.next();
                         agenda.cargarContactos(archivo);
                         System.out.println("Contactos cargados!");
                         break;
                default: 
                         break;
            }
            
            System.out.println("Por favor, ingrese la opción deseada para operar:");
            System.out.println("1) Agregar contacto");
            System.out.println("2) Verificar contacto existente");
            System.out.println("3) Listar contactos");
            System.out.println("4) Mostrar info de contacto");
            System.out.println("5) Mostrar info de telefono");
            System.out.println("6) Eliminar contacto");
            System.out.println("7) Guardar contactos");
            System.out.println("8) Cargar contactos");
            System.out.println("0tro) Finalizar");

            opcion = teclado.nextInt();  
            }
    }
    
}
