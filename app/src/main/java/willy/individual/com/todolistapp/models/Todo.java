package willy.individual.com.todolistapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.UUID;

public class Todo implements Parcelable{

    public String id;

    public boolean done;

    public String text;

    public Date remindDate;

    public Todo() {
        this.id = UUID.randomUUID().toString();
    }

    protected Todo(Parcel in) {
        id = in.readString();
        done = in.readByte() != 0;
        text = in.readString();
        remindDate = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeByte((byte) (done ? 1 : 0));
        parcel.writeString(text);
        parcel.writeLong(remindDate.getTime());
    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
