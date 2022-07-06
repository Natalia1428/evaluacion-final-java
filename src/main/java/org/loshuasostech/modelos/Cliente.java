package org.loshuasostech.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class Cliente extends Usuario {

  private String apellidos;
  private String telefono;
  private String afp;
  private int sistemaSalud;
  private String direccion;
  private String comuna;
  private int edad;

  private List<Capacitacion> capacitaciones;
  private List<Accidente> accidentes;
  private List<VisitaEnTerreno> visitas;

  public Cliente(String nombre, String fechaNacimiento, int run,
                 String apellidos, String telefono, String afp, int sistemaSalud,
                 String direccion, String comuna, int edad) {

    super(nombre, fechaNacimiento, run);
    this.apellidos = apellidos;
    this.telefono = telefono;
    this.afp = afp;
    this.sistemaSalud = sistemaSalud;
    this.direccion = direccion;
    this.comuna = comuna;
    this.edad = edad;

    this.capacitaciones = new ArrayList<>();
    this.visitas = new ArrayList<>();
    this.accidentes = new ArrayList<>();
  }

  public Cliente() {
  }


  /**
   * Define el nombre del cliente
   *
   * @param nombre Es una cadena entre 5 y 30 caracteres.
   * @throws IllegalArgumentException si el nombre no cumple con la condicion.
   */
  @Override
  public void setNombre(String nombre) {
    if (nombre.length() < 5 || nombre.length() > 30) {
      throw new IllegalArgumentException
              ("Nombre debe contener al menos 5 caracteres y no mas de 30");
    } else {
      this.nombre = nombre;
    }
  }

  public String getApellidos() {
    return apellidos;
  }

  /**
   * Define el(los) apellido(s) del cliente.
   *
   * @param apellidos Es una cadena entre 5 y 30 caracteres.
   * @throws IllegalArgumentException si apellido no cumple con la validacion.
   */
  public void setApellidos(String apellidos) {
    if (apellidos.length() < 5 || apellidos.length() > 30) {
      throw new IllegalArgumentException
              ("Apellido debe contener al menos 5 caracteres y no mas de 30");
    } else {
      this.apellidos = apellidos;
    }
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getAfp() {
    return afp;
  }

  /**
   * Define la AFP a la cual pertenece el cliente.
   *
   * @param afp Es una cadena entre 4 y 30 caracteres.
   * @throws IllegalArgumentException si AFP no cumple con la validacion.
   */
  public void setAfp(String afp) {
    if (afp.length() < 4 || afp.length() > 30) {
      throw new IllegalArgumentException
              ("AFP debe contener al menos 4 caracteres y no mas de 30");
    } else {
      this.afp = afp;
    }
  }

  public int getSistemaSalud() {
    return sistemaSalud;
  }

  /**
   * Define el Sistema Salud a la cual pertenece el cliente.
   *
   * @param sSalud Corresponde a un entero que puede ser 1 o 2.
   * @throws IllegalArgumentException si sistemaSalud no cumple con la condicion.
   */
  public void setSistemaSalud(String sSalud) throws NumberFormatException {
    int sistemaSalud = Integer.parseInt(sSalud); //
    if (sistemaSalud < 1 || sistemaSalud > 2) {
      throw new IllegalArgumentException
              ("Debe ingresar 1) FONASA o 2) ISAPRE");
    } else {
      this.sistemaSalud = sistemaSalud;
    }

  }

  public String getDireccion() {
    return direccion;
  }

  /**
   * Define la direccion del cliente.
   *
   * @param direccion Corresponde a una cadena de no mas de 70 caracteres
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setDireccion(String direccion) {
    if (direccion.length() > 70) {
      throw new IllegalArgumentException
              ("La direccion no puede tener mas de 70 caracteres");
    } else {
      this.direccion = direccion;
    }
  }

  public String getComuna() {
    return comuna;
  }

  /**
   * Define la Comuna del cliente.
   *
   * @param comuna Corresponde a una cadena de no mas de 50 caracteres
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setComuna(String comuna) {
    if (comuna.length() > 50) {
      throw new IllegalArgumentException
              ("La comuna no puede tener mas de 50 caracteres");
    } else {
      this.comuna = comuna;
    }
  }

  public int getEdad() {
    return edad;
  }

  /**
   * Define la edad del cliente.
   *
   * @param age Corresponde a un entero entre 0-149
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setEdad(String age) throws NumberFormatException {
    int edad = Integer.parseInt(age);
    if (edad < 0 || edad >= 150) {
      throw new IllegalArgumentException
              ("La edad debe estar entre 0 y 149 anios");
    } else {
      this.edad = edad;
    }
  }

  @Override
  public String toString() {
    return (super.toString() +
            "\nApellidos: " + this.apellidos +
            "\nTelefono: " + this.telefono +
            "\nAFP: " + this.afp +
            "\nSistema de salud: " + this.obtenerSistemaSalud() +
            "\nDireccion: " + this.direccion +
            "\nComuna: " + this.comuna +
            "\nEdad: " + this.edad);
  }

  public void analizarUsuario() {
    System.out.println("______________________________________");
    super.analizarUsuario();
    System.out.println
            ("Direccion: " + this.direccion + "\nComuna: " + this.comuna);
  }

  /**
   * Define una cadena que concatena el nombre y apellido del cliente
   *
   * @return La cadena concatenada.
   */
  public String obtenerNombre() {
    return this.getNombre() + " " + this.apellidos;
  }

  /**
   * Define un cadena asociado al valor de Sistema de salud
   *
   * @return Una cadena representativa del sistema de salud segun corresponda.
   */
  public String obtenerSistemaSalud() {
    return this.sistemaSalud == 1 ? "Fonasa" : "Isapre";
  }
}
