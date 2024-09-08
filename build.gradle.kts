plugins {
    id("java-library")
    id("jacoco")
    alias(libs.plugins.release)
}

group = "com.github.alexey-lapin.m3u8-parser"
version = scmVersion.version

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withSourcesJar()
    withJavadocJar()
}

dependencies {
    annotationProcessor(libs.immutables.value)

    compileOnly(libs.immutables.value)

    testImplementation(libs.junit)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}