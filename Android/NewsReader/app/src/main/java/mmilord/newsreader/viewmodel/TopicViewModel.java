package mmilord.newsreader.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by robertgross on 1/8/16.
 */
public class TopicViewModel implements Parcelable {

    private String _title;

    public TopicViewModel(String title) {
        _title = title;
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

    protected TopicViewModel(Parcel in) {
        this._title = in.readString();
    }

    public static final Creator<TopicViewModel> CREATOR = new Creator<TopicViewModel>() {
        public TopicViewModel createFromParcel(Parcel source) {
            return new TopicViewModel(source);
        }

        public TopicViewModel[] newArray(int size) {
            return new TopicViewModel[size];
        }
    };
}
