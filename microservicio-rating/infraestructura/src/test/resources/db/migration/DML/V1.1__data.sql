insert into books( id, title, author ) values( 1, 'Cien años de soledad', 'Gabriel Garcia Marquez' );
insert into books( id, title, author ) values( 2, 'Nerudianas', 'Pablo Neruda' );
insert into books( id, title, author ) values( 3, '20000 leguas de viaje submarino', 'Julio Verne' );

insert into ratings( id, id_book, stars ) values ( 1, 1, 5 );
insert into ratings( id, id_book, stars ) values ( 2, 1, 4 );
insert into ratings( id, id_book, stars ) values ( 3, 2, 3 );
insert into ratings( id, id_book, stars ) values ( 4, 3, 5 );


insert into cliente(id, nombre, tipo_cliente) values(1,'Cliente 1','PREFERENCIAL');
insert into cliente(id, nombre, tipo_cliente) values(2,'Cliente 2','COMUN');
insert into producto(id, nombre, aplica_iva, valor) values(1,'Producto 1',1, 25000);
insert into producto(id, nombre, aplica_iva, valor) values(2,'Producto 2',0, 10000);

insert into factura(id_cliente, valor_total, estado ) values(1, 25000, 'ACTIVA');
insert into factura(id_cliente, valor_total, estado ) values(2, 3000, 'ANULADA');
insert into producto_facturar( id_factura, id_producto, cantidad ) values(1, 1, 2);