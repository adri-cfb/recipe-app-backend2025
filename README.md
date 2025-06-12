# recipe-app-backend2025-Adriana
REST API for managing user/admin account and recipes with ingredients, portions, calories and dietary types

## 📚 Endpoints de la API

### 👤 Users

| Método | Endpoint             | Descripción             |
|--------|----------------------|-------------------------|
| POST   | `/api/users`         | Crear usuario           |
| GET    | `/api/users/{id}`    | Obtener usuario por ID  |

**Ejemplo (POST /api/users):**
```json
{
  "username": "adriana",
  "email": "adriana@example.com",
  "password": "supersegura123",
  "role": "ADMIN"
}
