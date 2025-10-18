/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Angello
 */
public class CuentaCorrienteTest {
    

    @Test
    void testRetirarConSaldoSuficiente() {
        Fecha fecha = new Fecha(1, 1, 2023);
        CuentaCorriente cuenta = new CuentaCorriente("1234", "Juan", fecha, 500.0, 300.0);
        assertTrue(cuenta.retirar(200.0));
        assertEquals(300.0, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testRetirarUsandoSobregiro() {
        Fecha fecha = new Fecha(1, 1, 2023);
        CuentaCorriente cuenta = new CuentaCorriente("1234", "Juan", fecha, 100.0, 300.0);
        assertTrue(cuenta.retirar(300.0)); // Retira 100 del saldo y 200 del sobregiro
        assertEquals(-200.0, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testRetirarExcediendoSobregiro() {
        Fecha fecha = new Fecha(1, 1, 2023);
        CuentaCorriente cuenta = new CuentaCorriente("1234", "Juan", fecha, 100.0, 300.0);
        assertFalse(cuenta.retirar(500.0)); // Saldo (100) + Sobregiro (300) = 400. Intenta retirar 500.
        assertEquals(100.0, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testRetirarMontoNegativo() {
        Fecha fecha = new Fecha(1, 1, 2023);
        CuentaCorriente cuenta = new CuentaCorriente("1234", "Juan", fecha, 100.0, 300.0);
        assertFalse(cuenta.retirar(-50.0));
        assertEquals(100.0, cuenta.getSaldo(), 0.001);
    }
    
}
