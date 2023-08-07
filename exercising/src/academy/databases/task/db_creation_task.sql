create database db_task;

drop database db_task;
use db_task;

create table user(	
userId INT primary key auto_increment,
firstName VARCHAR(50) not null,
lastName VARCHAR(50) not null,
email VARCHAR(50) not null UNIQUE,
mobile VARCHAR(15) not null,
language CHAR(3) not null,
expirationDate TIMESTAMP not null,
gender CHAR(1) not null,
username VARCHAR(50) not null unique,
hashPassword VARCHAR(255) not null,
hashPassword2 VARCHAR(255) not null,
creationDate TIMESTAMP not null default NOW(),
creationUser int not null,
modificationDate TIMESTAMP not null default NOW(),
modificationUser int not null
);

create table account(
accountId INT primary key auto_increment,
accountName VARCHAR(100) not null,
isActive boolean not null,
numberOfUsers INT,
timeZone VARCHAR(100),
creationDate TIMESTAMP not null default NOW(),
creationUser  int not null,
modificationDate TIMESTAMP not null default NOW(),
modificationUser int not null
);

create table gpsPosition(
positionId int primary key auto_increment,
latitude DECIMAL(10,6) not null,
longitude DECIMAL(10,6) not null,
positionDate TIMESTAMP not null,
creationDate TIMESTAMP not null default NOW(),
creationUser int not null,
speed DECIMAL(6,2) not null, # 9999.99 max?
deviceId int not null,      #(FK ON deviceId in device table)
isValid boolean not null,
deviceStatus tinyint not null check (deviceStatus <= 6),
currentDriver int not null, #(FK ON userId in user table)
accountId int not null,     #(FK ON accountId in account table)
constraint fk_gpsPosition_device
foreign key (deviceId)
references device(deviceId),
constraint fk_gpsPosition_user
foreign key (currentDriver)
references user(userId),
constraint fk_gpsPosition_account
foreign key(accountId)
references account(accountId)
);

create table vehicle(
vehicleId int primary key auto_increment,
deviceId int not null,          #(FK ON deviceId in device table)
creationDate TIMESTAMP not null default NOW(),
creationUser int not null,
modificationDate TIMESTAMP not null default NOW(),
modificationUser int not null,
vehicleBrand VARCHAR(40) not null,
vehicleModel VARCHAR(40) not null,
colour VARCHAR(20) not null,
plateNumber VARCHAR(10) not null unique,
horsePower INT not null,
vehicleCategory int not null,    # maybe VARCHAR(10) -> B1, B2, C, D - types of categories
defaultDriver int not null,      #(FK ON userId in user table)
accountId int not null,          #(FK ON accountId in account table)
lastPositionId int not null,     #(FK ON positionId in gpsPosition table)
constraint fk_vehicle_device
foreign key (deviceId)
references device(deviceId),
constraint fk_vehicle_user
foreign key (defaultDriver)
references user(userId),
constraint fk_vehicle_account
foreign key (accountId)
references account(accountId),
constraint fk_vehicle_gpsPosition
foreign key (lastPositionId)
references gpsPosition(positionId)
);


create table device(
deviceId int primary key auto_increment,
creationDate TIMESTAMP not null default NOW(),
creationUser int not null,
modificationDate TIMESTAMP not null default NOW(),
modificationUser int not null,
extId VARCHAR(100) not null, #(similar to name for the device)
typeId int not null,
deviceCategory tinyint not null check (deviceCategory <= 6),
accountId int not null,      #(FK ON accountId in account table)
constraint fk_device_account
foreign key (accountId)
references account(accountId)
);

create table periph(
periphId int primary key auto_increment,
deviceId int not null,                     #(Foreign key with deviceId in device table)
name VARCHAR(100) not null unique,
description VARCHAR(255) not null,
creationDate TIMESTAMP not null default NOW(),
creationUser int not null,
modificationDate TIMESTAMP not null default NOW(),
modificationUser int not null,
isActive boolean not null,
textParam TEXT not null,                   #(should contain long text, something as comment)
accountId int not null,                    #(FK ON accountId in account table)
constraint fk_periph_device
foreign key (deviceId)
references device(deviceId),
constraint fk_periph_account
foreign key (accountId)
references account(accountId)
);

create table `group`(
groupId int primary key auto_increment,
name VARCHAR(100) not null unique,
creationDate TIMESTAMP not null default NOW(),
creationUser int not null,
accountId int not null,           #(FK ON accountId in account table)
isActive boolean not null,
constraint fk_group_account
foreign key (accountId)
references account(accountId)
);

create table group_device(
	groupDeviceId int primary key auto_increment,
	groupId int not null,
	deviceId int not null,
	creationDate TIMESTAMP not null default NOW(),
	creationUser int not null, 
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL,
	constraint fk_group_device_group
	foreign key  (groupId)
	references `group`(groupId),
	constraint fk_group_device_device
	foreign key (deviceId)
	references device(deviceId)
);

create table group_vehicle(
	groupVehicleId int primary key auto_increment,
	groupId int not null,
	vehicleId int not null,
	creationDate TIMESTAMP not null default NOW(),
	creationUser int not null,
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL,
	constraint fk_group_vehicle_group
	foreign key  (groupId)
	references`group`(groupId),
	constraint fk_group_vehicle_vehicle
	foreign key  (vehicleId)
	references vehicle(vehicleId)
);
