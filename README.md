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

Los principales tipos implementados en este proyecto son el tipo correspondiente a la clase base 'Nacimiento', el tipo contenedor correspondiente a la clase 'Informes', al igual que otros tipos auxiliares como el tipo 'FactoríaNacimiento' y el correspondiente a la clase Enum 'TipoCentro', con el que se manejan los valores fijos acerca de los tipos de hospitales que pueden darse. 

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
 
- **edad()** de tipo Integer, método que calcula la edad de las personas nacidas en tal fecha.
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
- **compruebaHelipuerto()**: mediante este método se comprueba que el helipuerto no tenga valor 'null'.

**Criterio de igualdad**:

Mediante los métodos '.equals()' y '.hashCode' sabremos si dos objetos de tipo 'Nacimiento' son iguales, que será en el caso de que coincidan tanto el nombre del hospital, como la fecha de nacimiento, el número de nacimientos de hombres y el de mujeres. 

**Criterio de ordenación**:

Mediante el método procedente de la interfaz 'Comparable<>', '.compareTo()' sabremos si un objeto tiene preferencia sobre otro en su orden natural, que será en función al nombre del hospital, si coinciden, en función a la fecha de nacimiento, si coinciden de nuevo, en función al número de nacimientos de hombres y, si coincidieran también, en función al número de nacimientos de mujeres..

## Tipos auxiliares 

Además del tipo 'Nacimiento', que es descrito en la clase base del proyecto, hemos declarado en la clase Enum el tipo 'TipoCentro', con el que se manejan los valores fijos de los tipos de hospitales que pueden darse para la propiedad 'tipoCentro': *COMARCAL*,*CONCERTADO*,*ESPECIALIDADES*, *REGIONAL*, *PRIVADO*. 

### Factoría

En la clase 'FactoríaNacimiento' se encuentran algunos de los métodos estáticos auxiliares del proyecto que, a nivel general, trabajan sobre datos del tipo base 'Nacimiento' para su correcta adaptación y uso, como lo son los siguientes métodos:
- **leeNacimientos(String fichero)**: de tipo static List<Nacimiento>, método que lee cada una de las líneas del fichero csv, el cual es aportado su ruta como parámetro, que devuelve una lista de nacimientos.
- **parseaNacimiento (String s)**: de tipo static Nacimiento, método que trocea una línea del fichero csv que es aportada como parámetro y que, va asignando cada una de las propiedades del tipo 'Nacimiento' como variables para la posterior creación de un objeto del mismo tipo.
- **leeInformeStream(String fichero)**: de tipo static Informes, método que lee cada una de las líneas del fichero csv, el cual es aportado su ruta como parámetro, que devuelve un objeto del tipo contenedor Informes.

### Tipo Contenedor
El tipo 'Informes' es descrito en otra clase del proyecto, en la que se encuentran cada una de las propiedades, métodos y/o interfaces que trabajan sobre el tipo del mismo nombre. Básicamente, en este tipo, tratamos con las propiedades de un informe emitido por cualquier administración competente, como el nombre de la institución en cuestión, la fecha de emisión del informe, el número de serie de la institución que emite el informe, así como la lista de cada uno de los nacimientos que conforma el informe. Además, en tal clase, a parte de las propiedades antes mencionadas, han sido declarados métodos restrictivos, comparadores...
 
**Propiedades**
- **fechaEmisión** de tipo LocalDate, consultable y modificable. 
- **instituciónEmisora** de tipo String, consultable y modificable.
- **númeroInforme** de tipo Integer, consultable y modificable.
- **listaNacimientos** de tipo List<Nacimiento>, consultable.

Propiedades predeterminadas (métodos estáticos):
- **fechaPredetInforme()** de tipo LocalDate, devuelve la fecha a día de hoy.
- **numPredetInforme()** de tipo Integer, devuelve un número aleatorio de 8 cifras.
- **instituciónPredet()** de tipo String, devuelve la institución "Junta de Andalucía".
 
**Constructores**: 

- **C1**: recibe un parámetro por cada propiedad del tipo, excepto para la lista de nacimientos, que es inicializada como lista vacía.
- **C2**: recibe un parámetro por cada propiedad del tipo.
- **C3**: recibe un parámetro por cada propiedad del tipo, pasándose como último parámetro un stream de objetos del tipo base
 
**Restricciones**:
 
- **compruebaNúmeroInforme()**: mediante este método se comprueba que el número del informe no sea negativo y que tenga exactamente 8 cifras.

**Criterio de igualdad**: 

Mediante los métodos '.equals()' y '.hashCode' sabremos si dos objetos de tipo 'Informes' son iguales, que será en el caso de que coincidan tanto la fecha de emisión del informe, como el nombre de la institución emisora y el número de informe. 

**Criterio de ordenación**: 

Mediante el método procedente de la interfaz 'Comparable<>', '.compareTo()' sabremos si un objeto tiene preferencia sobre otro en su orden natural, que será en función a la fecha de emisión del informe, si coinciden, en función al nombre de la institución emisora, y si coinciden de nuevo, en función al número de informe.

**Otras operaciones**:
 
*Operaciones adicionales:*

- **getTamañoListaNacimientos()** de tipo Integer, método que calcula el tamaño de la propiedad que conforma la lista de nacimientos del informe.
- **añadeNacimiento(Nacimiento n)** de tipo void, método que añade a la propiedad que conforma la lista de nacimientos del informe el nacimiento que se pasa como parámetro.
- **añadeColeccionNacimientos(Collection<Nacimiento> c)** de tipo void, método que añade a la propiedad que conforma la lista de nacimientos del informe la colección de nacimientos que se pasa como parámetro.
- **eliminaNacimiento(Nacimiento n)** de tipo void, método que elimina de la propiedad que conforma la lista de nacimientos del informe el nacimiento que se pasa como parámetro.

*Métodos de tratamientos secuenciales:*

- **existeNacimiento(Nacimiento n)** de tipo Boolean, método que determina si el nacimiento pasado como parámetro se encuentra dentro de la propiedad que conforma la lista de nacimientos del informe en cuestión.


- **calculaNumeroNacimientosAño(String año)** de tipo Integer, método que calcula, en función al año pasado como parámetro, el número total de nacimientos producidos, de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión.


- **filtraHospitalesProvinciaHelipuerto(String provincia, Boolean helipuerto)** de tipo List<Nacimiento>, método que, en función a la provincia y valor de la propiedad helipuerto pasados como parámetros, devuelve una lista de hospitales, de entre los hospitales dados para los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión.


- **dicNacimientosProvincia()** de tipo Map<String,List<Nacimiento>>, método que devuelve un Map en el que las claves son las provincias de los nacimientos en cuestión y los valores asociados a cada clave es una lista de los nacimientos producidos en dicha provincia de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión.


- **dicCuentaNacimientosAño()** de tipo Map<Integer, Integer>, método que devuelve un Map en el que las claves son los años de los nacimientos en cuestión y los valores son el número total de nacimientos producidos en dicho año, de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **existeNacimientoStream(Nacimiento n)** de tipo Boolean, método que determina mediante el uso de la interfaz stream, si el nacimiento pasado como parámetro se encuentra dentro de la propiedad que conforma la lista de nacimientos del informe en cuestión


- **calculaNumeroNacimientosAñoStream(String año)** de tipo Integer, método que calcula mediante el uso de la interfaz stream el número total de nacimientos producidos en función al año pasado como parámetro, de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **filtraHospitalesProvinciaHelipuertoStream(String provincia, Boolean helipuerto)** de tipo List<Nacimiento>, método que en función a la provincia y valor de la propiedad helipuerto pasados como parámetros, mediante el uso de la interfaz stream, devuelve una lista de hospitales, de entre los hospitales dados para los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **calculaPesoMaximoProvinciaStream(String provincia)** de tipo Double, método que, mediante el uso de la interfaz stream, en función a una provincia pasada como parámetro, calcula el  mayor peso de una persona nacida de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **filtraNacimientosTipoHospitalFecha(String tipo)** de tipo List<Nacimieto>, método que en función al tipo de hospital de nacimiento, mediante el uso de la interfaz stream, devuelve una lista de nacimientos, de entre los hospitales dados para los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **dicNacimientosProvinciaStream()** de tipo Map<String, List<Nacimiento>>, método que, mediante el uso de la interfaz stream, devuelve un Map en el que las claves son las provincias de los nacimientos en cuestión y los valores asociados a cada clave son listas de los nacimientos producidos en dicha provincia de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **dicCuentaNacimientosAñoStream()** de tipo Map<Integer, Integer>, método que, mediante el uso de la interfaz stream, devuelve un Map en el que las claves son los años de los nacimientos en cuestión y los valores asociados a cada clave son el número total de nacimientos producidos en dicho año, de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **calculaMunicipiosDistintosStream()** de tipo Set<String>, método que, mediante el uso de la interfaz stream, devuelve un Set en el que los elementos son los municipios distintos de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **dicCalculaEdadEnMesesMinimaHospitalStream()** de tipo Map<String, Integer>, método que, mediante el uso de la interfaz stream, devuelve un Map en el que las claves son los hospitales de los nacimientos en cuestión y los valores asociados a cada clave son las edades mínimas, en meses, de las personas nacidas para dicho hospital, de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **dicMayoresAlturasProvinciaGénero(String género)** de tipo SortedMap<String, List<Double>>, método que, mediante el uso de la interfaz stream, en función al género que se pasa como parámetro, devuelve un Map en el que las claves son las provincias de los nacimientos en cuestión y los valores asociados a cada clave son listas de las mayores alturas de las personas nacidas para dicha provincia, de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión


- **maxDicCuentaHospitalesconHelipuertoProvincia()** de tipo Map.Entry<String, Long>, método que, mediante el uso de la interfaz stream, devuelve la entrada cuyo valor sea el mayor de entre el total de entradas de un Map en el que las claves son las provincias de los nacimientos en cuestión y los valores asociados a cada clave son el número total de nacimientos producidos cuyo hospital tiene helipuerto, de entre los nacimientos que conforman la propiedad del total de nacimientos del informe en cuestión
 .