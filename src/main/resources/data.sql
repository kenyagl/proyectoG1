INSERT INTO `mydb`.`usuario` (`clave`, `nombre`, `puntos_ejercicios`, `puntos_respuestas`) VALUES ('12345', 'Luis', '200', '100');
INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('54321', 'Ana');
INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('2468', 'Rosa');
INSERT INTO `mydb`.`usuario` (`clave`, `nombre`) VALUES ('8642', 'Carlos');

INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 3 times 4?', '1', '6', '9', '12', '15', '100', '12','Multiplication Exercise 1');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 7 times 9?', '2', '42', '54', '63', '72', '100', '63','Multiplication Exercise 2');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 5 times 6?', '1', '25', '30', '35', '40', '150', '30','Multiplication Exercise 3');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 8 times 11?', '2', '72', '80', '88', '96', '200', '88','Multiplication Exercise 4');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 12 multiplied by 6?', '2', '62', '68', '72', '76', '250', '3','Multiplication Exercise 5');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 7 multiplied by 11?', '3', '69', '72', '77', '81', '300', '4','Multiplication Exercise 6');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 3 multiplied by 13?', '2', '34', '36', '39', '41', '350', '2','Multiplication Exercise 7');
INSERT INTO mydb.ejercicio_op_mul (descripcion, dificultad, opcion1, opcion2, opcion3, opcion4, puntos_acceso, respuesta_correcta,titulo)
VALUES ('What is 18 multiplied by 2?', '1', '20', '30', '36', '42', '400', '3','Multiplication Exercise 8');

INSERT INTO `mydb`.`categoria_ejercicios` (`nombre`) VALUES ('String');
INSERT INTO `mydb`.`categoria_ejercicios` (`nombre`) VALUES ('Array');
INSERT INTO `mydb`.`categoria_ejercicios` (`nombre`) VALUES ('Clases y Objetos');
INSERT INTO `mydb`.`categoria_ejercicios` (`nombre`) VALUES ('POO');
INSERT INTO `mydb`.`categoria_ejercicios` (`nombre`) VALUES ('Herencia');

