# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021-2022)
**Autor/a:** Miguel Ángel Domínguez Ciero ; **uvus:** migdomcie

Este proyecto ha sido realizado con base en conjuntos de datos que abarcan, con grandes detalles, una secuencia de varios de los últimos nacimientos producidos en distintos hospitales de Andalucía. Su objetivo es el desarrollo de un programa capacitado para el óptimo tratamiento y gestión de datos en función de lo que el usuario (supongamos, en este caso, un funcionario) desee conocer para su posterior uso.

Concretamente, trabajaremos con datos específicos del hospital (registros) acerca de los recientes nacimientos, siendo éstos de la índole de especificaciones del hospital de nacimiento, el lugar y fecha de nacimiento, así como otros datos descriptivos físicos de los nacidos en función de su sexo.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto.
    * **fp.nacimentos**: Paquete que contiene los tipos correspondientes para la gestión de datos de los nacimientos.
    * **fp.nacimientos.test**: Paquete que contiene las clases de test de los tipos implementados en 'fp.nacimientos'.
    * **fp.utiles**:  Paquete que contiene las clases de utilidad (en este caso Checkers).  
* **/data**: Contiene el dataset o datasets del proyecto.
    * **Nacimientos.csv**: Archivos con los datos de los nacimientos en hospitales andaluces con los que vamos a trabajar.
    
## Estructura del *dataset*

El dataset con el que vamos a trabajar recoge los distintos registros de cada hospital que tratemos, para el cual supondrá una fila concreta. En cada una de estas filas existirán los correspondientes datos que tienen como título los niños/as nacidos/as en cada uno de dichos hospitales, estando cada fila formadas por 11 columnas, con la siguiente descripción:

* **Nombre**: de tipo String, representa el nombre propio del hospital en cuestión 
* **Tipo de Centro**: de tipo String, representa el tipo de hospital en cuestión 
* **Municipio**: de tipo String, representa el municipio en que está ubicado el hospital en cuestión
* **Provincia**: de tipo String, representa la provincia donde se ubica el hospital en cuestión
* **Fecha de nacimiento**: de tipo LocalDateTime representa el día de nacimiento de los nacidos
* **Hombres**: de tipo Integer, representa el número de niños nacidos en dicho hospital
* **Mujeres**: de tipo Integer, representa el número de niñas nacidos en dicho hospital
* **Promedio Peso Hombres (kg)**: de tipo Double, representa el promedio del peso de los niños nacidos en dicho hospital
* **Promedio Peso Mujeres (kg)**: de tipo Double representa el promedio del peso de las niñas nacidas en dicho hospital
* **Promedio estatura (cm)**: de tipo Double, representa el promedio de la estatura de los niños nacidos en dicho hospital 
* **Promedio estatura (cm)**: de tipo Double, representa el promedio de la estatura de las niñas nacidas en dicho hospital
* **helipuerto**: de tipo Boolean, representa si un hospital posee helipuerto o no.

## Tipos implementados

Los principales tipos implementados en este proyecto son el tipo correspondiente a la clase base 'Nacimiento', al igual que otros tipos auxiliares como el tipo correspondiente a la clase Enum 'TipoCentro', con el que se manejan los valores fijos acerca de los tipos de hospitales que pueden darse. 

### Tipo Base
El tipo 'Nacimiento' es descrito en la clase base del proyecto, en la que se encuentran cada una de las propiedades, métodos y/o interfaces que trabajan sobre el tipo del mismo nombre. Básicamente, en este tipo, tratamos con las propiedades de un nacimiento cualquiera, como el nombre del hospital en cuestión, la fecha de nacimiento, el número de nacimientos producidos por sexo... Además, en tal clase, a parte de las propiedades antes mencionadas, han sido declarados otros métodos como los que obtienen propiedades derivadas (como la edad), los métodos restrictivos, comparadores... 

**Propiedades**:

- **nombreHospital** de tipo String, consultable y modificable. 
- **tipoCentro** de tipo TipoCentro, consultable. 
- **municipio** de tipo String, consultable y modificable.
- **provincia** de tipo String, consultable y modificable.
- **fecha** de tipo LocalDate, consultable y modificable.
- **nHombres** de tipo Integer, consultable y modificable.
- **nMujeres** de tipo Integer, consultable y modificable.
- **promedioPesoH** de tipo Double, consultable y modificable.
- **promedioPesoM** de tipo Double, consultable y modificable.
- **promedioAltH** de tipo Double, consultable y modificable.
- **promedioAltM** de tipo Double, consultable y modificable.
- **helipuerto** de tipo Boolean, consultable y modificable.
 
Propiedades derivadas: 
 
- ** edad()** de tipo Integer, método que calcula la edad de las personas nacidas en tal fecha.
- **sumaNacimientos()** de tipo Integer, método que calcula el total de nacimientos producidos para el mismo registro(sin distinción de géneros).m

**Constructores**:

- **C1**: recibe un parámetro por cada propiedad del tipo..
- **C2**: recibe solo los parámetros del nombre del hospital, la provincia, el municipio y la fecha de nacimiento (el resto de propiedades queda con valor '0' y '0.0' si son de tipo Integer y Double, respectivamente, excepto la propiedad helipuerto, que queda por defecto con valor 'false'.)

**Restricciones**:
 
- **compruebanH()**: mediante este método se comprueba que el número de hombres no sea negativa.
- **compruebanM()**: mediante este método se comprueba que el número de mujeres no sea negativa.
- **compruebaPesoH()**: mediante este método se comprueba que el peso de los hombres no sea negativa.
- **compruebaPesoM()**: mediante este método se comprueba que el peso de las mujeres no sea negativa.
- **compruebaAlturaH()**: mediante este método se comprueba que la altura de los hombres no sea negativa.
- **compruebaAlturaM()**: mediante este método se comprueba que la altura de las mujeres no sea negativa.
- **compruebaHelipuerto()**: mediante este método se comprueba que el helipuerto no tenga valor 'null'..

**Criterio de igualdad**:

Mediante los métodos '.equals()' y '.hashCode' sabremos si dos objetos de tipo 'Nacimiento' son iguales, que será en el caso de que coincidan tanto el nombre del hospital, como la fecha de nacimiento, el número de nacimientos de hombres y el de mujeres. 

**Criterio de ordenación**:

Mediante el método procedente de la interfaz 'Comparable<>', '.compareTo()' sabremos si un objeto tiene preferencia sobre otro en su orden natural, que será en función al nombre del hospital, si coinciden, en función a la fecha de nacimiento, si coinciden de nuevo, en función al número de nacimientos de hombres y, si coincidieran también, en función al número de nacimientos de mujeres..

## Tipos auxiliares 

Además del tipo 'Nacimiento', que es descrito en la clase base del proyecto, hemos declarado en la clase Enum el tipo 'TipoCentro', con el que se manejan los valores fijos de los tipos de hospitales que pueden darse para la propiedad 'tipoCentro': *COMARCAL*,*CONCERTADO*,*ESPECIALIDADES*, *REGIONAL*. 
