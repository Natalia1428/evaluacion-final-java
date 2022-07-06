package org.loshuasostech.helpers;

public class ValidadorHoraFecha {

  /**
   * Valida una cadena para que cumpla con el formato de fecha correcta
   *
   * @param fechaAValidar Contiene una cadena a ser validada.
   * @return el resultado de la validacion
   */
  public static boolean fechaFormatoCorrecto(String fechaAValidar) {
    String formatoFecha =
            "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
    return fechaAValidar.matches(formatoFecha);
  }


  /**
   * Valida una cadena para que cumpla con el formato de hora correcta
   *
   * @param horaAValidar Contiene una cadena a ser validada.
   * @return el resultado de la validacion
   */
  public static boolean horaFormatoCorecto(String horaAValidar) {
    String formatoHora =
            "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$";
    return horaAValidar.matches(formatoHora);
  }
}
