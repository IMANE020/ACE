# ⚙️ Backend - eBank Application (Spring Boot)

## 📋 Description

Backend développé avec **Spring Boot 3** pour l'application bancaire **eBank**. Cette API REST sécurisée gère l'authentification, les opérations bancaires, la gestion des clients et des comptes.

## ⚙️ Technologies Utilisées

- **Java 17+**
- **Spring Boot 3**
- **Spring Security** avec JWT
- **Spring Data JPA**
- **H2 Database** (base de données en mémoire pour le développement)
- **JJWT** (pour la génération et validation des tokens JWT)
- **Maven** (gestion des dépendances)
- **Lombok** (réduction du code boilerplate)
- **Spring Boot Validation** (validation des données)

## 🏗️ Structure du Projet

```
backend/
├── src/main/java/com/bank/
│   ├── config/                    # Configurations Spring
│   │   ├── SecurityConfig.java    # Configuration Spring Security
│   │   ├── WebConfig.java         # Configuration CORS et Web
│   │   └── JwtAuthenticationFilter.java # Filtre JWT
│   ├── controller/                # Contrôleurs REST
│   │   ├── AuthController.java    # Authentification
│   │   ├── ClientController.java  # Gestion clients
│   │   ├── AccountController.java # Gestion comptes
│   │   ├── TransferController.java # Opérations de virement
│   │   └── DashboardController.java # Tableau de bord
│   ├── dto/                       # Data Transfer Objects
│   │   ├── LoginRequest.java
│   │   ├── LoginResponse.java
│   │   ├── ClientDTO.java
│   │   ├── AccountDTO.java
│   │   └── TransferRequest.java
│   ├── exception/                 # Gestion des exceptions
│   │   ├── GlobalExceptionHandler.java
│   │   ├── ResourceNotFoundException.java
│   │   └── AuthenticationException.java
│   ├── model/                     # Entités JPA
│   │   ├── User.java              # Utilisateur (CLIENT/AGENT_GUICHET)
│   │   ├── Client.java            # Client bancaire
│   │   ├── Account.java           # Compte bancaire
│   │   ├── Transaction.java       # Transaction/Opération
│   │   └── enums/                 # Énumérations
│   │       ├── Role.java
│   │       ├── AccountStatus.java
│   │       └── TransactionType.java
│   ├── repository/                # Repositories Spring Data JPA
│   │   ├── UserRepository.java
│   │   ├── ClientRepository.java
│   │   ├── AccountRepository.java
│   │   └── TransactionRepository.java
│   ├── security/                  # Configuration sécurité
│   │   ├── JwtTokenProvider.java  # Gestion des tokens JWT
│   │   ├── UserDetailsServiceImpl.java # Service d'authentification
│   │   └── PasswordEncoderConfig.java # Configuration hashage
│   ├── service/                   # Services métier
│   │   ├── AuthService.java       # Service d'authentification
│   │   ├── ClientService.java     # Service clients
│   │   ├── AccountService.java    # Service comptes
│   │   ├── TransferService.java   # Service virements
│   │   ├── DashboardService.java  # Service tableau de bord
│   │   └── EmailService.java      # Service envoi emails
│   ├── util/                      # Utilitaires
│   │   ├── RIBGenerator.java      # Génération de RIB
│   │   ├── DateUtils.java         # Utilitaires dates
│   │   └── Constants.java         # Constantes de l'application
│   └── BankApplication.java       # Classe principale Spring Boot
├── src/main/resources/
│   ├── application.properties      # Configuration Spring
│   ├── data/                       # Données initiales (optionnel)
│   │   └── data.sql               # Script SQL pour données de test
│   └── templates/                  # Templates email (Thymeleaf)
│       └── welcome-email.html
├── target/                         # Fichiers générés
├── pom.xml                         # Dépendances Maven
└── README.md
```

## 🔧 Prérequis

- **Java 17** ou supérieur
- **Maven 3.6+**
- **IDE** (IntelliJ IDEA, Eclipse, VS Code)

## 📦 Installation et Configuration

### 1. Cloner le projet

```bash
git clone [url-du-repo]
cd backend
```

### 2. Configurer l'application

Modifiez `src/main/resources/application.properties` selon votre environnement :

```properties
# Port d'exécution
server.port=8080

# Base de données H2
spring.datasource.url=jdbc:h2:mem:ebankdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# JWT Configuration
jwt.secret=votre-cle-secrete-jwt-changez-cela-en-production
jwt.expiration=3600000 # 1 heure en millisecondes

# Email (pour l'envoi des identifiants)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=votre-email@gmail.com
spring.mail.password=votre-mot-de-passe-app
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 3. Construire le projet

```bash
mvn clean install
```

### 4. Exécuter l'application

```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse : [http://localhost:8080](http://localhost:8080)

## API Endpoints

### Authentification
- `POST /api/auth/login` - Authentification utilisateur
- `POST /api/auth/change-password` - Changement de mot de passe
- `POST /api/auth/refresh-token` - Rafraîchissement du token

### Clients (Agent uniquement)
- `POST /api/clients` - Créer un nouveau client
- `GET /api/clients/{id}` - Récupérer un client par ID
- `GET /api/clients/cin/{cin}` - Récupérer par CIN

### Comptes (Agent uniquement)
- `POST /api/accounts` - Créer un nouveau compte
- `GET /api/accounts/client/{clientId}` - Comptes d'un client
- `PUT /api/accounts/{id}/status` - Changer le statut d'un compte

### Tableau de bord (Client)
- `GET /api/dashboard` - Tableau de bord client
- `GET /api/dashboard/accounts/{accountId}/transactions` - Transactions d'un compte

### Virements (Client)
- `POST /api/transfers` - Effectuer un virement
- `GET /api/transfers/history` - Historique des virements

## 🗄️ Base de données H2

Une base de données H2 en mémoire est utilisée pour le développement. L'interface web H2 Console est disponible à : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Paramètres de connexion H2 Console :
- **JDBC URL**: `jdbc:h2:mem:ebankdb`
- **Username**: `sa`
- **Password**: (laisser vide)

## 🔐 Sécurité JWT

L'application utilise JSON Web Tokens pour l'authentification :

1. **Authentification** : L'utilisateur se connecte avec login/mot de passe
2. **Token Génération** : Le backend génère un token JWT signé
3. **Token Stockage** : Le frontend stocke le token dans le localStorage
4. **Requêtes Authentifiées** : Le token est envoyé dans l'en-tête `Authorization: Bearer <token>`
5. **Expiration** : Le token expire après 1 heure (configurable)

## 📏 Règles Métier Implémentées

### RG_1 : Mot de passe crypté
- Utilisation de BCryptPasswordEncoder pour le hashage

### RG_4 : CIN unique
- Contrainte d'unicité au niveau base de données et validation

### RG_6 : Email unique
- Validation d'unicité de l'email

### RG_7 : Envoi d'email
- Envoi automatique des identifiants au nouveau client

### RG_8 : Vérification CIN existant
- Validation de l'existence du client avant création de compte

### RG_9 : Validation RIB
- Génération et validation de RIB valide

### RG_11 : Compte non bloqué
- Vérification du statut du compte avant opération

### RG_12 : Solde suffisant
- Validation du solde avant virement

### RG_13 & RG_14 : Débit/Crédit
- Mise à jour automatique des soldes

### RG_15 : Traçabilité
- Enregistrement précis des transactions avec date/heure

## 🧪 Tests

Exécuter les tests unitaires et d'intégration :

```bash
mvn test
```

## 📤 Déploiement

Pour créer un fichier JAR exécutable :

```bash
mvn clean package
```

Le JAR sera généré dans le dossier `target/`

## Dépendances Principales (pom.xml)

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- Base de données H2 -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    
    <!-- Validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- Email -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-mail</artifactId>
    </dependency>
</dependencies>
```

## Données Initiales

Le fichier `src/main/resources/data.sql` peut contenir des données de test :

```sql
-- Utilisateurs initiaux
INSERT INTO users (id, username, password, role, email, created_at) VALUES
(1, 'agent01', '$2a$10$...', 'AGENT_GUICHET', 'agent@bank.com', NOW()),
(2, 'client01', '$2a$10$...', 'CLIENT', 'client@email.com', NOW());

-- Clients de test
INSERT INTO clients (id, cin, first_name, last_name, email, address, birth_date, user_id) VALUES
(1, 'AB123456', 'John', 'Doe', 'john.doe@email.com', '123 Main St', '1990-01-01', 2);
```

---

**🎨 Frontend correspondant** : [Lien vers le dépôt frontend React](../frontend)

**👥 Auteurs** : Imane Tayb & Assia El-Attary

**📅 Date de livraison** : Décembre 2025
