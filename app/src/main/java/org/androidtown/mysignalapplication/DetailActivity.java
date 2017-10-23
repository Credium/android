package org.androidtown.mysignalapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    ImageView publisherImage, addedImage;
    TextView meetingTitle, meetingContents;
    Button doitTogether;
    boolean meetingStatus;

    //날짜, 장소, 마감, 인원수 추가할 것

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        publisherImage = (ImageView) findViewById(R.id.publisher_image);
        addedImage = (ImageView) findViewById(R.id.meeting_image);

        Intent i = getIntent();
        meetingStatus = i.getBooleanExtra("meetingStatus", false);


        if(meetingStatus == true){
            doitTogether = (Button) findViewById(R.id.doitTogether);
            doitTogether.setText("수정하기");
            doitTogether.setTextColor(Color.rgb(126, 130, 142));
            doitTogether.setBackgroundColor(Color.rgb(216, 216, 216));
            doitTogether.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(DetailActivity.this, ModifyMeetingActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }

        else if(meetingStatus == false){
            doitTogether = (Button) findViewById(R.id.doitTogether);
            doitTogether.setText("함께하기");
            doitTogether.setTextColor(Color.rgb(63, 74, 107));
            doitTogether.setBackgroundColor(Color.rgb(81, 215, 237));
            doitTogether.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(DetailActivity.this, DoitTogetherActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }

        // 퍼블리셔 정보, 이미지, 만남 세부 정보 전달받아오기
        // 참가하러 갈때 공통된 정보는 전달하기

    }

}
