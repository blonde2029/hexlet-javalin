import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    application
    kotlin("plugin.lombok") version "1.9.21"
    id("io.freefair.lombok") version "8.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}
application {
    mainClass.set("org.example.hexlet.HelloWorld")
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:5.6.1")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("io.javalin:javalin-rendering:5.6.0")
    implementation("gg.jte:jte:3.0.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("gg.jte:jte:3.0.1")
    implementation("io.javalin:javalin-rendering:5.6.2")

    implementation("org.apache.commons:commons-text:1.11.0")
    implementation("com.googlecode.owasp-java-html-sanitizer:owasp-java-html-sanitizer:20180219.1")
    implementation("com.h2database:h2:2.2.220")
    implementation("com.zaxxer:HikariCP:5.0.1")

//    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")


    //implementation(kotlin("script-runtime"))
    //implementation("org.jetbrains.kotlin:kotlin-script-runtime")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}