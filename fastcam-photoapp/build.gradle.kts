import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.30"
	kotlin("plugin.spring") version "1.4.30"
}

group = "info.thecodinglive.photoapp"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(project(":fastcam-spring-utils"))
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("commons-fileupload:commons-fileupload:1.4")
	implementation("io.springfox:springfox-swagger2:2.9.2")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")

	implementation ("org.springframework.cloud:spring-cloud-gcp-starter-storage")

	implementation("org.springframework.cloud:spring-cloud-config:3.0.1")
	implementation("org.springframework.cloud:spring-cloud-context:3.0.1")
	implementation("org.springframework.boot:spring-boot-starter-actuator")


  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
  implementation ("org.springframework.cloud:spring-cloud-gcp-starter-storage")

	implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
	implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")
	implementation ("de.codecentric:spring-boot-admin-starter-client:2.4.0")


	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom ("org.springframework.cloud:spring-cloud-dependencies:2020.0.1")
		mavenBom ("org.springframework.cloud:spring-cloud-gcp-dependencies:1.2.7.RELEASE")
		mavenBom ("org.springframework.cloud:spring-cloud-dependencies:2020.0.1")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}