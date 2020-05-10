# Corrientazos Recruiting test for s4n.

## Problem

La empresa “Su corrientazo a domicilio” ha contratado a S4N para el desarrollo de
una aplicación capaz de operar 20 drones para que haga entrega de almuerzos a
diferentes direcciones en la ciudad de Bogotá.

“Su corrientazo domicilio”, ha decidido que sólo entregará domicilios a 10 cuadras a
la redonda de su barrio, el cual puede ser representado con un plano cartesiano. En
una siguiente etapa de la implementación se solicitará que se pueda ampliar o
reducir este número dependiendo de los resultados del negocio.

De esta manera, la posición del dron está representada por la combinación de
coordenadas X y Y y una letra que corresponde a uno de los puntos cardinales. Por
simplificación, el barrio puede ser visto como una grilla. Por ejemplo, (0,0,N)
corresponde a la posición del dron en la esquina inferior izquierda de la grilla
estando el dron apuntando en dirección norte.

El dueño de “Su corrientazo a domicilio” será el responsable de escribir los
movimientos del dron para llegar a cada destino de cada uno de los almuerzos en
el sistema. Su deseo es poder usar un archivo de texto donde anotará las rutas de
entrega correspondientes a todos los pedidos del día y así programar las entregas
que el dron deberá realizar en el transcurso del mismo.

Es importante aclarar que el dron es sólo capaz de cargar hasta tres almuerzos por
vez; también es importante aclarar que este número de almuerzos puede ampliarse
o reducirse dependiendo de los resultados del negocio. Por esta razón, y
aprovechando el profundo conocimiento del barrio, el dueño de “Su corrientazo a
domicilio” será quien defina las rutas de entrega en el archivo de texto.

### Example input

```bash
AAAAIAA
DDDAIAD
AAIADAD
```

### Output

```bash
== Reporte de entregas ==
    (-2, 4) dirección Occidente
    (-1, 3) dirección Sur
    (0, 0) dirección Occidente
```

## How to run
* copy all input files in folder `input/`
* execute
```bash
./gradlew run
````
* verify all output files on `output/`

## How to test
```bash 
./gradlew test --tests "co.s4n.corrientazos.*"
```
* verify all output files on `output_test/`

## License

```
MIT License

Copyright (c) 2020 Darwin Esteban Algarin Sarmiento

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
