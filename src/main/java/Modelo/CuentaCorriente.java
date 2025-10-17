/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class CuentaCorriente extends CuentaBancaria {
        private double cupoSobregiro;

    public CuentaCorriente(String numeroCuenta, String nombreDueno, Fecha fechaApertura, double saldoInicial, double cupoSobregiro) {
        super(numeroCuenta, nombreDueno, fechaApertura, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
    }

    public double getCupoSobregiro() {
        return cupoSobregiro;
    }

    public boolean retirar(double monto) {
        if (monto > 0) {
            if (this.saldo + this.cupoSobregiro >= monto) {
                this.saldo -= monto;
                return true;
            }
        }
        return false;
    }

    public String obtenerInformacion() {
        return "Tipo de Cuenta: Corriente\n" +
               super.obtenerInformacion() + "\n" +
               "Cupo de Sobregiro: " + String.format("%.2f", cupoSobregiro);
    }
}
