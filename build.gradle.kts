import kotlin.String

val koinVersion: String by project
val mockitoVersion: String by project

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
    testImplementation("io.insert-koin:koin-test-junit5:$koinVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoVersion")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(20)
}