load(
    "@com_googlesource_gerrit_bazlets//:gerrit_plugin.bzl",
    "gerrit_plugin",
    "gerrit_plugin_dependency_tests",
)

gerrit_plugin(
    name = "metrics-reporter-jmx",
    srcs = glob(["src/main/java/**/*.java"]),
    manifest_entries = [
        "Gerrit-PluginName: metrics-reporter-jmx",
        "Gerrit-Module: com.googlesource.gerrit.plugins.metricsreporterjmx.Module",
    ],
    resources = glob(["src/main/resources/**/*"]),
    deps = ["@metrics-reporter-jmx_plugin_deps//:io_dropwizard_metrics_metrics_jmx"],
)

gerrit_plugin_dependency_tests(plugin = "metrics-reporter-jmx")
