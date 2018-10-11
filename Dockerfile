FROM gradle:jdk8 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --info

FROM openjdk:8-jre-alpine
EXPOSE 5000
COPY --from=builder /home/gradle/src/build/distributions/paychecker.tar /app/
WORKDIR /app
RUN tar -xvf paychecker.tar
RUN rm /app/paychecker.tar
WORKDIR /app/paychecker
CMD bin/paychecker
