dept-store
==========

REST/HATEOAS playground using Java/SpringMVC/JPA/ObjectDB

Build / Startup
---------------

You can build and start the web server without any other dependencies using Maven:

	mvn jetty:run

 - this uses Jetty as the servlet container, and an embedded ObjectDB as the data store.
 - it puts the data for ObjectDB inside your `.m2/db` directory in case you were wondering.
 
Access the server at `http://localhost:8080/shop/departments`

