package alvarez.oscar.buttonsapp.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import alvarez.oscar.buttonsapp.ButtonsApplication;
import alvarez.oscar.buttonsapp.R;
import alvarez.oscar.buttonsapp.databinding.ActivityMainBinding;
import alvarez.oscar.buttonsapp.models.ButtonObject;
import alvarez.oscar.buttonsapp.presenters.MainPresenter;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Activity with main functionality.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mPresenter;

    ActivityMainBinding binding;

    CompositeSubscription mSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButtonsApplication.getComponent().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        showLoader(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getButtons()
                .subscribe(buttonObjects -> {
                    showButtons(buttonObjects);
                });
    }

    private void showLoader(boolean isLoading) {
        binding.recyclerView.setVisibility(isLoading ? View.GONE : View.VISIBLE);
        binding.loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    private void showButtons(List<ButtonObject> buttonObjects) {
        showLoader(false);

    }
}
