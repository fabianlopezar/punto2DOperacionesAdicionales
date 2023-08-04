/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author santiago.londono_men
 */
package modelo;

import java.io.*;
import java.util.LinkedList;


public class Utilidades {


    public static boolean escribirCoordenadas(LinkedList<Punto2D> coordenadas, String rutaArchivo) {
        boolean t=false;
        try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Punto2D punto : coordenadas) {
                escritor.println(punto.toString());
                
            }
            t=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return t;
    }

  
    public static LinkedList<Punto2D> leerCoordenadas(String rutaArchivo) {
        LinkedList<Punto2D> listap= new LinkedList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    double x = Double.parseDouble(partes[0]);
                    double y = Double.parseDouble(partes[1]);
                    listap.add(new Punto2D(x, y));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return listap;
    }
}
