/*
 * Copyright 2020 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.profiler.context.provider;

import com.navercorp.pinpoint.bootstrap.plugin.uri.UriExtractorProvider;
import com.navercorp.pinpoint.bootstrap.plugin.uri.UriExtractorProviderLocator;
import com.navercorp.pinpoint.bootstrap.plugin.uri.UriExtractorProviderRegistry;
import com.navercorp.pinpoint.bootstrap.plugin.uri.UriStatRecorderFactory;
import com.navercorp.pinpoint.common.util.Assert;
import com.navercorp.pinpoint.profiler.context.recorder.DefaultUriStatRecorderFactory;
import com.navercorp.pinpoint.profiler.plugin.PluginContextLoadResult;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.List;

/**
 * @author Taejin Koo
 */
public class UriStatRecorderFactoryProvider implements Provider<UriStatRecorderFactory> {

    private final Provider<UriExtractorProviderLocator> uriExtractorProviderLocatorProvider;

    @Inject
    public UriStatRecorderFactoryProvider(Provider<UriExtractorProviderLocator> uriExtractorProviderLocatorProvider) {
        this.uriExtractorProviderLocatorProvider = Assert.requireNonNull(uriExtractorProviderLocatorProvider, "uriExtractorProviderLocatorProvider");
    }

    @Override
    public UriStatRecorderFactory get() {
        return new DefaultUriStatRecorderFactory(uriExtractorProviderLocatorProvider);
    }

}

