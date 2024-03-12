plugins {
    kotlin("jvm") version "1.9.22"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.springframework.boot") version "3.0.4"
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
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

java.sourceCompatibility = JavaVersion.toVersion("17")