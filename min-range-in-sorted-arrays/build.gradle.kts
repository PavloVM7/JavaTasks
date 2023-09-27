plugins {
    id("application")
}
group = "com.pm.testtasks.task"
version = "0.0.1"

application {
    applicationDefaultJvmArgs = listOf("-Xmx128M")
    mainClass.set("com.pm.testtasks.task.minrangearrays.Main")
}
dependencies {
    val jmhVersion = "1.37"
    testImplementation("org.openjdk.jmh:jmh-core:$jmhVersion")
    testAnnotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:$jmhVersion")
}