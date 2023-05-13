--INSERT INTO `mydb`.`usuario` (`clave`, `nombre`, `puntos_ejercicios`, `puntos_respuestas`) VALUES ('12345', 'Luis', '200', '100');
--INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('54321', 'Ana');
--INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('2468', 'Rosa');
--INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('8642', 'Carlos');
INSERT INTO usuario values ('1', NULL, 'Hernández', '$2a$10$2ao1OWFir.7au7lq0ANlCOG06ECWOvje/dbVkO0vhPIZ4H/O2K2oS', '2023-05-12', NULL, 'admin@gmail.com', NULL, 'admin', '100', '0');


INSERT INTO `mydb`.`rol` (`name`) VALUES ('user');
INSERT INTO `mydb`.`rol` (`name`) VALUES ('admin');
INSERT INTO users_roles values (1,2);


/*INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Qué comando resulta en este mensaje en la terminal?', '1', 'System out print line ("Hello World");', 'System.out.println("Hello World");', 'print ("Hello World")', 'System.out.print.ln("Hello World")', '100', 'System.out.println("Hello World");','Ejercicio1','ejemploEjercicio.png');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 7 times 9?', '2', '42', '54', '63', '72', '100', '63','Multiplication Exercise 2');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 5 times 6?', '1', '25', '30', '35', '40', '150', '30','Multiplication Exercise 3');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 8 times 11?', '2', '72', '80', '88', '96', '200', '88','Multiplication Exercise 4');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 12 multiplied by 6?', '2', '62', '68', '72', '76', '250', '72','Multiplication Exercise 5');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 7 multiplied by 11?', '3', '69', '72', '77', '81', '300', '77','Multiplication Exercise 6');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 3 multiplied by 13?', '2', '34', '36', '39', '41', '350', '39','Multiplication Exercise 7');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 18 multiplied by 2?', '1', '20', '30', '36', '42', '400', '36','Multiplication Exercise 8');*/

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Qué comando resulta en este mensaje en la terminal?', '1', 'System out print line ("Hello World");', 'System.out.println("Hello World");', 'print ("Hello World")', 'System.out.print.ln("Hello World")', '0', 'System.out.println("Hello World");','Hello World','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cómo se declara un número entero en Java?', '1', 'var entero = 1;', 'let entero = 1;', 'int entero = 1;', 'string entero = "1";', '100', 'int entero = 1;','Número entero','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cuál es la sintaxis correcta para un condicional "if" en Java?', '1', 'if (condition) { }', 'if { } else { }', 'if (condition) then { }', 'if (condition) { } else', '200', 'if (condition) { }','Ejercicio2','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cómo se llama el método que se ejecuta automáticamente al crear un objeto en Java?', '2', 'constructor', 'init()', 'new()', 'create()', '300', 'constructor','Ejercicio3','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Qué método se utiliza para leer una entrada de datos desde el usuario en Java?', '2', 'read()', 'input()', 'getInput()', 'Scanner()', '400', 'Scanner()','Ejercicio4','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cuál es la sintaxis correcta para crear un bucle "for" en Java?', '2', 'for (initialization; condition; update) { }', 'for (condition) { }', 'for (update) { }', 'for (initialization; condition)', '600', 'for (initialization; condition; update) { }','Ejercicio5','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Qué método se utiliza para imprimir un mensaje de error en Java?', '2', 'error.print()', 'System.err.print()', 'System.out.error()', 'print.error()', '700', 'System.err.print()','Ejercicio6','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Qué palabra clave se utiliza para declarar una clase en Java?', '3', 'type', 'class', 'struct', 'interface', '800', 'class','Ejercicio7','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Qué es un "wrapper class" en Java?', '3', 'Una clase que envuelve un objeto primitivo', 'Una clase que envuelve un objeto complejo', 'Una clase que se utiliza para implementar interfaces', 'Una clase que se utiliza para controlar excepciones', '900', 'Una clase que envuelve un objeto primitivo','Ejercicio8','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cuál es la sintaxis correcta para crear un arreglo unidimensional en Java?', '3', 'int[] arr = {1, 2, 3};', 'int arr[] = new int[3];', 'int arr[] = {1, 2, 3};', 'array arr = new array[3];', '1000', 'int[] arr = {1, 2, 3};','Ejercicio9','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Qué significa la sigla "POO" en Java?', '2', 'Programación orientada a objetos', 'Programación operativa ordenada', 'Programación ortodoxa original', 'Programación óptima de objetos', '1100', 'Programación orientada a objetos','POO en Java','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cuál es la sintaxis para un bucle "for" en Java?', '2', 'for (i = 0; i <= 10; i++) { }', 'for (i <= 10; i++;) { }', 'for (i = 0; i <= 10; i = i + 1) { }', 'for (i <= 10; i = i + 1;) { }', '1200', 'for (i = 0; i <= 10; i = i + 1) { }','Bucle for en Java','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cuál es el operador lógico "OR" en Java?', '2', '||', '&&', '!', '&', '1300', '||','Operador lógico OR','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cuál es la sintaxis para crear un objeto en Java?', '3', 'MyClass myObj = new MyClass();', 'MyClass myObj = MyClass();', 'new MyClass myObj = new();', 'new MyClass();', '1400', 'MyClass myObj = new MyClass();','Crear objeto en Java','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Cuál es el modificador de acceso que permite el acceso a cualquier clase o paquete en Java?', '3', 'public', 'private', 'protected', 'package', '1500', 'public','Modificador de acceso en Java','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES ('¿Qué significa la palabra clave "static" en Java?', '3', 'Se refiere a una variable o método compartido entre todas las instancias de una clase', 'Indica que una variable o método es privado', 'Crea una instancia de una clase', 'Establece una conexión de base de datos', '1600', 'Se refiere a una variable o método compartido entre todas las instancias de una clase','Palabra clave "static" en Java','ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta, titulo, imagen)
VALUES ('¿Qué es un objeto en Java?', '2', 'Una instancia de una clase', 'Una variable global', 'Una función matemática', 'Un operador lógico', '1700', 'Una instancia de una clase', 'Objetos en Java', 'ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta, titulo, imagen)
VALUES ('¿Cuál es el operador que se usa para comparar dos valores en Java?', '2', '==', '!=', '<>', '><', '1800', '==', 'Operadores en Java', 'ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta, titulo, imagen)
VALUES ('¿Cómo se llama el proceso de convertir un objeto en un tipo de dato primitivo en Java?', '3', 'Parseo', 'Casting', 'Transformación', 'Conversión', '1900', 'Casting', 'Casting en Java', 'ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta, titulo, imagen)
VALUES ('¿Qué hace el método "substring" en Java?', '3', 'Convierte un string en un número', 'Extrae una subcadena de un string', 'Concatena dos strings', 'Reemplaza una parte de un string', '2000', 'Extrae una subcadena de un string', 'Métodos de String en Java', 'ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta, titulo, imagen)
VALUES ('¿Qué es una excepción en Java?', '3', 'Un error de sintaxis', 'Un mensaje de advertencia', 'Un error en tiempo de ejecución', 'Un problema con la conexión a Internet', '2100', 'Un error en tiempo de ejecución', 'Excepciones en Java', 'ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta, titulo, imagen)
VALUES ('¿Cuál es el resultado de la operación 5 % 2 en Java?', '4', '2', '1', '2.5', '0.5', '2200', '1', 'Operadores en Java', 'ejemploEjercicio.png');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta, titulo, imagen)
VALUES ('¿Qué hace el operador "&" a nivel de bits en Java?', '4', 'Realiza una operación de suma', 'Realiza una operación de resta', 'Realiza una operación de multiplicación', 'Realiza una operación de AND', '23000', 'Realiza una operación de AND', 'Operadores a nivel de bits en Java', 'ejemploEjercicio.png');


INSERT INTO `mydb`.`categoria` (`nombre`) VALUES ('String');
INSERT INTO `mydb`.`categoria` (`nombre`) VALUES ('Array');
INSERT INTO `mydb`.`categoria` (`nombre`) VALUES ('Clases y Objetos');
INSERT INTO `mydb`.`categoria` (`nombre`) VALUES ('POO');
INSERT INTO `mydb`.`categoria` (`nombre`) VALUES ('Herencia');



-- Inserción de preguntas

INSERT INTO `preguntas` (`titulo_pregunta`, `texto_pregunta`, `foto`, `fecha_pregunta`, `votos`, `id_usuario`)
VALUES

('¿Cuáles son las mejores técnicas de estudio para mejorar el rendimiento académico?', 'Estoy buscando consejos y técnicas efectivas para mejorar mi rendimiento en los estudios. ¿Qué estrategias han funcionado bien para ustedes?', 'foto1.jpg', '2023-05-12', 0, 1),
('¿Qué opciones de carrera son ideales para alguien con habilidades en programación?', 'Tengo habilidades en programación y me gustaría saber qué opciones de carrera son las más adecuadas para aprovechar al máximo mis habilidades. ¿Alguna sugerencia?', 'foto2.jpg', '2023-05-12', 0, 1),
('Recomendaciones de libros de ciencia ficción para leer este verano', 'Estoy buscando recomendaciones de libros de ciencia ficción interesantes para disfrutar durante mis vacaciones de verano. ¿Cuáles son algunos de tus favoritos?', 'foto3.jpg', '2023-05-12', 0, 1),
('¿Cuáles son los mejores destinos turísticos para visitar en Europa?', 'Planeo hacer un viaje a Europa y estoy buscando recomendaciones sobre los mejores lugares para visitar. ¿Cuáles son tus destinos favoritos en Europa?', 'foto4.jpg', '2023-05-12', 0, 1),
('Consejos para mejorar la productividad en el trabajo desde casa', 'Trabajo desde casa y me gustaría conocer algunos consejos y técnicas para aumentar mi productividad y mantenerme enfocado. ¿Qué estrategias han funcionado para ustedes?', 'foto5.jpg', '2023-05-12', 0, 1);




-- Inserción de relaciones con categorias

INSERT INTO `preguntas_categorias` (`pregunta_id`, `categorias_id_categoria_ejercicios`)

VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 2),
(3, 3),
(4, 1),
(5, 2);

