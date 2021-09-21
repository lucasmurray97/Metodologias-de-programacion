# Aventuras de Marcos y Luis

#### Lucas Murray H.

Proyecto semestral CC3002. Implementación de "Mario and Luigi". En src se encuentran
todas las clases/interfaces desarrolladas y que definen el modelo. En test, todos las
pruebas de lo implementado hasta la fecha.


##### Para Compilar:

- Ejecutar el gradle build. Esto tirará error, pero no se preocupe.

- Ejecutar en el terminal `./gradl ew --stop`

- Ejecutar el build project.

##### Main

En este archivo se implementaron todas las clases que componen el funcionamiento de la aplicación, cada
una está descrita y documentada, sin embargo las principales son:

- Protagonistas: Marcos y Luigi
- Enemigos: Goomba, Boo y Spiny.
- Items: RedMushroom, Honey Syrup y Star.

##### ¿Como funciona?

Actualmente la aplicación permite crear todos los personajes que se mencionaron y
permite a los protagonistas recoger, almacenar y utilizar items. Considera restricciones
de integralidad en las distintas variables que componen a los personajes
e implementa clases abstractas e interfaces que garantizan el correcto funcionamiento
de los métodos programados.

##### Testeo

Todos los test se encuentran en "test". Para revisarlos, apretar click derecho en
test/java y seleccionar "Run 'All Tests'".
