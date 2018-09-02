package alvarez.oscar.buttonsapp.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import alvarez.oscar.buttonsapp.ButtonsApplication;
import alvarez.oscar.buttonsapp.R;
import alvarez.oscar.buttonsapp.adapters.ButtonsAdapter;
import alvarez.oscar.buttonsapp.databinding.ActivityMainBinding;
import alvarez.oscar.buttonsapp.models.ButtonObject;
import alvarez.oscar.buttonsapp.presenters.MainPresenter;
import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Oscar Álvarez on 01/09/18.
 * Activity with main functionality.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mPresenter;

    ActivityMainBinding binding;

    CompositeDisposable disposable;

    ButtonsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButtonsApplication.getComponent().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        disposable = new CompositeDisposable();
        showLoader(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getButtonsData();
        binding.swipeContainer.setOnRefreshListener(() -> {
            disposable.clear();
            adapter.clear();
            getButtonsData();
            binding.swipeContainer.setRefreshing(false);

        });
        binding.swipeContainer.setColorSchemeResources(android.R.color.holo_red_light);

    }

    private void getButtonsData() {
        disposable.add(mPresenter.getButtons()
                .subscribe(this::showButtons,
                        this::showErrorView));
    }

    @Override
    protected void onPause() {
        super.onPause();
        disposable.clear();
    }

    private void showErrorView(Throwable throwable) {
        binding.errorView.getViewStub().inflate();
        showLoader(false);
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
        adapter = new ButtonsAdapter(buttonObjects);
        binding.recyclerView.setAdapter(adapter);
    }
}
