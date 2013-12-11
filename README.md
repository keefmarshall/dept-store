dept-store
==========

REST/HATEOAS playground using Java/SpringMVC/JPA/ObjectDB

You can build and start the web server without any other dependencies using Maven:

mvn jetty:run

 - this uses Jetty as the servlet container, and an embeedded ObjectDB as the data store. It
puts the data for ObjectDB inside your .m2/db directory in case you were wondering.

