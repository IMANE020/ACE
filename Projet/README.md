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

![Interface Agent - Ajout Client](<img width="1172" height="831" alt="img1" src="https://github.com/user-attachments/assets/9f3972cc-c544-49b2-95df-287e28c636fd" />
)
*Formulaire d'ajout d'un nouveau client*

![Interface Agent - Création Compte](<img width="1182" height="621" alt="img3" src="https://github.com/user-attachments/assets/6f96c9e0-5c45-44b7-9c46-c49a8fc536f4" />
)
*Création d'un nouveau compte bancaire*

![Interface Agent - Dépôt/Retrait](<img width="1176" height="693" alt="img5" src="https://github.com/user-attachments/assets/787a54b2-a812-49b4-85d1-bca2f4d6ba05" />
)
*Interface de dépôt et retrait d'espèces*

### 👤 Espace Client
- **Tableau de bord** avec solde et RIB
- **Historique des 10 dernières opérations**
- **Effectuer des virements** vers d'autres comptes

![Tableau de Bord Client](<img width="1177" height="511" alt="img6" src="https://github.com/user-attachments/assets/146e3f50-0f4e-4b8a-9db0-da891109ec36" />
)
*Tableau de bord client avec historique des opérations*

![Formulaire de Virement](<img width="1187" height="585" alt="img9" src="https://github.com/user-attachments/assets/bca8388a-5861-4112-877a-037b334bcebd" />
)
*Formulaire pour effectuer un virement*

![Historique après Virement](<img width="1197" height="557" alt="img10" src="https://github.com/user-attachments/assets/186d2aa1-f046-47a5-929f-adebd25ce240" />
)
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

| Page de Connexion | Changement Mot de Passe | Notification Succès |
|-------------------|-------------------------|---------------------|
| ![Login](<img width="970" height="730" alt="img11" src="https://github.com/user-attachments/assets/ef087362-093d-4f61-8337-2f76c4d7de6a" />
) | ![Change Password](<img width="1210" height="450" alt="img7" src="https://github.com/user-attachments/assets/3d5850c2-72ab-489d-98ce-b61e752ec9fb" />
) | ![Success](<img width="1175" height="888" alt="img2" src="https://github.com/user-attachments/assets/2ca6fdf1-a24a-4e87-8464-d6d3a8ffee95" />
) |

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


**Projet réalisé dans le cadre du cours d'Architecture des Composants d'Entreprise - Décembre 2025**
