--INSERT INTO `mydb`.`usuario` (`clave`, `nombre`, `puntos_ejercicios`, `puntos_respuestas`) VALUES ('12345', 'Luis', '200', '100');
--INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('54321', 'Ana');
--INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('2468', 'Rosa');
--INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('8642', 'Carlos');
INSERT INTO usuario values ('1', NULL, 'Hernández', '$2a$10$2ao1OWFir.7au7lq0ANlCOG06ECWOvje/dbVkO0vhPIZ4H/O2K2oS', '2023-05-12', NULL, 'admin@gmail.com', NULL, 'admin', '100', '0');


INSERT INTO `mydb`.`rol` (`name`) VALUES ('USER');
INSERT INTO `mydb`.`rol` (`name`) VALUES ('ADMIN');
INSERT INTO users_roles values (1,2);


INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo, imagen)
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
VALUES ('What is 18 multiplied by 2?', '1', '20', '30', '36', '42', '400', '36','Multiplication Exercise 8');

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

