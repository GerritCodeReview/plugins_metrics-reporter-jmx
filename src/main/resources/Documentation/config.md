@PLUGIN@ Configuration
=========================

The following fields can be specified in `$site_path/etc/@PLUGIN@.config` file:

File '@PLUGIN@.config'
--------------------

### Exclude metrics

```
[metrics]
  exclude = caches.*
  exclude = events.*
```

```metrics.exclude```
:   Regex pattern used to exclude metrics from the report. It can be specified multiple times.
    Note that pattern matching is done on the whole metric name, not only on a part of it.
