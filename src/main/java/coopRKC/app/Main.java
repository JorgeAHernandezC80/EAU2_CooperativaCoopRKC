package coopRKC.app;

import coopRKC.modelo.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cooperativa coop = new Cooperativa();

        int numSocios;
        while (true) {
            System.out.print("¿Cuántos socios desea registrar en el sistema?: ");
            try {
                numSocios = scanner.nextInt();
                if (numSocios <= 0) {
                    System.out.println("Debe registrar al menos 1 socio.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Ingrese un número válido.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        for (int i = 0; i < numSocios; i++) {
            System.out.println("\n *** Registro de socio #" + (i + 1) + " ***");
            System.out.print("Nombre del socio: ");
            String nombre = scanner.nextLine();

            String cedula;
            do {
                System.out.print("Cédula del socio: ");
                cedula = scanner.nextLine();
                if (coop.validarCedulaUnica(cedula)) {
                    System.out.println("Ya existe un socio con este numero de cédula.");
                }
            } while (coop.validarCedulaUnica(cedula));

            Socio socio = new Socio(nombre, cedula);
            coop.registrarSocio(socio);

            int numCuentas;
            while (true) {
                System.out.print("¿Cuántas cuentas de ahorro desea abrir para " + nombre + "?: ");
                try {
                    numCuentas = scanner.nextInt();
                    if (numCuentas <= 0) {
                        System.out.println("Debe abrir al menos 1 cuenta.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Ingrese un número válido.");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();

            for (int j = 0; j < numCuentas; j++) {
                System.out.println("Cuenta #" + (j + 1));
                String numeroCuenta;
                do {
                    System.out.print("Número de cuenta: ");
                    numeroCuenta = scanner.nextLine();
                    if (coop.validarNumeroCuentaUnico(numeroCuenta)) {
                        System.out.println("El número de cuenta ya existe. Intente otro.");
                    }
                } while (coop.validarNumeroCuentaUnico(numeroCuenta));

                double interes;
                while (true) {
                    System.out.print("Tasa de interés (Ejemplo: 0.02 => 2%): ");
                    try {
                        interes = scanner.nextDouble();
                        if (interes < 0) {
                            System.out.println("La tasa de interés no puede ser negativa.");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Entrada inválida. Favor ingresar un número (ej. 0.02).");
                        scanner.nextLine();
                    }
                }
                scanner.nextLine();

                double deposito;
                while (true) {
                    System.out.print("Depósito inicial: $");
                    try {
                        deposito = scanner.nextDouble();
                        if (deposito < 0) {
                            System.out.println("El depósito no puede ser negativo.");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Favor ingresar un monto válido (ej. 100000).");
                        scanner.nextLine();
                    }
                }
                scanner.nextLine();

                CuentaAhorros cuenta = new CuentaAhorros(numeroCuenta, interes);
                cuenta.depositarDinero(deposito);
                socio.addCuenta(cuenta);
            }
        }

        // Programación funcional
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Resultado de la Programación Funcional:");
        System.out.println("=".repeat(50));

        // Lista de los nombres de los socios
        System.out.println("\n1. Nombres de todos los socios:");
        coop.listarSocios()
                .stream()
                .map(Socio::getNombre)
                .forEach(System.out::println);

        // Cuentas con saldo > $500,000
        System.out.println("\n2. Cuentas con saldo mayor a $500,000:");
        coop.listarSocios().stream()
                .flatMap(socio -> socio.getCuentas().stream())
                .filter(cuenta -> cuenta.getSaldo() > 500000)
                .forEach(cuenta ->
                        System.out.println("   Cuenta: " + cuenta.getNumeroCuenta() +
                                " - Saldo: " + cuenta.getSaldo()));

        // Total del dinero en la cooperativa
        double total = coop.listarSocios().stream()
                .flatMap(socio -> socio.getCuentas().stream())
                .mapToDouble(Cuenta::getSaldo)
                .reduce(0.0, Double::sum);
        System.out.println("\n3. Total del dinero en la cooperativa: $" + total);

        scanner.close();
    }
}