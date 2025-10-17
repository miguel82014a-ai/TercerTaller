/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tercertaller;
import Modelo.CuentaBancaria;
import Modelo.GestorCuentas;
import Modelo.UtilidadesBanco;

import javax.swing.JOptionPane;
/**
 *
 * @author migue
 */
public class TercerTaller {
    
    
    private static CuentaBancaria[] cuentas = new CuentaBancaria[10]; // Array para almacenar hasta 10 cuentas
    private static int contadorCuentas = 0;
    
    public static void main(String[] args) {
            int opcion;
        do {
            String[] opcionesMenuPrincipal = {"Crear Cuenta", "Operar Cuenta", "Mostrar Todas las Cuentas", "Salir"};
            opcion = UtilidadesBanco.mostrarOpciones("Bienvenido\nSeleccione una opción:", "Menú Principal", opcionesMenuPrincipal);

            switch (opcion) {
                case 0: 
                    crearNuevaCuenta();
                    break;
                case 1: 
                    operarCuentaExistente();
                    break;
                case 2: 
                    UtilidadesBanco.mostrarMensaje(GestorCuentas.mostrarTodasLasCuentas(cuentas), "Listado de Cuentas", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3: 
                    UtilidadesBanco.mostrarMensaje("Gracias por usar el Sistema Bancario. ¡Hasta pronto!", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    
                    opcion = 3; 
                    UtilidadesBanco.mostrarMensaje("Operación cancelada. Saliendo del programa.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } while (opcion != 3);
    }

    private static void crearNuevaCuenta() {
        if (contadorCuentas >= cuentas.length) {
            UtilidadesBanco.mostrarMensaje("No se pueden crear más cuentas. Límite alcanzado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] tiposCuenta = {"Cuenta de Ahorros", "Cuenta Corriente"};
        int tipoSeleccionado = UtilidadesBanco.mostrarOpciones("Seleccione el tipo de cuenta a crear:", "Crear Cuenta", tiposCuenta);

        if (tipoSeleccionado == -1) { 
            return;
        }

        String numeroCuenta = UtilidadesBanco.solicitarString("Ingrese el número de cuenta:");
        if (numeroCuenta == null || numeroCuenta.trim().isEmpty()) return;
        
        if (GestorCuentas.buscarCuenta(cuentas, numeroCuenta) != null) {
            UtilidadesBanco.mostrarMensaje("Ya existe una cuenta con ese número.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreDueno = UtilidadesBanco.solicitarString("Ingrese el nombre del dueño:");
        if (nombreDueno == null || nombreDueno.trim().isEmpty()) return;

        int dia = UtilidadesBanco.solicitarInt("Ingrese el día de apertura:");
        if (dia == -1) return;
        int mes = UtilidadesBanco.solicitarInt("Ingrese el mes de apertura:");
        if (mes == -1) return;
        int anio = UtilidadesBanco.solicitarInt("Ingrese el año de apertura:");
        if (anio == -1) return;

        double saldoInicial = UtilidadesBanco.solicitarDouble("Ingrese el saldo inicial:");
        if (Double.isNaN(saldoInicial)) return;

        CuentaBancaria nuevaCuenta = null;
        if (tipoSeleccionado == 0) { 
            nuevaCuenta = GestorCuentas.crearCuentaAhorros(numeroCuenta, nombreDueno, dia, mes, anio, saldoInicial);
        } else if (tipoSeleccionado == 1) { 
            double cupoSobregiro = UtilidadesBanco.solicitarDouble("Ingrese el cupo de sobregiro:");
            if (Double.isNaN(cupoSobregiro)) return;
            nuevaCuenta = GestorCuentas.crearCuentaCorriente(numeroCuenta, nombreDueno, dia, mes, anio, saldoInicial, cupoSobregiro);
        }

        if (nuevaCuenta != null) {
            cuentas[contadorCuentas++] = nuevaCuenta;
            UtilidadesBanco.mostrarMensaje("Cuenta creada exitosamente.\n" + nuevaCuenta.obtenerInformacion(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void operarCuentaExistente() {
        String numeroCuenta = UtilidadesBanco.solicitarString("Ingrese el número de cuenta a operar:");
        if (numeroCuenta == null || numeroCuenta.trim().isEmpty()) return;

        CuentaBancaria cuenta = GestorCuentas.buscarCuenta(cuentas, numeroCuenta);

        if (cuenta == null) {
            UtilidadesBanco.mostrarMensaje("Cuenta no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcionOperacion;
        do {
            String[] opcionesOperacion = {"Consignar", "Retirar", "Ver Información", "Ver Saldo Actual", "Volver al Menú Principal"};
            opcionOperacion = UtilidadesBanco.mostrarOpciones("Cuenta: " + cuenta.getNumeroCuenta() + "\nSaldo: " + cuenta.obtenerSaldoActual() + "\nSeleccione una operación:", "Operaciones de Cuenta", opcionesOperacion);

            switch (opcionOperacion) {
                case 0: 
                    double montoConsignar = UtilidadesBanco.solicitarDouble("Ingrese el monto a consignar:");
                    if (Double.isNaN(montoConsignar)) break;
                    if (montoConsignar > 0) {
                        cuenta.consignar(montoConsignar);
                        UtilidadesBanco.mostrarMensaje("Consignación exitosa. Nuevo saldo: " + cuenta.obtenerSaldoActual(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        UtilidadesBanco.mostrarMensaje("El monto a consignar debe ser positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1: // Retirar
                    double montoRetirar = UtilidadesBanco.solicitarDouble("Ingrese el monto a retirar:");
                    if (Double.isNaN(montoRetirar)) break;
                    if (montoRetirar > 0) {
                        if (cuenta.retirar(montoRetirar)) {
                            UtilidadesBanco.mostrarMensaje("Retiro exitoso. Nuevo saldo: " + cuenta.obtenerSaldoActual(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            UtilidadesBanco.mostrarMensaje("No se pudo realizar el retiro. Saldo/Cupo de sobregiro insuficiente.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        UtilidadesBanco.mostrarMensaje("El monto a retirar debe ser positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2: 
                    UtilidadesBanco.mostrarMensaje(cuenta.obtenerInformacion(), "Información de Cuenta", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3: 
                    UtilidadesBanco.mostrarMensaje("Saldo actual: " + cuenta.obtenerSaldoActual(), "Saldo Actual", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4: 
                    break;
                default:
                    
                    opcionOperacion = 4; 
                    break;
            }
        } while (opcionOperacion != 4);
    }
}

