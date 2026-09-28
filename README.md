---

# AutoLoc — Modèle de données (Séance 2)

## 1. Contexte

Lors de la Séance 2, nous avons identifié et implémenté les **entités métier** du domaine AutoLoc sous forme de classes JPA. Cette étape pose les fondations du modèle de données **avant l'ajout des associations** entre entités (prévues en Séance 3).

Chaque entité est annotée `@Entity`, utilise Lombok (`@Getter`, `@Setter`, `@NoArgsConstructor`, etc.) et possède une clé primaire auto-générée.

## 2. Entités implémentées

| Entité | Description | Champs principaux |
|---|---|---|
| `Agence` | Agence de location de véhicules. | `idAgence`, `nom`, `adresse`, `ville`, `telephone` |
| `Client` | Client souhaitant louer un véhicule. | `idClient`, `nom`, `prenom`, `email`, `telephone`, `numPermis`, `dateInscription` |
| `Employe` | Employé d'une agence (agent ou manager). | `idEmploye`, `nom`, `prenom`, `role` |
| `Vehicule` | Véhicule de la flotte. | `idVehicule`, `immatriculation`, `marque`, `modele`, `annee`, `statut` |
| `Reservation` | Réservation d'un véhicule par un client. | `idReservation`, `dateDebut`, `dateFin`, `statut` |
| `Contrat` | Contrat de location signé. | `idContrat`, `dateSignature`, `montantTotal`, `valide` |
| `Paiement` | Paiement lié à un contrat. | `idPaiement`, `datePaiement`, `montant`, `modePaiement` |
| `Maintenance` | Maintenance d'un véhicule. | `idMaintenance`, `dateDebut`, `dateFin`, `description` |
| `Equipement` | Équipement associé à un véhicule. | `idEquipement`, `libelle` |

## 3. Énumérations métier

Les énumérations suivantes modélisent les états et rôles du domaine :

### `StatutVehicule`
- `DISPONIBLE`
- `LOUE`
- `EN_MAINTENANCE`
- `HORS_SERVICE`

### `StatutReservation`
- `EN_ATTENTE`
- `CONFIRMEE`
- `ANNULEE`
- `TERMINEE`

### `ModePaiement`
- `ESPECES`
- `CARTE`
- `VIREMENT`

### `RoleEmploye`
- `AGENT`
- `MANAGER`

## 4. Repositories Spring Data

Un repository a été créé pour chaque entité afin de gérer les opérations CRUD via Spring Data JPA :

- `VehiculeRepository` (implémenté en Séance 2)
- Les autres repositories suivront au fil des ateliers.

## 5. Données de démonstration

La classe `DataInitializer` (profil `dev`) insère automatiquement 3 véhicules au démarrage si la table `vehicule` est vide :

| Immatriculation | Marque | Modèle | Année | Statut |
|---|---|---|---|---|
| 123 TU 4567 | Renault | Clio | 2022 | DISPONIBLE |
| 789 TU 1234 | Peugeot | 208 | 2023 | DISPONIBLE |
| 456 TU 7890 | Volkswagen | Golf | 2021 | LOUE |

## 6. Schéma SQL généré

Au démarrage, Hibernate crée automatiquement les tables suivantes :

```sql
create table agence (
  id_agence bigint not null auto_increment,
  adresse varchar(255),
  nom varchar(255),
  telephone varchar(255),
  ville varchar(255),
  primary key (id_agence)
) engine=InnoDB;

create table client (
  id_client bigint not null auto_increment,
  date_inscription date,
  email varchar(255),
  nom varchar(255),
  num_permis varchar(255),
  prenom varchar(255),
  telephone varchar(255),
  primary key (id_client)
) engine=InnoDB;

create table contrat (
  id_contrat bigint not null auto_increment,
  date_signature date,
  montant_total float(53),
  valide bit,
  primary key (id_contrat)
) engine=InnoDB;

create table employe (
  id_employe bigint not null auto_increment,
  nom varchar(255),
  prenom varchar(255),
  role enum ('AGENT','MANAGER'),
  primary key (id_employe)
) engine=InnoDB;

create table equipement (
  id_equipement bigint not null auto_increment,
  libelle varchar(255),
  primary key (id_equipement)
) engine=InnoDB;

create table maintenance (
  id_maintenance bigint not null auto_increment,
  date_debut date,
  date_fin date,
  description varchar(255),
  primary key (id_maintenance)
) engine=InnoDB;

create table paiement (
  id_paiement bigint not null auto_increment,
  date_paiement date,
  mode_paiement enum ('CARTE','ESPECES','VIREMENT'),
  montant float(53),
  primary key (id_paiement)
) engine=InnoDB;

create table reservation (
  id_reservation bigint not null auto_increment,
  date_debut date,
  date_fin date,
  statut enum ('ANNULEE','CONFIRMEE','EN_ATTENTE','TERMINEE'),
  primary key (id_reservation)
) engine=InnoDB;

create table vehicule (
  id_vehicule bigint not null auto_increment,
  annee integer,
  immatriculation varchar(255),
  marque varchar(255),
  modele varchar(255),
  statut enum ('DISPONIBLE','EN_MAINTENANCE','HORS_SERVICE','LOUE'),
  primary key (id_vehicule)
) engine=InnoDB;