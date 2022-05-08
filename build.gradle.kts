plugins {
	id("java")
	id("org.jetbrains.kotlin.jvm") version "1.6.21"
	id("org.jetbrains.intellij") version "1.4.0"
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlin.coreLibrariesVersion}")
}

group = "com.kraxarn"
version = "2022.0.1"

repositories {
	mavenCentral()
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
	version.set("2021.3")
	type.set("RD") // Target IDE Platform

	plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
	// Set the JVM compatibility versions
	withType<JavaCompile> {
		sourceCompatibility = "11"
		targetCompatibility = "11"
	}
	withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions.jvmTarget = "11"
	}

	patchPluginXml {
		sinceBuild.set("213")
		untilBuild.set("222.*")
	}

	signPlugin {
		certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
		privateKey.set(System.getenv("PRIVATE_KEY"))
		password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
	}

	publishPlugin {
		token.set(System.getenv("PUBLISH_TOKEN"))
	}
}
