# Simple-Grade-System
A records system for student grades. The project was created in response to an assignment in ITC313 at Charles Sturt University.

## Pre-requisites
* [MySQL connector for JDK](https://dev.mysql.com/downloads/connector/j/)
* [MySQL Server](http://dev.mysql.com/downloads/mysql/)

Also good to import and compile project in [Eclipse](http://www.eclipse.org/)

## Database setup

When setting up MySQL, make sure to set the root password as `abc123`.

Create a database:

`CREATE DATABASE ST123456`

Although, the option is there to change the database name to anything. The name must match the string typed into the **Database** field.

## Usage

At the login screen:
1.	Check load defaults if you have went with the above default database setup. Otherwise, put in the custom settings
2.	Click connect

For the first launch, you will to create a table in the database to get started:
1.	Select **Settings** from the left hand menu
2.	Select **Create table**
3.	Click **Apply**

If successful, the lower panel will display "Table created...".

To insert a record:
1.	Select **Insert** from the menu
2.	Fill in the form.
		* The ID must be 3 characters that are numerical. They also must be unique.
		* The Assigment score fields must be numerical
3.	Click on **Insert**

To search a record:
1.	Select **Search** from the menu
2.	Type in an existing record ID.
3.	Click on **Search**

Lastly you can click on **Overview** from the menu to view all records.

## Known Issues
The login form accepts a connection when all the fields are blank. This causes a false connection to the database.
