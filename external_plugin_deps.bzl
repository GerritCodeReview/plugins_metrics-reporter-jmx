load("//tools/bzl:maven_jar.bzl", "maven_jar")

def external_plugin_deps():
    maven_jar(
        name = "metrics_jmx",
        artifact = "io.dropwizard.metrics:metrics-jmx:4.0.5",
        sha1 = "d7be4ddd7ba674ee8be1d23d883fb3ca68ee1d54",
    )
