package com.corenetworks.presentacion;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {


        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        try {

            System.out.println("Ingresamos el archivo de entrada: ");
            String archivoDestino = buffer.readLine();


            System.out.println("Introducimos un valor numérico entre 1 y 255 -> ");
            int usuario = Integer.parseInt(buffer.readLine());

            if (usuario < 1 || usuario > 255) {
                System.out.println("El valor debe estar entre 1 y 255 ");
                return;
            }


            System.out.println("Ingresamos  el archivo de salida: ");
            String archivoOrigen = buffer.readLine();


            try (FileWriter f1 = new FileWriter(archivoOrigen);
                 PrintWriter p1 = new PrintWriter(f1)) {

                int letra=0;
                while ((letra = buffer.read()) != -1) {

                    int letraCifrada = letra ^ usuario;
                    p1.write(letraCifrada);
                }

            }
        } catch (IOException e) {
            System.out.println(e.toString());

        }
    }

}
