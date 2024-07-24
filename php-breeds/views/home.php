<?php include_once("./views/templates/document-start.php");?>
<h2>¿Que es Breeds?</h2>
<p>Es una app de preguntas y respuestas para averiguar las razas de distintos animales, pero también records, bellezas y sube la foto de tu mascota a un ranking</p>
<p><a href="https://play.google.com/store/apps/details?id=es.tipolisto.msxquiz" target="_banck">Descarga la app de aquí</a></p>

<h2>Records</h2>
<p>Compite para ver quien saca más records por animal<a href="<?php echo PATHSERVER."Score/showAll" ?>">este ranking</a></p>
<p>Una vez abierta selecciona el animal con el que quieres jugar y responde a las preguntas</p>
<img src="<?php echo PATHIMAGES ?>0.png" height="500px"/>
<p>Cuando aciertes conseguirás puntos que verás en la parte superior, si has creado un nuevo record se te preguntará el nombre</p>
<img src="<?php echo PATHIMAGES ?>1.png" height="500px"/>
<p>Si pinchas en el menú principal en Ranking, verás tu puntuación maxima y la posibilidad de subirla a internet, en el siguiente ejemplo ada ha conseguido 166 puntos,
Al pinchar en "Subir máxima puntuación a internet" se te pedirá el usuario y contraseña si no has iniciado sesión</p>
<img src="<?php echo PATHIMAGES ?>2.png" height="500px"/>
<p>Una vez aprobado se quedará grabado en internet, puedes ver la tabla de records o ranking pinchando en el enlace que está encima del botón o  <a href="<?php echo PATHSERVER."Score/showAll"; ?>">aquí</a></p>
<img src="<?php echo PATHIMAGES ?>4.png" height="500px"/>

<h2>bellezas / Beauties</h2>
<h2>Sube la foto de tu mascota</h2>
<p>Si te registras en la app o en la web pinchando <a href="<?php echo PATHSERVER."Auth/register" ?>">Aquí</a></p>
<p>Puedes subir la foto de tu animal para que otros la puntuen en <a href="<?php echo PATHSERVER."Score/showAll"; ?>">este ranking</a></p>
<img src="<?php echo PATHIMAGES ?>5.png" height="500px"/>

<?php include_once("./views/templates/document-end.php");?>
		






















			



