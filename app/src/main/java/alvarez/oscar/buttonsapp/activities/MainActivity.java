package alvarez.oscar.buttonsapp.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import alvarez.oscar.buttonsapp.ButtonsApplication;
import alvarez.oscar.buttonsapp.R;
import alvarez.oscar.buttonsapp.adapters.ButtonsAdapter;
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
        List<ButtonObject> list = new ArrayList<>();
        list.add(new ButtonObject(ButtonObject.APPLE_TYPE, "Hi"));
        list.add(new ButtonObject(ButtonObject.YAHOO_TYPE, null));
        list.add(new ButtonObject(ButtonObject.GOOGLE_TYPE, null));
        list.add(new ButtonObject(ButtonObject.APPLE_TYPE, null));
        showButtons(list);
    }

    private void showLoader(boolean isLoading) {
        binding.recyclerView.setVisibility(isLoading ? View.GONE : View.VISIBLE);
        binding.loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    private void showButtons(List<ButtonObject> buttonObjects) {
        showLoader(false);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.addItemDecoration(
                new DividerItemDecoration(binding.recyclerView.getContext(),
                        DividerItemDecoration.VERTICAL));
        ButtonsAdapter adapter = new ButtonsAdapter(buttonObjects);
        binding.recyclerView.setAdapter(adapter);
    }
}
