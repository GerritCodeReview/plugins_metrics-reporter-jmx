load("//tools/bzl:maven_jar.bzl", "maven_jar")

def external_plugin_deps():
    maven_jar(
        name = "metrics_jmx",
        artifact = "io.dropwizard.metrics:metrics-jmx:4.1.12.1",
        sha1 = "0fb1e42f6f182d306d0b567c7b9e26cadd13b49e",
    )
