workspace(name = "metrics_reporter_jmx")

load("//:bazlets.bzl", "load_bazlets")

load_bazlets(
    commit = "2807d30761a889187f06d99e969fb0ea2fbe5afe",
    #local_path = "/home/<user>/projects/bazlets",
)

load(
    "@com_googlesource_gerrit_bazlets//:gerrit_api.bzl",
    "gerrit_api",
)

gerrit_api()

load("//:external_plugin_deps.bzl", "external_plugin_deps")

external_plugin_deps()
