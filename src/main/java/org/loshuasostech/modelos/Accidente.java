package org.loshuasostech.modelos;

import org.loshuasostech.helpers.ValidadorHoraFecha;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class Accidente {
  private int id;
  private String rut;
  private String diaAccidente;
  private String hora;
  private String lugar;
  private String origen;
  private String consecuencia;

  public Accidente(int id, String rut, String diaAccidente, String hora,
                   String lugar, String origen, String consecuencia) {

    this.id = id;
    this.rut = rut;
    this.diaAccidente = diaAccidente;
    this.hora = hora;
    this.lugar = lugar;
    this.origen = origen;
    this.consecuencia = consecuencia;
  }

  public Accidente() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRut() {
    return rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getDiaAccidente() {
    return diaAccidente;
  }

  /**
   * Define la fecha del accidente
   *
   * @param diaAccidente corresponde a una fecha en formato DD/MM/AAAA
   * @throws IllegalArgumentException si la fecha  no cumple la condicion
   */
  public void setDiaAccidente(String diaAccidente) {
    if (!ValidadorHoraFecha.fechaFormatoCorrecto(diaAccidente)) {
      throw new IllegalArgumentException
              ("Debe ingresar la fecha del accidente en formato DD/MM/AAAA");
    } else {
      this.diaAccidente = diaAccidente;
    }
  }

  public String getHora() {
    return hora;
  }

  /**
   * Define el hora del Accidente
   *
   * @param hora Corresponde a una cadena en formato valido HH:MM
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setHora(String hora) {
    if (!ValidadorHoraFecha.horaFormatoCorecto(hora)) {
      throw new IllegalArgumentException
              ("Debe ingresar la hora del accidente en formato HH:MM");
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

  public String getOrigen() {
    return origen;
  }

  /**
   * Define el origen del accidente.
   *
   * @param origen Es una cadena con un maximo de 100 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setOrigen(String origen) {
    if (origen.length() > 100) {
      throw new IllegalArgumentException
              ("Debe describir el origen en un maximo de 100 caracteres");
    } else {
      this.origen = origen;
    }
  }

  public String getConsecuencia() {
    return consecuencia;
  }

  /**
   * Define las consecuencias del accidente.
   *
   * @param consecuencia Es una cadena con un maximo de 100 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setConsecuencia(String consecuencia) {
    if (consecuencia.length() > 100) {
      throw new IllegalArgumentException
              ("Debe describir las consecuencias en un maximo de 100 caracteres");
    } else {
      this.consecuencia = consecuencia;
    }
  }

  @Override
  public String toString() {
    return ("Identificador accidente: " + this.id +
            "\nRUT: " + this.rut +
            "\nDia (accidente): " + this.diaAccidente +
            "\nHora: " + this.hora +
            "\nLugar: " + this.lugar +
            "\nOrigen :" + this.origen +
            "\nConsecuencias: " + this.consecuencia);
  }
}
