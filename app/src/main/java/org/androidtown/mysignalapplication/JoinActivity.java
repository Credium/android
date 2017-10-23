package org.androidtown.mysignalapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class JoinActivity extends AppCompatActivity {

    ImageButton mProfile;
    Button mRegister;
    AutoCompleteTextView mUserID;
    EditText mPassword, mUserFullName, mJob, mPhoneNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mProfile = (ImageButton) findViewById(R.id.profile_photo);
        mRegister = (Button) findViewById(R.id.register_button);
        mUserID = (AutoCompleteTextView) findViewById(R.id.userID);
        mPassword = (EditText) findViewById(R.id.password);
        mUserFullName = (EditText) findViewById(R.id.full_name);
        mJob = (EditText) findViewById(R.id.job);
        mPhoneNum = (EditText) findViewById(R.id.phone_number);

        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 앨범 열기
                // 크롭하기
                // 이미지 가져오기
                // 이미지 보여주기
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서버로 회원가입 정보 보내기
                // 메인으로 넘어가기
            }
        });
    }

    //앨범 여는 메소드
    //크롭 메소드
    //이미지 가져오는 메소드
    //이미지 보여주는 메소드
    //서버로 정보 담고 보내기
    //정보 유효성 확인

}
