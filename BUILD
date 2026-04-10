load(
    "@com_googlesource_gerrit_bazlets//:gerrit_plugin.bzl",
    "gerrit_plugin",
)
load(
    "@com_googlesource_gerrit_bazlets//tools:in_gerrit_tree.bzl",
    "in_gerrit_tree_enabled",
)
load(
    "@com_googlesource_gerrit_bazlets//tools:runtime_jars_allowlist.bzl",
    "runtime_jars_allowlist_test",
)
load(
    "@com_googlesource_gerrit_bazlets//tools:runtime_jars_overlap.bzl",
    "runtime_jars_overlap_test",
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

runtime_jars_allowlist_test(
    name = "check_metrics-reporter-jmx_third_party_runtime_jars",
    allowlist = ":metrics-reporter-jmx_third_party_runtime_jars.allowlist.txt",
    hint = "plugins/metrics-reporter-jmx:check_metrics-reporter-jmx_third_party_runtime_jars_manifest",
    target = ":metrics-reporter-jmx__plugin",
)

runtime_jars_overlap_test(
    name = "metrics-reporter-jmx_no_overlap_with_gerrit",
    against = "//:headless.war.jars.txt",
    hint = "Exclude overlaps via maven.install(excluded_artifacts=[...]) and re-run this test.",
    target = ":metrics-reporter-jmx__plugin",
    target_compatible_with = in_gerrit_tree_enabled(),
)
