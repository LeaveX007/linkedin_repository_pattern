import kotlin.String

val koinVersion: String by project
val ktorVersion: String by project

plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.michael-pfeffer-consulting"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Koin
    implementation(project.dependencies.platform("io.insert-koin:koin-bom:$koinVersion"))
    implementation("io.insert-koin:koin-core")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(20)
}