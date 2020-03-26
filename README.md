# rediscache
For this poc a sample database "employees" provided by MySQL is used.  Below is a link to the documentation of employees database:
	https://dev.mysql.com/doc/employee/en/employees-preface.html
Read the Installation section of the above link to install the DB on your MySQL server instance.

This poc assume
	1.  a MySQL server is already running and accessible at 127.0.0.1 and port 3306
	2.  a running MySQL server has employees database
	3.  a Redis server is already running and accessible at 127.0.0.1 and port 6379.  I have used a docker image of the Redis.
