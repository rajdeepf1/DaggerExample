package com.example.daggerexample.analytics

import android.util.Log

interface AnalyticsServices {
    fun trackEvent(eventName: String, eventType: String)
}

class MixPanel() : AnalyticsServices {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("MixPanel", "trackEvent: eventName--->${eventName} and eventType---->${eventType}")
    }

}

class FirebaseAnalytics(): AnalyticsServices {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("FirebaseAnalytics", "trackEvent: eventName--->${eventName} and eventType---->${eventType}")
    }

}