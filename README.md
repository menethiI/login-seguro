## Login Seguro com Spring Boot, Thymeleaf e MongoDB Atlas
 
Este projeto é um sistema completo de autenticação e autorização de usuários, desenvolvido em **Java com Spring Boot**, utilizando **MongoDB Atlas** como banco de dados e **Thymeleaf** para renderização das páginas HTML. O foco principal é segurança, escalabilidade e boas práticas de desenvolvimento.
 
---
 
## Funcionalidades
 
- Cadastro de usuários com validação completa de dados
- Login seguro com criptografia de senha (BCrypt)
- Controle de sessão com Spring Security
- Restrição de acesso por perfil (ADMIN, USER, etc.)
- Logout funcional com redirecionamento
- Validações backend e frontend para todos os campos
- Armazenamento seguro no MongoDB Atlas
 
---
 
## Tecnologias utilizadas
 
- Java 17
- Spring Boot 3
- Spring Security
- Spring Data MongoDB
- Thymeleaf
- Lombok
- MongoDB Atlas
   
---
 
## Telas disponíveis
 
| Tela           | Descrição                                   |
|----------------|----------------------------------------------|
| `/login`       | Página de login com validações de acesso     |
| `/cadastro`    | Tela de cadastro com confirmação de senha    |
| `/home`        | Página protegida, acessível após login       |
| `/error`       | Página de erro personalizada                 |
 
---
 
## Regras de validação
 
### Nome:
- Obrigatório
- Máximo de 40 caracteres
- Somente letras
 
### E-mail:
- Obrigatório
- Máximo de 60 caracteres
- Somente letras, números, `@`, `.` e `-`
- Não pode já existir no banco
 
### Senha:
- Obrigatória
- Mínimo de 8 e máximo de 20 caracteres
- Deve conter letra maiúscula, minúscula, número e símbolo
 
### Confirmação de senha:
- Obrigatória
- Deve ser idêntica à senha
 
---
 
## Como rodar o projeto
 
### 1. Clonar o repositório
 
```bash
git clone https://github.com/seu-usuario/login-seguro-springboot.git
cd login-seguro-springboot
```

### 2. Configurar a string de conexão no arquivo application.properties
Recomendamos utilizar variáveis de ambiente para garantir a segurança do banco de dados
```
spring.data.mongodb.uri=${MONGO_DB_URI}
```

### 3. Build do projeto 
```
mvn clean install -DskipTests
```

### 4. Executar a aplicação
```
mvn spring-boot:run
```

Acesse no navegador:
http://localhost:8021/login

---

## Requisitos 
- JDK 17
- Maven 3.8+
- MongoDB Atlas
- STS / Eclipse / Intellij
