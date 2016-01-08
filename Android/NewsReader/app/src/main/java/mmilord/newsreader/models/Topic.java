package mmilord.newsreader.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by robertgross on 1/8/16.
 */
public class Topic implements Parcelable {

    private String _title;

    public Topic(String title) {
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

    protected Topic(Parcel in) {
        this._title = in.readString();
    }

    public static final Creator<Topic> CREATOR = new Creator<Topic>() {
        public Topic createFromParcel(Parcel source) {
            return new Topic(source);
        }

        public Topic[] newArray(int size) {
            return new Topic[size];
        }
    };
}
