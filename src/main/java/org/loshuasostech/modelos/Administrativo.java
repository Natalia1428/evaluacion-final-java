package org.loshuasostech.modelos;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class Administrativo extends Usuario {

  private String area;
  private String expPrevia;

  public Administrativo(String nombre, String fechaNacimiento, int run,
                        String area, String expPrevia) {

    super(nombre, fechaNacimiento, run);
    this.area = area;
    this.expPrevia = expPrevia;
  }

  public Administrativo() {
  }

  public String getArea() {
    return area;
  }

  /**
   * Define el Area correspondiente al Administrativo
   *
   * @param area Es una cadena entre 5 y 20 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setArea(String area) {
    if (area.length() < 5 || area.length() > 20) {
      throw new IllegalArgumentException
              ("El area debe contener al menos 5 caracteres y no mas de 20");
    } else {
      this.area = area;
    }
  }

  public String getExpPrevia() {
    return expPrevia;
  }

  /**
   * Define la experiencia previa del Administrativo
   *
   * @param expPrevia Es una cadena no mayor a 100 caracteres.
   * @throws IllegalArgumentException si no cumple con la condicion.
   */
  public void setExpPrevia(String expPrevia) {
    if (expPrevia.length() > 100) {
      throw new IllegalArgumentException
              ("Debe describir su experiencia previa en no mas de 100 caracteres");
    } else {
      this.expPrevia = expPrevia;
    }

  }

  @Override
  public String toString() {
    return (super.toString() +
            "\nArea :" + this.area +
            "\nExperiencia Previa: " + this.expPrevia);
  }

  public void analizarUsuario() {
    System.out.println("______________________________________");
    super.analizarUsuario();
    System.out.println("Area :" + this.area);
    System.out.println("Experiencia Previa :" + this.expPrevia);
  }
}
