plugins {
    kotlin("jvm")
    application
}

application {
    mainClass.set("dev.jolvera.infrastructure.Main")
}

dependencies {
    implementation("com.pulumi:pulumi:0.12.0")
    implementation("com.pulumi:aws:6.15.0")
    // Add other providers as needed (gcp, azure, etc.)

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation("ch.qos.logback:logback-classic:1.4.14")
}