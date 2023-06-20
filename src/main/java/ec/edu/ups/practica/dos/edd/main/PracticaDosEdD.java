/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.practica.dos.edd.main;

import ec.edu.ups.practica.dos.edd.controlador.ControladorTienda;
import ec.edu.ups.practica.dos.edd.vista.Tienda;

/**
 *
 * @author mateo
 */
public class PracticaDosEdD {

    public static void main(String[] args) {
        ControladorTienda controlador = new ControladorTienda();
        Tienda vista = new Tienda(controlador);
        vista.iniciar();
    }
}
