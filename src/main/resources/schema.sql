create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR,
  collaterals_fk INT
);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuel_capacity INT,
  seats INT,
  collaterals_fk INT
);

create table COLLATERALS (
  id IDENTITY primary key
);

create table ASSESSED_VALUE (
  id IDENTITY primary key,
  collaterals_fk INT,
  assessed_value DEC(20),
  change_date DATE
);

alter table CAR add constraint fk_collaterals_car foreign key (collaterals_fk) references COLLATERALS(id);

alter table AIRPLANE add constraint fk_collaterals_airplane foreign key (collaterals_fk) references COLLATERALS(id);

alter table ASSESSED_VALUE add constraint fk_assessed_value foreign key (collaterals_fk) references COLLATERALS(id);

