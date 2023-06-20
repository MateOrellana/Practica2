/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.edd.modelo;

import java.util.LinkedList;

/**
 *
 * @author mateo
 */
public class Inventario {
    private LinkedList<Producto> productos;

    public Inventario() {
        productos = new LinkedList<>();
    }

    public void añadirProducto(Producto producto) {
        productos.add(producto);
    }

    public void removeProduct(Producto producto) {
        productos.remove(producto);
    }

    public void actualizarCantidad(Producto producto, int newCantidad) {
        productos.set(newCantidad, producto);
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }
}
