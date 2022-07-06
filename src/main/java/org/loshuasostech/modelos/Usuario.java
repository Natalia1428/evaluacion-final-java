package org.loshuasostech.modelos;

import org.loshuasostech.helpers.ValidadorHoraFecha;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class Usuario implements Asesoria {
  protected String nombre;
  protected String fechaNacimiento;
  protected int run;

  public Usuario() {

  }

  public Usuario(String nombre, String fechaNacimiento, int run) {
    this.nombre = nombre;
    this.fechaNacimiento = fechaNacimiento;
    this.run = run;
  }

  public String getNombre() {
    return nombre;
  }

  /**
   * Define el nombre del usuario
   *
   * @param nombre Es una cadena entre 10 y 50 caracteres.
   * @throws IllegalArgumentException si el nombre no cumple con la condicion.
   */
  public void setNombre(String nombre) {
    if (nombre.length() < 10 || nombre.length() > 50) {
      throw new IllegalArgumentException
              ("Nombre debe contener al menos 10 caracteres y no mas de 50");
    } else {
      this.nombre = nombre;
    }

  }

  public String getFechaNacimiento() {


    return this.fechaNacimiento;
  }

  /**
   * Define la fecha de nacimiento del usuario
   *
   * @param fechaNacimiento corresponde a una fecha en formato DD/MM/AAAA
   * @throws IllegalArgumentException si la fecha  no cumple la condicion
   */
  public void setFechaNacimiento(String fechaNacimiento) {
    if (!ValidadorHoraFecha.fechaFormatoCorrecto(fechaNacimiento)) {
      throw new IllegalArgumentException
              ("Debe ingresar la fecha en formato DD/MM/AAAA");
    } else {
      this.fechaNacimiento = fechaNacimiento;
    }

  }

  public int getRun() {
    return run;
  }

  /**
   * Define el RUN para el usuario
   *
   * @param sRun corresponde a un numero menor a 99.999.999
   * @throws IllegalArgumentException si el numero no cumple la condicion.
   */
  public void setRun(String sRun) throws NumberFormatException {
    int run = Integer.parseInt(sRun);
    if (run >= 99_999_999) {
      throw new IllegalArgumentException
              ("El RUN debe ser menor a 99.999.999");
    } else {
      this.run = run;
    }

  }

  @Override
  public String toString() {
    return ("Nombre: " + this.nombre +
            "\nFecha de nacimiento: " + this.fechaNacimiento +
            "\nRUN: " + this.run);
  }

  @Override
  public void analizarUsuario() {
    System.out.println("Nombre: " + this.nombre + "\nRUN: " + this.run);
  }

  /**
   * Calcula la edad del usuario a partir de su fecha de nacimiento.
   *
   * @return Un valor entero que representa la edad.
   */
  private int calcularEdad() {
    String[] partes = this.fechaNacimiento.split("/");
    LocalDate nacimiento =
            LocalDate.of(Integer.parseInt(partes[2]),
                    Integer.parseInt(partes[1]), Integer.parseInt(partes[0]));

    Period period = Period.between(nacimiento, LocalDate.now());

    return period.getYears();
  }

  /**
   * Muestra por pantalla la edad del usuario segun formato.
   */
  public void mostrarEdad() {
    System.out.printf("%nEl usuario tiene %d anios de edad", this.calcularEdad());
  }
}
