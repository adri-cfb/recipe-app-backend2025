# 🍎 Healthy Recipe API 🍏

REST API built with Java and Spring Boot for managing healthy recipes. Allows users to create accounts, add recipes with their ingredients, and categorize them by food type and category.

---

##  Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Postman (for testing)

---
## Diagarams

### Draft Diagram
![image.png](recipe-app-backend2025/src/main/resources/static/image.png)
![image (1).png](recipe-app-backend2025/src/main/resources/static/image%20%281%29.png)

### Final Diagram
<div class="sl-block is-focused" data-block-type="image" data-name="image-dba733" style="width: 374px; height: 707.143px; left: 17.3735px; top: 0px; min-width: 1px; min-height: 1px;" data-origin-id="25985c2af301b3e0cbd83f4d59dd69d0"><div class="sl-block-content" style="z-index: 13; transition-duration: 0.6s; transition-delay: 0.3s;" data-animation-type="slide-left"><img style="" data-natural-width="714" data-natural-height="1350" data-lazy-loaded="" src="https://s3.amazonaws.com/media-p.slid.es/uploads/2943065/images/12200616/DiagramIntellij.png"></div></div>


---

##  Project Structure

```
recipe-app-backend2025
   ── controller
   ── service
   ── model
   ── repository
   ── dto
   ── exception
   ── config (pending to be completed)
```

---

##  Main Endpoints

### USERS

| Method | Endpoint | Description |
| ------ | ----------------- | ---------------------------- |
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get a user by ID |
| POST | `/api/users` | Create new user |
| PUT | `/api/users/{id}` | Update existing user |
| DELETE | `/api/users/{id}` | Delete user by ID |

### RECIPES

| Method | Endpoint | Description |
| ------ | ------------------- | ------------------------- |
| GET | `/api/recipes` | Get all recipes |
| GET | `/api/recipes/{id}` | Get recipe by ID |
| POST | `/api/recipes` | Create new recipe |
| PUT | `/api/recipes/{id}` | Update recipe |
| DELETE | `/api/recipes/{id}` | Delete recipe by ID |

### INGREDIENTS

| Method | Endpoint | Description |
| ------ | ----------------------- | ------------------------------ |
| GET | `/api/ingredients` | Get all ingredients |
| POST | `/api/ingredients` | Create new ingredient |
| PUT | `/api/ingredients/{id}` | Update ingredient |
| DELETE | `/api/ingredients/{id}` | Delete ingredient by ID |

---

##  Error Handling

- `UserNotFoundException`
- `RecipeNotFoundException`
- `IngredientNotFoundException`
- `EmailExistsException`

All handled with a global `@ControllerAdvice` handler.

---

##  Security

`Not implemented. Planned for future improvements.`

---

##  Completed Features

- Full CRUD for users, recipes, and ingredients
- Entity relationships
- Annotated validations
- Custom error handling
- Implemented UserDTO

---

##  Future Improvements

- Authentication and authorization with Spring Security and JWT
- Implemented RecipeDTO and IngredientDTO

---

##  POST Request Example (User)
[Postman_testresults_Adriana_Finalproyect.pdf](recipe-app-backend2025/src/main/resources/static/Postman_testresults_Adriana_Finalproyect.pdf)
``` json
{
"username": "adriana",
"email": "adriana@example.com",
"password": "123456",
"role": "ADMIN"
}
```

---
##  Proyect tracking with Trello & Slide

- https://trello.com/b/8tm28IRj
- https://slides.com/d/kRmR5BE/speaker/ei6k8q8
---

##  🌟 Author

### Adriana Fernández. 
www.linkedin.com/in/adriana-fernandez-bracamonte
 
Final project 
Ironhack - Back-end BootCamp 2025