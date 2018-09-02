package alvarez.oscar.buttonsapp.injection;

import javax.inject.Singleton;

import alvarez.oscar.buttonsapp.BuildConfig;
import alvarez.oscar.buttonsapp.presenters.MainPresenter;
import alvarez.oscar.buttonsapp.repositories.ButtonRepository;
import alvarez.oscar.buttonsapp.services.ButtonService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Provides dependencies to objects which need it.
 */

@Module
public class GeneralModule {

    @Singleton
    @Provides
    public MainPresenter providesMainPresenter(ButtonRepository repository) {
        return new MainPresenter(repository);
    }

    @Singleton
    @Provides
    public ButtonRepository providesButtonRepository(ButtonService buttonService) {
        return new ButtonRepository(buttonService);
    }

    //network
    @Singleton
    @Provides
    public Retrofit providesRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public ButtonService providesButtonService(Retrofit retrofitInstance) {
        return retrofitInstance.create(ButtonService.class);
    }


}
