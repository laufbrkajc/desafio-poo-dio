FROM eclipse-temurin

RUN mkdir /app

COPY out/ /app

WORKDIR /app

CMD java Main
