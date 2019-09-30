// Copyright (C) 2015 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.googlesource.gerrit.plugins.metricsreporters;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jmx.JmxReporter;
import com.google.gerrit.extensions.annotations.Listen;
import com.google.gerrit.extensions.events.LifecycleListener;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Listen
@Singleton
public class GerritJmxReporter implements LifecycleListener {
  private final JmxReporter reporter;

  @Inject
  public GerritJmxReporter(MetricRegistry registry, Configuration config) {

    /* Copy the registry to avoid filtering the global one */
    MetricRegistry filteredRegistry = new MetricRegistry();
    filteredRegistry.registerAll(registry);

    config
        .getExcludes()
        .forEach(
            exclude -> {
              filteredRegistry.removeMatching(
                  new MetricFilter() {
                    @Override
                    public boolean matches(String name, Metric metric) {
                      return name.matches(exclude);
                    }
                  });
            });

    this.reporter = JmxReporter.forRegistry(filteredRegistry).build();
  }

  @Override
  public void start() {
    reporter.start();
  }

  @Override
  public void stop() {
    reporter.stop();
  }
}
