/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4interfaz.pantallas;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Alfonso
 */
public class Fuente {
    // Método para cargar la fuente
    public Font cargarFuente(String ruta, float tamaño) {
        try {
            InputStream fontStream = getClass().getResourceAsStream(ruta);
            // Importamos la clase font. Se le pasará como parámetro el tamaño y la ruta
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            return font.deriveFont(tamaño);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
