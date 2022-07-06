package org.loshuasostech.ui;

import org.loshuasostech.helpers.SetOperation;
import org.loshuasostech.logic.Contenedor;
import org.loshuasostech.modelos.*;

import java.util.Scanner;

/**
 * @author Los Huasos TECH
 * @version 0.1
 * @since 01-07-2022
 */
public class TextUI {
  private final Scanner scanner;
  private final Contenedor contenedor;

  public TextUI(Scanner scanner, Contenedor contenedor) {
    this.scanner = scanner;
    this.contenedor = contenedor;
  }

  /**
   * Inicia el programa y despliega el menu principal, solicita por teclado al
   * usuario que escoja una opcion, y verifica que se encuentre en el rango
   * correcto antes de procesarla.
   */
  public void start() {
    while (true) {
      System.out.println("*********************************");
      System.out.println("*      Ingrese una opcion:      *");
      System.out.println("*********************************");
      System.out.println("| 1) Almacenar cliente          |");
      System.out.println("| 2) Almacenar profesional      |");
      System.out.println("| 3) Almacenar administrativo   |");
      System.out.println("| 4) Almacenar capacitacion     |");
      System.out.println("| 5) Eliminar usuario           |");
      System.out.println("| 6) Listar usuarios            |");
      System.out.println("| 7) Listar usuarios por tipo   |");
      System.out.println("| 8) Listar capacitaciones      |");
      System.out.println("| 0) Salir                      |");
      System.out.println("*********************************");
      System.out.print(" > ");
      String input = scanner.nextLine();

      if (input.equals("0")) {
        System.out.println("Adios!");
        break;
      } else if (input.matches("[1-8]")) {
        procesarInput(input);
      }
    }
  }

  /**
   * Procesa el input ingreasdo por el usuario desde el Menu principal y realiza
   * accion acorde.
   *
   * @param input corresponde una Cadena que contiene un numero del 1-8,
   *              verificado previamente.
   */
  private void procesarInput(String input) {
    if (input.equals("1")) {
      almacenarCliente();
    }
    if (input.equals("2")) {
      almacenarProfesional();
    }
    if (input.equals("3")) {
      almacenarAdministrativo();
    }
    if (input.equals("4")) {
      almacenarCapacitacion();
    }
    if (input.equals("5")) {
      eliminarUsuario();
    }
    if (input.equals("6")) {
      listarUsuarios();
    }
    if (input.equals("7")) {
      listarPorTipo();
    }
    if (input.equals("8")) {
      listarCapacitaciones();
    }
  }

  /**
   * Muestra por pantalla las capacitaciones almacenadas segun formato.
   */
  private void listarCapacitaciones() {
    if (!this.contenedor.contenedorCapacitacionesVacio()) {
      for (Capacitacion c : this.contenedor.obtenerCapacitaciones()) {
        System.out.println("==============================");
        System.out.println("ID Capacitacion : " + c.getId());
        c.mostrarDetalle();
        System.out.println("\n==============================");
        System.out.println(" +++ Clientes: +++ ");
        System.out.println("--------------------");
        for (Usuario u : this.contenedor.obtenerUsuarios()) {
          if (u.getRun() == Integer.parseInt(c.getRutCliente())) {
            System.out.println(u);
            System.out.println("--------------------");
          }
        }
      }
    } else {
      System.out.println("\n < No existen registros de capacitaciones > \n");
    }
  }

  /**
   * Solicita al usuario que indique un tipo de usuario y muestra por pantalla
   * los datos obtenidos para todos los usuarios que pertenezcan a este tipo.
   */
  private void listarPorTipo() {
    if (!this.contenedor.contenedorUsuariosVacio()) {
      System.out.println("Que tipo de Usuario desea listar:");
      System.out.println(" 1) Cliente");
      System.out.println(" 2) Profesional");
      System.out.println(" 3) Administrativo");

      String input = scanner.nextLine();

      if (input.equals("1")) {
        System.out.println("--- Cliente(s) encontrado(s): ----");
        this.contenedor.obtenerUsuariosPorTipo("cliente")
                .forEach(Usuario::analizarUsuario);
      } else if (input.equals("2")) {
        System.out.println("--- Profesional(es) encontrado(s): ----");
        this.contenedor.obtenerUsuariosPorTipo("Profesional")
                .forEach(Usuario::analizarUsuario);
      } else if (input.equals("3")) {
        System.out.println("--- Administrativo(s) encontrado(s): ----");
        this.contenedor.obtenerUsuariosPorTipo("Administrativo")
                .forEach(Usuario::analizarUsuario);
      } else {
        System.out.println("Opcion no valida");
      }
      System.out.println();
    } else {
      System.out.println("\n < Primero debe ingresar usuarios al registro > \n");
    }
  }

  /**
   * Solicita por teclado el rut de un usuario y lo elimina del contenedor de ser
   * posible, mostrando un mensaje de exito.
   */
  private void eliminarUsuario() {
    if (!this.contenedor.contenedorUsuariosVacio()) {
      while (true) {
        String rutAEliminar = validarNoVacio("Indique el RUT");
        try {
          boolean borrado =
                  this.contenedor.eliminarUsuario(Integer.parseInt(rutAEliminar));
          if (borrado) {
            System.out.println("\nUsuario eliminado exitosamente!\n");
          }
          break;
        } catch (NumberFormatException e) {
          System.out.println("Debe Ingresar un numero");
        }
      }
    } else {
      System.out.println("\n < No existen registros de usuarios > \n");
    }
  }

  /**
   * Muestra por pantalla la informacion basica de todos los usuarios
   * ingresados, obtenidos desde el contenedor.
   */
  private void listarUsuarios() {
    if (!this.contenedor.contenedorUsuariosVacio()) {
      System.out.println("--- Usuarios actualmente registrados ---");
      for (Usuario usuario : this.contenedor.obtenerUsuarios()) {
        System.out.println("---------------------------");
        System.out.println("Nombre          : " + usuario.getNombre());
        System.out.println("RUT             : " + usuario.getRun());
        System.out.println("Fecha nacimiento: " + usuario.getFechaNacimiento());
      }
      System.out.println("---------------------------");
      System.out.println();
    } else {
      System.out.println("\n < Primero debe ingresar usuarios al registro > \n");
    }
  }

  /**
   * Solicita la informacion necesaria para almacenar un nuevo Cliente,
   * la valida y asigna mediante el metodo validar().
   */
  private void almacenarCliente() {
    Cliente cliente = new Cliente();
    System.out.println("Ingrese la informacion del nuevo cliente: ");

    validar(cliente::setNombre, "Nombre");
    validar(cliente::setApellidos, "Apellido");
    validar(cliente::setFechaNacimiento, "Fecha Nacimiento (DD/MM/AAAA)");
    validar(cliente::setRun, "RUN");
    validar(cliente::setTelefono, "Telefono");
    validar(cliente::setAfp, "AFP");
    validar(cliente::setSistemaSalud, "Sistema de salud [1|2]");
    validar(cliente::setDireccion, "Direccion");
    validar(cliente::setComuna, "Comuna");
    validar(cliente::setEdad, "Edad");

    this.contenedor.almacenarCliente(cliente);
    System.out.println("\nCliente almacenado con exito!\n");

  }

  /**
   * Solicita la informacion necesaria para almacenar un nuevo Profesional,
   * la valida y asigna mediante el metodo validar().
   */
  private void almacenarProfesional() {
    Profesional pro = new Profesional();
    System.out.println("Ingrese la informacion del nuevo Profesional: ");

    validar(pro::setNombre, "Nombre");
    validar(pro::setFechaNacimiento, "Fecha Nacimiento (DD/MM/AAAA)");
    validar(pro::setRun, "RUN");
    validar(pro::setTitulo, "Titulo");
    validar(pro::setFechaIngreso, "Fecha Ingreso (DD/MM/AAAA)");

    this.contenedor.almacenarProfesional(pro);
    System.out.println("\nProfesional almacenado con exito!\n");
  }

  /**
   * Solicita la informacion necesaria para almacenar un nuevo Administrativo,
   * la valida y asigna mediante el metodo validar().
   */
  private void almacenarAdministrativo() {
    Administrativo admin = new Administrativo();
    System.out.println("Ingrese la informacion del nuevo Administrativo: ");

    validar(admin::setNombre, "Nombre");
    validar(admin::setFechaNacimiento, "Fecha Nacimiento (DD/MM/AAAA)");
    validar(admin::setRun, "RUN");
    validar(admin::setArea, "Area");
    validar(admin::setExpPrevia, "Experiencia previa");

    this.contenedor.almacenarAdministrativo(admin);
    System.out.println("\nAdministrativo almacenado con exito!\n");
  }

  /**
   * Solicita la informacion necesaria para almacenar una nueva capacitacion,
   * la valida y asigna mediante el metodo validar().
   */
  private void almacenarCapacitacion() {
    Capacitacion capa = new Capacitacion();
    System.out.println("Ingrese la informacion para una nueva capacitacion: ");

    validar(capa::setId, "Identificador");
    validar(capa::setRutCliente, "RUT Cliente");
    validar(capa::setDia, "Dia");
    validar(capa::setHora, "Hora (HH:MM)");
    validar(capa::setLugar, "Lugar");
    validar(capa::setDuracion, "Duracion (min)");
    validar(capa::setCantidadAsistentes, "Cantidad Asistentes");

    this.contenedor.almacenarCapacitacion(capa);
    System.out.println("\nCapacitacion almacenada con exito!\n");
  }

  /**
   * Realiza validaciones correspondientes al metodo recibido por medio de la
   * interfaz funcional y se asegura que la informacion recibida cumpla con las
   * condiciones impuestas en dicho metodo.
   *
   * @param operation corresponde al metodo setter a procesar.
   * @param prompt    Cadena que representa la consulta realizada al usuario.
   */
  private void validar(SetOperation operation, String prompt) {
    while (true) {
      String data = validarNoVacio(prompt);
      try {
        operation.apply(data);
        break;
      } catch (NumberFormatException e) {
        System.out.println(" < Debe ingresar un numero > ");
      } catch (IllegalArgumentException e) {
        System.out.println(" < " + e.getMessage() + " > ");
      }
    }
  }

  /**
   * Realiza una solicitud de informacion al usuario basada en la cadena recibida,
   * se asegura de obtener un valor no vacio antes de devolverlo.
   *
   * @param aValidar Hace referencia a la consulta hacia el usuario.
   * @return Una Cadena con la respuesta del usuario, que nunca sera vacia.
   */
  private String validarNoVacio(String aValidar) {
    String dato;
    while (true) {
      System.out.print(aValidar + ": ");
      dato = scanner.nextLine();
      if (!dato.isEmpty()) {
        return dato;
      }
      System.out.println(" < Este campo es obligatorio > ");
    }
  }
}
