package alvarez.oscar.buttonsapp.utils;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oscar Álvarez on 01/09/18.
 */
public class RxHelper {

    public static <T> Observable<T> IOAndMainthreadSchedule(Observable<T> observable) {
        return observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation());
    }
}
