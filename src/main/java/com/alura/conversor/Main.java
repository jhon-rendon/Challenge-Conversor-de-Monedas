package com.alura.conversor;

import com.alura.conversor.service.CurrencyService;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CurrencyService service = new CurrencyService();
        boolean continuar = true;

        while (continuar) {
            System.out.println("===============================");
            System.out.println("    CONVERSOR DE MONEDAS ");
            System.out.println("===============================");
            System.out.println("Seleccione una opción:");
            System.out.println("1) USD → COP");
            System.out.println("2) COP → USD");
            System.out.println("3) USD → EUR");
            System.out.println("4) EUR → USD");
            System.out.println("5) USD → BRL");
            System.out.println("6) Salir");
            System.out.print("Opción: ");

            int opcion = sc.nextInt();
            if (opcion == 6) {
                continuar = false;
                System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                break;
            }

            System.out.print("Ingrese el monto: ");
            double monto = sc.nextDouble();

            String from = "";
            String to = "";

            switch (opcion) {
                case 1 -> { from = "USD"; to = "COP"; }
                case 2 -> { from = "COP"; to = "USD"; }
                case 3 -> { from = "USD"; to = "EUR"; }
                case 4 -> { from = "EUR"; to = "USD"; }
                case 5 -> { from = "USD"; to = "BRL"; }
                default -> {
                    System.out.println("Opción inválida. Intente nuevamente.");
                    continue;
                }
            }

            try {
                double resultado = service.convert(from, to, monto);
                System.out.printf("%.2f %s equivalen a %.2f %s%n", monto, from, resultado, to);
            } catch (IOException  e) {
                System.out.println("Error al consultar la API: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        sc.close();
    }
}
