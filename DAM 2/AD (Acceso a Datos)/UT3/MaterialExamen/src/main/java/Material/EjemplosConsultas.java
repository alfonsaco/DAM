/*
  ---------------------- SQL -------------------------
  select c.codigociclista, c.nombreciclista, e.codigoetapa, e.tipoetapa, t.codigotramo, t.nombretramo, t.categoria
    from ciclistas c join etapas e on c.codigociclista=e.ciclistaganador
                     join tramospuertos t on t.ciclistaganador=e.ciclistaganador
    where t.pendiente like '%5,5%'
    order by c.codigociclista;
 
 
  ====================== HQL =======================
	 SELECT c.codigociclista AS codigociclista,
	       c.nombreciclista AS nombreciclista,
	       e.codigoetapa AS codigoetapa,
	       e.tipoetapa AS tipoetapa,
	       t.codigotramo AS codigotramo,
	       t.nombretramo AS nombretramo,
	       t.categoria AS categoria
	FROM Ciclistas c
	JOIN c.etapases e
	JOIN c.tramospuertoses t
	WHERE t.pendiente LIKE '%5,5%'
	ORDER BY c.codigociclista

 
 
 
 ---------------------- SQL -------------------------
 
 ====================== HQL =======================
 	SELECT e.codigoetapa AS codigo,
       e.km AS km,
       e.pobsalida AS salida,
       e.pobllegada AS llegada,
       c.nombreciclista AS nombreCiclista
	FROM Etapas e
	JOIN e.ciclistas c
	WHERE (e.tipoetapa LIKE 'Media Montaña' OR e.tipoetapa LIKE 'Montaña')
	  AND e.pobsalida = e.pobllegada
 
 
 
  ---------------------- SQL -------------------------
  SELECT 
    q.codigoequipo, 
    c.nombreciclista, 
    q.nombreequipo, 
    COUNT(x.codigocamiseta) AS etapas_lunares
	FROM ciclistas c
	JOIN resumen_camisetas x ON c.codigociclista = x.codigociclista
	JOIN camisetas i ON x.codigocamiseta = i.codigocamiseta
	JOIN equipos q ON q.codigoequipo = x.codigoequipo
	WHERE i.color LIKE '%Lunares%'
	GROUP BY q.codigoequipo, c.nombreciclista, q.nombreequipo
	ORDER BY q.codigoequipo, c.nombreciclista;
 
  ====================== HQL =======================
  SELECT 
    q.codigoequipo AS codigoequipo,
    c.nombreciclista AS nombreciclista,
    q.nombreequipo AS nombreequipo,
    COUNT(i.codigocamiseta) AS etapas_lunares
	FROM ResumenCamisetas x
	JOIN x.ciclistas c
	JOIN x.camisetas i
	JOIN x.equipos q
	WHERE i.color LIKE '%Lunares%'
	GROUP BY q.codigoequipo, c.nombreciclista, q.nombreequipo
	ORDER BY q.codigoequipo, c.nombreciclista
	
	
	
	
	---------------------- SQL -------------------------
	select e.codigoequipo, e.nombreequipo, x.codigocamiseta, x.color, count(x.codigocamiseta)
    from equipos e join resumen_camisetas j on j.codigoequipo=e.codigoequipo
                   join camisetas x on x.codigocamiseta=j.codigocamiseta
    group by e.codigoequipo, e.nombreequipo, x.codigocamiseta, x.color
 
   	====================== HQL =======================
   	SELECT q.codigoequipo AS codigoequipo,
       q.nombreequipo AS nombreequipo,
       i.codigocamiseta AS codigocamiseta,
       i.color AS color,
       COUNT(i.codigocamiseta) AS veces
	FROM ResumenCamisetas r
	JOIN r.equipos q
	JOIN r.camisetas i
	GROUP BY q.codigoequipo, q.nombreequipo, i.codigocamiseta, i.color
	
	
	
		NOTA MEDIA
	select a.nombre, round(avg(m.notaasig),2) 
	from Alumnos a 
	left join a.matriculases m
	group by a.nombre

*/