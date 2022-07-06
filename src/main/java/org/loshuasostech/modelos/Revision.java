package org.loshuasostech.modelos;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class Revision {
  private int idRevision;
  private int idVisita;
  private String nombre;
  private String detalle;
  private int estado;

  public Revision(int idRevision, int idVisita, String nombre, String detalle,
                  int estado) {

    this.idRevision = idRevision;
    this.idVisita = idVisita;
    this.nombre = nombre;
    this.detalle = detalle;
    this.estado = estado;
  }

  public Revision() {
  }

  public int getIdRevision() {
    return idRevision;
  }

  public void setIdRevision(int idRevision) {
    this.idRevision = idRevision;
  }

  public int getIdVisita() {
    return idVisita;
  }

  public void setIdVisita(int idVisita) {
    this.idVisita = idVisita;
  }

  public String getNombre() {
    return nombre;
  }

  /**
   * Define el nombre para la revision
   *
   * @param nombre Es una cadena entre 10 y 50 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setNombre(String nombre) {
    if (nombre.length() < 10 || nombre.length() > 50) {
      throw new IllegalArgumentException
              ("El nombre de la revision debe contener entre 10 y 50 caracteres");
    } else {
      this.nombre = nombre;
    }
  }

  public String getDetalle() {
    return detalle;
  }

  /**
   * Define el detalle de la revision
   *
   * @param detalle Es una cadena con un maximo de 100 caracteres
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setDetalle(String detalle) {
    if (detalle.length() > 100) {
      throw new IllegalArgumentException
              ("El detalle de la revision no puede exceder los 100 caracteres");
    } else {
      this.detalle = detalle;
    }
  }

  public int getEstado() {
    return estado;
  }

  /**
   * Define el estado de la revision
   *
   * @param estado Corresponde a un entero entre 1 y 3
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setEstado(int estado) {
    if (estado < 1 || estado > 3) {
      throw new IllegalArgumentException
              ("Debe indicar un estado valido (entre 1 y 3)");
    } else {
      this.estado = estado;
    }
  }

  @Override
  public String toString() {
    return ("Identificador revision: " + this.idRevision +
            "\nIdentificador visita: " + this.idVisita +
            "\nNombre revision: " + this.nombre +
            "\nDetalle: " + this.detalle +
            "\nEstado: " + this.estado);
  }
}
