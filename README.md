dept-store
==========

REST/HATEOAS playground using Java / SpringMVC / JPA / ObjectDB

Introduction
------------

This is a playground for me to learn about RESTful APIs using HATEOAS - the idea that the API
should be self-explanatory through the inclusion of human-readable and consistent URLs, as well
as adhering to the normal REST standards of GET, POST, DELETE actions etc.

It's based on a department store - the store has departments, each department sells items. An
item belongs to one and only one department. At some point I'll add the concept of different
physical stores, and stock of items within each store. Not all physical stores will have all
departments.

It's loosely based on an interview test I had to do - the food-shop-node example in my github
is the app I actually submitted as I didn't have time to do it this way, (the Node app took less
than an hour to put together, in total). 

This was a good excuse to see how it might work in a declarative Spring environment.

- Lesson 1: it is a whole lot slower to do completely from scratch in Java - getting the 
configuration right is fiddly. It literally took less than an hour in Node.js - has taken a
while to get this far in Java (although it's a better solution, probably more robust and flexible)
- Lesson 2: the HATEOAS stuff is much easier to implement in Java thanks to `spring-hateaos`
although I didn't fully investigate all the options for 3rd-party libraries in Node.


Build / Startup
---------------

You can build and start the web server without any other dependencies using Maven:

	mvn jetty:run

 - this uses Jetty as the servlet container, and an embedded ObjectDB as the data store.
 - it puts the data for ObjectDB inside your `.m2/db` directory in case you were wondering.
 
Access the root of the API at `http://localhost:8080/departments`

