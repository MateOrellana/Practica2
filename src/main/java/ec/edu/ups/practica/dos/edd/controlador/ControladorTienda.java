/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.edd.controlador;

import ec.edu.ups.practica.dos.edd.modelo.HistorialDeVenta;
import ec.edu.ups.practica.dos.edd.modelo.Inventario;
import ec.edu.ups.practica.dos.edd.modelo.Producto;
import ec.edu.ups.practica.dos.edd.modelo.TransaccionDeVenta;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author mateo
 */
public class ControladorTienda {
    private Inventario inventario;
    private HistorialDeVenta historialDeVenta;

    public ControladorTienda(){
        inventario = new Inventario();
        historialDeVenta = new HistorialDeVenta();
    }
    

    public void registrarProducto(String nombre, int codigo, double precio, int cantidad) {
        Producto producto = new Producto(nombre, codigo, precio, cantidad);
        inventario.añadirProducto(producto);
    }

    public void venderProducto(int codigo, int cantidadVendida) {
        LinkedList<Producto> productos = inventario.getProductos();
        Producto productoEncontrado = null;
  
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado != null) {
            if (productoEncontrado.getCantidad() >= cantidadVendida) {
                productoEncontrado.setCantidad(productoEncontrado.getCantidad() - cantidadVendida);
                TransaccionDeVenta transaccion = new TransaccionDeVenta(productoEncontrado, cantidadVendida);
                historialDeVenta.añadirTransaccion(transaccion);
                System.out.println(cantidadVendida + " unidades de " + productoEncontrado.getNombre() + " vendida.");
            } else {
                System.out.println("Cantidad insuficiente disponible.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void mostrarInventario() {
        LinkedList<Producto> productos = inventario.getProductos();
        System.out.println("Inventario actual:");
        System.out.println("------------------");
        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Codigo: " + producto.getCodigo());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("------------------");
        }
    }

    public void mostrarHistorialDeVentas() {
        Stack<TransaccionDeVenta> transacciones = historialDeVenta.getTransacciones();
        System.out.println("Historial de ventas:");
        System.out.println("------------------");
        for (TransaccionDeVenta transaccion : transacciones) {
            Producto producto = transaccion.getProducto();
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Codigo: " + producto.getCodigo());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Cantidad vendida: " + transaccion.getCantidadVendida());
            System.out.println("------------------");
        }
    }
}
