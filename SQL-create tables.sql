DROP TABLE events_has_employees; 
DROP TABLE sales; 
DROP TABLE cases; 
DROP TABLE customers;
DROP TABLE users; 
DROP TABLE wood; 
DROP TABLE employees;
DROP TABLE postnr;

CREATE TABLE users(
id INTEGER GENERATED ALWAYS AS IDENTITY,
firstName VARCHAR(30),
lastName VARCHAR(30),
status INTEGER,
CONSTRAINT users_pk PRIMARY KEY(id)
);

CREATE TABLE cases(
id INTEGER GENERATED ALWAYS AS IDENTITY,
createdDate VARCHAR(30), 
address VARCHAR(30), 
postalCode INTEGER, 
postPlace VARCHAR(30),
subject VARCHAR(30),
req_date VARCHAR(30), 
req_time VARCHAR(30), 
description VARCHAR(200),
price INTEGER,
checkup_date VARCHAR(30),
startDate VARCHAR(30), 
toolList VARCHAR(200),
contactPerson VARCHAR(200),
status VARCHAR(30),
creator INTEGER,
supervisor INTEGER,
customer INTEGER, 
CONSTRAINT cases_pk PRIMARY KEY(id)
);

CREATE TABLE employees(
id INTEGER GENERATED ALWAYS AS IDENTITY, 
firstName VARCHAR(30),
lastName VARCHAR(30),
removedFromAttendance VARCHAR(30),
lastRegDate VARCHAR(30),
attendanceWithoutWork INTEGER,
lastRegDateBackup VARCHAR(30),
attendanceWithoutWorkBackup INTEGER,
CONSTRAINT employees_pk PRIMARY KEY(id)
);

CREATE TABLE events_has_employees(
case_id INTEGER,
employee_id INTEGER,
CONSTRAINT events_has_employees_pk PRIMARY KEY(case_id, employee_id)
);

CREATE TABLE sales(
id INTEGER GENERATED ALWAYS AS IDENTITY, 
quantity INTEGER, 
customer INTEGER, 
wood VARCHAR(30), 
postalCode INTEGER,
postPlace VARCHAR(30), 
address VARCHAR(30),
status VARCHAR(30),
CONSTRAINT sales_pk PRIMARY KEY(id)
);

CREATE TABLE customers(
id INTEGER GENERATED ALWAYS AS IDENTITY, 
firstName VARCHAR(30), 
lastName VARCHAR(30), 
phoneNumber INTEGER, 
CONSTRAINT customers_pk PRIMARY KEY(id)
);

CREATE TABLE wood(
woodType VARCHAR(30), 
bagSize INTEGER, 
price INTEGER, 
CONSTRAINT wood_pk PRIMARY KEY(woodType)
);

CREATE TABLE postnr(
id INTEGER GENERATED ALWAYS AS IDENTITY,
postnr VARCHAR(30),
postadresse VARCHAR(30)
);

ALTER TABLE events_has_employees ADD CONSTRAINT case_id_fk FOREIGN KEY(case_id) REFERENCES cases(id);
ALTER TABLE events_has_employees ADD CONSTRAINT employee_id_fk FOREIGN KEY(employee_id) REFERENCES employees(id);

ALTER TABLE cases ADD CONSTRAINT creator_fk FOREIGN KEY(creator) REFERENCES users(id);
ALTER TABLE cases ADD CONSTRAINT supervisor_fk FOREIGN KEY(supervisor) REFERENCES users(id);
ALTER TABLE cases ADD CONSTRAINT customer_fk FOREIGN KEY(customer) REFERENCES customers(id);

ALTER TABLE sales ADD CONSTRAINT sales_customer_fk FOREIGN KEY(customer) REFERENCES customers(id);
ALTER TABLE sales ADD CONSTRAINT wood_fk FOREIGN KEY(wood) REFERENCES wood(woodType);

-- Inserts are used for test purposes.

INSERT INTO users VALUES(DEFAULT, 'Borgar', 'Lie', 1);
INSERT INTO users VALUES(DEFAULT, 'Bjørn', 'Hoxmark', 1);
INSERT INTO users VALUES(DEFAULT, 'Thomas', 'Haugrud', 1);
INSERT INTO users VALUES(DEFAULT, 'Jørgen', 'Wilhelmsen', 1);

INSERT INTO wood VALUES('Eik 50', 50, 800);
INSERT INTO wood VALUES('Furu 50', 50, 900);
INSERT INTO wood VALUES('Bjørk 50', 50, 1000);
INSERT INTO wood VALUES('Bjørk 40', 40, 850);
INSERT INTO wood VALUES('Bjørk 30', 20, 500);

INSERT INTO customers VALUES(DEFAULT, 'Per', 'Persen', 91323324);
INSERT INTO customers VALUES(DEFAULT, 'Ola', 'Olsen', 91101020);
INSERT INTO customers VALUES(DEFAULT, 'Karl', 'Karlsen', 40502531);

INSERT INTO sales VALUES(default, 30, 1, 'Eik 50', 1400, 'Ski', 'Humleveien 13', 'Ikke levert');
INSERT INTO sales VALUES(default, 2, 2, 'Bjørk 30', 7710, 'Sparbu', 'Mære', 'Ikke levert');
INSERT INTO sales VALUES(default, 5, 3, 'Bjørk 40', 7540, 'Klæbu', 'Klokkarvegen 2', 'levert');

INSERT INTO cases VALUES(DEFAULT, '10-04-2014', 'Klokkarvegen 2', 7540, 'Klæbu', 'Maling UTE', '20-05-2014', '08:00', 'Maling av hus, 4 vegger', 2000, '10-05-2014', '20-05-2014', 'Malingskoster. Maling har kunden', 'Ingar 99933999', 'Aktiv', 1, 3, 1);

INSERT INTO cases VALUES(DEFAULT, '10-04-2014', 'Klokkarvegen 2', 7540, 'Klæbu', 'Maling INNE', '21-05-2014', '10:00', 'Maling av 2 rom', 1000, '10-05-2014', '21-05-2014', 'Malingskoster. Maling har kunden', 'Lars 90224323', 'Aktiv', 1, 2, 1);

INSERT INTO cases VALUES(DEFAULT, '12-04-2014', 'Humleveien 13', 1400, 'Ski', 'Vedstabling UTE', '30-05-2014', '09:00', 'Vedbæring og stabling', 1750, '22-05-2014', '29-05-2014', 'Godt humør', 'Kåre 22334433', 'Uferdig', 3, 4, 3);

INSERT INTO cases VALUES(DEFAULT, '05-04-2014', 'Mære', 7710, 'Sparbu', 'Maling UTE', '11-04-2014', '07:00', 'Maling av hus, 2 vegger', 1750, '07-04-2014', '11-04-2014', 'Malingskoster. Maling har kunden', 'Nils Arne 99004400', 'Ferdig', 4, 3, 2);

INSERT INTO employees VALUES (DEFAULT, 'Lars', 'Larsen', '', '', 0, '', 0);
INSERT INTO employees VALUES (DEFAULT, 'Arne', 'Gunnarson', '10.04.2014', '10.04.2014', 3, '', 3);
INSERT INTO employees VALUES (DEFAULT, 'Mats', 'Hoppla', '', '', 0, '', 0);
INSERT INTO employees VALUES (DEFAULT, 'Magnus', 'Kristiansen', '', '', 0, '', 0);

INSERT INTO events_has_employees VALUES(1, 1);
INSERT INTO events_has_employees VALUES(1, 3);
INSERT INTO events_has_employees VALUES(4, 1);
INSERT INTO events_has_employees VALUES(4, 3);
INSERT INTO events_has_employees VALUES(4, 4);
