package com.amco.clarovideo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.amco.clarovideo.R;
import com.amco.clarovideo.delegate.AppDelegate;
import com.amco.clarovideo.helpers.OnMovieSelectedListener;
import com.amco.clarovideo.helpers.RestApi;
import com.amco.clarovideo.helpers.adapters.MoviesAdapter;
import com.amco.clarovideo.helpers.model_response.ComponentResponse;
import com.amco.clarovideo.helpers.model_response.GroupResponse;
import com.amco.clarovideo.helpers.model_response.ModuleResponse;
import com.amco.clarovideo.helpers.model_response.ServerResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, OnMovieSelectedListener {
    /**
     * The Search view.
     */
    @BindView(R.id.sv_am)
    SearchView searchView;

    /**
     * The Recycler view.
     */
    @BindView(R.id.rv_am)
    RecyclerView recyclerView;

    /**
     * The Swipe refresh layout.
     */
    @BindView(R.id.srl_am)
    SwipeRefreshLayout swipeRefreshLayout;

    private SearchView.SearchAutoComplete searchAutoComplete;

    private Call<ServerResponse> callConfiguration;
    private Call<ServerResponse> callMovies;

    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        searchAutoComplete = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        searchAutoComplete.setThreshold(0);
        searchAutoComplete.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        searchAutoComplete.setOnItemClickListener(this);

        searchView.setIconified(true);
        searchView.setEnabled(false);

        adapter = new MoviesAdapter(this);
        adapter.setListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        this.swipeRefreshLayout.setOnRefreshListener(this);

        this.swipeRefreshLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        searchView.setQuery("", false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (callConfiguration != null && !callConfiguration.isCanceled()) {
            callConfiguration.cancel();
        }

        if (callMovies != null && !callMovies.isCanceled()) {
            callMovies.cancel();
        }
    }

    /**
     * hide process indicator into refresh layout.
     */
    protected void stopRefreshLayout() {
        this.swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    /**
     * show process indicator into refresh layout.
     */
    protected void startRefreshLayout() {
        this.swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void onRefresh() {
        downloadContent();
    }

    private void downloadContent() {
        adapter.updateList(new ArrayList<GroupResponse>());
        searchAutoComplete.setAdapter(null);

        searchView.setIconified(true);
        searchView.setEnabled(false);

        final RestApi restApi = ((AppDelegate) getApplication()).getRestApi();

        callConfiguration = restApi.getConfiguration();

        callConfiguration.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                if (response.isSuccessful() && response.body().getMessage().equals(RestApi.OK)) {
                    ArrayList<ModuleResponse> moduleResponses = response.body().getDataResponse().getModulesResponse().getArrModule();

                    if (!moduleResponses.isEmpty()) {
                        ModuleResponse moduleResponse = null;

                        for (ModuleResponse mr : response.body().getDataResponse().getModulesResponse().getArrModule()) {
                            if (mr.getType().equals("listadoinfinito")) {
                                moduleResponse = mr;
                                break;
                            }
                        }

                        if (moduleResponse != null) {
                            ComponentResponse componentResponse = null;

                            for (ComponentResponse cr : moduleResponse.getComponentsResponse().getArrComponent()) {
                                if (cr.getType().equals("Listadoinfinito")) {
                                    componentResponse = cr;
                                }
                            }

                            if (componentResponse != null) {
                                String urlMovies = componentResponse.getPropertiesResponse().getUrl().startsWith("/") ?
                                        componentResponse.getPropertiesResponse().getUrl().replaceFirst("/", "") :
                                        componentResponse.getPropertiesResponse().getUrl();

                                downloadMovies(urlMovies);
                            } else {
                                showSnackBarError(R.string.error_download_content);
                                stopRefreshLayout();
                            }
                        } else {
                            showSnackBarError(R.string.error_download_content);
                            stopRefreshLayout();
                        }
                    } else {
                        showSnackBarError(R.string.error_download_content);
                        stopRefreshLayout();
                    }
                } else {
                    showSnackBarError(R.string.error_download_content);
                    stopRefreshLayout();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                if (!call.isCanceled()) {
                    showSnackBarError(R.string.error_download_content);
                    stopRefreshLayout();
                }
            }
        });
    }

    private void downloadMovies(String urlFinal) {
        final RestApi restApi = ((AppDelegate) getApplication()).getRestApi();

        callMovies = restApi.getMovies(urlFinal + "&" + RestApi.URL_KEYS);

        callMovies.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                stopRefreshLayout();

                if (response.isSuccessful() && response.body().getMessage().equals(RestApi.OK)) {
                    ArrayList<GroupResponse> groupResponses = response.body().getDataResponse().getArrGroup();

                    if (!groupResponses.isEmpty()) {
                        adapter.updateList(groupResponses);

                        ArrayList<String> arrTitles = new ArrayList<>();

                        for (GroupResponse gr : groupResponses) {
                            arrTitles.add(gr.getTitle());
                        }

                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrTitles);
                        searchAutoComplete.setAdapter(arrayAdapter);

                        searchView.setIconified(true);
                        searchView.setEnabled(true);
                    } else {
                        showSnackBarError(R.string.error_no_content);
                    }
                } else {
                    showSnackBarError(R.string.error_download_content);
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                if (!call.isCanceled()) {
                    showSnackBarError(R.string.error_download_content);
                    stopRefreshLayout();
                }
            }
        });
    }

    private void showSnackBarError(int strId) {
        Snackbar.make(this.recyclerView, strId, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onGlobalLayout() {
        this.recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

        startRefreshLayout();
        downloadContent();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.searchView.clearFocus();
        searchView.setQuery("", false);

        String object = (String) parent.getItemAtPosition(position);

        for (int i = 0; i < adapter.getItems().size(); i++) {
            GroupResponse response = adapter.getItems().get(i);

            if (object.equals(response.getTitle())) {
                startActivityWithMovie(response);
                break;
            }
        }
    }

    @Override
    public void movieSelectedWithIndex(int index) {
        startActivityWithMovie(adapter.getItems().get(index));
    }

    /**
     * Start activity with movie.
     *
     * @param movie the movie
     */
    public void startActivityWithMovie(GroupResponse movie) {
        Intent intent = new Intent(MainActivity.this, MovieDescriptionActivity.class);

        intent.putExtra("movie", movie);

        startActivity(intent);
    }

    /**
     * Gets adapter.
     *
     * @return the adapter
     */
    public MoviesAdapter getAdapter() {
        return adapter;
    }
}
