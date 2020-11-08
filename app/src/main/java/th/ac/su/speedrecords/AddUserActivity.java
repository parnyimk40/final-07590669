package th.ac.su.speedrecords;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import th.ac.su.speedrecords.db.AppDatabase;
import th.ac.su.speedrecords.model.User;
import th.ac.su.speedrecords.util.AppExecutors;
import th.ac.su.speedrecords.util.DateFormatter;

import java.util.Calendar;
import java.util.Date;

public class AddUserActivity extends AppCompatActivity {

    private Calendar mBirthDateCalendar = Calendar.getInstance();
    private Calendar mSomeTimeCalendar = Calendar.getInstance();

    private EditText mBirthDateEditText, mSomeTimeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

      //  mBirthDateEditText = findViewById(R.id.m_text_view);
        //mBirthDateEditText = findViewById(R.id.s_text_view);
        mBirthDateEditText.setInputType(InputType.TYPE_NULL);
        mBirthDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddUserActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                mBirthDateCalendar.set(Calendar.YEAR, year);
                                mBirthDateCalendar.set(Calendar.MONTH, month);
                                mBirthDateCalendar.set(Calendar.DAY_OF_MONTH, day);
                                String formatDate = DateFormatter.formatDateForUi(mBirthDateCalendar.getTime());
                                mBirthDateEditText.setText(formatDate);
                            }
                        },
                        mBirthDateCalendar.get(Calendar.YEAR),
                        mBirthDateCalendar.get(Calendar.MONTH),
                        mBirthDateCalendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });

        mSomeTimeEditText = findViewById(R.id.add_meters);
        mSomeTimeEditText = findViewById(R.id.add_seconds);
        mSomeTimeEditText.setInputType(InputType.TYPE_NULL);
        mSomeTimeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        AddUserActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                mSomeTimeCalendar.set(Calendar.HOUR_OF_DAY, hour);
                                mSomeTimeCalendar.set(Calendar.MINUTE, minute);
                            //    String formatDate = DateFormatter.formatDateForUi(mSomeTimeCalendar.getTime());
                                mSomeTimeEditText.setText(minute);
                            }
                        },
                        mSomeTimeCalendar.get(Calendar.HOUR_OF_DAY),
                        mSomeTimeCalendar.get(Calendar.MINUTE),
                        true
                );
                timePickerDialog.show();
            }
        });

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // อ่านค่าจากช่อง first_name_edit_text, last_name_edit_text
                String firstName;
                String lastName;
                Date birthDate = mBirthDateCalendar.getTime();
                int gender;
                boolean single;

                //final User user = new User(0, "xx", "yy", birthDate, 1, true, birthDate);

             //   AppExecutors executors = new AppExecutors();
              //  executors.diskIO().execute(new Runnable() {
                  //  @Override
                  //  public void run() { // worker thread
                    //    AppDatabase db = AppDatabase.getInstance(AddUserActivity.this);
                     //   db.userDao().addUser(user);
                        finish();
               //     }
                //});
            }
        });
    }
}
