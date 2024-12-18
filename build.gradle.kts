import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    id("java")
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("com.gradleup.shadow") version "8.3.1"
    id("maven-publish")
}

group = "de.kamiql"
version = "2.0.4"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
    maven {
        url = uri("https://eldonexus.de/repository/maven-snapshots/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")

    implementation("de.kamiql.i18n:I18n:2.0.1-SNAPSHOT")
    implementation("com.github.stefvanschie.inventoryframework:IF:0.10.17")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks {
    ->
    compileJava {
        options.encoding = "UTF-8"
    }

    compileTestJava {
        options.encoding = "UTF-8"
    }

    javadoc {
        options.encoding = "UTF-8"
    }

    shadowJar {
        archiveBaseName.set("SellPlugin")
        archiveVersion.set("2.0.2")
        archiveClassifier.set("")
        mergeServiceFiles()

        relocate("com.github.stefvanschie.inventoryframework", "de.kamiql.inventoryframework")

        dependencies {
            include(dependency("com.github.stefvanschie.inventoryframework:IF"))
        }

        destinationDirectory.set(file("C:\\Users\\kamiql\\IdeaProjects\\SellPlugin\\Output"))
    }

    bukkit {
        foliaSupported = true

        apiVersion = "1.13"

        load = BukkitPluginDescription.PluginLoadOrder.STARTUP
        authors = listOf("kamiql")
        contributors = listOf("")
        prefix = "SellPlugin"

        name = "SellPlugin"
        main = "de.kamiql.Main"

        commands {
            register("sell") {
                description = "Verkaufe Items!"
                permission = "sell.commands.sell"
                aliases = listOf("sell", "verkaufen")
            }
            register("reload") {
                description = "Reload the Plugin!"
                permission = "sell.commands.reload"
            }
        }

        depend = listOf("Vault", "SMP-Core")

        load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
    }
}