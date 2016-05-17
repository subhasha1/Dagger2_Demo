package com.wordpress.androidbolts.dagger2_basicsetup;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    SharedPreferences prefs();

    void inject(MainActivity activity);
}
