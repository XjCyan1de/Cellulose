rootProject.name = "Cellulose"

pluginManagement {
    repositories {
        jcenter()
        maven("https://maven.fabricmc.net/")
        maven("https://repo-new.spongepowered.org/repository/maven-public")
        gradlePluginPortal()
    }
}

include("cellulose-fabric-mod")
