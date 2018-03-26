package com.amco.clarovideo.helpers;

import com.amco.clarovideo.helpers.model_response.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by nekak on 24/03/18.
 */
public interface RestApi {
    /**
     * The constant OK.
     */
    String OK = "OK";
    /**
     * The constant URL_KEYS.
     */
    String URL_KEYS = "api_version=v5.5&authpn=webclient&authpt=tfg1h3j4k6fd7&format=json&region=mexico&device_id=web&device_category=web&device_model=web&device_type=web&device_manufacturer=generic&HKS=9lrk9et93ck595t27qav0mkcf1";

    /**
     * Gets configuration.
     *
     * @return the configuration
     */
    @GET("services/cms/level?"+URL_KEYS+"&node=sapelcienficc")
    Call<ServerResponse> getConfiguration();

    /**
     * Gets movies.
     *
     * @param url the url
     * @return the movies
     */
    @GET()
    Call<ServerResponse> getMovies(@Url String url);

    /**
     * Gets movie description.
     *
     * @param url the url
     * @return the movie description
     */
    @GET()
    Call<ServerResponse> getMovieDescription(@Url String url);
}
