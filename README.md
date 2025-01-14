# Library API 📚

Une API RESTful pour gérer une bibliothèque. Ce projet est développé avec **Spring Boot** et utilise une base de données H2 en mémoire pour stocker les données.

## Fonctionnalités

- **Gestion des livres**
  - Ajouter un livre
  - Consulter la liste des livres
  - Récupérer les détails d’un livre spécifique
  - Supprimer un livre
- **Base de données en mémoire**
  - Utilisation de H2 pour stocker les données
  - Accès via une console H2 intégrée
- **Endpoints REST**
  - Construits avec Spring Boot et Spring Data JPA

## Technologies utilisées

- **Langage** : Java
- **Framework** : Spring Boot
- **Base de données** : H2 (en mémoire)
- **Outils** :
  - Maven pour la gestion des dépendances
  - cURL ou Postman pour tester l'API

## Installation et exécution

### Pré-requis
- **Java 17** ou une version compatible
- **Maven**

### Étapes
1. Clonez le projet :
```bash
   git clone <url-du-repo>
   cd library-api
```
2. Compiler le projet : 
```bash
    mvn spring-boot:run
```
3. Accédez à l'application à l'adresse :

- ***API REST :*** http://localhost:8080
- ***Console H2 :*** http://localhost:8080/h2-console

Informations pour la console H2 :

- ***JDBC URL : jdbc:h2:mem:testdb***
- ***Nom d'utilisateur : sa***
- ***Mot de passe : (vide)***

Endpoints

Livres

   Méthode   |   Endpoint          |   Description               |
|---         |:-:    |:-:          |
|   GET      |   /api/books        |   Récupérer tous les livres |
|   POST     |  /api/books         |   Ajouter un nouveau livre  |
|   GET      |   /api/books/{id}   |   Récupérer un livre par ID |
|   DELETE   |  /api/books/{id}    |   Supprimer un livre par ID |


Exemple de requête
Ajouter un livre
bash
```bash
curl -X POST http://localhost:8080/api/books \
-H "Content-Type: application/json" \
-d '{"title": "1984", "author": "George Orwell", "isbn": "9780451524935"}'
```

Récupérer tous les livres
bash
```bash
curl -X GET http://localhost:8080/api/books
```