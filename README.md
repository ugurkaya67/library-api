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
