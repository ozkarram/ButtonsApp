package alvarez.oscar.buttonsapp;

import android.app.Application;

import alvarez.oscar.buttonsapp.injection.AppComponent;
import alvarez.oscar.buttonsapp.injection.DaggerAppComponent;
import alvarez.oscar.buttonsapp.injection.GeneralModule;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Application class to provide component in any part of the app.
 */
public class ButtonsApplication extends Application {
    static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .generalModule(new GeneralModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
