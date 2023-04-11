import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun config(name: String) = project.findProperty(name).toString()

repositories {
    mavenCentral()
}

plugins {
    java
// https://plugins.jetbrains.com/docs/intellij/using-kotlin.html#kotlin-standard-library
    id("org.jetbrains.kotlin.jvm") version "1.8.20"
    id("org.jetbrains.intellij") version "1.13.3"
}

group = config("group")
version = config("version")

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
}

intellij {
    pluginName.set(config("pluginName"))
    version.set(
        if (config("platformVersion") == "eap") {
            "LATEST-EAP-SNAPSHOT"
        } else {
            config("platformVersion")
        }
    )
    type.set(config("platformType"))

    val usePlugins = config("usePlugins").split(',')
    for (plugin in usePlugins) {
        if (plugin.isEmpty()) {
            continue
        }
        val (name, version) = plugin.split(':')
        if (name == "python") {
            when (type.get()) {
                "PY" -> {
                    plugins.add("python")
                }

                "PC" -> {
                    plugins.add("PythonCore")
                }

                else -> {
                    plugins.add("PythonCore:${version}")
                }
            }
        } else {
            plugins.add(plugin)
        }
    }
}

fun readChangeNotes(pathname: String): String {
    val lines = file(pathname).readLines()

    val notes: MutableList<MutableList<String>> = mutableListOf()

    var note: MutableList<String>? = null

    for (line in lines) {
        if (line.startsWith('#')) {
            if (notes.size == 3) {
                break
            }
            note = mutableListOf()
            notes.add(note)
            val header = line.trimStart('#')
            note.add("<b>$header</b>")
        } else if (line.isNotBlank()) {
            note?.add(line)
        }
    }

    return notes.joinToString(
        "</p><br><p>",
        prefix = "<p>",
        postfix = "</p><br>"
    ) {
        it.joinToString("<br>")
    } +
            "See the full change notes on the <a href='" +
            config("repository") +
            "/blob/master/CHANGES.md'>github</a>"
}

tasks {
    config("jvmVersion").let {
        withType<JavaCompile> {
            sourceCompatibility = it
            targetCompatibility = it
        }
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = it
        }
    }

    wrapper {
        distributionType = Wrapper.DistributionType.ALL
        gradleVersion = config("gradleVersion")
    }

    test {
        useJUnit()

        maxHeapSize = "2G"
    }

    patchPluginXml {
        version.set(project.version.toString())
        pluginDescription.set(file("description.html").readText())
        changeNotes.set(readChangeNotes("CHANGES.md"))
        sinceBuild.set(config("platformSinceBuild"))
        untilBuild.set(config("platformUntilBuild"))
    }

    publishPlugin {
        dependsOn("buildPlugin")
//        token.set(file("token.txt").readLines()[0])
        channels.set(listOf(config("publishChannel")))
    }

    buildSearchableOptions {
        enabled = false
    }
}
