/*
 * (c) Copyright 2021 Marcin Nowakowski
 */

plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("ma.glasnost.orika:orika-core:1.5.2")
    //implementation("ma.glasnost.orika:orika-core:1.6.0-SNAPSHOT")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

tasks.test {
    useJUnitPlatform()
}
