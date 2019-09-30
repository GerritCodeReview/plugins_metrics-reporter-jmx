@PLUGIN@ Configuration
=========================

The @PLUGIN@ plugin must be installed on all the instances and the following fields
should be specified in `$site_path/etc/@PLUGIN@.config` file:

File '@PLUGIN@.config'
--------------------

### Exclude metrics

```
[metrics]
  exclude = caches.*
  exclude = events.*
```

```metrics.exclude```
:   String used to exclude metrics from the report. It can be specified multiple times.
    Parsed as regular expression. Note, ^ and $ are automatically added around the string.
