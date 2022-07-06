package org.loshuasostech;

import org.loshuasostech.logic.Contenedor;
import org.loshuasostech.ui.TextUI;

import java.util.Scanner;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */

public class Main {

  /**
   * Inicia el programa, inyectando scanner y contenedor a la UI para procesar
   * la informacion que el usuario necesite.
   *
   * @param args Sin implementacion
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Contenedor contenedor = new Contenedor();
    TextUI ui = new TextUI(scanner, contenedor);
    ui.start();
  }
}