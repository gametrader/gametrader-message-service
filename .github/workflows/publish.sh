#!/usr/bin/env bash
cd client
sed -i "s/gametrader-message-service-rest-client/gametrader-message-service-rest-client$1/" settings.gradle
./gradlew publish