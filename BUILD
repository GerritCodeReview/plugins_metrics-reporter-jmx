load("//tools/bzl:plugin.bzl", "gerrit_plugin")

gerrit_plugin(
    name = "metrics-reporter-jmx",
    srcs = glob(["src/main/java/**/*.java"]),
    manifest_entries = [
        "Gerrit-PluginName: metrics-reporter-jmx",
    ],
    resources = glob(["src/main/resources/**/*"]),
    deps = ["@metrics_jmx//jar"],
)
