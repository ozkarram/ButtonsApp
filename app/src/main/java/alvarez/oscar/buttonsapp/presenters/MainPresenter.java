package alvarez.oscar.buttonsapp.presenters;

import java.util.List;

import alvarez.oscar.buttonsapp.models.ButtonObject;
import alvarez.oscar.buttonsapp.repositories.ButtonRepository;
import rx.Observable;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Presenter with logic for MainActivity view.
 */
public class MainPresenter {

    private ButtonRepository mRepository;

    public MainPresenter(ButtonRepository repository) {
        mRepository = repository;
    }

    public Observable<List<ButtonObject>> getButtons() {
        return mRepository.getButtons();
    }
}
