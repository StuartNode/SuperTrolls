rootProject.name = "SuperTrolls"
includeBuild("../NexisApi") {
    dependencySubstitution {
        substitute(module("dev.stuart:NexisApi")).using(project(":"))
    }
}