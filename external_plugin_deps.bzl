load("//tools/bzl:maven_jar.bzl", "maven_jar")

def external_plugin_deps():
    maven_jar(
        name = "metrics_jmx",
        artifact = "io.dropwizard.metrics:metrics-jmx:4.0.2",
        sha1 = "c8c14f6d66100a6b79f5d4b6de1d50ccc7f627fb",
    )
