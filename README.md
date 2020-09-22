
# **Laboratorio 5 - MVC Primefaces Introduction - 2020-2**
### Joel Carvajal - Johan Rueda
## Parte I. - Jugando a ser un cliente HTTP
Abrimos una consola de comandos windows e ingresamos el código

    telnet www.escuelaing.edu.co 80
 
Realizamos la solicitud `GET sssss/abc.html HTTP/1.0` La cual nos da como resultado:

![301 Moved permanently.](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/2.PNG)

Existen **Diferentes Status Codes en HTTP:**
 - [1xx Respuestas informativas](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes#1xx_informational_response):  
 > Petición recibida, continuando proceso. Esta respuesta significa que el servidor ha recibido los encabezados de la petición, y que el cliente debería proceder a enviar el cuerpo de la misma (en el caso de peticiones para las cuales el cuerpo necesita ser enviado.
 - [  2xx: Peticiones correctas](https://es.wikipedia.org/wiki/Anexo:C%C3%B3digos_de_estado_HTTP#2xx:_Peticiones_correctas):
> Esta clase de código de estado indica que la petición fue recibida correctamente, entendida y aceptada.
 - [3xx: Redirecciones](https://es.wikipedia.org/wiki/Anexo:C%C3%B3digos_de_estado_HTTP#3xx:_Redirecciones):
> El cliente tiene que tomar una acción adicional para completar la petición.
 - [4xx: Errores del cliente](https://es.wikipedia.org/wiki/Anexo:C%C3%B3digos_de_estado_HTTP#4xx:_Errores_del_cliente):
 > La solicitud contiene sintaxis incorrecta o no puede procesarse.
 - [ 5xx: Errores de servidor](https://es.wikipedia.org/wiki/Anexo:C%C3%B3digos_de_estado_HTTP#5xx:_Errores_de_servidor):
> El servidor falló al completar una solicitud aparentemente válida.

Ahora realizaremos la siguiente conexión  `telnet www.httpbin.org 80` y realizamos la petición: `GET /html HTTP/1.1`:

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/3.PNG)

Obviamente la petición GET es insuficiente así que también tenemos la petición POST las cuales se diferencian en la forma de enviar los datos a la página cuando se pulsa el botón “Enviar”. Mientras que el método **GET** envía los datos usando la URL, el método **POST** los envía de forma que no podemos verlos (en un segundo plano u "ocultos" al usuario).
tambien existen **peticiones** como:
- [GET](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/GET): El método `GET` solicita una representación de un recurso específico. Las peticiones que usan el método `GET`  sólo deben recuperar datos.
- [HEAD](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/HEAD) : El método  `HEAD`  pide una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta.
- [POST](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/POST): El método  `POST`  se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.
- [PUT](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/PUT): El modo `PUT` reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición.
- [DELETE](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/DELETE): El método `DELETE`  borra un recurso en específico.
- [CONNECT](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/CONNECT):El método `CONNECT`  establece un túnel hacia el servidor identificado por el recurso.
- [OPTIONS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/OPTIONS):El método `OPTIONS` es utilizado para describir las opciones de comunicación para el recurso de destino.
- [TRACE](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/TRACE): El método `TRACE` realiza una prueba de bucle de retorno de mensaje a lo largo de la ruta al recurso de destino.
- [PATCH](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/PATCH):El método `PATCH`  es utilizado para aplicar modificaciones parciales a un recurso.

si embargo En la practica no se utiliza `telnet` para hacer peticiones a sitios web sino el comando `curl` con ayuda de la linea de comandos `curl www.httpbin.org` que podemos usar con diferentes parámetros como:

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/curl-1.PNG)

 - `curl -v`: curl explicará y mostrará muchas más cosas.
 
 ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/curl-v.PNG)
 
 - `curl -i`:mostrara los conjuntos de encabezados que normalmente estan ocultos.
 
 ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/curl-i.PNG)
 
 ## Parte II. - Haciendo una aplicación Web dinámica a bajo nivel.
Creamos un proyecto en maven con el arquetipo de aplicación Web estándar maven-archetype-webapp.

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/mvncreacion.PNG)

luego de hacer las respectivas modificaciones a nuestro pom.xml Compilamos y ejecutamos la aplicación en el servidor embebido Tomcat, a través de Maven con:
```
mvn package
mvn tomcat7:run
```
obtemenos como resultado:
![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/mvnpackagecorrecto.PNG)

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/tomcatcorrecto.PNG)

abrimos un navegador y ponemos la URL con la cual se le enviarán peticiones al ‘SampleServlet’, ademas de adicionar a esta un petición GET y opcional-mente el parámetro 'name':

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/helloServletcorrecto.PNG)

ahora vamos a introducir la URL con la cual se le enviaran peticiones a 'jojoServlet' con el parámetro id:

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/jjservletcorrecto.PNG)
 
en caso de no poner este parametro veremos:
  
![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/jjservleterror.PNG)

## Parte III
creamos el archivo `index.html` en el directorio `src/main/webapp/index.html`:

    <!DOCTYPE html>
    <html>
        <head>
            <title>Start Page</title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        </head>
    	<script>
    	function validateForm() {
    		var x = document.forms["form"]["id"].value;
    		if (x == "") {
    			alert("campo vacio");
    			return false;
    		}
    	}
    	</script>
        <body bgcolor="black">
    	<center>
    		<h2><font  face="Georgia, Arial" color="#ffffff"> Introduzca el ID </font></h2>
    		<form name="form" action="/jjServlet" method="get">
    			<input type="text" name="id" required>
    			<input type="submit" value="ENVIAR">
    		</form>
    	</center>
        </body>
    </html>
en primer caso usaremos el metodo POST:

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/indexpost.PNG)

y luego el metodo GET:

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/indexget.PNG)

como vemos la diferencia es como envia los parametros, esto lo notamos con el URL.

## Parte IV. - Frameworks Web MVC – Java Server Faces / Prime Faces
vamos a realizar el proyecto de una calculadora estadística, para esto creamos el proyecto con el arquetipo antes mencionado.

 1. En nuestro caso esta sera nuestra calculadora estadística muy simple:
 
 ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/aceptacionreiniciar.PNG)
 
 3. realizaremos algunas pruebas de aceptación.
 
 ***calcular:***

![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/aceptacioncalcular.PNG) 		

***Reiniciar:***
 
 ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/aceptacionreiniciar.PNG)


 4. Probaremos en dos navegadores diferentes:

  ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/pruevanavegador.PNG)

 5. con anotación @ApplicationScoped:

 ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/aceptacionreiniciar.PNG)
 
 6. con anotación @SessionScoped:

 ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/sessionscopped.PNG)
 
 7. buscaremos nuestro elemento oculto:
 
  ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/numerooculto.PNG)
  
 8. por ultimo añadiremos una tabla que nos guarde los números ingresados anteriormente.

  ![](https://github.com/johanrueda/CVDS-LAB5/blob/master/Imagenes/tabla.PNG)




## Biblografia

 - https://es.wikipedia.org/wiki/Anexo:Códigos_de_estado_HTTP
 - https://developer.mozilla.org/es/docs/Web/HTTP/Methods
 - https://ec.haxx.se/usingcurl/usingcurl-verbose