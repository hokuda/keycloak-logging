# keycloak-logging
A custom endpoint to change log levels during runtime of Keycloak

https://stackoverflow.com/questions/63250947/how-to-change-the-log-level-during-runtime-in-quarkus を簡単に動かせるようにまとめたもの

## build

    mvn clean package

## deploy

    cp target/keycloak-logging-1.0-SNAPSHOT.jar $KCHOME/providers
    cd $KCHOME
    ./bin/kc.sh build
    ./bin/kc.sh start-dev --debug

## usage

* get log level

      curl http://localhost:8080/logging/org.keycloak

* set log level

      curl http://localhost:8080/logging/org.keycloak?level=DEBUG
