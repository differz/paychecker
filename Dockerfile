FROM gradle:jdk8 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:8-jre-slim
EXPOSE 12200
COPY --from=builder /home/gradle/src/build/distributions/paychecker.tar /app/
WORKDIR /app
RUN tar -xvf paychecker.tar
WORKDIR /app/paychecker
CMD bin/paychecker