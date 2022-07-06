package org.loshuasostech.modelos;

import org.loshuasostech.helpers.ValidadorHoraFecha;

import java.util.List;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class Capacitacion {
  private int id;
  private String rutCliente;
  private String dia;
  private String hora;
  private String lugar;
  private String duracion;
  private int cantidadAsistentes;


  public Capacitacion(int id, String rutCliente, String dia, String hora,
                      String lugar, String duracion, int cantidadAsistentes) {

    this.id = id;
    this.rutCliente = rutCliente;
    this.dia = dia;
    this.hora = hora;
    this.lugar = lugar;
    this.duracion = duracion;
    this.cantidadAsistentes = cantidadAsistentes;
  }

  public Capacitacion() {
  }

  public int getId() {
    return id;
  }

  public void setId(String identificacion) throws NumberFormatException {
    this.id = Integer.parseInt(identificacion);
  }

  public String getRutCliente() {
    return rutCliente;
  }

  public void setRutCliente(String rutCliente) {
    this.rutCliente = rutCliente;
  }

  public String getDia() {
    return dia;
  }

  /**
   * Define el dia de la Capacitacion
   *
   * @param dia Corresponde a una cadena equivalente a un dia valido.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setDia(String dia) {
    List<String> diasPermitidos = List.of("lunes", "martes", "miercoles",
            "jueves", "viernes", "sabado", "domingo");
    dia = dia.toLowerCase();
    if (!diasPermitidos.contains(dia)) {
      throw new IllegalArgumentException("Debe ingresar un dia valido.");
    } else {
      this.dia = dia;
    }
  }

  public String getHora() {
    return hora;
  }

  /**
   * Define el hora de la Capacitacion
   *
   * @param hora Corresponde a una cadena en formato valido HH:MM
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setHora(String hora) {
    if (!ValidadorHoraFecha.horaFormatoCorecto(hora)) {
      throw new IllegalArgumentException
              ("Debe ingresar la hora en formato HH:MM");
    } else {
      this.hora = hora;
    }
  }

  public String getLugar() {
    return lugar;
  }

  /**
   * Define el Lugar correspondiente a la capacitacion
   *
   * @param lugar Es una cadena entre 10 y 50 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setLugar(String lugar) {
    if (lugar.length() < 10 || lugar.length() > 50) {
      throw new IllegalArgumentException
              ("El Lugar debe contener al menos 10 caracteres y no mas de 50");
    } else {
      this.lugar = lugar;
    }
  }

  public String getDuracion() {
    return duracion;
  }

  /**
   * Define la duracion de la capacitacion
   *
   * @param duracion Es una cadena no mayor a 70 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setDuracion(String duracion) {
    if (duracion.length() > 70) {
      throw new IllegalArgumentException
              ("Debe describir la duracion en no mas de 70 caracteres");
    } else {
      this.duracion = duracion;
    }
  }

  public int getCantidadAsistentes() {
    return cantidadAsistentes;
  }

  /**
   * Define la cantidad de asistentes inscritos en la capacitacion.
   *
   * @param cantidad Es un entero menor a 1000
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setCantidadAsistentes(String cantidad) throws NumberFormatException {
    int cantidadAsistentes = Integer.parseInt(cantidad);

    if (cantidadAsistentes >= 1000) {
      throw new IllegalArgumentException
              ("Se permite un maximo de 999 asistentes");
    } else {
      this.cantidadAsistentes = cantidadAsistentes;
    }
  }


  @Override
  public String toString() {
    return ("Identificador accidente: " + this.id +
            "\nRUT Cliente: " + this.rutCliente +
            "\nDia: " + this.dia +
            "\nHora: " + this.hora +
            "\nLugar: " + this.lugar +
            "\nDuracion: " + this.duracion +
            "\nCantidad Asistentes: " + this.cantidadAsistentes);
  }

  public void mostrarDetalle() {
    System.out.printf
            ("La capacitacion sera en %s %na las %s del dia %s, y durara %s minutos",
                    this.lugar, this.hora, this.dia, this.duracion);
  }
}
