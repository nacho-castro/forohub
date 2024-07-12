<h1>ForoHub API with Java Spring</h1>

<p>This project was made during AluraLatam course: REST API using Java and Spring. It allows management of questions, answers, and user authentication with JWT.</p>

<h2>Features</h2>
    <ul>
        <li><strong>Question and Answer Management:</strong> Allows CRUD operations (Create, Read, Update, Delete) on questions and answers.</li>
        <li><strong>JWT Authentication:</strong> User registration and authentication process using JSON Web Tokens (JWT) with Bearer tokens.</li>
        <li><strong>Database:</strong> Uses JPA (Java Persistence API) with Spring Data to persist data related to questions, answers, and users.</li>
    </ul>

  <h2>Technologies Used</h2>
    <ul>
        <li>Java 17</li>
        <li>Spring Boot</li>
        <li>Spring Security with JWT</li>
        <li>Spring Data JPA</li>
        <li>MySQL</li>
    </ul>

  <h2>Setup</h2>
    <ol>
        <li><strong>Clone the Repository:</strong>
            <pre><code>git clone https://github.com/your-user/forum-api.git<br>cd forum-api</code></pre>
        </li>
        <li><strong>Configure Database:</strong><br>
            Configure your SQL database in <code>application.properties</code>:<br><br>
            <pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/forum_db
            <br>spring.datasource.username=your_username
            <br>spring.datasource.password=your_password</code></pre>
        </li>
        <li><strong>Run the Application:</strong><br>
            Use Maven to compile and run the application:<br><br>
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
        <li><strong>Available Endpoints:</strong><br>
            <ul>
                <li><strong>Authentication:</strong></li>
                <ul>
                    <li><code>POST /usuario</code>: User registration.</li>
                    <li><code>POST /login</code>: User authentication (JWT retrieval).</li>
                </ul>
                <li><strong>Questions and Answers:</strong></li>
                <ul>
                    <li><code>GET /topicos</code>: Get all topics.</li>
                    <li><code>GET /topicos/{id}</code>: Get a topic by ID.</li>
                    <li><code>POST /topicos</code>: Create a new topic.</li>
                    <li><code>PUT /topicos/{id}</code>: Update an existing topic.</li>
                    <li><code>DELETE /topicos/{id}</code>: Delete a topic.</li>
                    <li><code>POST /respuestas</code>: Add an answer to a topic.</li>
                    <li><code>PUT /respuestas/{id}</code>: Update an existing answer.</li>
                    <li><code>DELETE /respuestas/{id}</code>: Delete an answer.</li>
                </ul>
            </ul>
        </li>
        <li><strong>Security:</strong><br>
            All requests that modify data (POST, PUT, DELETE) require authentication via the Bearer token in the Authorization header, obtained from <code>POST /login</code>.
        </li>
    </ol>

   <h2>Author</h2>
    <p>Ignacio Castro &lt;ignaciocastroplanas@gmail.com&gt;</p>
