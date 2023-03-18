# power-framework

## Important notes to read first:

 1. This is a hobbyist project. 
 2. This project is licenced as LGPL 2.1, which also means it is distributed without any warranty. 
 3. In case, you find a bug or propose an improvement:
   * Raise an issue or participate a new discussion.
   
## About

Power Framework is a Java library.

It contains several modules: view, collections, json, time, db, persistence, random, reflection, sql, xml and web and others.

View is an abstraction of JavaFX. Window class may be the most used class of this module and is used as a place for everything user sees. Window class uses custom decorations, system decorations are not used.

Collections contains full implementation of some collection type like linked list, queue, stack, list, map, set, properties, tree and others.

Json is used to represent json object and json array as a Java Object. Json files can be parsed to JsonObject instance. Every instance of JsonObject or JsonArray can be printed to minimal or pretty String.

DB is used to give abstraction for jdbc and SQLite, hides implementation. Database package can be used to store permanent data.

Persistence is used to dynamically manage SQLite database, create table ddl, insert, update and delete statements are automatically generated from Java classes using reflection. Persistence behaves maybe like the Hibernate library.

Random is used to generate pseudorandom numbers and is based on linear congruent function and using seeds.

Time contains some classes used to represent date and time without time zone information, universal date and time, date and time with time zone information. There are also some classes representing durations and period. Time module is partially an abstraction on Java SE time classes, but the interface to use it is a little different.

Reflection is a abstraction of Java SE reflection classes.

SQL generates sql Statements.

Xml is used to generate xml output by Java classes. Web uses xml and creates html pages. 
