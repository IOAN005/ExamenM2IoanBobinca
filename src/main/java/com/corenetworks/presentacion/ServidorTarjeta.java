package com.corenetworks.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorTarjeta {
    public static void main(String[] args) {
        String[] respuestas = {"2024/01/16", "1234567890123456", "2033/08/30", "388", "500"};
        BufferedReader mensajeEntrada = null;
        PrintWriter mensajeSalida = null;

        try (ServerSocket servidor = new ServerSocket(3000);) {
            while (true) {
                System.out.println("Esperando peticiones ->");
                Socket s1 = servidor.accept();
                mensajeEntrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                String solicitud = mensajeEntrada.readLine();
                Random numeroAleatorio=new Random();
                int numero=numeroAleatorio.nextInt(5);
                System.out.println("El numero aleatorio es ->"+numeroAleatorio);

                switch (solicitud){
                    case "1":
                        System.out.println("solicitar la fecha transaction");
                        break;
                    case "2":
                        System.out.println("Solicitar nuero de tarjeta");
                        break;
                    case "3":
                        System.out.println("Solicitar fecha vencimiento");
                        break;
                    case "4" :
                        System.out.println("solicitar CCV");
                        break;
                    case "5" :
                        System.out.println("Solicitar la cantidad");

                }

                int indice = Integer.parseInt(solicitud);
                mensajeSalida = new PrintWriter(s1.getOutputStream(), true);
                mensajeSalida.println(respuestas[indice - 1]);





            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    }