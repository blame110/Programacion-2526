
USE peliculas_marcadiz;
CREATE TABLE IF NOT EXISTS critico (
    id          INT NOT NULL AUTO_INCREMENT,
    nombre      VARCHAR(100) NOT NULL,
    medio       VARCHAR(100) NOT NULL,
    anyo_inicio INT NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS critico_has_pelicula (
    critico_id  INT NOT NULL,
    pelicula_id INT NOT NULL,
    puntuacion  INT NOT NULL,   -- puntuación del 1 al 10
    PRIMARY KEY (critico_id, pelicula_id),
    CONSTRAINT fk_critico_has_pelicula_critico
        FOREIGN KEY (critico_id)
        REFERENCES critico (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT fk_critico_has_pelicula_pelicula
        FOREIGN KEY (pelicula_id)
        REFERENCES pelicula (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
) ENGINE = InnoDB;


INSERT INTO critico (nombre, medio, anyo_inicio) VALUES
('Carlos Boyero',     'El País',         1980),
('Jordi Costa',       'El País',         1995),
('Beatriz Martínez',  'Fotogramas',      2002),
('Diego Galán',       'El País',         1970),
('Nuria Vidal',       'Fotogramas',      1988),
('Ángel Fdez. Santos','El Mundo',        1975),
('Javier Ocaña',      'El País',         2000),
('Luis Martínez',     'El Mundo',        1998);


-- Reseñas (usando los ids de las películas del examen anterior)
INSERT INTO critico_has_pelicula (critico_id, pelicula_id, puntuacion) VALUES
(1, 1, 9),
(1, 3, 7),
(1, 5, 8),
(2, 2, 10),
(2, 4, 9),
(3, 1,  8),
(3, 6,  7),
(4, 3,  6),
(4, 7,  9),
(5, 2,  8),
(5, 5, 10),
(6, 4,  7),
(6, 8,  8),
(7, 6,  9),
(7, 7,  8),
(8, 1,  7),
(8, 8,  9);



CREATE TABLE director ( id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL, nacionalidad VARCHAR(50) NOT NULL, anyo_nacimiento INT NOT NULL ); 
-- Se añade la FK en pelicula apuntando a director 
ALTER TABLE pelicula ADD COLUMN id_director INT, ADD CONSTRAINT fk_pelicula_director FOREIGN KEY (id_director) REFERENCES director(id);
 INSERT INTO director (nombre, nacionalidad, anyo_nacimiento) VALUES ('Steven Spielberg', 'Estadounidense', 1946), ('Pedro Almodóvar', 'Española', 1949), ('Hayao Miyazaki', 'Japonesa', 1941), ('Christopher Nolan','Británica', 1970), ('Isabel Coixet', 'Española', 1960);
INSERT INTO pelicula (titulo, clasificacion, duracion, sinopsis, id_director) VALUES
('La Lista de Schindler',  2, 195, 'Historia real durante el Holocausto.',        1),
('E.T. el extraterrestre', 1,  115, 'Un niño hace amistad con un alienígena.',    1),
('Todo sobre mi madre',    2, 101, 'Drama sobre identidad y pérdida.',            2),
('Volver',                 2,  95, 'Una mujer regresa a su pueblo natal.',        2),
('El viaje de Chihiro',    1, 125, 'Una niña en el mundo de los espíritus.',      3),
('Mi vecino Totoro',       1,  86, 'Dos niñas descubren criaturas del bosque.',   3),
('El Caballero Oscuro',    2, 152, 'Batman se enfrenta al Joker.',                4),
('Origen',                 2, 148, 'Un ladrón que roba secretos del subconsciente.', 4),
('La vida secreta de las palabras', 2, 112, 'Drama sobre trauma y soledad.',     5),
('Mapa de los sonidos de Tokio',    2,  89, 'Historia de amor y tragedia.',      5);



