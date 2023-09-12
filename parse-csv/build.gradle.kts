plugins {
    id("application")
}

group = "com.pm.testtasks.task"
version = "0.0.1"

application {
    applicationDefaultJvmArgs = listOf("-Xmx128M")
    mainClass.set("com.pm.testtasks.task.parsecsv.Main")
}