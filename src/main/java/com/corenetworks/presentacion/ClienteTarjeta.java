package com.corenetworks.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTarjeta {
    public static void main(String[] args) {
        String solicitudAutorizacion = monstrarMenu();
        try (Socket cliente = new Socket("localhost", 3000);) {
            PrintWriter mensajeEnviar = new PrintWriter(cliente.getOutputStream(), true);

            mensajeEnviar.println(solicitudAutorizacion);
            System.out.println("esperando respuesta del servidor ...");

            //Esperamos la respuesta del servidor

            BufferedReader mensajeRecibido = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println(mensajeRecibido.readLine());

        } catch (UnknownHostException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static String monstrarMenu() {
        String[] solicitudes = {"Fecha de Transaction",
                "Numero de tarjeta ",
                "Fecha de Vencimiento", "Digitos adicionale CVV",
                "Cantidad"};
        int numSolicitud = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%s %n", "-".repeat(50));
        System.out.printf("%-20s %n", "MENU DE OPCIONES");
        System.out.printf("%s %n", "-".repeat(50));
        for (int i = 0; i < solicitudes.length; i++) {
            System.out.printf("%d %s %n", i + 1, solicitudes[i]);
            //Recibir la respuesta del usuario
            while (true) {
                System.out.println("Opcion seleccionada ->");
                numSolicitud = teclado.nextInt();
                if (numSolicitud >= 1 && numSolicitud <= solicitudes.length) {
                    break;
                }
            }


        }
        return Integer.toString(numSolicitud);
    }
}