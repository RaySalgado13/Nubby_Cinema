USE bgu9smpsgbze7uldszfh;

START TRANSACTION;
    INSERT INTO usuarios VALUES(NULL,'rayito',MD5('123'));
    INSERT INTO clientes VALUES (
        NULL,
        1,
        'Raymundo',
        'Salgado',
        'rayfisher_@hotmail.com',
        '4431844783'
    );

    INSERT INTO usuarios VALUES(NULL,'sergito',MD5('456'));
    INSERT INTO clientes VALUES (
        NULL,
        2,
        'Sergio',
        'Mendez',
        'sergito@hotmail.com',
        '4434826547'
    );

    INSERT INTO usuarios VALUES(NULL,'angelito',MD5('789'));
    INSERT INTO clientes VALUES (
        NULL,
        3,
        'Angel',
        'Ortiz',
        'angelito@hotmail.com',
        '4435981651'
    );
COMMIT;

--UPDATE usuarios SET contrasenia = MD5('123') WHERE id_usuario = 1;
UPDATE usuarios SET genero = 'H' WHERE id_usuario < 4;

--SELECT clientes.correo, usuarios.usuario FROM clientes INNER JOIN usuarios ON clientes.id_usuario=usuarios.id_usuario;
-------------------------------------
--correo        |       usuario
----------------|--------------------
--rayfsher@.....|        rayito
--...           |
--...           |
-------------------------------------

START TRANSACTION;
    INSERT INTO usuarios VALUES (
        NULL,
        'rayito',
        MD5('123'),
        'Raymundo',
        'Salgado',
        'rayfisher_@hotmail.com',
        '4431844783'
    );

    INSERT INTO usuarios VALUES (
        NULL,
        'sergito',
        MD5('456'),
        'Sergio',
        'Mendez',
        'sergito@hotmail.com',
        '4434826547'
    );

    INSERT INTO usuarios VALUES (
        NULL,
        'angelito',
        MD5('789'),
        'Angel',
        'Ortiz',
        'angelito@hotmail.com',
        '4435981651'
    );
COMMIT;

START TRANSACTION;
    INSERT INTO generos VALUES(
        NULL,
        'Comedia'
    );
    INSERT INTO generos VALUES(
        NULL,
        'Suspenso'
    );
    INSERT INTO generos VALUES(
        NULL,
        'Terror'
    );
    INSERT INTO generos VALUES(
        NULL,
        'Accion'
    );
    INSERT INTO generos VALUES(
        NULL,
        'Infantil'
    );
    INSERT INTO generos VALUES(
        NULL,
        'Sci-Fi'
    );
    INSERT INTO generos VALUES(
        NULL,
        'Drama'
    );
    INSERT INTO generos VALUES(
        NULL,
        'Romance'
    );
    INSERT INTO generos VALUES(
        NULL,
        'Adolescentes'
    );
COMMIT;

START TRANSACTION;
    INSERT INTO peliculas VALUES(
        NULL,
        'Los Croods 2: Una Nueva Era',
        95,
        'A',
        '2021-01-01',
        '2021-01-25',
        5,
        'Joel Crawford',
        'Los Croods necesitan un nuevo lugar donde vivir, por lo que viajan por el mundo en busca de un lugar más seguro al que puedan llamar hogar.'
    );

    INSERT INTO peliculas VALUES(
        NULL,
        'Mujer Maravilla 1984',
        151,
        'B',
        '2021-01-01',
        '2021-03-01',
        4,
        'Patty Jenkins',
        'La nueva aventura cinematográfica de Mujer Maravilla nos transporta instantáneamente a la década de los 80, en la que enfrentará a dos nuevos enemigos'
    );

    INSERT INTO peliculas VALUES(
        NULL,
        'El Día del Fin del Mundo',
        120,
        'C',
        '2021-01-01',
        '2021-03-01',
        4,
        'Roman Waugh',
        'El mundo se enfrenta a la lluvia de meteoritos más grande de la historia y aniquilará todo rastro de vida, los gobiernos del mundo realizan un sorteo donde los afortunados podrán sobrevivir'
    );

    INSERT INTO peliculas VALUES(
        NULL,
        'Estación Zombie 2: Península',
        116,
        'C',
        '2021-01-01',
        '2021-02-16',
        2,
        'Sang-ho Yeon',
        'Jun-seok es un exsoldado que logra escapar de la Península a Hong Kong y acepta una oferta tentadora de un extranjero que lo hace regresar a la Península'
    );

    INSERT INTO peliculas VALUES(
        NULL,
        'El Baile de los 41',
        116,
        'C',
        '2021-01-01',
        '2021-02-16',
        7,
        'David Pablos',
        'Ignacio lleva una doble vida: es miembro de una sociedad clandestina mientras asciende en el tradicional mundo de la política'
    );

    INSERT INTO peliculas VALUES(
        NULL,
        'El Tiempo Contigo',
        112,
        'A',
        '2021-01-01',
        '2021-01-23',
        9,
        'Makoto Shinkai',
        'Un adolescente se escapa a Tokio y entabla una amistad con una joven que parece ser capaz de manipular el clima. '
    );
COMMIT;

START TRANSACTION;
    INSERT INTO salas VALUES(
        NULL,
        'Normal',
        78
    );
    INSERT INTO salas VALUES(
        NULL,
        'VIP',
        '60'
    );
    INSERT INTO salas VALUES(
        NULL,
        'Premium',
        78
    );
    INSERT INTO salas VALUES(
        NULL,
        'Macro',
        78
    );
    INSERT INTO salas VALUES(
        NULL,
        '3D',
        78
    );
COMMIT;

START TRANSACTION;
    INSERT INTO funciones VALUES(
        NULL,
        1,
        1,
        '2021-01-20',
        '09:15',
        NULL,
        57
    );

    INSERT INTO funciones VALUES(
        NULL,
        1,
        4,
        '2021-01-23',
        '11:00',
        NULL,
        70
    );

    INSERT INTO funciones VALUES(
        NULL,
        1,
        5,
        '2021-01-29',
        '10:30',
        NULL,
        75
    );

    ----------------

    INSERT INTO funciones VALUES(
        NULL,
        2,
        1,
        '2021-01-20',
        '14:15',
        NULL,
        57
    );

    INSERT INTO funciones VALUES(
        NULL,
        2,
        4,
        '2021-01-23',
        '13:50',
        NULL,
        70
    );

    INSERT INTO funciones VALUES(
        NULL,
        2,
        5,
        '2021-01-29',
        '16:00',
        NULL,
        75
    );

    ----------------------

    INSERT INTO funciones VALUES(
        NULL,
        3,
        1,
        '2021-01-20',
        '11:25',
        NULL,
        57
    );

    INSERT INTO funciones VALUES(
        NULL,
        3,
        4,
        '2021-01-23',
        '13:00',
        NULL,
        70
    );

    INSERT INTO funciones VALUES(
        NULL,
        3,
        5,
        '2021-01-29',
        '13:00',
        NULL,
        75
    );

    -------------------------

    INSERT INTO funciones VALUES(
        NULL,
        4,
        1,
        '2021-01-20',
        '13:05',
        NULL,
        57
    );

    INSERT INTO funciones VALUES(
        NULL,
        4,
        4,
        '2021-01-23',
        '14:00',
        NULL,
        70
    );

    INSERT INTO funciones VALUES(
        NULL,
        4,
        5,
        '2021-01-29',
        '9:00',
        NULL,
        75
    );

    ---------------------------
    INSERT INTO funciones VALUES(
        NULL,
        5,
        1,
        '2021-01-20',
        '12:20',
        NULL,
        57
    );

    INSERT INTO funciones VALUES(
        NULL,
        5,
        4,
        '2021-01-23',
        '15:50',
        NULL,
        70
    );

    INSERT INTO funciones VALUES(
        NULL,
        5,
        5,
        '2021-01-29',
        '9:00',
        NULL,
        75
    );
--------------------------------------
INSERT INTO funciones VALUES(
        NULL,
        6,
        1,
        '2021-01-20',
        '13:05',
        "10:20",
        57
    );

    INSERT INTO funciones VALUES(
        NULL,
        6,
        4,
        '2021-01-23',
        '11:00',
        NULL,
        70
    );

    INSERT INTO funciones VALUES(
        NULL,
        6,
        5,
        '2021-01-29',
        '13:00',
        NULL,
        75
    );
COMMIT;

START TRANSACTION;

    INSERT INTO sucursales VALUES(
        NULL,
        'Morelia Centro'
    );

    INSERT INTO sucursales VALUES(
        NULL,
        'Plaza Morelia'
    );

    INSERT INTO sucursales VALUES(
        NULL,
        'Morelia Andador'
    );
COMMIT;

START TRANSACTION;

    INSERT INTO sucursales_has_funciones VALUES(
        1,15
    );
    INSERT INTO sucursales_has_funciones VALUES(
        1,13
    );
    INSERT INTO sucursales_has_funciones VALUES(
        1,5
    );
    INSERT INTO sucursales_has_funciones VALUES(
        1,20
    );
    INSERT INTO sucursales_has_funciones VALUES(
        1,9
    );
    INSERT INTO sucursales_has_funciones VALUES(
        1,3
    );
    INSERT INTO sucursales_has_funciones VALUES(
        1,21
    );
    INSERT INTO sucursales_has_funciones VALUES(
        1,12
    );
    INSERT INTO sucursales_has_funciones VALUES(
        1,1
    );


    INSERT INTO sucursales_has_funciones VALUES(
        2,5
    );
    INSERT INTO sucursales_has_funciones VALUES(
        2,10
    );
    INSERT INTO sucursales_has_funciones VALUES(
        2,3
    );
    INSERT INTO sucursales_has_funciones VALUES(
        2,12
    );
    INSERT INTO sucursales_has_funciones VALUES(
        2,24
    );
    INSERT INTO sucursales_has_funciones VALUES(
        2,13
    );
    INSERT INTO sucursales_has_funciones VALUES(
        2,18
    );
    INSERT INTO sucursales_has_funciones VALUES(
        2,21
    );
    INSERT INTO sucursales_has_funciones VALUES(
        2,17
    );


    INSERT INTO sucursales_has_funciones VALUES(
        3,20
    );
    INSERT INTO sucursales_has_funciones VALUES(
        3,16
    );
    INSERT INTO sucursales_has_funciones VALUES(
        3,7
    );
    INSERT INTO sucursales_has_funciones VALUES(
        3,1
    );
    INSERT INTO sucursales_has_funciones VALUES(
        3,22
    );
    INSERT INTO sucursales_has_funciones VALUES(
        3,13
    );
    INSERT INTO sucursales_has_funciones VALUES(
        3,3
    );
    INSERT INTO sucursales_has_funciones VALUES(
        3,18
    );
    INSERT INTO sucursales_has_funciones VALUES(
        3,11
    );
COMMIT;