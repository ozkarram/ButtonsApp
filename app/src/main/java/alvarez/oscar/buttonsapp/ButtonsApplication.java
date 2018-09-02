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

    private static AppComponent component;

    private static ButtonsApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        component = DaggerAppComponent.builder()
                .generalModule(new GeneralModule())
                .build();
    }

    public static ButtonsApplication getInstance() {
        return mInstance;
    }

    public static AppComponent getComponent() {
        return component;
    }
}
