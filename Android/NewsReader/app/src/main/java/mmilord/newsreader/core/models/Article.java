package mmilord.newsreader.core.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by robertgross on 1/9/16.
 */
public class Article {

    @SerializedName("url")
    String _url;

    @SerializedName("title")
    String _title;

    @SerializedName("imageURL")
    String _imageURL;

    @SerializedName("contents")
    String _contents;

}
