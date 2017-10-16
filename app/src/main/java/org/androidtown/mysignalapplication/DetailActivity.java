package org.androidtown.mysignalapplication;

import android.content.Intent;
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
    //날짜, 장소, 마감, 인원수 추가할 것

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        publisherImage = (ImageView) findViewById(R.id.publisher_image);
        addedImage = (ImageView) findViewById(R.id.meeting_image);

        doitTogether = (Button) findViewById(R.id.doitTogether);
        doitTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailActivity.this, DoitTogetherActivity.class);
                startActivity(i);
                finish();
            }
        });

        // 퍼블리셔 정보, 이미지, 만남 세부 정보 전달받아오기
        // 참가하러 갈때 공통된 정보는 전달하기

    }

}
