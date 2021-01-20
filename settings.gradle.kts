rootProject.name = "Cellulose"

pluginManagement {
    repositories {
        jcenter()
        maven("https://maven.fabricmc.net/")
        maven("https://repo-new.spongepowered.org/repository/maven-public")
        gradlePluginPortal()
    }
}

include("cellulose-mixin-api")
include("cellulose-accessor")
include("cellulose-common")
include("cellulose-server")