#!/bin/bash

# Java 17'yi kullan
export JAVA_HOME=/opt/java/openjdk17
export PATH=$JAVA_HOME/bin:$PATH

# Maven'in doğru çalışması için ayarlar
export MAVEN_OPTS="-Xmx1024m"

# Maven projesini derle
mvn clean package
