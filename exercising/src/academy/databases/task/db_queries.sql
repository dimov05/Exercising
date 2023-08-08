-- Queries:
-- 
-- 1. Select all vehicles, that have attached device
select
	v.vehicleId,
	v.vehicleBrand,
	v.plateNumber
from vehicle v
where v.deviceId is not null ;

-- 2. Select all devices with more than one periph attached
select
	d.deviceId,
	d.extId,
	COUNT(p.name) as periphs_attached
from device d
join periph as p on d.deviceId = p.deviceId
group by d.deviceId having periphs_attached > 1;

-- 3. Select all vehicles with more than 50 hp
select vehicleId, vehicleBrand, plateNumber, horsePower 
from vehicle 
where horsePower  > 50;

-- 4. Select all entities for one specific account (all vehicles, devices and periphs, even not related between)
-- select
-- 	a.accountId as account_id,
-- 	a.accountName as account_name,
-- 	count(p.name)  as periph_count,
-- 	count(d.extId) as device_count,
-- 	count(v.plateNumber) as vehicle_count
-- from account as a 
-- join periph as p on p.accountId = a.accountId 
-- join device as d on d.accountId = a.accountId
-- join vehicle as v on v.accountId  = a.accountId
-- where a.accountId = 66;
(select v.plateNumber, 'vehicle' as entity_type from vehicle as v where v.accountId = 66)
union 
(select d.extId, 'device' as entity_type from device as d where d.accountId = 66)
union 
(select p.name, 'periph' as entity_type from periph as p where p.accountId = 66);

-- select * from 
-- (select v.plateNumber,  from vehicle as v where v.accountId = 66) as vehicle
-- cross join
-- (select d.extId from device as d where d.accountId = 66) as device
-- cross join 
-- (select p.name from periph as p where p.accountId = 66) as periph;
-- 
-- select * from vehicle limit 20

-- 5. Select all periphs for a specific vehicle, ordered by modification date descending

select v.vehicleId, v.vehicleBrand, p.modificationDate, p.name as periph_name from vehicle v
join device as d on d.deviceId = v.deviceId
join periph as p on p.deviceId  = d.deviceId where v.vehicleId = 6 order by p.modificationDate desc;

-- 6. Select all gpsPositions for a specific device, that occurred the last 7 days

select gps.positionId, gps.positionDate from gpsposition gps
where gps.positionDate >= DATE(NOW() - interval 7 day) and deviceId = 75;

-- 7. Select first name and last name (in one column) and also the email of all the users, that are active (the expirationDate has not occurred yet)

select concat_ws(' ',u.firstName,u.lastName) as full_name, u.email, u.expirationDate from user as u 
where u.expirationDate > now();

-- 8. Select all users that haven’t filled their emails

select concat_ws(' ',u.firstName,u.lastName) as full_name from user as u where u.email is null;

-- 9. Select all vehicles that have ‘3’ in the plate number

select v.vehicleBrand ,v.plateNumber  from vehicle as v where v.plateNumber like '%3%';

-- 10. Select the last 10 added devices

select d.deviceId, d.creationDate from device as d order by d.creationDate desc limit 10;

-- 11. Select 5 vehicles with minimal hp

select v.vehicleBrand ,v.plateNumber, v.horsePower from vehicle as v 
order by v.horsePower asc limit 5;

-- select v.vehicleBrand, v.plateNumber, MIN(v.horsePower) from vehicle as v
-- group by v.vehicleId limit 5;

-- 12. Select all the positions and vehicles, for which a specific user has been a driver

select gps.positionId, v.plateNumber, concat_ws(' ',u.firstName,u.lastName) as full_name, u.userId from user as u
join vehicle as v on v.defaultDriver = u.userId
join gpsPosition as gps on gps.currentDriver = u.userId
where u.userId = 29;

-- 13. Select the average speed of the positions for a specific account

select a.accountName, a.accountId, avg(gps.speed) from account as a
join gpsposition as gps where a.accountId = gps.accountId 
group by a.accountId ;


