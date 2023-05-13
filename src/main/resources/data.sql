INSERT INTO usuario values
    ('1', NULL, 'Master', '$2a$10$2ao1OWFir.7au7lq0ANlCOG06ECWOvje/dbVkO0vhPIZ4H/O2K2oS', '2023-05-12', 'Vengo aquí a motivarme para aprender Java', 'admin@gmail.com', 'result-0.png', 'Kosso', '100', '100'),
    ('2', NULL, 'Hernández', '$2a$10$YnjxiddygjqkDTOCiu9UH.FAkZRQiDdd7crUoQvSOE1mBwdsarUIq', '2023-05-13', 'Vengo aquí a motivarme para aprender Java', 'pepeher@gmail.com', 'profile.jpg', 'Pepe', '300', '200');



INSERT INTO `mydb`.`rol` (`name`) VALUES ('user');
INSERT INTO `mydb`.`rol` (`name`) VALUES ('admin');
INSERT INTO users_roles values (1,2), (2,1);

---Ejercicios

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
VALUES
('¿Qué comando resulta en este mensaje en la terminal?', '1', 'System out print line ("Hello World");', 'System.out.println("Hello World");', 'print ("Hello World")', 'System.out.print.ln("Hello World")', '0', 'System.out.println("Hello World");','Hello World','ejemploEjercicio.png'),
('¿Cómo se declara un número entero en Java?', '1', 'var entero = 1;', 'let entero = 1;', 'int entero = 1;', 'string entero = "1";', '100', 'int entero = 1;','Número entero', null),
('¿Cuál es la sintaxis correcta para un condicional "if" en Java?', '1', 'if (condition) { }', 'if { } else { }', 'if (condition) then { }', 'if (condition) { } else', '200', 'if (condition) { }','Bucle if','if-loop.png'),
('¿Cómo se llama el método que se ejecuta automáticamente al crear un objeto en Java?', '2', 'constructor', 'init()', 'new()', 'create()', '300', 'constructor','Métodos','metodo-objeto.png'),
('¿Qué método se utiliza para leer una entrada de datos desde el usuario en Java?', '2', 'read()', 'input()', 'getInput()', 'Scanner()', '400', 'Scanner()','Entrada de datos', null),
('¿Cuál es la sintaxis correcta para crear un bucle "for" en Java?', '2', 'for (condition) { }', 'for (update) { }', 'for (initialization; condition)', 'for (initialization; condition; update) { }', '500', 'for (initialization; condition; update) { }','Bucle for', null),
('¿Qué método se utiliza para imprimir un mensaje de error en Java?', '2', 'error.print()', 'System.err.print()', 'System.out.error()', 'print.error()', '600', 'System.err.print()','Mensaje de error', null),
('¿Qué palabra clave se utiliza para declarar una clase en Java?', '3', 'type', 'class', 'struct', 'interface', '700', 'class','Declarar una clase',null),
('¿Qué es un "wrapper class" en Java?', '3', 'Una clase que envuelve un objeto complejo', 'Una clase que envuelve un objeto primitivo', 'Una clase que se utiliza para implementar interfaces', 'Una clase que se utiliza para controlar excepciones', '800', 'Una clase que envuelve un objeto primitivo','Clase Wrapper',null),
('¿Cuál es la sintaxis correcta para crear un array unidimensional en Java?', '3', 'int[] arr = {1, 2, 3};', 'int arr[] = new int[3];', 'int arr[] = {1, 2, 3};', 'array arr = new array[3];', '900', 'int[] arr = {1, 2, 3};','Arrays',null),
('¿Qué significa la sigla "POO" en Java?', '2', 'Programación orientada a objetos', 'Programación operativa ordenada', 'Programación ortodoxa original', 'Programación óptima de objetos', '1000', 'Programación orientada a objetos','POO en Java',null),
('¿Cuál es la sintaxis para un bucle "for" en Java?', '2', 'for (i = 0; i <= 10; i++) { }', 'for (i <= 10; i++;) { }', 'for (i = 0; i <= 10; i = i + 1) { }', 'for (i <= 10; i = i + 1;) { }', '1100', 'for (i = 0; i <= 10; i = i + 1) { }','Bucle for en Java',null),
('¿Cuál es el operador lógico "OR" en Java?', '2', '&&', '!', '||', '&', '1200', '||','Operador lógico OR',null),
('¿Cuál es la sintaxis para crear un objeto en Java?', '3', 'MyClass myObj = new MyClass();', 'MyClass myObj = MyClass();', 'new MyClass myObj = new();', 'new MyClass();', '1300', 'MyClass myObj = new MyClass();','Crear objeto en Java',null),
('¿Cuál es el modificador de acceso que permite el acceso a cualquier clase o paquete en Java?', '3', 'public', 'private', 'protected', 'package', '1400', 'public','Modificador de acceso en Java',null),
('¿Qué significa la palabra clave "static" en Java?', '3', 'Se refiere a una variable o método compartido entre todas las instancias de una clase', 'Indica que una variable o método es privado', 'Crea una instancia de una clase', 'Establece una conexión de base de datos', '1500', 'Se refiere a una variable o método compartido entre todas las instancias de una clase','Palabra clave "static" en Java',null),
('¿Qué es un objeto en Java?', '2', 'Una instancia de una clase', 'Una variable global', 'Una función matemática', 'Un operador lógico', '1600', 'Una instancia de una clase', 'Objetos en Java', null),
('¿Cuál es el operador que se usa para comparar dos valores en Java?', '2', '==', '!=', '<>', '><', '1700', '==', 'Operadores en Java', null),
('¿Cómo se llama el proceso de convertir un objeto en un tipo de dato primitivo en Java?', '3', 'Parseo', 'Casting', 'Transformación', 'Conversión', '1800', 'Casting', 'Casting en Java', null),
('¿Qué hace el método "substring" en Java?', '3', 'Convierte un string en un número', 'Extrae una subcadena de un string', 'Concatena dos strings', 'Reemplaza una parte de un string', '1900', 'Extrae una subcadena de un string', 'Métodos de String en Java', null),
('¿Qué es una excepción en Java?', '3', 'Un error de sintaxis', 'Un mensaje de advertencia', 'Un error en tiempo de ejecución', 'Un problema con la conexión a Internet', '2000', 'Un error en tiempo de ejecución', 'Excepciones en Java', null),
('¿Cuál es el resultado de la operación 5 % 2 en Java?', '4', '2', '1', '2.5', '0.5', '2100', '1', 'Operadores en Java', null),
('¿Qué hace el operador "&" a nivel de bits en Java?', '4', 'Realiza una operación de suma', 'Realiza una operación de resta', 'Realiza una operación de multiplicación', 'Realiza una operación de AND', '22000', 'Realiza una operación de AND', 'Operadores a nivel de bits en Java', null);

---Categorías de ejercicios y preguntas

INSERT INTO `mydb`.`categoria` (`nombre`)
VALUES
    ('String'), ('Array'), ('Clases y Objetos'), ('POO'), ('Herencia'), ('Básicos'), ('Bucles');

--- Categorías de ejercicios

INSERT INTO `mydb`.`ejercicio_categoria`(`id_ejercicio_op_mul`, `id_categoria`)
    VALUES
    ('1', '6'),
    ('2', '6'),
    ('3', '6'), ('3', '7'),
    ('4', '6'), ('4', '4'), ('4', '3'),
    ('5', '6'),
    ('6', '6'), ('6', '7'),
    ('7', '6'),
    ('8', '3'), ('8', '6'),
    ('9', '3'), ('9', '6'),
    ('10', '6'), ('10', '2');



-- Inserción de preguntas

INSERT INTO `preguntas` (`titulo_pregunta`, `texto_pregunta`, `foto`, `fecha_pregunta`, `votos`, `id_usuario`)
VALUES
    ('¿Cuál es la diferencia entre un objeto y una clase en Java?', 'No entiendo bien la diferencia entre un objeto y una clase en Java. ¿Podrían explicármelo?', 'foto1.jpg', '2023-05-13', 0, 1),
    ('¿Cómo se declara una variable en Java?', 'Soy nuevo en Java y no sé cómo se declara una variable. ¿Alguien podría ayudarme?', 'foto1.jpg', '2023-05-13', 0, 1),
    ('¿Qué es un bucle for en Java?', 'He oído hablar del bucle for en Java, pero no sé exactamente qué es. ¿Podrían explicármelo?', 'foto1.jpg', '2023-05-13', 0, 1),
    ('¿Cómo se manejan las excepciones en Java?', 'Me han dicho que Java tiene un sistema para manejar excepciones, pero no sé cómo funciona. ¿Alguien podría darme una idea?', 'foto1.jpg', '2023-05-13', 0, 1),
    ('¿Cómo se lee entrada del usuario en Java?', 'Quiero saber cómo puedo leer la entrada que ingrese un usuario en Java. ¿Alguien sabe cómo hacerlo?', 'foto1.jpg', '2023-05-13', 0, 1);
/*('¿Cuáles son las mejores técnicas de estudio para mejorar el rendimiento académico?', 'Estoy buscando consejos y técnicas efectivas para mejorar mi rendimiento en los estudios. ¿Qué estrategias han funcionado bien para ustedes?', 'foto1.jpg', '2023-05-12', 0, 1),
('¿Qué opciones de carrera son ideales para alguien con habilidades en programación?', 'Tengo habilidades en programación y me gustaría saber qué opciones de carrera son las más adecuadas para aprovechar al máximo mis habilidades. ¿Alguna sugerencia?', 'foto2.jpg', '2023-05-12', 0, 1),
('Recomendaciones de libros de ciencia ficción para leer este verano', 'Estoy buscando recomendaciones de libros de ciencia ficción interesantes para disfrutar durante mis vacaciones de verano. ¿Cuáles son algunos de tus favoritos?', 'foto3.jpg', '2023-05-12', 0, 1),
('¿Cuáles son los mejores destinos turísticos para visitar en Europa?', 'Planeo hacer un viaje a Europa y estoy buscando recomendaciones sobre los mejores lugares para visitar. ¿Cuáles son tus destinos favoritos en Europa?', 'foto4.jpg', '2023-05-12', 0, 1),
('Consejos para mejorar la productividad en el trabajo desde casa', 'Trabajo desde casa y me gustaría conocer algunos consejos y técnicas para aumentar mi productividad y mantenerme enfocado. ¿Qué estrategias han funcionado para ustedes?', 'foto5.jpg', '2023-05-12', 0, 1);
*/



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

