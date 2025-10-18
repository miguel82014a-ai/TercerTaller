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
public class CuentaAhorrosTest {
    
    
    private CuentaAhorros cuentaAhorros;

    /**
     * Test of  method, of class CuentaAhorros.
     */

    @Test
    void testRetirar() {
        Fecha fecha = new Fecha(1, 1, 2023);
        CuentaAhorros cuenta = new CuentaAhorros("1234", "Pedro", fecha, 500.0);
        assertTrue(cuenta.retirar(200.0));
        assertEquals(300.0, cuenta.getSaldo(), 0.001);
        assertFalse(cuenta.retirar(400.0)); // No hay saldo suficiente
        assertEquals(300.0, cuenta.getSaldo(), 0.001);
        assertFalse(cuenta.retirar(-50.0)); // Monto negativo
        assertEquals(300.0, cuenta.getSaldo(), 0.001);
    }
    
}
