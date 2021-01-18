START TRANSACTION;
    CREATE TABLE usuarios(
        id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        usuario VARCHAR(20) NOT NULL,
        contrasenia VARCHAR(200) NOT NULL
        nombre VARCHAR(100) NOT NULL,
        apellidos VARCHAR(200) NOT NULL,
        correo VARCHAR(100) NOT NULL,
        celular VARCHAR(10) NULL,
    );

    CREATE TABLE generos(
        id_genero INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        genero VARCHAR(80) NOT NULL
    );

    CREATE TABLE peliculas(
        id_pelicula INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        nombre_pelicula VARCHAR(50) NOT NULL,
        duracion_minutos FLOAT NOT NULL,
        categoria CHAR NOT NULL,
        fecha_estreno DATE NOT NULL,
        fecha_salida DATE NULL,
        id_genero INT NOT NULL,
        director VARCHAR(100) NULL,

        FOREIGN KEY (id_genero) REFERENCES generos(id_genero)
    );

    CREATE TABLE salas(
        id_sala INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        nombre VARCHAR(80) NOT NULL,
        numero_asientos INT NULL
    );

    CREATE TABLE funciones(
        id_funcion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        id_pelicula INT NOT NULL,
        id_sala INT NOT NULL,
        dia DATE NOT NULL,
        hora_inicio DATETIME NOT NULL,
        hora_fin DATETIME NULL,
        precio FLOAT NOT NULL,

        FOREIGN KEY (id_sala) REFERENCES salas(id_sala),
        FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula)
    );
    
    CREATE TABLE boletos(
        id_boleto BIGINT UNSIGNED NOT NULL PRIMARY KEY, --(id_sucursal)(DDMMAA)(id_pelicula)(id_sala)(fila[0-5])(asiento)
                                                        --216012153518
        id_funcion INT NOT NULL,
        id_usuario INT NOT NULL,
        asiento VARCHAR(3) NOT NULL,
        valido BOOLEAN NULL,

        FOREIGN KEY (id_funcion) REFERENCES funciones(id_funcion),
        FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) 
    );

    CREATE TABLE sucursales(
        id_sucursal INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        nombre VARCHAR(100) NOT NULL
    );

    CREATE TABLE sucursales_has_funciones(
        id_sucursal INT NOT NULL,
        id_funcion INT NOT NULL,

        FOREIGN KEY (id_sucursal) REFERENCES sucursales(id_sucursal)
        FOREIGN KEY (id_funcion) REFERENCES funciones(id_funcion)
    );
COMMIT;