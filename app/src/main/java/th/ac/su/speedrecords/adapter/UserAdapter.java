package th.ac.su.speedrecords.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.speedrecords.R;
import th.ac.su.speedrecords.model.User;
import th.ac.su.speedrecords.util.DateFormatter;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;
    private User[] mUsers;

    public UserAdapter(Context context, User[] users) {
        this.mContext = context;
        this.mUsers = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_record, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mUsers[position];


        // holder.mTextView.setText(DateFormatter.formatTimeForUi(user.meters));
        // holder.sTextView.setText(DateFormatter.formatTimeForUi(user.seconds));

       // holder.cowImageView.setImageResource(
               // user.Time == User.more ? R.drawable.red_cow : R.drawable.ic_launcher_background
      //  );
    }

    @Override
    public int getItemCount() {
        return mUsers.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView timeTextView;
        TextView mTextView;
        TextView sTextView;
        ImageView cowImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.timeTextView = itemView.findViewById(R.id.time_text_view);
            this.mTextView = itemView.findViewById(R.id.m_text_view);
            this.sTextView = itemView.findViewById(R.id.s_text_view);
            this.cowImageView = itemView.findViewById(R.id.cow_image_view);
        }
    }
}
