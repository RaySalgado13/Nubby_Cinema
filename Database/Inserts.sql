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
UPDATE usuarios SET genero = 'H' WHERE id_usuario < 4