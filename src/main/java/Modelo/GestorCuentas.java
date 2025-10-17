/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Modelo.CuentaAhorros;
import Modelo.CuentaCorriente;
/**
 *
 * @author migue
 */
public class GestorCuentas {
    
    public static CuentaAhorros crearCuentaAhorros(String numero, String dueno, int dia, int mes, int anio, double saldoInicial) {
        Fecha fecha = new Fecha(dia, mes, anio);
        return new CuentaAhorros(numero, dueno, fecha, saldoInicial);
    }

    public static CuentaCorriente crearCuentaCorriente(String numero, String dueno, int dia, int mes, int anio, double saldoInicial, double cupoSobregiro) {
        Fecha fecha = new Fecha(dia, mes, anio);
        return new CuentaCorriente(numero, dueno, fecha, saldoInicial, cupoSobregiro);
    }

    public static CuentaBancaria buscarCuenta(CuentaBancaria[] cuentas, String numero) {
        if (cuentas == null || numero == null) {
            return null;
        }
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null && cuentas[i].getNumeroCuenta().equals(numero)) {
                return cuentas[i];
            }
        }
        return null;
    }

    public static String mostrarTodasLasCuentas(CuentaBancaria[] cuentas) {
        StringBuilder sb = new StringBuilder();
        if (cuentas == null || cuentas.length == 0) {
            sb.append("No hay cuentas registradas.\n");
        } else {
            for (int i = 0; i < cuentas.length; i++) {
                if (cuentas[i] != null) {
                    sb.append("-------------------------------------\n");
                    sb.append(cuentas[i].obtenerInformacion());
                    sb.append("\n");
                }
            }
            sb.append("-------------------------------------");
        }
        return sb.toString();
    }

}
