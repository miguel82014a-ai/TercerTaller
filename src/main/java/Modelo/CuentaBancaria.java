/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class CuentaBancaria {
        private String numeroCuenta;
    private String nombreDueno;
    private Fecha fechaApertura;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, String nombreDueno, Fecha fechaApertura, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.nombreDueno = nombreDueno;
        this.fechaApertura = fechaApertura;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public Fecha getFechaApertura() {
        return fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consignar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }

    public String obtenerInformacion() {
        return "Número de Cuenta: " + numeroCuenta + "\n" +
               "Dueño: " + nombreDueno + "\n" +
               "Fecha de Apertura: " + fechaApertura.toString() + "\n" +
               "Saldo Actual: " + String.format("%.2f", saldo);
    }

    public String obtenerSaldoActual() {
        return String.format("%.2f", saldo);
    }
}
