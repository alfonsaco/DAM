

1. Abrir el run sql
2. Ejecutar el comando: 
	connect con_sys/dam as sysdba
3. Ejecutar el comando
	create user NOMBRE identified by NOMBRE		+INTRO
	default tablespace users			+INTRO
	quota unlimited on users;			+INTRO
4. grant connect, resource to NOMBRE;
