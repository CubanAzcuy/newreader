package mmilord.newsreader.core.resources;

import mmilord.newsreader.core.models.Article;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by robertgross on 1/9/16.
 */
public interface RSSTextParser {
    @GET("/api/rss")
    Call<Article> getArticleText(@Query("url") String url);
}
