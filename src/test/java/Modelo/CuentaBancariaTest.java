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
public class CuentaBancariaTest {
    

    @Test
    void testConsignar() {
        Fecha fecha = new Fecha(1, 1, 2023);
        CuentaBancaria cuenta = new CuentaBancaria("12345", "Juan", fecha, 1000.0);
        cuenta.consignar(500.0);
        assertEquals(1500.0, cuenta.getSaldo(), 0.001);
        cuenta.consignar(-100.0); // Monto negativo no debe afectar el saldo
        assertEquals(1500.0, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testRetirar() {
        Fecha fecha = new Fecha(1, 1, 2023);
        CuentaBancaria cuenta = new CuentaBancaria("12345", "Juan", fecha, 1000.0);
        assertTrue(cuenta.retirar(500.0));
        assertEquals(500.0, cuenta.getSaldo(), 0.001);
        assertFalse(cuenta.retirar(1000.0)); // No hay saldo suficiente
        assertEquals(500.0, cuenta.getSaldo(), 0.001);
        assertFalse(cuenta.retirar(-100.0)); // Monto negativo no debe afectar el saldo
        assertEquals(500.0, cuenta.getSaldo(), 0.001);
    }

    
}
