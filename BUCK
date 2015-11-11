include_defs('//bucklets/gerrit_plugin.bucklet')
include_defs('//lib/maven.defs')

gerrit_plugin(
  name = 'metrics-reporter-jmx',
  srcs = glob(['src/main/java/**/*.java']),
  resources = glob(['src/main/resources/**/*']),
  deps = [
    '//lib/dropwizard:dropwizard-core'
  ],
  manifest_entries = [
    'Gerrit-PluginName: metrics-reporter-jmx',
  ],
)

# this is required for bucklets/tools/eclipse/project.py to work
java_library(
  name = 'classpath',
  deps = [':metrics__plugin'],
)


