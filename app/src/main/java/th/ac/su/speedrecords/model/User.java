package th.ac.su.speedrecords.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import th.ac.su.speedrecords.util.DateConverter;

import java.util.Date;

@Entity(tableName = "users")
public class User {

    public static final int more = 1;
    public static final int no_more = 0;

    @ColumnInfo(name = "time")
   // @TypeConverters(DateConverter.class)
    public final String Time;

    @ColumnInfo(name = "meters")
    @TypeConverters(DateConverter.class)
    public final String meters;

    @ColumnInfo(name = "seconds")
    @TypeConverters(DateConverter.class)
    public final String seconds;


    public User(String Time ,String meters ,String seconds) {

        this.Time = Time;
        this.meters = meters;
        this.seconds = seconds;
    }
}
