# Sistema de Acceso a Servicios Remotos de Persistencia
El objetivo del proyecto consistió en poner en funcionamiento un sistema distribuido que realice una invocación remota de métodos que incluyan el acceso a una base de datos. Para ello, se realizó un sistema que transacciones bursátiles de compra-venta de acciones en una casa de bolsa de valores. Esta aplicación está organizada en 3 capas:

- **Cliente**: esta capa es responsable de solo administrar la interfaz de usuario y se comunica con el servidor para la obtención de los portaforios de inversiones y las llamadas de las funciones de compra-venta de acciones.

- **Servidor**: funciona como el gestor de las decisiones que realiza el programa como la resolución de las competencias de propuestas de transaccioón y genera las acciones correspondientes para la actualización y consulta de la base de datos.

- **Base de datos**: contiene las tablas *compañías* que corresponde a lista de compañías que cotizan en la casa de bolsa, *usuarios* que contiene la información correspondiente al portafolio de inversiones de cada usuario, y  *transacciones* que contiene el registro de las transacciones realizadas por el operador de la bolsa a solicitud de los usuarios. 

Para ver más detalles del diseño, vea la sección ![**ESPECIFICACIÓN DE DISEÑO**](https://github.com/EdwinFajardoBarrera/SDFInal/blob/master/ESPECIFICACIÓN%20DE%20DISEÑO.zip)

## Instrucciones de uso

### Instalación

Las tres capas del sistema (cliente, servidor, datos) fueron desarrollados en el lenguaje de programación **Java**. También es necesario crear una base de datos para el archivo **bolsadevalores.sql**, el cual puede manejarse mediante un servidor web (como [XAMPP](https://www.apachefriends.org/es/index.html)).

El programa necesita ser 
