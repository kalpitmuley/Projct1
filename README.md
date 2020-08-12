# Project1

Q1. Create a spring boot app which interacts with any mysql database and performs all the below mentioned tasks in it. 

Entity Name that should be used throughout the project : Book

Book.java
{
	long id,
	String name,
	String authorName
	int cost,
	Timestamp (data type you have find from the mapping of sql data types to java data types)

}

Task 1 : The app server is jetty.

Task 2 : Runs the server on some different port other than 8080 and create one Rest API which will return the port of the server. API endpoint can be anything but the method should be a GET one
Note : Don’t hardcode the port in the controller, read the port from the configuration file

Task 3 : Create GET and POST APIs for getting all the books in the database present and for inserting a book respec tively.
There is an additional thing you need to do in the POST API for inserting, you need to add the insertion timestamp which is basically the time at which the book got inserted in the table

Task 4 : Create a PUT API, endpoint can be anything it’s up to you. The functionality should be : Update the name of the author as William for every book whose authorName has Will as the first word

Note : `Will` as the first word means that if authorName has name Will ___

Cases that you need to consider :

Will Martin - Valid case (Need to update)

WillMartin - Invalid case (Don’t update this since Will is not a proper word, it's just a substring in this case)

Will - Valid Case (Need to update this since will is a proper word)

Note : In all the valid cases the final authorName should be William and nothing else no surname no space etc.
Remember to only use JPQL in this part, no native query allowed

Task 5 : A DELETE API to delete all the books which have cost greater than 1000
Do this using native query part, no JPQL allowed in this function/API

In total create 5 APIs for this project
