mysql -h 127.0.0.1 -uroot -e "drop database if exists bd2_grupo23; create database bd2_grupo23;"

mysql -h 127.0.0.1 -uroot -e "CREATE USER IF NOT EXISTS 'grupo_23'@'localhost' IDENTIFIED BY 'grupo_23'"

mysql -h 127.0.0.1 -uroot -e "CREATE USER IF NOT EXISTS 'grupo_23'@'%' IDENTIFIED BY 'grupo_23'"

mysql -h 127.0.0.1 -uroot -e "GRANT ALL PRIVILEGES ON bd2_grupo23.* TO 'grupo_23'@'%'";

mysql -h 127.0.0.1 -uroot -e "GRANT ALL PRIVILEGES ON bd2_grupo23.* TO 'grupo_23'@'localhost'";