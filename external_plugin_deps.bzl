load("//tools/bzl:maven_jar.bzl", "maven_jar")

def external_plugin_deps():
    maven_jar(
        name = "metrics_jmx",
        artifact = "io.dropwizard.metrics:metrics-jmx:4.0.3",
        sha1 = "d49313634a606496433e34b733251ba9fdbb333f",
    )
