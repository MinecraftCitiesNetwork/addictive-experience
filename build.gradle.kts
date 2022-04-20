plugins {
    java
    idea
    eclipse
}

group = "io.github.md5sha256"
version = "0.0.1-SNAPSHOT"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

subprojects {

    group = rootProject.group
    version = rootProject.version

    apply {
        plugin<JavaPlugin>()
        plugin<JavaLibraryPlugin>()
        plugin<IdeaPlugin>()
        plugin<EclipsePlugin>()
    }

    java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

    repositories {
        mavenCentral()
        maven {
            name = "spigot-repo"
            url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
            content {
                includeGroup("org.bukkit")
                includeGroup("org.spigotmc")
            }
        }
        maven {
            name = "paper-repo"
            url = uri("https://papermc.io/repo/repository/maven-public/")
        }
    }

    tasks {

        withType(JavaCompile::class) {
            options.release.set(17)
            options.encoding = Charsets.UTF_8.name()
            options.isFork = true
            options.isDeprecation = true
        }

        withType(Javadoc::class) {
            options.encoding = Charsets.UTF_8.name()
        }

        withType(ProcessResources::class) {
            filteringCharset = Charsets.UTF_8.name()
        }
    }

}


