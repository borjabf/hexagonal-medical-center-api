# 🏥 Medical Centers API - Hexagonal Architecture
Este es un microservicio para la gestión de centros médicos, desarrollado siguiendo los principios de la Arquitectura Hexagonal (Ports & Adapters) para garantizar un código desacoplado, testeable y fácil de mantener.

## 🚀 Tecnologías Utilizadas
- Java 21 (LTS)
- Spring Boot 3.x (Framework principal)
- MongoDB (Base de datos NoSQL)
- Docker & Docker Compose (Containerización y orquestación)
- JUnit 5 & Mockito (Pruebas unitarias y mocks)
- Swagger / OpenAPI 3 (Documentación interactiva)
- MapStruct (Mapeo de objetos entre capas)

## 🏗️ Arquitectura
El proyecto está dividido en tres capas principales para asegurar la separación de responsabilidades:

1. **Dominio (Domain)**: El corazón de la aplicación. Contiene los modelos de negocio y las interfaces (puertos) que definen cómo se comunica el mundo exterior con la lógica.


2. **Aplicación (Application)**: Contiene los casos de uso (servicios) que implementan la lógica de negocio, permaneciendo totalmente agnósticos a la tecnología (bases de datos o frameworks).


3. **Infraestructura (Infrastructure)**: La capa más externa. Contiene las implementaciones técnicas: controladores REST, persistencia en MongoDB y configuraciones de Spring.

 ## 🛠️ Instalación y Ejecución rápida
 Levanta el entorno completo (**Microservicio + MongoDB**) sin configurar nada localmente.

> 1. Clona el repositorio en tu máquina.
> 2. Asegúrate de tener Docker Desktop iniciado.
> 3. En la raíz del proyecto, lanza el despliegue:
>
> ```bash
> docker compose up --build
> ```
>
✨ **¡Listo!** Accede a la documentación interactiva en: [http://localhost:8080/swagger](http://localhost:8080/swagger)
## 📖 Documentación (Swagger)
Una vez que la aplicación esté corriendo, puedes explorar y probar todos los endpoints de la API de forma visual desde el navegador:


**Desde aquí puedes realizar operaciones CRUD completas:**

* ![POST](https://img.shields.io/badge/POST-brightgreen) `/api/v1/centers` — Crear un nuevo centro.
* ![GET](https://img.shields.io/badge/GET-blue) `/api/v1/centers` — Listar todos los centros.
* ![GET](https://img.shields.io/badge/GET-blue) `/api/v1/centers/{id}` — Buscar por ID único.
* ![DELETE](https://img.shields.io/badge/DELETE-red) `/api/v1/centers/{id}` — Eliminar un centro.
---
## 👤 Autor

**Borja Bajo** — *Software Developer*

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/borja-bajo)
