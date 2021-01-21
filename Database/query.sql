
SELECT B.id_boleto, P.nombre_pelicula, F.dia, F.hora_inicio, SL.nombre AS nombre_sala

FROM boletos B
INNER JOIN funciones F ON B.id_funcion = F.id_funcion
INNER JOIN peliculas P ON F.id_pelicula = P.id_pelicula
INNER JOIN salas SL ON F.id_sala = SL.id_sala

WHERE B.id_usuario = 1;