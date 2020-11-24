plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "me.thunderstorm010"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.jsoniter:jsoniter:0.9.23")

}

java {
    withSourcesJar()
    withJavadocJar()
}