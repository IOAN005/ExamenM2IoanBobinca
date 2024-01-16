package com.corenetworks;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //Ejercicio 1.
        File fichero =new File("examen.txt");
        System.out.println("Nombre del archivo  ->"+ fichero.getName());
        System.out.println("Ruta absoluta -> "+fichero.getAbsolutePath());
        System.out.println("Es una carpeta ? " +fichero.isDirectory());
        System.out.println("Es  un fichero?  "+fichero.isFile());
        System.out.println("Ultima Modificaciowhatn -> " + fichero.lastModified());
        System.out.println("Existe? " +fichero.exists());
        System.out.println("Puede leer? " +fichero.canRead());
        System.out.println("Fichero absoluto ->" + fichero.getAbsoluteFile());



    }
}