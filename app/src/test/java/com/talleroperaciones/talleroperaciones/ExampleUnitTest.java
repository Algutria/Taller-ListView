package com.talleroperaciones.talleroperaciones;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void save_a_operation_in_data_array() {
        String[] data = {"Lado: 4"};

        Operation op = new Operation("Area del Cuadrado", data, "16");
        op.save();

        assertEquals(Data.getOperations().size(), 1, 0);
    }
}