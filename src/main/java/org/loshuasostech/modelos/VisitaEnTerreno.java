package org.loshuasostech.modelos;

import org.loshuasostech.helpers.ValidadorHoraFecha;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class VisitaEnTerreno {
  private int id;
  private String rut;
  private String dia;
  private String hora;
  private String lugar;
  private String comentarios;
  private List<Revision> revisiones;

  public VisitaEnTerreno(int id, String rut, String dia, String hora,
                         String lugar, String comentarios) {

    this.id = id;
    this.rut = rut;
    this.dia = dia;
    this.hora = hora;
    this.lugar = lugar;
    this.comentarios = comentarios;

    this.revisiones = new ArrayList<>();
  }

  public VisitaEnTerreno() {
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

  public String getDia() {
    return dia;
  }

  /**
   * Define la fecha de la visita
   *
   * @param dia corresponde a una fecha en formato DD/MM/AAAA
   * @throws IllegalArgumentException si la fecha  no cumple la condicion
   */
  public void setDia(String dia) {
    if (!ValidadorHoraFecha.fechaFormatoCorrecto(dia)) {
      throw new IllegalArgumentException
              ("Debe ingresar la fecha de la visita en formato DD/MM/AAAA");
    } else {
      this.dia = dia;
    }
  }

  public String getHora() {
    return hora;
  }

  /**
   * Define el hora de la visita
   *
   * @param hora Corresponde a una cadena en formato valido HH:MM
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setHora(String hora) {
    if (!ValidadorHoraFecha.horaFormatoCorecto(hora)) {
      throw new IllegalArgumentException
              ("Debe ingresar la hora de la visita en formato HH:MM");
    } else {
      this.hora = hora;
    }
  }

  public String getLugar() {
    return lugar;
  }

  /**
   * Define el lugar de la visita
   *
   * @param lugar Corresponde a una cadena entre 10 y 50 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setLugar(String lugar) {
    if (lugar.length() < 10 || lugar.length() > 50) {
      throw new IllegalArgumentException
              ("El lugar debe estar definido entre 10 y 50 caracteres");
    } else {
      this.lugar = lugar;
    }

  }

  public String getComentarios() {
    return comentarios;
  }

  /**
   * Define los comentarios referentes a la visita.
   *
   * @param comentarios Corresponde a una cadena de un maximo de 100 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setComentarios(String comentarios) {
    if (comentarios.length() > 100) {
      throw new IllegalArgumentException
              ("Los comentarios no deben exceder los 100 caracteres");
    } else {
      this.comentarios = comentarios;
    }
  }

  @Override
  public String toString() {
    return ("Identificador visita: " + this.id +
            "\nRUT: " + this.rut +
            "\nDia: " + this.dia +
            "\nHora: " + this.hora +
            "\nLugar: " + this.lugar +
            "\nComentarios: " + this.comentarios);
  }
}
