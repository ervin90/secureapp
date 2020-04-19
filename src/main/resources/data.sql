drop table UTENTI;
drop table RUOLI;
drop table LIBRI;
drop table PRESTATORI;
create table UTENTI
(
   email varchar (64) not null primary key,
   nome varchar (32) not null,
   cognome varchar (32) not null,
   password varchar (512) not null
);
create table PRESTATORI
(
   id bigint not null primary key,
   nome varchar (32) not null,
   tasso double not null,
   disponibilita bigint not null
);
create table RUOLI
(
   email varchar (64) not null,
   ruolo varchar (32) not null
);
create table LIBRI
(
   id bigint not null primary key,
   nome varchar (128),
   genere varchar (64),
   scrittore varchar (64)
);
INSERT INTO UTENTI VALUES
(
   'mario.rossi@mail.com',
   'mario',
   'rossi',
   '$2y$10$F.GNv6esdYy9uZh4VTaz2uiVzPh4TxkUL3i7aCtgv53T1AUuUQc2u'
);
-- bcrypt(mario123, 10) USER
INSERT INTO UTENTI VALUES
(
   'anna.rossi@mail.com',
   'anna',
   'rossi',
   '$2y$10$pJNdLLxMVyVjojIgPcpsIeNDcyPqLyMYgjsfKcBYPgiHdX8nOsBAe'
);
-- bcrypt(anna1234, 10) USER and ADMIN
INSERT INTO RUOLI VALUES
(
   'mario.rossi@mail.com',
   'ROLE_USER'
);
INSERT INTO RUOLI VALUES
(
   'anna.rossi@mail.com',
   'ROLE_USER'
);
INSERT INTO RUOLI VALUES
(
   'anna.rossi@mail.com',
   'ROLE_ADMIN'
);
INSERT INTO LIBRI VALUES
(
   1,
   'In Search of Lost Time',
   'Fiction',
   'Marcel Proust'
);
INSERT INTO LIBRI VALUES
(
   2,
   'Life of Pi',
   'Action and Adventure',
   'Yann Martel'
);
INSERT INTO LIBRI VALUES
(
   3,
   'The Night Fire',
   'Detective and Mystery',
   'Michael Connely'
);
INSERT INTO PRESTATORI VALUES
(
   1,
   'Bob',
   0.075,
   640
);
INSERT INTO PRESTATORI VALUES
(
   2,
   'Jane',
   0.069,
   480
);
INSERT INTO PRESTATORI VALUES
(
   3,
   'Fred',
   0.071,
   520
);
INSERT INTO PRESTATORI VALUES
(
   4,
   'Marry',
   0.104,
   170
);
INSERT INTO PRESTATORI VALUES
(
   5,
   'John',
   0.081,
   320
);
INSERT INTO PRESTATORI VALUES
(
   6,
   'Dave',
   0.074,
   140
);
INSERT INTO PRESTATORI VALUES
(
   7,
   'Angela',
   0.071,
   60
);