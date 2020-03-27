COVID-19 Rest API
----
A standalone and minimalist still -- in progress -- covid19 case reporting rest-api. Is based on CDC PUI and Case Report form. 

Details can be found on https://www.cdc.gov/coronavirus/2019-ncov/php/reporting-pui.html

To run the application you need:
- Standalone tomcat:
	It is enough to have to download tomcat and add
	`</tomcat-users>
		<role rolename="manager-gui"/>
		  <user username="admin" password="admin" roles="manager-gui"/>
	</tomcat-users>` inside `tomcat-users.xml`
- Mysql(MariaDb) server
- Run DDL and then DMl found inside `resources/schema/db`
- Deploy and Test(if you use post man, there is postman collection inside resources/schema/)

![Swagger spec](src/main/resources/images/spec.png?raw=true "Swagger spec")