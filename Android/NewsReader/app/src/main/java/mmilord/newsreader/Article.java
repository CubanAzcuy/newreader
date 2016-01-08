package mmilord.newsreader;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by robertgross on 1/7/16.
 */
public class Article implements Parcelable {
    String _title;

    public Article(String title) {
        _title = title;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Article))return false;
        if (((Article) other).getTitle().equals(_title)) return true;
        return false;
    }

    public String getTitle() {
        return _title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._title);
    }

    protected Article(Parcel in) {
        this._title = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
