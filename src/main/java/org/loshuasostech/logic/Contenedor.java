package org.loshuasostech.logic;

import org.loshuasostech.modelos.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class Contenedor {

  private List<Asesoria> usuarios;
  private List<Capacitacion> capacitaciones;


  public Contenedor() {
    this.usuarios = new ArrayList<>();
    this.capacitaciones = new ArrayList<>();
  }

  /**
   * Recibe un objeto Cliente y lo almacena en la lista correspondiente
   *
   * @param cliente Es el objeto recibido.
   */
  public void almacenarCliente(Cliente cliente) {
    this.usuarios.add(cliente);
  }

  /**
   * Recibe un objeto Profesional y lo almacena en la lista correspondiente
   *
   * @param profesional Es el objeto recibido.
   */
  public void almacenarProfesional(Profesional profesional) {
    this.usuarios.add(profesional);
  }

  /**
   * Recibe un objeto Administrativo y lo almacena en la lista correspondiente
   *
   * @param administrativo Es el objeto recibido.
   */
  public void almacenarAdministrativo(Administrativo administrativo) {
    this.usuarios.add(administrativo);
  }

  /**
   * Recibe un objeto Capacitacion y lo almacena en la lista correspondiente
   *
   * @param capacitacion Es el objeto recibido.
   */
  public void almacenarCapacitacion(Capacitacion capacitacion) {
    this.capacitaciones.add(capacitacion);
  }

  /**
   * Elimina un usuario de la lista segun el RUN
   *
   * @param RUN Corresponde al RUN del usuario a eliminar
   */
  public boolean eliminarUsuario(int RUN) {
    //Se verifica que la lista no se encuentre vacia.
    if (!this.usuarios.isEmpty()) {
      for (Asesoria usuario : this.usuarios) {
        //Se realiza casteo para recuperar acceso a metodos get.
        Usuario u = (Usuario) usuario;
        if (u.getRun() == RUN) {
          usuarios.remove(u);
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Obtiene una lista de todos los Usuarios, casteados a tipo Usuario
   *
   * @return una Lista con todos los Usuarios ingresados
   */
  @SuppressWarnings("unchecked")
  public List<Usuario> obtenerUsuarios() {
    return (List<Usuario>) (Object) this.usuarios;
  }

  /**
   * Obtiene los usuarios referentes al tipo indicado
   *
   * @param tipo Cadena que indica el tipo de usuario a obtener
   * @return una lista con todos los usuarios del tipo indicado en el contenedor
   */
  public List<Usuario> obtenerUsuariosPorTipo(String tipo) {
    List<Usuario> unTipoDeUsuarios = new ArrayList<>();
    if (tipo.equalsIgnoreCase("cliente")) {
      for (Asesoria u : this.usuarios) {
        // Checkear si es Cliente antes de agregar.
        if (u instanceof Cliente) {
          Usuario toAdd = (Usuario) u;
          unTipoDeUsuarios.add(toAdd);
        }
      }
    }
    if (tipo.equalsIgnoreCase("administrativo")) {
      for (Asesoria u : this.usuarios) {
        // Checkear si es Administrativo antes de agregar.
        if (u instanceof Administrativo) {
          Usuario toAdd = (Usuario) u;
          unTipoDeUsuarios.add(toAdd);
        }
      }
    }
    if (tipo.equalsIgnoreCase("profesional")) {
      for (Asesoria u : this.usuarios) {
        // Checkear si es Profesional antes de agregar.
        if (u instanceof Profesional) {
          Usuario toAdd = (Usuario) u;
          unTipoDeUsuarios.add(toAdd);
        }
      }
    }
    return unTipoDeUsuarios;
  }

  /**
   * Devuelve una lista con las capacitaciones almacenadas
   *
   * @return Lista con de objectos Capacitacion
   */
  public List<Capacitacion> obtenerCapacitaciones() {
    return this.capacitaciones;
  }

  /**
   *
   * @return TRUE si contenedor de Usuarios se encuentra vacio.
   */
  public boolean contenedorUsuariosVacio(){
    return this.usuarios.isEmpty();
  }

  /**
   *
   * @return TRUE si contenedor de Capacitaciones se encuentra vacio.
   */
  public boolean contenedorCapacitacionesVacio(){
    return this.capacitaciones.isEmpty();
  }
}
