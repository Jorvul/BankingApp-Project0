# BankingApp-Project0
This Banking App allows you to perform the following functionalities by using Postman with the Postgres database.

## Description
The Banking App API is a Server-side application that facilitates the management of Client's Bank Accounts. A client create new accounts of various categories.

## RESTful Endpoints:

POST /clients => Creates a new client
	return a 201 status code

GET /clients => gets all clients
	return 200

GET /clients/10 => get client with id of 10
	return 404 if no such client exist

PUT /clients/12 => updates client with id of 12	
	return 404 if no such client exist

DELETE /clients/15 => deletes client with the id of 15
	return 404 if no such client exist
	return 205 if success

POST /clients/5/accounts =>creates a new account for client with the id of 5
	return a 201 status code

GET /clients/7/accounts => get all accounts for client 7
	return 404 if no client exists
