CREATE OR REPLACE VIEW v_notas
AS
select invno, cast(issue_date as date) as dtEmissao, cast(date as date) as dtEntrada,
  nfname as nfno, invse as nfse, nfekey as chave, S.cgc as cnpjDest, V.cgc as cnpjEmit,
  V.name as fornecedor
from sqldados.inv AS I
  inner join sqldados.invnfe AS N
    USING(invno)
  inner join sqldados.store AS S
    ON S.no = I.storeno
  inner join sqldados.vend AS V
    ON V.no = I.vendno
WHERE issue_date > DATE_SUB(current_date, INTERVAL 3 MONTH);

