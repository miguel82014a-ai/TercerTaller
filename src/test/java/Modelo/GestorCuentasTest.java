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
public class GestorCuentasTest {
    
    @Test
    void testCrearCuentaAhorros() {
        CuentaAhorros cuenta = GestorCuentas.crearCuentaAhorros("1234", "Pedro", 1, 1, 2023, 100.0);
        assertNotNull(cuenta);
        assertEquals("1234", cuenta.getNumeroCuenta());
        assertEquals("Pedro", cuenta.getNombreDueno());
        assertEquals(100.0, cuenta.getSaldo(), 0.001);
        assertEquals("01/01/2023", cuenta.getFechaApertura().toString());
    }

    @Test
    void testCrearCuentaCorriente() {
        CuentaCorriente cuenta = GestorCuentas.crearCuentaCorriente("1234", "Pedro", 1, 1, 2023, 200.0, 500.0);
        assertNotNull(cuenta);
        assertEquals("222", cuenta.getNumeroCuenta());
        assertEquals("Pedro", cuenta.getNombreDueno());
        assertEquals(200.0, cuenta.getSaldo(), 0.001);
        assertEquals(500.0, cuenta.getCupoSobregiro(), 0.001);
        assertEquals("01/01/2023", cuenta.getFechaApertura().toString());
    }

    @Test
    void testBuscarCuenta() {
        Fecha fecha = new Fecha(1, 1, 2023);
        CuentaBancaria cuenta1 = new CuentaAhorros("A1", "Dueno A", fecha, 100.0);
        CuentaBancaria cuenta2 = new CuentaCorriente("C1", "Dueno C", fecha, 200.0, 300.0);
        CuentaBancaria[] cuentas = {cuenta1, cuenta2, null};

        assertEquals(cuenta1, GestorCuentas.buscarCuenta(cuentas, "A1"));
        assertEquals(cuenta2, GestorCuentas.buscarCuenta(cuentas, "C1"));
        assertNull(GestorCuentas.buscarCuenta(cuentas, "X1"));
        assertNull(GestorCuentas.buscarCuenta(null, "A1"));
        assertNull(GestorCuentas.buscarCuenta(cuentas, null));
    }
    
}
