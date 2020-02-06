// Copyright (C) 2020 The Android Open Source Project
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

package com.googlesource.gerrit.plugins.metricsreporterjmx;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.MetricRegistryListener;
import com.codahale.metrics.Timer;
import java.util.function.Predicate;

public class FilteredMetricRegistry extends MetricRegistry {
  private final MetricRegistry registry;
  private final Predicate<String> exclusionFilter;

  FilteredMetricRegistry(MetricRegistry registry, Predicate<String> exclusionFilter) {
    this.registry = registry;
    this.exclusionFilter = exclusionFilter;
  }

  @Override
  public void addListener(MetricRegistryListener listener) {
    registry.addListener(new FilteringListener(listener, exclusionFilter));
  }

  private static class FilteringListener implements MetricRegistryListener {
    private final MetricRegistryListener delegate;
    private final Predicate<String> exclusionFilter;

    FilteringListener(MetricRegistryListener delegate, Predicate<String> exclusionFilter) {
      this.delegate = delegate;
      this.exclusionFilter = exclusionFilter;
    }

    @Override
    public void onGaugeAdded(String name, Gauge<?> gauge) {
      execute(name, () -> delegate.onGaugeAdded(name, gauge));
    }

    @Override
    public void onGaugeRemoved(String name) {
      execute(name, () -> delegate.onGaugeRemoved(name));
    }

    @Override
    public void onCounterAdded(String name, Counter counter) {
      execute(name, () -> delegate.onCounterAdded(name, counter));
    }

    @Override
    public void onCounterRemoved(String name) {
      execute(name, () -> delegate.onCounterRemoved(name));
    }

    @Override
    public void onHistogramAdded(String name, Histogram histogram) {
      execute(name, () -> delegate.onHistogramAdded(name, histogram));
    }

    @Override
    public void onHistogramRemoved(String name) {
      execute(name, () -> delegate.onHistogramRemoved(name));
    }

    @Override
    public void onMeterAdded(String name, Meter meter) {
      execute(name, () -> delegate.onMeterAdded(name, meter));
    }

    @Override
    public void onMeterRemoved(String name) {
      execute(name, () -> delegate.onMeterRemoved(name));
    }

    @Override
    public void onTimerAdded(String name, Timer timer) {
      execute(name, () -> delegate.onTimerAdded(name, timer));
    }

    @Override
    public void onTimerRemoved(String name) {
      execute(name, () -> delegate.onTimerRemoved(name));
    }

    private void execute(String name, Runnable r) {
      if (!exclusionFilter.test(name)) {
        r.run();
      }
    }
  }
}
