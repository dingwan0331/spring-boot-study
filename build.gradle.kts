plugins {
    kotlin("jvm") version "1.9.22"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.springframework.boot") version "3.0.4"
    id("io.kotest.multiplatform") version "5.0.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test"){
        exclude(group= "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.6.2")
    testImplementation("io.kotest:kotest-framework-datatest:5.6.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

java.sourceCompatibility = JavaVersion.toVersion("17")