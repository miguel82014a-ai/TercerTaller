/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class CuentaAhorros extends CuentaBancaria{
        public CuentaAhorros(String numeroCuenta, String nombreDueno, Fecha fechaApertura, double saldoInicial) {
        super(numeroCuenta, nombreDueno, fechaApertura, saldoInicial);
    }

    public boolean retirar(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }

    public String obtenerInformacion() {
        return "Tipo de Cuenta: Ahorros\n" + super.obtenerInformacion();
    }
}
