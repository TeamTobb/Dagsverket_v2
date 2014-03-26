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
CONSTRAINT users_pk PRIMARY KEY(id)
);

CREATE TABLE cases(
id INTEGER GENERATED ALWAYS AS IDENTITY, 
address VARCHAR(30), 
postalCode INTEGER, 
postPlace VARCHAR(30), 
customer INTEGER, 
status VARCHAR(30), 
req_date VARCHAR(30), 
inspectDate VARCHAR(30),
startDate VARCHAR(30), 
supervisor INTEGER,
creator INTEGER,
CONSTRAINT cases_pk PRIMARY KEY(id)
);

CREATE TABLE employees(
id INTEGER GENERATED ALWAYS AS IDENTITY, 
firstName VARCHAR(30),
lastName VARCHAR(30),
lastWorkDate VARCHAR(30),
lastRegDate VARCHAR(30),
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
CONSTRAINT sales_pk PRIMARY KEY(id)
);

CREATE TABLE customers(
id INTEGER GENERATED ALWAYS AS IDENTITY, 
firstName VARCHAR(30), 
lastName VARCHAR(30), 
phoneNumber INTEGER, 
address VARCHAR(30), 
postalCode INTEGER, 
postPlace VARCHAR(30), 
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