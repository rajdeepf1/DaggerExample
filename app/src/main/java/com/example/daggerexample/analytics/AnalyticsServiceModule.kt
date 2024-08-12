package com.example.daggerexample.analytics

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsServiceModule {
    @Singleton
    @Provides
    fun getMixPanel() : AnalyticsServices {
        return MixPanel()
    }
}