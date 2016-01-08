package mmilord.newsreader.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by robertgross on 1/7/16.
 */
public class ArticleViewModel implements Parcelable {
    String _title;

    public ArticleViewModel(String title) {
        _title = title;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof ArticleViewModel))return false;
        if (((ArticleViewModel) other).getTitle().equals(_title)) return true;
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

    protected ArticleViewModel(Parcel in) {
        this._title = in.readString();
    }

    public static final Creator<ArticleViewModel> CREATOR = new Creator<ArticleViewModel>() {
        public ArticleViewModel createFromParcel(Parcel source) {
            return new ArticleViewModel(source);
        }

        public ArticleViewModel[] newArray(int size) {
            return new ArticleViewModel[size];
        }
    };
}
