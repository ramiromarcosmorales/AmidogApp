# Amidog 🐶

Sistema para la gestión local de **propietarios, perros y turnos**. Proyecto práctico para uso local.
Enfocado en buenas prácticas de POO, JPA y organización por capas. Ideal para un negocio chico/uso en casa.

## 🚀 Features

- CRUD de **Propietarios** y **Perros**
- **Turnos** por Perro (crear, listar)
- Lecturas listas para UI.
- Validaciones de entrada (utilidad centralizada)
- Persistencia local en **MySQL**

## Arquitectura

- Capas:
  - model/ **Entidades JPA** (Propietario, Perro, Turno)
  - persistence/ **Repos JPA** (JpaController) + JpaUtil (EMF Singleton)
  - controller/ *Lógica de aplicación + Validaciones*
  - utils/ *Helpers* (ValidacionUtils)
  - view/ *UI con 3 ventanas*

- Relaciones:
  - Propietario: `1..*` Perro
  - Perro `1..*` Turno

## Configuración

## Cómo correr