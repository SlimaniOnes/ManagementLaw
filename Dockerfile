# Utiliser l'image OpenJDK 17
FROM openjdk:17

VOLUME /tmp

# Copier le fichier JAR dans le conteneur
COPY target/managementLaw-0.0.1-SNAPSHOT.jar /app.jar

# Exposer le port 2000
EXPOSE 2000

# Commande pour exécuter l'application lorsque le conteneur démarre
CMD ["java", "-jar", "/app.jar"]
