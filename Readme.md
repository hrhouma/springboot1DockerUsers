# Java CRUD REST API avec Spring Boot, Hibernate, PostgreSQL, Docker, et Docker Compose

Ce projet illustre la mise en place d'une API REST en Java utilisant Spring Boot, Hibernate, PostgreSQL, Docker, et Docker Compose.

## Ressources

- Article de référence sur le développement de l'API : [DEV.TO](https://dev.to/francescoxx/java-crud-rest-api-using-spring-boot-hibernate-postgres-docker-and-docker-compose-5cln)
- Code source sur GitHub : [FrancescoXX/java-live-api](https://github.com/FrancescoXX/java-live-api), [hrhouma/springboot1DockerUsers](https://github.com/hrhouma/springboot1DockerUsers.git)

## 1. Installation

Suivez ces étapes pour installer et démarrer le projet :

```bash
mvn clean -DskipTests
mvn install -DskipTests # création de target/*.jar
docker-compose build
docker images
docker-compose up -d
docker ps
curl http://localhost/api/users
```

## 2. Vérification PostgreSQL

Pour interagir avec PostgreSQL dans un conteneur Docker :

```bash
docker exec -it nom_du_conteneur bash # Ou 'sh' si 'bash' n'est pas disponible
```

Dans le shell PostgreSQL :

```sql
psql -U postgres -d postgres
\l # Lister toutes les bases de données
\c postgres # Se connecter à la base de données 'postgres'
\dt # Lister toutes les tables
\d users # Afficher la structure de la table 'users'
SELECT * FROM users; # Sélectionner tous les enregistrements de 'users'
\h # Aide sur les commandes SQL
\h SELECT # Aide sur la commande SELECT
\q # Quitter
```

## 3. CRUD

Pour interagir avec l'API REST :

```http
### Obtenir tous les utilisateurs
GET http://localhost:8080/api/users
Content-Type: application/json

### Obtenir un utilisateur par ID
GET http://localhost:8080/api/users/1
Content-Type: application/json

### Créer un nouvel utilisateur
POST http://localhost:8080/api/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "johndoe@example.com"
}

### Mettre à jour un utilisateur
PUT http://localhost:8080/api/users/1
Content-Type: application/json

{
  "name": "Jane Doe",
  "email": "janedoe@example.com"
}

### Supprimer un utilisateur
DELETE http://localhost:8080/api/users/1
Content-Type: application/json
```
Utilisez l'extension REST Client de VS Code pour envoyer ces requêtes : [REST Client on Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=humao.rest-client).

## 4. Aller Plus Loin Avec PostgreSQL

Pour approfondir vos connaissances sur PostgreSQL, consultez [ce tutoriel sur Tutorialspoint](https://www.tutorialspoint.com/postgresql/postgresql_select_query.htm).


```markdown
# Aller Plus Loin Avec PostgreSQL

Pour approfondir vos connaissances sur PostgreSQL, consultez [ce tutoriel sur Tutorialspoint](https://www.tutorialspoint.com/postgresql/postgresql_select_query.htm).

## Sauvegarder l'état actuel dans la branche version0

```bash
git checkout main
git checkout -b version0
git push -u origin version0
```

## Retourner à la branche main

```bash
git checkout main
```

## Créer et commencer le travail sur version1

```bash
git checkout -b version1
# Faites vos modifications puis...
git add .
git commit -m "Début des travaux sur version1"
git push -u origin version1
```
```

