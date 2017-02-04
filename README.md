# Java Database Example

This is a set of examples for database interactions with a MariaDB database using both raw Java and JPA using Hibernate. As written, the examples assume you have a locally installed MariaDB server with a schema named `class` and table within that schema called `example`. The `example` table has an auto-incrementing column `id` as its primary key and a varchar column `name`.

The `insertExample` and `selectExample` functions use direct database interactions with Java's `java.sql` package.

The `insertJPAExample` and `retrieveJPAExample` use JPA - Java Persistence API. This acts as an ORM, or Object-Relation Mapping. This automatically generates SQL statements for classes you define as entities. This allows developers to worry more about their application and less about their database.

See information about `java.sql` at https://docs.oracle.com/javase/7/docs/api/java/sql/package-summary.html.

See information about JPA at https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html

See information about Hibernate at http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
