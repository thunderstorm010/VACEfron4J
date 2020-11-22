plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("maven")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.jsoniter:jsoniter:0.9.23")
}
