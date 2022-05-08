package sg.edu.np.mad.test1mad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private String TAG = "List Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView profileImage = findViewById(R.id.profileImage);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new
                DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });
        builder.setNegativeButton("View", new
                DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Random num = new Random();
                        int rand = num.nextInt();
                        Intent launchMainActivity = new Intent(ListActivity.this, MainActivity.class);
                        launchMainActivity.putExtra("Random Number", rand);
                        startActivity(launchMainActivity);
                    }
                });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Image Pressed!");
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}