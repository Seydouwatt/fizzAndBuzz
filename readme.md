#FIZZBUZZLIKE

This programme is a simple fizz-buzz like REST server, in JAVA 18

- JAVA version : 18
- MAVEN version : 4.0.0

The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing all multiples of 3 by ""fizz"", all multiples of 5 by ""buzz"", and all multiples of 15 by ""fizzbuzz"".
The output would look like this: ""1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,...

This programme goal is to implement a web server that will expose a REST API endpoint that:
- Accepts five parameters: three integers int1, int2 and limit, and two strings str1 and str2.
- Returns a list of strings with numbers from 1 to limit, where: all multiples of int1 are replaced by str1, all multiples of int2 are replaced by str2, all multiples of int1 and int2 are replaced by str1str2.

  - get method : http://localhost:8080/fizz/attribute?arg1=1&arg2=2&arg3=3&arg4=foo&arg5=bar

    - Example : http://localhost:8080/fizz/attribute?int1=2&int2=5&limit=80&str1=super&str2=hyper
    -    return this : ["1","super","3","super","hyper","super","7","super","9","superhyper","11","super","13","super","hyper","super","17","super","19","superhyper"].
- There is also a Post method doing the same. You just have to fill a form-data body with same parameters.
  - post method : http://8080/localhost:8080/fizz/attributePost

This programme can return statitics informations by using the following URL.
    - http://localhost:8080/fizz/stats
This URL return to you a sentence with the parameters corresponding to the most used request, as well as the number of hits for this request.

    - Example : "La requette utilisant les paramètres suivants a été appelé 7 fois : 4 - 7 - 80 - foo - bar" 

- Endpoints : 
  - /fizz/attribute 
  - /fizz/attributePost
  - /fizz/stats

To run in development :
 - Download from Git repository or Git pull
 - Install JAVA jdk 18
 - Install MAVEN 4.0.0
 - Check if Maven is installing all project dependencies
 - Right click on "src/main/java/com/seydou/fizzBuzzLike/FizzBuzzLikeApplication"
 - And choose "Run FizzBuzzLikeApplication main()" to start a web server on "localhost:8080"

To run in production :
 - Download from Git repository or Git pull
 - Install JAVA jdk 18
 - Install MAVEN 4.0.0
 - Check if Maven is installing all project dependencies
 - On Maven LifeCycle folder double click on "package" to generate a .jar in the target folder
 - With a command line tool, go to the target folder and run the command "jav -jar fizzBuzzLike-1.jar" to start a web server on "localhost:8080"



  

 