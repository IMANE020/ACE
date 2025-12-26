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

<img width="1172" height="831" alt="img1" src="https://github.com/user-attachments/assets/53d27569-ec8b-411f-8889-f9ea38a3839b" />

*Formulaire d'ajout d'un nouveau client*

<img width="1182" height="621" alt="img3" src="https://github.com/user-attachments/assets/97d54cd9-3f41-4657-94ad-b16f9affca47" />

*Création d'un nouveau compte bancaire*

### 💰 Gestion des Opérations Bancaires
Les agents peuvent effectuer des **dépôts** et **retraits** sur les comptes clients. Chaque opération est immédiatement enregistrée et visible dans le tableau de bord du client.

<img width="1176" height="693" alt="img5" src="https://github.com/user-attachments/assets/3ef9c466-6dab-4990-a2bc-44104ce19ddf" />

*Interface de dépôt et retrait d'espèces par l'agent*

<img width="1182" height="702" alt="Retrait" src="https://github.com/user-attachments/assets/49398904-9e32-44c6-bfd9-cfc9c7216dff" />

*Confirmation de retrait effectué avec succès*

### 👤 Espace Client - Suivi en Temps Réel
Les clients peuvent consulter leur **tableau de bord** qui affiche en temps réel :
- Leur solde actuel
- Leur RIB
- Les **10 dernières opérations** (virements, dépôts, retraits)

Chaque opération effectuée par l'agent (dépôt/retrait) ou par le client (virement) apparaît immédiatement dans l'historique avec :
- **Intitulé** de l'opération
- **Type** (CRÉDIT/DÉBIT)
- **Date** précise
- **Montant** (+ pour les crédits, - pour les débits)

<img width="1177" height="511" alt="img6" src="https://github.com/user-attachments/assets/b1c3b87c-427d-49a2-81c7-51dc2c850417" />

*Tableau de bord client avec solde et historique*

<img width="1196" height="610" alt="notif_client" src="https://github.com/user-attachments/assets/f21c3a87-0b89-4d34-94ef-27913c98baef" />

*Historique mis à jour après retrait et virement - notez les opérations DEBIT*

### 💸 Virements entre Comptes
Les clients peuvent effectuer des virements vers d'autres comptes. Le système vérifie automatiquement :
- Le solde disponible
- La validité du compte
- L'état du compte (non bloqué)

<img width="1187" height="585" alt="img9" src="https://github.com/user-attachments/assets/9a9080f5-6ecd-41eb-b5b2-bd37927eafc3" />

*Formulaire pour effectuer un virement*

****<img width="1197" height="557" alt="img10" src="https://github.com/user-attachments/assets/a42640b1-2f2f-40a8-8e75-1e60d02da129" />
*Mise à jour du solde et de l'historique après virement*

## 🔄 Flux des Opérations

1. **Agent effectue un dépôt/retrait** → Opération enregistrée
2. **Client consulte son dashboard** → Opération visible immédiatement
3. **Client effectue un virement** → Solde mis à jour en temps réel
4. **Historique** → Toutes les opérations tracées avec date et heure

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
- ✅ Mise à jour en temps réel des soldes
- ✅ Historique détaillé des transactions

## 👥 Profils de Test

**Agent de Guichet:**
- Login: `agent@gmail.com`
- Mot de passe: `agent123`

**Client:**
- Login: `Test@gmail.com`
- Mot de passe: `654321`

## 📞 Binome
Tayeb Imane @ El-Attary Assia 


---

**Projet réalisé dans le cadre du cours d'Architecture des Composants d'Entreprise - Décembre 2025**
