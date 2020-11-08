package th.ac.su.speedrecords.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import th.ac.su.speedrecords.model.User;
import th.ac.su.speedrecords.util.AppExecutors;
import th.ac.su.speedrecords.util.DateFormatter;

import java.util.Calendar;

import th.ac.su.speedrecords.model.User;

@Database(entities = {User.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = "AppDatabase";
    private static final String DB_NAME = "user.db";

    private static AppDatabase sInstance;

    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DB_NAME
            ).addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    insertInitialData(context);
                }
            }).build();
        }
        return sInstance;
    }

    private static void insertInitialData(final Context context) {
        AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() { // worker thread
                AppDatabase db = getInstance(context);
                db.userDao().addUser(
                        new User(
                                "177.1 KM/H",
                                "31.0 METERS",
                                "0.6 SECONDS"

                        ),
                        new User(
                                "72.0 KM/H",
                                "100.0 METERS",
                               "5.0 SECONDS"


                        ),
                        new User(
                                "90.0 KM/H",
                                "100.0 METERS",
                                "4.0 SECONDS"

                        )
                );
            }
        });
    }
}

