
# F1 History
<title> ![Imagen no disponible](https://lh3.googleusercontent.com/-aTCvWBY2eS8/WRCraQ0aoYI/AAAAAAAAAAI/MDt3JUWZYTgKQcxS8CYKS5o0W-mcIr2cACL0B/h271/2017-05-08.png)</title>

# FUNCIONALIDAD


## Conexiones fuentes externas(API,URL,FIREBASE)
<p>Conexion Ergast api</p>
<a href="http://www.ergast.com/mrd">http://www.ergast.com</a>
<p>Conexion Firebase (google,facebook)</p>
<p>Fuente de las imagenes mediante url externa(pilotos,equipos)</p>
<a href="http://www.wikipedia.com">http://www.wikipedia.com</a>


## Menu Desplegable

### Settings
<p>Esta opcion solo es visible si se esta logeado en la App</p>
<p> Guarda configuracion mediante Shared preferences</p>
<p>Añadidas funcionalidades(Internacionalizacion,Cambio de color toolbar,Cambio vista del maps )</p>

### Año campeonato
<p>Esta opcion solo es visible si se esta logeado en la App</p>
<p>Una vez logueado, permite cambiar el año del campeonato y la aplicacion mostrara toda la informacion del año elegido (Defecto:2017) a excepcion de los Resultados</p>

### Login/Logout
<p>Login/logout implementado para la plataforma Facebook y Google</p>
<p>Logearse en la app conlleva las siguientes ventajas(Preferencias): Seleccion año campeonato,Guardar favoritos(Pilotos,Equipos,Circuitos)</p>

### Contact
<p>Implementado formulario para Enviar correo A la cuenta seleccionada en el codigo</p>
<p>Permite enviar correo siempre y cuando se tenga un cliente de correo instalado en el dispositivo</p>

### About
<p>Explicación del uso de la aplicacion y por quien ha sido realizada</p>

### Favoritos
<p>Se utiliza Shared preferences para guardar las configuraciones de favoritos</p>
<p>Esta opcion solo es visible si se esta logeado en la App</p>
<p>Esta funcion da la opcion al usuario de guardar tanto aquellos equipos pilotos o circuitos favoritos para que puedan ser guardados i visualizados con mas rapidez</p>

![Imagen no disponible](https://firebasestorage.googleapis.com/v0/b/daw-9ec9d.appspot.com/o/Menu.PNG?alt=media&token=a383c708-88e7-4769-a9db-fc34d9b0f7d1)

## Funcionalidad Vistas

### Main
<p>Implementada cuenta atras(Proxima carrera)"Clase fecha"</p>
<p>Acceso mediante botones a las siguientes vistas :</p>
<p>Circuitos,Resultados,Clasificacion,Pilotos,Equipos,Calendario</p>
![Imagen no disponible](https://firebasestorage.googleapis.com/v0/b/daw-9ec9d.appspot.com/o/Principal.PNG?alt=media&token=b16159a0-3f5f-4d44-98b7-f89178e01f39)

### Resultados
<p>Implementada funcionalidad para mostrar de la ultima carrera realizada(posicion,nombre,puntuacion)[Ergast api]</p>
![Imagen no disponible](https://firebasestorage.googleapis.com/v0/b/daw-9ec9d.appspot.com/o/Resultados.PNG?alt=media&token=3bfe60ea-aadc-4fc0-8a76-2c2a6afdefa3)

### Circuitos
<p>Cuenta con un gridView que muestra foto si existe i el identificador</p>
<p>Cuenta con otra vista detalles que implementa lo siguiente :</p>
<p>Implementada funcionalidad para mostrar(Maps del circuito con marquer incluido,Informacion basica del circuito,Url)[Ergast api]</p>
![Imagen no disponible](https://firebasestorage.googleapis.com/v0/b/daw-9ec9d.appspot.com/o/Circuitos.PNG?alt=media&token=ce52aedc-c0aa-42e6-9b84-dd7276286ee2)

### Clasificacion
<p>Implementada funcionalidad para mostrar(Posicion,Nombre(piloto o equipo),Puntos,Victorias)[Ergast api]</p>
![Imagen no disponible](https://firebasestorage.googleapis.com/v0/b/daw-9ec9d.appspot.com/o/Clasificacion.PNG?alt=media&token=915c0728-f3ef-4177-9a9c-6605d08d29bb)

### Pilotos
<p>Cuenta con un gridView que muestra foto si existe y el identificador</p>
<p>Cuenta con otra vista detalles que implementa lo siguiente :</p>
<p>Implementada funcionalidad para mostrar(Posicion,Nombre(piloto o equipo),Puntos,Victorias)[Ergast api]</p>
![Imagen no disponible](https://firebasestorage.googleapis.com/v0/b/daw-9ec9d.appspot.com/o/Pilotos.PNG?alt=media&token=64adb119-7157-42ed-ae91-1b5f3bd92b2d)


### Equipos
<p>Cuenta con un gridView que muestra foto si existe y el identificador</p>
<p>Cuenta con otra vista detalles que implementa lo siguiente :</p>
<p>Implementada funcionalidad para mostrar(Nombre equipo,Pais origen,informacion basica y url)[Ergast api]</p>
![Imagen no disponible](https://firebasestorage.googleapis.com/v0/b/daw-9ec9d.appspot.com/o/Equipos.PNG?alt=media&token=ac06d530-85f1-4266-93d8-5821915f0c98)


### Calendario
<p>Implementada funcionalidad para mostrar(Nombre carrera,Fecha,Hora)[Ergast api]</p>
![Imagen no disponible](https://firebasestorage.googleapis.com/v0/b/daw-9ec9d.appspot.com/o/Calendario.PNG?alt=media&token=6a3f5cfa-2815-49f0-af75-deccf4b35c94)



# RESUMEN DE TRABAJO F1History

<p>(Main) Realizado por : Alejandro Garcia, Jordi Sempere</p>
<p>(Circuitos) Realizado por :Alejandro Garcia, Jordi Sempere</p>
<p>(Maps Circuitos) Realizado por :Alejandro Garcia</p>
<p>(Pilotos) Realizado por :Alejandro Garcia,Jordi Sempere</p>
<p>(Equipos) Realizado por :Alejandro Garcia,Jordi Sempere</p>
<p>(Busqueda imagenes URL y cambios para correcta conexion) Realizado por :Jordi Sempere</p>
<p>(Clasificacion) Realizado por :Alejandro Garcia, Jordi Sempere</p>
<p>(Resultados) Realizado por :Alejandro Garcia</p>
<p>(Calendario) Realizado por :Alejandro Garcia, Jordi Sempere</p>
<p>(Login) Realizado por :Alejandro Garcia, Jordi Sempere</p>
<p>(Settings) Realizado por :Alejandro Garcia, Jordi Sempere</p>
<p>(Shared Preferences Settings (guardar y cargar)) Realizado por :Jordi Sempere</p>
<p>(Contact) Realizado por :Jordi Sempere</p>
<p>(About) Realizado por :Alejandro Garcia</p>
<p>(Año competicion) Realizado por :Alejandro Garcia</p>
<p>(Favoritos) Realizado por :Alejandro Garcia</p>
<p>(Shared Preferences Favoritos (guardar y cargar)) Realizado por :Alejandro Garcia</p>
<p>Conexiones(Firebase,API) Realizado por :Alejandro Garcia, Jordi Sempere</p>



