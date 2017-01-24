This project develop REST API to perform function with Basic Authentication

1) Sample Request to perform search with given json input data 

curl http://localhost:7777/counter-api/search -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -d "{\"searchText\":[\"Duis\", \"Sed\", \"Donec\", \"Augue\", \"Pellentesque\", \"123\"]}" -X POST -H "Content-Type:application/json"


2) 
curl http://localhost:7777/counter-api/top/20 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw=="  -X POST 


NOTE: 

** Text file name that is used to perform the word count is in application.properties
** TODO -H ”Accept:text/csv” isn't working, need to allow the result to be able to write into csv file
** TODO add more test case to allow code coverage 80% above
** TODO add more exception handling functionaly to handle more error cases.
