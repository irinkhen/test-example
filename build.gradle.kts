plugins {
	java
	id("org.springframework.boot") version "3.1.11"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "test.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testImplementation("com.codeborne:selenide:7.3.1")
	implementation("com.codeborne:selenide:7.3.1")
	implementation("io.github.bonigarcia:webdrivermanager:5.8.0")
	//testImplementation("org.testng:testng:7.10.2")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0-M1")

	runtimeOnly("org.postgresql:postgresql")
	implementation("org.postgresql:postgresql:42.7.3")
	implementation("org.jdbi:jdbi3:3.0.0-beta2")
	implementation("org.jdbi:jdbi3-sqlobject:3.45.1")

	testImplementation("io.qameta.allure:allure-selenide:2.18.1")
	implementation("io.qameta.allure:allure-selenide:2.18.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
