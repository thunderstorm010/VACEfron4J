plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.github.thunderstorm010"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.jsoniter:jsoniter:0.9.23")
}
