CREATE OR REPLACE VIEW v_produto
AS
select no as prdno, name, ifnull(grade, '') as grade, TRIM(mfno_ref) as codigo,
  TRIM(ifnull(B.barcode,P.barcode)) as ean, qttyPackClosed/1000 as qtPacote
from sqldados.prd AS P
   left join sqldados.prdbar AS B
     ON P.no = B.prdno;

