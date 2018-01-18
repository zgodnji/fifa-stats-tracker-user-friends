#!/usr/bin/env bash

mvn clean package

docker build -t ancina/user-friends .

docker run -d -p 8086:8086 -t ancina/user-friends