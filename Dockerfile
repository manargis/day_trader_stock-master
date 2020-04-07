FROM ibmjava:8-sfj
LABEL maintainer="Hemant K Vyas"


ADD target/CdayTradeApplicationDevstockservices-1.0-SNAPSHOT.jar CdayTradeApplicationDevstockservices-1.0-SNAPSHOT.jar
VOLUME /tmp
EXPOSE 8080

ENV JAVA_OPTS=""
ENV POSTGRES_DB=${POSTGRES_DB}
ENV POSTGRES_USER=${POSTGRES_USER}
ENV POSTGRES_PASSWORD=${POSTGRES_PASSWORD}
ENV POSTGRES_HOST=${POSTGRES_HOST}


ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:postgresql://${POSTGRES_HOST}/postgres","-jar","CdayTradeApplicationDevstockservices-1.0-SNAPSHOT.jar"]

