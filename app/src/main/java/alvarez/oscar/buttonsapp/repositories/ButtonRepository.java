package alvarez.oscar.buttonsapp.repositories;

import java.util.List;

import alvarez.oscar.buttonsapp.models.ButtonObject;
import alvarez.oscar.buttonsapp.services.ButtonService;
import alvarez.oscar.buttonsapp.utils.RxHelper;
import io.reactivex.Observable;


/**
 * Created by Oscar Álvarez on 01/09/18.
 * Repository for ButtonObjects list.
 */
public class ButtonRepository {

    private ButtonService mService;

    public ButtonRepository(ButtonService service) {
        mService = service;
    }

    public Observable<List<ButtonObject>> getButtons() {
        return RxHelper.IOAndMainthreadSchedule(mService.getButtons());
    }
}
