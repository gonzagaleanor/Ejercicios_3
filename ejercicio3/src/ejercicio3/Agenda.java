/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Casa
 */
public class Agenda {
    private ArrayList<Contacto> agenda;
    
    public Agenda(){
        this.agenda = new ArrayList<>();
    }
    
    public boolean agregarContacto(Contacto contactoNuevo){
        boolean flag = this.existeContacto(contactoNuevo);
        if(!flag){
            agenda.add(contactoNuevo);
        }
        return flag;
    }
    
    public boolean existeContacto(Contacto contacto){
        boolean duplicado_flag = false;
        
        for(int indice = 0;indice<this.agenda.size();indice++)
        {
            if(this.agenda.get(indice).getNombre().equals(contacto.getNombre())){
                duplicado_flag=true;
            }
        }
        
        return duplicado_flag;
    }
    
    public void listarContactos(){
        for(int indice = 0;indice<this.agenda.size();indice++)
        {
            System.out.println("(Nombre: "+this.agenda.get(indice).getNombre()+"; Telefono: "+this.agenda.get(indice).getTelefono()+"; Email: "+this.agenda.get(indice).getEmail()+")");
        }
    }
    
    public String buscaContacto(String nombre){
        for(int indice = 0;indice<this.agenda.size();indice++)
        {
            if(this.agenda.get(indice).getNombre().equals(nombre)){
                return this.agenda.get(indice).getTelefono();
            }
        }
        return "";
    }
    
    public Agenda buscaContactoPorTelefono(String telefono){
        Agenda resultados = new Agenda();
        for(int indice = 0;indice<this.agenda.size();indice++)
        {
            if(this.agenda.get(indice).getTelefono().toLowerCase().contains(telefono.toLowerCase())){
                resultados.agregarContacto(this.agenda.get(indice));
            }
        }
        return resultados;
    }
    
    public boolean eliminarContacto (String nombre){
        boolean duplicado_flag = false;
        
        for(int indice = 0;indice<this.agenda.size();indice++)
        {
            if(this.agenda.get(indice).getNombre().equals(nombre)){
                this.agenda.remove(indice);
                System.out.println("El elemento fue removido!");
                duplicado_flag=true;
                return duplicado_flag;
            }
        }
        System.out.println("El elemento NO fue removido!");
        return duplicado_flag;
    }
    
    public void guardarContactos(){
        
        String fileName = "Contactos.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                for(int indice = 0;indice<this.agenda.size();indice++)
                {
                    bufferedWriter.write(this.agenda.get(indice).getNombre()+";"+this.agenda.get(indice).getTelefono()+";"+this.agenda.get(indice).getEmail());
                }
            }
        }
        catch(IOException ex) {
            System.out.println(
                "Error escribiendo el archivo '"
                + fileName + "'");
        }
        
    }
    
    public void cargarContactos(String archivo){

        String fileName = archivo;
        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);

            try (
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] infoContacto = line.split(";");
                    Contacto contactoNuevo = new Contacto(infoContacto[0],infoContacto[1],infoContacto[2]);
                    this.agregarContacto(contactoNuevo);
                }
                fileReader.close();
            }         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "No se pudo abrir el archivo '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error leyendo el archivo '" 
                + fileName + "'");    
        }
    }
    
}
