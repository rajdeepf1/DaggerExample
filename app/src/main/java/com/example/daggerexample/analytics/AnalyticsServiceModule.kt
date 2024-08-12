package com.example.daggerexample.analytics

import dagger.Module
import dagger.Provides

@Module
class AnalyticsServiceModule {
    @Provides
    fun getMixPanel() : AnalyticsServices {
        return MixPanel()
    }
}