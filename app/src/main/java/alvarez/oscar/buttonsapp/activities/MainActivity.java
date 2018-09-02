package alvarez.oscar.buttonsapp.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import alvarez.oscar.buttonsapp.ButtonsApplication;
import alvarez.oscar.buttonsapp.R;
import alvarez.oscar.buttonsapp.databinding.ActivityMainBinding;
import alvarez.oscar.buttonsapp.presenters.MainPresenter;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Activity with main functionality.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mPresenter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButtonsApplication.getComponent().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }
}
