/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.edd.modelo;

import java.util.Stack;

/**
 *
 * @author mateo
 */
public class HistorialDeVenta {
    private Stack<TransaccionDeVenta> transacciones;

    public HistorialDeVenta() {
        transacciones = new Stack<>();
    }

    public void añadirTransaccion(TransaccionDeVenta transaccion) {
        transacciones.push(transaccion);
    }

    public Stack<TransaccionDeVenta> getTransacciones() {
        return transacciones;
    }
}
