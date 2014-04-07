DROP TABLE events_has_employees; 
DROP TABLE sales; 
DROP TABLE cases; 
DROP TABLE customers;
DROP TABLE users; 
DROP TABLE wood; 
DROP TABLE employees; 

CREATE TABLE users(
id INTEGER GENERATED ALWAYS AS IDENTITY,
firstName VARCHAR(30),
lastName VARCHAR(30),
status INTEGER,
CONSTRAINT users_pk PRIMARY KEY(id)
);

CREATE TABLE cases(
id INTEGER GENERATED ALWAYS AS IDENTITY, 
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
toolList VARCHAR(30),
contactPerson VARCHAR(30),
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
lastWorkDate VARCHAR(30),
lastRegDate VARCHAR(30),
attendanceWithoutWork INTEGER,
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

ALTER TABLE events_has_employees ADD CONSTRAINT case_id_fk FOREIGN KEY(case_id) REFERENCES cases(id);
ALTER TABLE events_has_employees ADD CONSTRAINT employee_id_fk FOREIGN KEY(employee_id) REFERENCES employees(id);

ALTER TABLE cases ADD CONSTRAINT creator_fk FOREIGN KEY(creator) REFERENCES users(id);
ALTER TABLE cases ADD CONSTRAINT supervisor_fk FOREIGN KEY(supervisor) REFERENCES users(id);
ALTER TABLE cases ADD CONSTRAINT customer_fk FOREIGN KEY(customer) REFERENCES customers(id);

ALTER TABLE sales ADD CONSTRAINT sales_customer_fk FOREIGN KEY(customer) REFERENCES customers(id);
ALTER TABLE sales ADD CONSTRAINT wood_fk FOREIGN KEY(wood) REFERENCES wood(woodType);

INSERT INTO users VALUES(DEFAULT, 'Borgar', 'Lie', 1);
INSERT INTO users VALUES(DEFAULT, 'Bjørn', 'Hoxmark', 1);
INSERT INTO users VALUES(DEFAULT, 'Thomas', 'Haugrud', 1);
INSERT INTO users VALUES(DEFAULT, 'Jørgen', 'Wilhelmsen', 1);

INSERT INTO wood VALUES('Eik', 50, 800);
INSERT INTO customers VALUES(DEFAULT, 'fornavn', 'etternavn', 91323324);
INSERT INTO sales VALUES(default, 30, 1, 'Eik', 1400, 'Ski', 'humleveien 13');
--INSERT INTO cases VALUES(default, 'jobbAdresseveien 1', 7001, 'Trondheim',1, 'activ', '10.04.2014','09.04.2014', '11.04.2014', 2, 2);
 

INSERT INTO employees VALUES (DEFAULT, 'Hei', 'Heisen', '', '', 0);
INSERT INTO employees VALUES (DEFAULT, 'Arne', 'Gunnarson', '', '', 0);
INSERT INTO employees VALUES (DEFAULT, 'masdm', 'Hoppla', '', '', 0);


INSERT INTO cases VALUES (DEFAULT, '', 0, '', '', '', '', '', 0, '', '', '', '', '', 1, 1, 1);
INSERT INTO cases VALUES (DEFAULT, '', 0, '', '', '', '', '', 0, '', '', '', '', '', 1, 1, 1);
INSERT INTO cases VALUES (DEFAULT, '', 0, '', '', '', '', '', 0, '', '', '', '', '', 1, 1, 1);
INSERT INTO cases VALUES (DEFAULT, '', 0, '', '', '', '', '', 0, '', '', '', '', '', 1, 1, 1);

INSERT INTO events_has_employees VALUES(1, 1);
INSERT INTO events_has_employees VALUES(2, 1);
INSERT INTO events_has_employees VALUES(3, 1);
INSERT INTO events_has_employees VALUES(3, 2);

