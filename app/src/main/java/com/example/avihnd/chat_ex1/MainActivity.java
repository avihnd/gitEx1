package com.example.avihnd.chat_ex1;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button mSendButton;
    EditText mUserMsg;
    TextView mChatBody;
    Calendar c = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
    ScrollView chat_ScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get send button, user messages, and chat body by id
        mSendButton = (Button) findViewById(R.id.button_send);
        mUserMsg = (EditText) findViewById(R.id.et_user_msg);
        mChatBody = (TextView) findViewById(R.id.tv_chat_body);
        chat_ScrollView = (ScrollView) findViewById(R.id.chat_ScrollView);

        //set an onClick listener
        mSendButton.setOnClickListener(new View.OnClickListener() {
          @RequiresApi(api = Build.VERSION_CODES.N)
          public void onClick(View v)
            {
                String msg = mUserMsg.getText().toString();
                String formattedDate = df.format(c.getTime());
                mChatBody.append("\n\n\n" + formattedDate + "\t" + msg);
                mUserMsg.setText("");
                //scroll down on each new message
                chat_ScrollView.post(new Runnable()
                {
                    public void run()
                    {
                        chat_ScrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }




}
