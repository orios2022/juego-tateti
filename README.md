# juego-tateti
<b><h3>Aplicación de Escritorio Java - Juego TaTeTi</h3></b>
Juego desarrollado para Plataforma Java y mediante API Java Standar Edition.
La misma se desarrolló implementado una arquitectura MVC para una mayor independencia entre sus componentes y/o paquetes de clases, facilidad en el mantenimiento en caso de errores y posibilitando el escalamiento de la aplicación en caso de ser requerido.<br>
Además la misma cuenta con conexión a base de datos mediante MySQL y la utilización de procedimientos almacenados, aunque esto último no es necesario ya que no habrá sobrecarga resultante de comunicar grandes cantidades de datos salientes y entrantes por tratarse de una aplicación de escritorio con fines lúdicos. <br>
También se tiene en cuenta la interactividad con el usuario, ofreciéndole un entorno intuitivo y con imágenes y sonidos acordes al juego.
A continuación, se detalla en simples pasos la configuración de la BBDD requerida para un mejor uso de la aplicación. <b><br>
Puntualmente acá consultaras el historial de partidas ganadas entre los dos bandos (cruz y circulo);
<b><h3>BASE DE DATOS</h3></b>
<b><p>1) Creación de la BBDD en servidor MySQL denominándola <i>estadistica</i></p></b>
<b><p>2) Creación de la tabla:</p></b>
create table estadistica (<br>
cruz int,<br>
circulo int<br>
)<br>
<b><p>2) Creación de los procedimientos almacenados:</p></b>
CREATE PROCEDURE USP_INSERTAR_TATETI (<br>
cz int,<br>
cr int<br>
)<br>
BEGIN<br>
INSERT INTO estadistica (cruz, circulo)<br>
VALUES(cz, cr);<br>
END<br><br>
CREATE PROCEDURE USP_PUNTAJE_TATETI ()<br>
BEGIN<br>
SELECT sum(cruz), sum(circulo) FROM estadistica<br>
END<br><br>
CREATE PROCEDURE ELIMINAR_AHORCADO ()<br>
BEGIN<br>
delete from historial;<br>
END
