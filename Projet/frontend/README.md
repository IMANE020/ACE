# Frontend - eBank Application (React)

## Description

Frontend développé avec React pour l'application bancaire **eBank**, offrant des fonctionnalités de gestion bancaire sécurisées pour deux profils utilisateurs : **CLIENT** et **AGENT_GUICHET**.

## Technologies Utilisées

- **React 18**
- **React Router DOM 6** (pour la navigation)
- **Axios** (pour les requêtes HTTP)
- **Context API** (pour la gestion d'état global d'authentification)
- **CSS Modules** (pour le style modulaire)

## Structure du Projet

```
FRONTEND/
├── node_modules/
├── public/
│   └── index.html
├── src/
│   ├── components/
│   │   └── ProtectedRoute.js          (Route protégée par authentification)
│   ├── context/
│   │   └── AuthContext.js             (Contexte d'authentification JWT)
│   ├── pages/
│   │   ├── Login.css & Login.js               (Connexion utilisateur)
│   │   ├── ClientDashboard.css & .js          (Tableau de bord client)
│   │   ├── AgentDashboard.css & .js           (Interface agent de guichet)
│   │   ├── ChangePassword.css & .js           (Changement de mot de passe)
│   │   └── Transfer.css & .js                 (Formulaire de virement)
│   ├── App.css & App.js               (Composant principal et routing)
│   ├── index.css & index.js           (Point d'entrée)
├── package.json
├── package-lock.json
└── README.md
```

## Installation

```bash
npm install
```

## Lancement en Développement

```bash
npm start
```

L'application sera accessible à l'adresse : [http://localhost:3000](http://localhost:3000)

## Configuration

Le frontend est configuré pour communiquer avec le backend Spring Boot via un proxy défini dans `package.json` (port par défaut : `8080`).

## <img width="512" height="512" alt="image" src="https://github.com/user-attachments/assets/d1eba85d-e9cd-43e7-a8b4-857b5e983766" />
Pages et Fonctionnalités

### 1. **Login** (`/login`)
- Authentification des utilisateurs (CLIENT / AGENT_GUICHET)
- Validation des identifiants avec messages d'erreur conformes aux RG
- Génération et stockage du token JWT (validité : 1 heure)

### 2. **ClientDashboard** (`/client-dashboard`)
- Affichage du solde et du RIB
- Liste des 10 dernières opérations (débits/crédits)
- Support multi-comptes avec liste déroulante
- Pagination pour consulter l'historique complet
- Lien vers la page de virement

### 3. **AgentDashboard** (`/agent-dashboard`)
- Formulaire d'ajout de nouveau client (nom, prénom, CIN, email, etc.)
- Création de nouveau compte bancaire (RIB associé à un client)
- Envoi automatique des identifiants par email au nouveau client

### 4. **Transfer** (`/transfer`)
- Formulaire de virement inter-comptes
- Vérification du solde et du statut du compte
- Saisie du RIB destinataire et du motif
- Traçabilité des opérations (date et montant)

### 5. **ChangePassword** (`/change-password`)
- Changement de mot de passe utilisateur
- Validation côté frontend et backend

## Système d'Authentification

- Utilisation de **JWT (JSON Web Token)** pour la sécurisation des sessions
- Token stocké dans le `localStorage`
- Injection automatique du token dans les entêtes Axios
- Protection des routes via `ProtectedRoute.js`
- Gestion des erreurs d'autorisation et d'expiration de session

## Règles Métier Implémentées (Frontend)

### RG_2 : Login ou mot de passe erronés
- Affichage d'un message d'erreur en cas d'échec d'authentification

### RG_3 : Expiration du token
- Redirection vers la page de login avec message "Session invalide"

### RG_11 : Compte non bloqué
- Vérification avant virement

### RG_12 : Solde suffisant
- Validation du montant du virement par rapport au solde

## Sécurité

- Toutes les routes (sauf `/login`) sont protégées par authentification
- Vérification des rôles (CLIENT / AGENT_GUICHET) pour l'accès aux fonctionnalités
- Messages d'erreur génériques en cas d'accès non autorisé

## Inspiration Interface

L'interface s'inspire des applications bancaires modernes (ex : Banque Populaire) avec :
- Design clair et professionnel
- Navigation intuitive
- Feedback utilisateur immédiat (messages, chargements, erreurs)

---

**Backend correspondant** : [Lien vers le dépôt backend Spring Boot]([Projet/backend](https://github.com/IMANE020/ACE/tree/main/Projet/backend))

**Auteurs** : Iman Tayb & Assia El-Attary

**Date de livraison** : Décembre 2025

