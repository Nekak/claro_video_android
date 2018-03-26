package com.amco.clarovideo.activities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.amco.clarovideo.delegate.AppDelegate;
import com.amco.clarovideo.helpers.RestApi;
import com.amco.clarovideo.helpers.model_response.ComponentResponse;
import com.amco.clarovideo.helpers.model_response.GroupResponse;
import com.amco.clarovideo.helpers.model_response.ModuleResponse;
import com.amco.clarovideo.helpers.model_response.ServerResponse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by nekak on 25/03/18.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    /**
     * The Activity test rule.
     */
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Download content is right.
     *
     * @throws Exception the exception
     */
    @Test
    public void downloadContent_IsRight() throws Exception {
        final RestApi restApi = ((AppDelegate) activityTestRule.getActivity().getApplication()).getRestApi();

        Call<ServerResponse> callConfiguration = restApi.getConfiguration();

        assertNotNull("The call is null", callConfiguration);

        callConfiguration.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                assertNotNull("The response has not message", response.body().getMessage());

                if (response.isSuccessful() && response.body().getMessage().equals(RestApi.OK)) {
                    assertNotNull("The response has not data", response.body().getDataResponse());

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

                            assertNotNull("Has no data for continue process", componentResponse);
                            if (componentResponse != null) {
                                assertNotNull("Url movie is null", componentResponse.getPropertiesResponse().getUrl());
                                assertFalse("Url movie is empty", componentResponse.getPropertiesResponse().getUrl().isEmpty());

                                String urlMovies = componentResponse.getPropertiesResponse().getUrl().startsWith("/") ?
                                        componentResponse.getPropertiesResponse().getUrl().replaceFirst("/", "") :
                                        componentResponse.getPropertiesResponse().getUrl();

                                assertNotNull(urlMovies);
                            } else {
                                /*showSnackBarError(R.string.error_download_content);
                                stopRefreshLayout();*/
                            }
                        } else {
                            /*showSnackBarError(R.string.error_download_content);
                            stopRefreshLayout();*/
                        }
                    } else {
                        /*showSnackBarError(R.string.error_download_content);
                        stopRefreshLayout();*/
                    }
                } else {
                    /*showSnackBarError(R.string.error_download_content);
                    stopRefreshLayout();*/
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                if (!call.isCanceled()) {
                    /*showSnackBarError(R.string.error_download_content);
                    stopRefreshLayout();*/
                }
            }
        });
    }

    /**
     * Download movies is right.
     */
    @Test
    public void downloadMovies_IsRight() {
        String urlFinal = "services/content/list?quantity=40&order_way=DESC&order_id=200&level_id=GPS&from=0&node_id=9869&region=mexico&api_version=v5.5&authpn=webclient&authpt=tfg1h3j4k6fd7&format=json&region=mexico&device_id=web&device_category=web&device_model=web&device_type=web&device_manufacturer=generic&HKS=9lrk9et93ck595t27qav0mkcf1";

        assertFalse("Not valid string", urlFinal.startsWith("/"));

        final RestApi restApi = ((AppDelegate) activityTestRule.getActivity().getApplication()).getRestApi();

        Call<ServerResponse> callMovies = restApi.getMovies(urlFinal + "&" + RestApi.URL_KEYS);

        assertNotNull("The call is null", callMovies);

        callMovies.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                assertNotNull("The response has not message", response.body().getMessage());

                if (response.isSuccessful() && response.body().getMessage().equals(RestApi.OK)) {
                    assertNotNull("The response has not data", response.body().getDataResponse());
                    ArrayList<GroupResponse> groupResponses = response.body().getDataResponse().getArrGroup();

                    if (!groupResponses.isEmpty()) {

                    } else {
                        //showSnackBarError(R.string.error_no_content);
                    }
                } else {
                    //showSnackBarError(R.string.error_download_content);
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                /*if (!call.isCanceled()) {
                    showSnackBarError(R.string.error_download_content);
                    stopRefreshLayout();
                }*/
            }
        });
    }
}
