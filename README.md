Challenge Conversor de Monedas - Alura ONE Java Back End

Este proyecto fue desarrollado como parte del Challenge ONE - Back End Java de Oracle + Alura LATAM, con el objetivo de construir una aplicación que permita convertir monedas en tiempo real utilizando una API de tasas de cambio.

Tecnologías utilizadas

Java 17

Maven

Gson (Google)

ExchangeRate API (v6.exchangerate-api.com)

HTTPURLConnection

IntelliJ IDEA / VS Code

Descripción del proyecto

El Conversor de Monedas permite realizar conversiones entre distintas divisas utilizando una API externa actualizada.
El usuario puede seleccionar desde un menú las monedas que desea convertir y el sistema mostrará el valor actualizado.

El proyecto está estructurado siguiendo buenas prácticas de programación orientada a objetos, con clases separadas para la lógica de negocio, la conexión a la API y la presentación.

Funcionalidades principales

Conversión entre monedas (ej. USD ↔ EUR, USD ↔ COP, etc.)

Solicitudes HTTP a la API ExchangeRate.

Lectura dinámica de tasas de cambio en tiempo real.

Menú interactivo por consola.

Manejo de errores ante respuestas inválidas o claves API incorrectas.

Instalación y ejecución

Clonar el repositorio:

git clone https://github.com/jhon-rendon/Challenge-Conversor-de-Monedas.git
cd Challenge-Conversor-de-Monedas


Compilar y ejecutar el proyecto con Maven:

mvn clean package
java -jar target/conversor-moneda-1.0.jar


O ejecutar directamente desde tu IDE (IntelliJ / VS Code).

Configurar tu API Key

Regístrate en ExchangeRate API
.

Obtén tu API Key personal.

En el archivo ExchangeRateService.java, reemplaza:

private static final String API_KEY = "YOUR-API-KEY";


por tu clave:

private static final String API_KEY = "tu_api_key_aquí";

🧮 Ejemplo de uso
===============================
Conversor de Monedas
===============================
1. Dólar (USD) → Peso Colombiano (COP)
2. Euro (EUR) → Dólar (USD)
3. Peso Mexicano (MXN) → Dólar (USD)
4. Salir
   Seleccione una opción: 1
   Ingrese la cantidad a convertir: 10
   Resultado: 10 USD = 40,200.00 COP

📦 Estructura del proyecto
📁 conversor-moneda
┣ 📂 src
┃ ┗ 📂 main
┃   ┣ 📂 java
┃   ┃ ┗ 📂 com.jhonrendon.conversor
┃   ┃   ┣ 📜 Main.java
┃   ┃   ┣ 📜 Menu.java
┃   ┃   ┣ 📜 ExchangeRateService.java
┃   ┃   ┗ 📜 CurrencyConverter.java
┃   ┗ 📂 resources
┗ 📜 pom.xml