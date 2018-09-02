package alvarez.oscar.buttonsapp.injection;

import javax.inject.Singleton;

import alvarez.oscar.buttonsapp.activities.MainActivity;
import dagger.Component;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Component with classes that might use dependency injection.
 */

@Singleton
@Component(modules = {GeneralModule.class})
public interface AppComponent {

    //activities
    void inject(MainActivity activity);


}
