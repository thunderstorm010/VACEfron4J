plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("maven-publish")
}

group = "com.github.thunderstorm010"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.jsoniter:jsoniter:0.9.23")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.0.1")
}

tasks.test {
    useJUnitPlatform()
}