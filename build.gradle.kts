plugins {
    kotlin("jvm") version "1.4.21"
    id("fabric-loom") version "0.5-SNAPSHOT"
}

val minecraft_version: String by project
val yarn_mappings: String by project
val loader_version: String by project
val fabric_version: String by project

repositories {
    maven("https://repo-new.spongepowered.org/repository/maven-public")
}

dependencies {
    minecraft("com.mojang:minecraft:${minecraft_version}")
    mappings("net.fabricmc:yarn:${yarn_mappings}:v2")
    modImplementation("net.fabricmc:fabric-loader:${loader_version}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${fabric_version}")
    implementation("org.spongepowered:spongeapi:8.0.0-SNAPSHOT")
}

val main by sourceSets

val accessors by sourceSets.registering {
    applyNamedDependencyOnOutput(originProject = project, sourceAdding = this, targetSource = main, implProject = project, dependencyConfigName = main.implementationConfigurationName)
}
val mixins by sourceSets.registering {
    applyNamedDependencyOnOutput(originProject = project, sourceAdding = accessors.get(), targetSource = this, implProject = project, dependencyConfigName = this.implementationConfigurationName)
}

fun applyNamedDependencyOnOutput(originProject: Project, sourceAdding: SourceSet, targetSource: SourceSet, implProject: Project, dependencyConfigName: String) {
    implProject.dependencies.add(dependencyConfigName, sourceAdding.output)
}

tasks {
    val kotlinOptions: org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions.() -> Unit =  {
        jvmTarget = "11"
        freeCompilerArgs = listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xjvm-default=all"
        )
    }
    compileKotlin {
        kotlinOptions(kotlinOptions)
    }
    compileTestKotlin {
        kotlinOptions(kotlinOptions)
    }
    test {
        useJUnitPlatform()
    }
}