# eBank - Application de Gestion Bancaire

## 📋 Description

Application web complète de gestion bancaire développée avec **Spring Boot** (backend) et **React** (frontend). L'application offre des fonctionnalités bancaires sécurisées pour deux types d'utilisateurs : **Clients** et **Agents de Guichet**.

## 🎯 Fonctionnalités Principales

### 🔐 Authentification Sécurisée
- Connexion avec JWT (validité 1 heure)
- Deux rôles : CLIENT et AGENT_GUICHET
- Changement de mot de passe

### 👤 Espace Agent Guichet
- **Ajout de nouveaux clients** avec envoi d'identifiants par email
- **Création de comptes bancaires** avec génération de RIB
- **Opérations de dépôt/retrait** sur les comptes clients

<img width="1172" height="831" alt="img1" src="https://github.com/user-attachments/assets/d5d34ba6-a1b5-49db-b2ac-cf03b5a6d89b" />

*Formulaire d'ajout d'un nouveau client*

<img width="1182" height="621" alt="img3" src="https://github.com/user-attachments/assets/37fa72f6-7563-4f5b-8be0-cf0a55820172" />

*Création d'un nouveau compte bancaire*

<img width="1176" height="693" alt="img5" src="https://github.com/user-attachments/assets/3b8c9d01-aaf1-46d2-9c36-0ba4435a7a7b" />

*Interface de dépôt et retrait d'espèces*

### 👤 Espace Client
- **Tableau de bord** avec solde et RIB
- **Historique des 10 dernières opérations**
- **Effectuer des virements** vers d'autres comptes

<img width="1177" height="511" alt="img6" src="https://github.com/user-attachments/assets/5153e2a3-7972-47cd-9b27-76a48827184c" />

*Tableau de bord client avec historique des opérations*

<img width="1187" height="585" alt="img9" src="https://github.com/user-attachments/assets/c83102a9-edb7-45fa-aad6-39bbcfa21fa2" />

*Formulaire pour effectuer un virement*

<img width="1197" height="557" alt="img10" src="https://github.com/user-attachments/assets/cee78ac2-de61-4cc2-992b-f2f38070544b" />

*Mise à jour du solde après virement*

## 🛠️ Architecture Technique

### Backend (Spring Boot)
- **Spring Boot 3** avec Spring Security
- **JWT** pour l'authentification
- **Spring Data JPA** avec base H2
- **API REST** complète

### Frontend (React)
- **React 18** avec Hooks
- **React Router** pour la navigation
- **Context API** pour la gestion d'état
- **Axios** pour les requêtes HTTP

## 🚀 Installation Rapide

### Backend
```bash
cd backend
mvn spring-boot:run
```
*Serveur démarré sur http://localhost:8080*

### Frontend
```bash
cd frontend
npm install
npm start
```
*Application accessible sur http://localhost:3000*

## 📱 Captures d'Écran
Page de Connexion: 
<img width="970" height="730" alt="img11" src="https://github.com/user-attachments/assets/ff62131a-fe5f-4855-b14e-e47cbe3533f9" />

Changement Mot de passe:
<img width="1210" height="450" alt="img7" src="https://github.com/user-attachments/assets/16d61d8c-61dc-42bd-8b2e-7d17f8f99def" />

Notification Succès:
<img width="1176" height="447" alt="img8" src="https://github.com/user-attachments/assets/dcd023d6-af3a-4d45-a509-792182085135" />

## 🔒 Sécurité

- Authentification JWT avec expiration automatique
- Hashage BCrypt pour les mots de passe
- Validation des données côté serveur
- Protection des routes par rôle utilisateur

## 📊 Règles Métier Implémentées

- ✅ Validation des identifiants uniques (CIN, email)
- ✅ Vérification du solde avant virement
- ✅ Traçabilité complète des opérations
- ✅ Envoi d'emails automatisés
- ✅ Gestion des statuts de comptes

## 👥 Profils de Test

**Agent de Guichet:**
- Login: `agent@gmail.com`
- Mot de passe: `agent123`

**Client:**
- Login: `Test@gmail.com`
- Mot de passe: `654321`

---

**Projet réalisé dans le cadre du cours d'Architecture des Composants d'Entreprise - Décembre 2025**
