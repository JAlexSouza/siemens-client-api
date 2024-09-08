// CRIAR UM AMBIENTE COM JDK E MAVEN
// COMPILAR A NOSSA APLICAÇÃO
// EXECUTAR O COMMANDO DO JAVA PARA EXECUTAR A APLICAÇÃO

# Use the official Ubuntu image as the base
FROM ubuntu:20.04 as build

# Set environment variables to non-interactive to avoid prompts during package installation
ENV DEBIAN_FRONTEND=noninteractive

# Update package list and install prerequisites
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    openjdk-21-jdk \
    maven \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Install Maven 3.9.9 (note: Maven is already available in the default Ubuntu repos, but for a specific version you might need to download it manually)
RUN wget https://downloads.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip \
    && unzip apache-maven-3.9.9-bin.zip -d /opt \
    && ln -s /opt/apache-maven-3.9.9 /opt/maven \
    && rm apache-maven-3.9.9-bin.zip

# Set up environment variables for Maven
ENV MAVEN_HOME=/opt/maven
ENV PATH="${MAVEN_HOME}/bin:${PATH}"

# Verify installations
RUN java -version && mvn -version

# Copying our project
RUN mkdir -p /usu/src/app

# Set the working directory
WORKDIR /usu/src/app

ADD . /usu/src/app

RUN mvn package

FROM confidencerepo/git-openjdk21:latest
# Copying our project
RUN mkdir -p /usu/src/app

# Set the working directory
WORKDIR /usu/src/app

COPY --from=build /usu/src/app/target/siemens-client-api-0.0.1-SNAPSHOT.jar app.jar

# Default command
CMD ["java","-jar","app.jar"]