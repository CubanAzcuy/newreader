package mmilord.newsreader.core.resources;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import mmilord.newsreader.core.LoggingInterceptor;
import mmilord.newsreader.core.models.Article;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by robertgross on 1/9/16.
 */

//https://guides.codepath.com/android/Leveraging-the-Gson-Library
// http://inaka.net/blog/2014/10/10/android-retrofit-rest-client/
    //https://guides.codepath.com/android/Consuming-APIs-with-Retrofit
    //http://inthecheesefactory.com/blog/retrofit-2.0/en


public class RetrofitObject {
    public static void callsomethings(){
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new LoggingInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://outspeacker.elasticbeanstalk.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RSSTextParser service = retrofit.create(RSSTextParser.class);

        Call<Article> call = service.getArticleText("http://feeds.arstechnica.com/arstechnica/index");
        call.enqueue(new Callback<Article>() {

            @Override
            public void onResponse(Response<Article> response, Retrofit retrofit) {
                Article boxOfficeMovieResponse = response.body();
                System.out.println(boxOfficeMovieResponse.toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

}
