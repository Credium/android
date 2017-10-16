package org.androidtown.mysignalapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DoitTogetherActivity extends AppCompatActivity {

    ImageView meetingImage;
    EditText name, phone, coment;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doit_together);

        meetingImage = (ImageView) findViewById(R.id.meeting_image_sign);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        coment = (EditText) findViewById(R.id.coment);
        signUp = (Button) findViewById(R.id.sign_Up_meeting);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DoitTogetherActivity.this, DetailActivity.class);
                // 버튼 누르면 함께하기 버튼을 수정하기 버튼으로 변경하는 것 추가하기
                // 데이터 이동 추가
                startActivity(i);
                finish();
            }
        });
    }
}
