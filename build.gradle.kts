plugins {
    id("java")
    id("application")
}

group = "com.pm.testtasks.task"
version = "1.0-SNAPSHOT"

allprojects {
    apply {
        plugin("java")
    }
    group = "com.pm.testtasks.task"
    version = "0.0.1"
    repositories {
        mavenCentral()
    }

    dependencies {
//        testImplementation(platform("org.junit:junit-bom:5.10.0"))
//        testRuntimeOnly("org.junit.jupiter:junit-jupiter")
        testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }
    tasks.test {
        useJUnitPlatform()
    }
    java {
        withSourcesJar()
    }
}

application {
    applicationDefaultJvmArgs = listOf("-Xmx128M")
    mainClass.set("com.pm.testtasks.task.Main")
}
