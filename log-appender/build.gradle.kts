plugins {
    id("java")
    id("application")
}

description = "OpenTelemetry Log Appender Example"
val moduleName by extra { "io.opentelemetry.examples.log-appender" }

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

dependencies {
    // Slf4J / logback
    implementation("org.slf4j:slf4j-api:2.0.9")
    implementation("ch.qos.logback:logback-core:1.4.13")
    implementation("ch.qos.logback:logback-classic:1.4.13")

    // JUL to SLF4J bridge
    implementation("org.slf4j:jul-to-slf4j:2.0.9")

    // Log4j
    implementation(platform("org.apache.logging.log4j:log4j-bom:2.22.0"))
    implementation("org.apache.logging.log4j:log4j-api")
    implementation("org.apache.logging.log4j:log4j-core")

    // OpenTelemetry core
    implementation("io.opentelemetry:opentelemetry-sdk")
    implementation("io.opentelemetry:opentelemetry-exporter-otlp")
    implementation("io.opentelemetry.semconv:opentelemetry-semconv")

    // OpenTelemetry log4j / logback appenders
    implementation("io.opentelemetry.instrumentation:opentelemetry-log4j-appender-2.17")
    implementation("io.opentelemetry.instrumentation:opentelemetry-logback-appender-1.0")
}

application {
    mainClass = "io.opentelemetry.example.logappender.Application"
}