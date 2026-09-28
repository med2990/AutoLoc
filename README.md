# AutoLoc — Acteurs et cas d'utilisation (Séance 1)

## 1. Contexte

**AutoLoc** est une application de gestion de location de véhicules entre agences.
Ce document présente la première identification des **acteurs** et des **cas d'utilisation** réalisée lors de la Séance 1.

---

## 2. Acteurs identifiés

| Acteur | Description | Type |
|---|---|---|
| **Client** | Personne souhaitant louer un véhicule auprès d'une agence. | Acteur principal |
| **Agent d'agence** | Employé chargé de gérer les locations, les véhicules et les clients au quotidien dans son agence. | Acteur principal |
| **Responsable d'agence** | Responsable supervisant l'activité d'une agence (véhicules, agents, statistiques). | Acteur principal |
| **Administrateur** | Gestionnaire de l'application : comptes, rôles, paramétrage global. | Acteur principal |

---

## 3. Cas d'utilisation par acteur

### 3.1 Client

- Consulter le catalogue des véhicules disponibles
- Rechercher un véhicule (par catégorie, agence, dates)
- Créer un compte / s'authentifier
- Effectuer une réservation
- Modifier ou annuler une réservation
- Consulter l'historique de ses locations
- Consulter / imprimer sa facture

### 3.2 Agent d'agence

- S'authentifier
- Gérer les véhicules de son agence (ajout, modification, disponibilité)
- Enregistrer une location (départ du véhicule)
- Enregistrer le retour d'un véhicule
- Gérer les clients de son agence
- Consulter et imprimer les factures
- Consulter le planning des réservations

### 3.3 Responsable d'agence

- S'authentifier
- Gérer les agents de son agence (création, affectation)
- Superviser les véhicules de son agence
- Consulter les statistiques d'activité (locations, revenus, taux d'occupation)
- Valider ou refuser des opérations sensibles (remises, annulations)
- Consulter les rapports de son agence

### 3.4 Administrateur

- S'authentifier
- Gérer les comptes utilisateurs (création, désactivation, rôles)
- Gérer les agences
- Gérer les catégories de véhicules et les tarifs
- Paramétrer l'application (règles, options globales)
- Consulter les journaux / audits
- Effectuer des sauvegardes / restaurations

---

## 4. Remarques

- Cette liste est **préliminaire** : elle sera affinée lors des séances suivantes (ajout possible d'acteurs secondaires tels qu'un **système de paiement** ou un **service de maintenance**).
- Les cas d'utilisation seront détaillés (description, préconditions, scénario nominal, exceptions) dans les diagrammes et fiches descriptives à venir.
