package alvarez.oscar.buttonsapp.services;

import java.util.List;

import alvarez.oscar.buttonsapp.models.ButtonObject;
import io.reactivex.Observable;
import retrofit2.http.GET;



/**
 * Created by Oscar Álvarez on 01/09/18.
 */
public interface ButtonService {

    @GET("buttons")
    Observable<List<ButtonObject>> getButtons();
}
