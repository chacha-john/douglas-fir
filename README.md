# douglas-fir

## By Chacha John 

# Table of Content

+ [Description](#description)
+ [Screenshots](#screenshots)
+ [Technology Used](#technology-used)
+ [Set up Instructions](#setup-instructions)
+ [Licence](#licence)
+ [Authors Info](#authors-Info)

# Description
<p>An application where users can create quotes and have those quotes voted on whether they are terrible or are inspirational.</p>

[Go Back to the top](#douglas-fir)

# Screenshots
![Landing page screenshot](/src/main/resources/public/images/luku.png "Landing page")
![Add sighting page screenshot](/src/main/resources/public/images/luku2.png "Add sighting page")

# Technology Used
* HTML5 - This was used for structuring the page.

* CSS3 - This was used for styling the page.

* Java Spark - backend logic and routing

* Postgresql - Data store for application data

* Heroku - deployment for live version

[How to set up](#setup-instructions)
#### In PSQL:
* CREATE DATABASE wildlife_tracker; 
* CREATE TABLE animals(id serial PRIMARY KEY, animalName varchar, category varchar, health varchar, age varchar);
* CREATE TABLE sightings (id serial PRIMARY KEY, animalName varchar, rangerName varchar, timeOfSight timestamp);

[Live link](https://riko-douglas-fir.herokuapp.com/)

[Go Back to the top](#douglas-fir)

# Licence

[Licence](LICENSE)

[Go Back to the top](#douglas-fir)

# Authors Info

Linkedin - [Chacha John](https://www.linkedin.com/in/chachaup/)

Twitter - [Chacha](https://www.twitter.com/_chachaup)

Email - [Chacha John](mailto:chachaerickjo@gmail.com)

[Go Back to the top](#douglas-fir)
