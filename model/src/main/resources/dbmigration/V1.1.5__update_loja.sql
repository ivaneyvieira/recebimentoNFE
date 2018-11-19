delete from lojas;

insert into lojas(id, numero, sigla, cnpj, created_at, updated_at, version)
select no as id, no as numero, sname as sigla, cgc as cnpj,
       current_timestamp created_at, current_timestamp as updated_at, 0 as version
FROM sqldados.store;

