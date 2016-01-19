package mmilord.newsreader.core.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by robertgross on 1/9/16.
 */
public class Article {

    @SerializedName("url")
    private String _url;

    @SerializedName("title")
    private String _title;

    @SerializedName("imageURL")
    private String _imageURL;

    @SerializedName("contents")
    private String _contents;



}
