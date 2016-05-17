package com.wordpress.androidbolts.dagger2_basicsetup;

import android.app.Application;
import android.content.Context;

public class DaggerApplication extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = AppComponentInitializer.init(this);
    }

    public static AppComponent component(Context context) {
        return ((DaggerApplication) context.getApplicationContext()).component;
    }

    private final static class AppComponentInitializer {

        public static AppComponent init(Context context) {
            return DaggerAppComponent.builder().appModule(new AppModule(context)).build();
        }

    }
}
