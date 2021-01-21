SELECT B.id_boleto AS numero_boleto, B.asiento, P.nombre_pelicula, F.dia, F.hora_inicio, SL.nombre AS nombre_sala, S.nombre AS nombre_sucursal

FROM boletos B
INNER JOIN funciones F ON B.id_funcion = F.id_funcion
INNER JOIN peliculas P ON F.id_pelicula = P.id_pelicula
INNER JOIN salas SL ON F.id_sala = SL.id_sala
INNER JOIN sucursales_has_funciones SHF ON SHF.id_funcion = F.id_funcion
INNER JOIN sucursales S ON S.id_sucursal = SHF.id_sucursal

WHERE B.id_usuario = 3
GROUP BY B.id_boleto
ORDER BY B.id_boleto


SELECT * FROM boletos WHERE id_usuario = 1;