alter table clientes add constraint fk_cliente_contato
foreign key (contato_id) references contato(id);