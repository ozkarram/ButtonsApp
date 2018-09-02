package alvarez.oscar.buttonsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import alvarez.oscar.buttonsapp.ButtonsApplication;
import alvarez.oscar.buttonsapp.R;
import alvarez.oscar.buttonsapp.presenters.MainPresenter;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Activity with main functionality.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButtonsApplication.getComponent().inject(this);

        setContentView(R.layout.activity_main);

    }
}
