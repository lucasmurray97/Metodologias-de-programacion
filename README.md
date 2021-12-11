# Aventuras de Marcos y Luis

#### Lucas Murray H.

Proyecto semestral CC3002. Implementación de "Mario and Luigi". En src se encuentran
todas las clases/interfaces desarrolladas y que definen el modelo. En test, todos las
pruebas de lo implementado hasta la fecha.


##### Para Compilar:

- Ejecutar el gradle build. 

- Ejecutar el build project.

#### Para ejecutar la Gui:

- Ir a al paquete GUI, y ejecutar el main del archivo App.java.

##### Main

En este archivo se implementaron todas las clases que componen el funcionamiento de la aplicación, cada
una está descrita y documentada, sin embargo las principales son:

- Protagonistas: Marcos y Luigi
- Enemigos: Goomba, Boo y Spiny.
- Items: RedMushroom, Honey Syrup y Star.
- BagPack: Corresponde a la mochila que comparten los protagonistas del juego.
- Battle: Implementa la lógica de una batalla entre los personajes y sus enemigos.
- Game: Implementa la lógica del juego completo y corresponde al controlador.

##### ¿Como funciona?

###### Entrega 1:

Actualmente la aplicación permite crear todos los personajes que se mencionaron y
permite a los protagonistas recoger, almacenar y utilizar items. Considera restricciones
de integralidad en las distintas variables que componen a los personajes
e implementa clases abstractas e interfaces que garantizan el correcto funcionamiento
de los métodos programados. Existen avances por sobre los requisitos de la entrega, cómo 
la clase BagPack y detalles en las construcciones de los personajes.

###### Entrega 2:

- Se implementó toda la dinámica de ataques entre personajes, considerando todas las restricciones asociadas al 
quién puede atacar a quién.
- Se implementó un characterState pattern para los personajes, en donde la actividad que puede realizar un personaje está 
restringida por el estado en el que está: Alive o Knocked Out.
- Se implementó el sistema de turnos correspondiente a una batalla, en donde el flujo es controlado a través de un
characterState design pattern design, donde cada turno es un estado de la batalla, a lo cual se añade el estado de fin de la batalla.
- Se implementó el flujo de una partida, nuevamente a través de un characterState pattern, en donde una partida puede encontrarse en 4 estados:
preparando una batalla, en batalla, GameOver y HasWon. Nuevamente, las funcionalidades de una batalla están restringidas
al estado en batalla y la creación de batallas, aumento de nivel, agregación de items para batalla y aumento de score al estado de preparacion de 
batallas.

###### Entrega 3:

- Se implementaron dos observers: uno para el manejo de la muerte de personajes en batalla y otro para cuando una batalla se da por finalizada.
- Se implementó todo el manejo de excepciones asociado al modelo.
- Se implementó un NullObjectPattern para personajes y batallas.
- Se implementó una interfaz gráfica básica del juego.

##### Supuestos
Se supuso que existe una relación entre el nivel de un personaje y las variables que lo definen, acá
se muestra el cómo se implementó:

```
public void setLvl(int lvl) {
    this.lvl = lvl;
    this.maxHp = (int) (this.baseHp*Math.pow(1.1,this.lvl));
    this.maxAtk = (int) (this.baseAtk*Math.pow(1.1,this.lvl));
    this.maxDef = (int) (this.baseDef*Math.pow(1.1,this.lvl));
}
```
Este supuesto se incorporó en los requerimientos de la entrega, pero se mantuvo la forma en que se implementó.

Se supuso que se reinician las stats de los personajes principales antes de cada batalla, esto a través del método
```revive()```.

##### Testeo

Todos los test se encuentran en "test". Para revisarlos, apretar click derecho en
test/java y seleccionar "Run 'All Tests'".

##### Detalles:
En la GUI se utilizó casting para la siguiente situación:
```
this.game.chooseTargetMarcos((AttackableByMarcos) enemy);
this.game.chooseTargetLuigi((AttackableByLuigi) enemy);
```
Lo anterior, debido a que a priori solo se sabe que los elementos del arreglo characters en la batalla son de tipo Character. Sin embargo, la interfaz restringe la elección para el usuario de manera que no se genere nunca un caso en donde no se pueda
realizar el cast. Por ejemplo, se generaría un error en el caso de que enemy fuera Boo y se tratase de castear a AttackableByLuigi, sin embargo para los turnos de luigi NO es posible elegir a Boo porque este no se presenta
dentro de las opciones de elección.
