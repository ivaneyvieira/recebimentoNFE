-- apply changes
create table lojas (
  id                            bigint auto_increment not null,
  numero                        integer not null,
  sigla                         varchar(2) not null,
  created_at                    datetime(6) not null,
  updated_at                    datetime(6) not null,
  version                       integer not null,
  constraint uq_lojas_numero unique (numero),
  constraint pk_lojas primary key (id)
);

create table notas (
  id                            bigint auto_increment not null,
  loja_id                       bigint,
  chave                         varchar(50) not null,
  nfno                          varchar(32) not null,
  nfse                          varchar(4) not null,
  cnpj_emitente                 varchar(20) not null,
  emitente                      varchar(100) not null,
  cnpj_destinatario             varchar(20) not null,
  destinatario                  varchar(100) not null,
  created_at                    datetime(6) not null,
  updated_at                    datetime(6) not null,
  version                       integer not null,
  constraint pk_notas primary key (id)
);

create table produtos (
  id                            bigint auto_increment not null,
  nota_id                       bigint,
  codigo                        varchar(60) not null,
  ean                           varchar(14) not null,
  descricao                     varchar(120) not null,
  quantidade                    double(10,4) not null,
  valor_unitario                double(10,2) not null,
  unidade                       varchar(6) not null,
  created_at                    datetime(6) not null,
  updated_at                    datetime(6) not null,
  version                       integer not null,
  constraint pk_produtos primary key (id)
);

create table volumes (
  id                            bigint auto_increment not null,
  nota_id                       bigint,
  quantidade                    integer not null,
  especie                       varchar(60) not null,
  peso_liquido                  double(10,4) not null,
  peseo_bruto                   double(10,4) not null,
  created_at                    datetime(6) not null,
  updated_at                    datetime(6) not null,
  version                       integer not null,
  constraint pk_volumes primary key (id)
);

create index ix_notas_loja_id on notas (loja_id);
alter table notas add constraint fk_notas_loja_id foreign key (loja_id) references lojas (id) on delete restrict on update restrict;

create index ix_produtos_nota_id on produtos (nota_id);
alter table produtos add constraint fk_produtos_nota_id foreign key (nota_id) references notas (id) on delete restrict on update restrict;

create index ix_volumes_nota_id on volumes (nota_id);
alter table volumes add constraint fk_volumes_nota_id foreign key (nota_id) references notas (id) on delete restrict on update restrict;

