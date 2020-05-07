COVID-19 Rest API
----
# General information about the project.
The motivation behind this project is that as we all know the world is struggling to cope with a sudden fast growing and blazing virus. Even though it seemed to be something easier in the beginning, it has shaken many strong countries, let alone the countries with poor medical coverage. This project tries to address this issue in a way that it facilitates **case management**, starting from **case registration** to **follow-up** and **contact tracing**. And it tries to follow guidelines mainly from **[CDC](https://www.cdc.gov/coronavirus/2019-ncov/php/reporting-pui.html)**

# How to setup
1. Standalone tomcat: It is enough to have to download tomcat and add the following inside tomcat-users.xml
	``` 
	</tomcat-users> 
		<role rolename="manager-gui"/> 
		<user username="admin" password="admin" roles="manager-gui"/> 
	</tomcat-users>
	```
2. PostgreSQL(can easily be migrated to MYSQL) server
3. Run DDL and then DML found inside `resources/schema/db`
4. Deploy and Test(if you use postman, there is postman collection inside resources/schema/postman_collections)
