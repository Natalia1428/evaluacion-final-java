# Sprint Final Módulo 4 [JAVA]

#### Desarrollado por Los Huasos TECH:

[Natalia Ponce](https://github.com/Natalia1428),
[Diego Saavedra](https://github.com/dleonDesarrollo),
[Cristóbal Pulgar](https://github.com/CristobalNPE).

## Contexto

Se necesita proveer una solución tecnologíca a una compañía
de asesorías en prevención de riesgos, que cuente con la
capacidad de manejar y almacenar la inscripción de diversos
tipos de usuario y capacitaciones.

## Solución

Para este fin se implementó una aplicación de interfaz de texto
capaz de cumplir con los requisitos antes mencionados de la
siguiente manera:

- Se definen diversas clases 'modelo' con sus propiedades representando a cada
  entidad que conforma el programa: Usuario, Cliente, Profesional,
  Administrativo, Capacitacion, Visitas en terreno y Revisión.
- También se definio una interfaz 'Asesoria' con el fin de
  agrupar los distintos tipos de usuario para su posterior análisis.
- Se definieron múltiples validaciones en los métodos mutadores
  con el objetivo de asignar los valores a cada entidad al momento
  de su creación según el formato requerido por el solicitante.
- Se creo una clase 'helper' simplificar la validación de los
  campos que requerian un formato específico, como fechas y horas.
- En la clase Contenedor, esta constituida la lógica del programa
  que permite ingresar, eliminar y consultar datos respecto de Usuarios
  y Capacitaciones.
- Para proporcionar al usuario final una manera ágil de manejar la
  aplicación, se creo una clase que almacena una interfaz de texto que
  muestra a dicho usuario los diferentes menus y opciones que el programa
  puede presentar.
- Finalmente, se creo una Interfaz Funcional que permitio llamar a
  los métodos mutadores desde el menu evitando repetición de código.

## Herramientas

- Java 15

