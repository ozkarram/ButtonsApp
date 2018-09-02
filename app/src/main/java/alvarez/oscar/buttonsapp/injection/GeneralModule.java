package alvarez.oscar.buttonsapp.injection;

import android.content.Context;

import javax.inject.Singleton;

import alvarez.oscar.buttonsapp.presenters.MainPresenter;
import alvarez.oscar.buttonsapp.repositories.ButtonRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Provides dependencies to objects which need it.
 */

@Module
public class GeneralModule {

    private Context context;

    public GeneralModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public MainPresenter providesMainPresenter(ButtonRepository repository) {
        return new MainPresenter(repository);
    }

    @Singleton
    @Provides
    public ButtonRepository providesButtonRepository() {
        return new ButtonRepository();
    }

}
