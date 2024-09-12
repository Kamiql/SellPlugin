import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    id("java")
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("maven-publish")
}

group = "de.kamiql"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT")
    bukkitLibrary("org.mongodb:mongodb-driver-legacy:4.5.1")
    bukkitLibrary("net.dv8tion:JDA:5.0.2")
    implementation("com.github.MilkBowl:VaultAPI:1.7")
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
        archiveVersion.set("1.0.0")
        archiveClassifier.set("")
        mergeServiceFiles()
        manifest {
            attributes["Main-Class"] = "de.kamiql.Main"
        }
        configurations = listOf(project.configurations.runtimeClasspath.get())
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
                usage = "/sell <info>"
                permission = "sell.commands.sell"
                aliases = listOf("sell", "verkaufen")
            }
        }

        depend = listOf("Vault")

    }
}