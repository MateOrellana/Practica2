/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.edd.vista;

import ec.edu.ups.practica.dos.edd.controlador.ControladorTienda;
import java.util.Scanner;

/**
 *
 * @author mateo
 */
public class Tienda {
    private ControladorTienda controlador;
    private Scanner scanner;

    public Tienda(ControladorTienda controlador) {
        this.controlador = controlador;
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Sistema de gestión de tiendas");
        System.out.println("1. Registrar nuevo producto");
        System.out.println("2. Vender producto");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Mostrar historial de ventas");
        System.out.println("5. Salir");
        System.out.print("Ingrese su elección: ");
    }

    public void iniciar() {
        int eleccion;
        do {
            mostrarMenu();
            eleccion = getEleccionUsuario();
            switch (eleccion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    venderProducto();
                    break;
                case 3:
                    mostrarInventario();
                    break;
                case 4:
                    mostrarHistorialDeVentas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Elección no válida. Inténtalo de nuevo.");
            }
            System.out.println();
        } while (eleccion != 5);
    }

    private int getEleccionUsuario() {
        int eleccion = scanner.nextInt();
        scanner.nextLine(); 
        return eleccion;
    }

    private void registrarProducto() {
        System.out.println("Ingrese los detalles del producto:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 

        controlador.registrarProducto(nombre, codigo, precio, cantidad);
        System.out.println("Product registered successfully.");
    }

    private void venderProducto() {
        System.out.println("Ingrese los detalles del producto:");  
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();
        System.out.print("Cantidad: ");
        int cantidadVendida = scanner.nextInt();
        scanner.nextLine();

        controlador.venderProducto(codigo, cantidadVendida);
    }

    private void mostrarInventario() {
        controlador.mostrarInventario();
    }

    private void mostrarHistorialDeVentas() {
        controlador.mostrarHistorialDeVentas();
    }
}
