# Spring AI ETL Pipeline

A Spring Boot application that demonstrates an ETL (Extract, Transform, Load) pipeline using Spring AI for document processing with AI-powered keyword enrichment.

## Features

- **Document Processing**: Extract, transform, and load text documents
- **AI Integration**: Uses OpenAI API for intelligent keyword metadata enrichment
- **Text Splitting**: Automatically splits documents into manageable chunks using token-based splitting
- **REST API**: Simple HTTP endpoints for triggering the ETL pipeline and AI chat
- **Spring Boot**: Built on Spring Boot 3.4.1 with modern Java features

## Technologies

- **Java**: 22 (compiled to Java 17)
- **Spring Boot**: 3.4.1
- **Spring AI**: 1.1.2
- **Maven**: Build and dependency management
- **OpenAI API**: AI model integration (supports gpt-4o-mini and other models)

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- OpenAI API key with available quota

## Configuration

Update `src/main/resources/application.properties` with your OpenAI API key:

```properties
spring.ai.openai.api-key=your-api-key-here
spring.ai.openai.base-url=https://api.openai.com
spring.ai.openai.chat.options.model=gpt-4o-mini
spring.ai.openai.chat.options.temperature=0.7
```

## Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd spring-ai-etl-pipeline
```

2. Configure your OpenAI API key in `application.properties`

3. Build the project:
```bash
mvn clean install
```

## Running the Application

Start the application using Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### ETL Pipeline
Process documents through the ETL pipeline:
```bash
GET http://localhost:8080/etl
```

This endpoint:
1. Loads text from `src/main/resources/input.txt`
2. Splits the text into chunks using token-based splitting
3. Enriches each chunk with AI-generated keywords
4. Writes the processed documents to `output.txt`

### AI Chat
Simple chat endpoint:
```bash
GET http://localhost:8080/api/ai/chat?message=Your message here
```

### AI Streaming Chat
Streaming chat responses:
```bash
GET http://localhost:8080/api/ai/stream?message=Your message here
```

## Project Structure

```
src/
├── main/
│   ├── java/hope/com/
│   │   ├── Main.java                      # Spring Boot application entry point
│   │   ├── controller/
│   │   │   ├── ChatController.java        # AI chat endpoints
│   │   │   └── ETLDocController.java      # ETL pipeline endpoint
│   │   └── service/
│   │       ├── ETLLoaderService.java      # Document loading service
│   │       ├── ETLTransformerService.java # Document transformation service
│   │       └── ETLWritterService.java     # Document writing service
│   └── resources/
│       ├── application.properties         # Application configuration
│       └── input.txt                      # Input document for ETL
└── pom.xml                                # Maven configuration
```

## How It Works

### ETL Pipeline Flow

1. **Extract**: `ETLLoaderService` reads the input text file
2. **Transform**: `ETLTransformerService` splits text into chunks and enriches with AI-generated keywords
3. **Load**: `ETLWritterService` writes processed documents to output file

### AI Integration

The application uses Spring AI's `KeywordMetadataEnricher` to automatically generate relevant keywords for each document chunk using the configured AI model.

## Development

### Building
```bash
mvn clean compile
```

### Running Tests
```bash
mvn test
```

### Packaging
```bash
mvn clean package
```

## Troubleshooting

### Port 8080 Already in Use
```bash
lsof -ti:8080 | xargs kill -9
```

### API Quota Exceeded
Ensure your OpenAI API key has sufficient credits at https://platform.openai.com/account/billing

## License

This project is for educational and demonstration purposes.

## Author

soni-world

