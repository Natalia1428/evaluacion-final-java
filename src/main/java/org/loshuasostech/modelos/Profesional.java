package org.loshuasostech.modelos;

import org.loshuasostech.helpers.ValidadorHoraFecha;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class Profesional extends Usuario {

  private String titulo;
  private String fechaIngreso;

  public Profesional(String nombre, String fechaNacimiento, int run,
                     String titulo, String fechaIngreso) {

    super(nombre, fechaNacimiento, run);
    this.titulo = titulo;
    this.fechaIngreso = fechaIngreso;
  }

  public Profesional() {
  }

  public String getTitulo() {
    return titulo;
  }

  /**
   * Define el titulo del Profesional.
   *
   * @param titulo Corresponde a una cadena entre 10 y 50 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setTitulo(String titulo) {
    if (titulo.length() < 10 || titulo.length() > 50) {
      throw new IllegalArgumentException
              ("Titulo debe contener al menos 10 caracteres y no mas de 50");
    } else {
      this.titulo = titulo;
    }
  }

  public String getFechaIngreso() {
    return fechaIngreso;
  }

  /**
   * Define la fecha de ingreso del Profesional
   *
   * @param fechaIngreso corresponde a una fecha en formato DD/MM/AAAA
   * @throws IllegalArgumentException si la fecha  no cumple la condicion
   */
  public void setFechaIngreso(String fechaIngreso) {
    if (!ValidadorHoraFecha.fechaFormatoCorrecto(fechaIngreso)) {
      throw new IllegalArgumentException
              ("Debe ingresar la fecha en formato DD/MM/AAAA");
    } else {
      this.fechaIngreso = fechaIngreso;
    }
  }

  @Override
  public String toString() {
    return (super.toString() +
            "\nTitulo: " + this.titulo +
            "\nFecha de ingreso: " + this.fechaIngreso);
  }

  @Override
  public void analizarUsuario() {
    System.out.println("______________________________________");
    super.analizarUsuario();
    System.out.println("Titulo: " + this.titulo);
    System.out.println("Fecha de ingreso: " + this.fechaIngreso);
  }
}
