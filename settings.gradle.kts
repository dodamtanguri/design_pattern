plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "design_pattern"
include("src:main:java")
findProject(":src:main:java")?.name = "java"
