# WMS-Doors
### Warehouse management system DOORS
Информационная система учета материальных средств на складе организации **"ДверейДешевлеНеБывает"**

---
Для создания базы данных необходимо:
1. Открыть консоль mySql:
```shell
sudo mysql --password
```
2. Создать базу данных:
```roomsql
create database wms_doors;
```
3. Создать пользователя:
```roomsql
create user 'wms_doors_admin'@'%' identified by '12345'; 
```
4. Дать новому пользователю полномочия на базу данных:
```roomsql
grant all on wms_doors.* to 'wms_doors_admin'@'%';
```