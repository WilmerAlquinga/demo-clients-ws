create table client
(
    id         int      not null auto_increment,
    created_at TIMESTAMP    not null,
    deleted_at TIMESTAMP    null,
    updated_at TIMESTAMP    not null,
    lastname   varchar(50)  not null,
    name       varchar(50)  not null,
    email      varchar(60)  not null,
    fullname   varchar(100) not null,
    address    varchar(120),
    primary key (id)
);

INSERT INTO client (name, lastname, fullname, email, address, created_at, updated_at, deleted_at)
VALUES ('Alex', 'Torres', 'Alex Torres', 'atorres@email.com', 'Quito, Ecuador', '2023-10-25 00:00:00',
        '2023-10-25 00:00:00', null),
       ('Ariel', 'Cajas', 'Ariel Cajas', 'atorres@email.com', 'Conocoto, Quito, Ecuador', '2023-10-25 00:00:00',
        '2023-10-25 00:00:00', '2023-10-25 00:00:00'),
       ('Ana', 'Paucar', 'Ana Paucar', 'paucar@email.com', 'Sangolquí, Ecuador', '2023-10-25 00:00:00',
        '2023-10-25 00:00:00', null);
