plugins {
    kotlin("jvm") version "2.1.10" apply false
    id("io.ktor.plugin") version "3.0.3" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.10" apply false
    id("co.uzzu.dotenv.gradle") version "2.0.0" apply false
}

allprojects {
    group = "dev.jolvera"
    version = "0.0.1"

    repositories {
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
    }
}