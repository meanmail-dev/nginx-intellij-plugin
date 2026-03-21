fun config(name: String) = project.findProperty(name).toString()

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.intelliJPlatform)
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        create(config("platformType"), config("platformVersion"))
    }
}

intellijPlatform {
    buildSearchableOptions = false
}

// This module is a library, not a standalone plugin — disable plugin-specific tasks
tasks.configureEach {
    if (name == "prepareJarSearchableOptions" ||
        name == "verifyPluginConfiguration" ||
        name == "verifyPlugin"
    ) {
        enabled = false
    }
}
