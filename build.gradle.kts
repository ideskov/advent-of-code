plugins {
    kotlin("jvm") version "1.3.61"
}

group = "ideskov"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://ci-repo.aexp.com/java-proxy/content/groups/prod")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.kittinunf.fuel:fuel:2.2.1")
    implementation("com.github.kittinunf.fuel:fuel-moshi:2.2.1")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}