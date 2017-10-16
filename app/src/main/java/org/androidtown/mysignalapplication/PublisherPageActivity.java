package org.androidtown.mysignalapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.androidtown.mysignalapplication.Adapter.RecyclerAdapter;
import org.androidtown.mysignalapplication.DataSetting.CardItem;
import org.androidtown.mysignalapplication.Fragments.MyPageFragment;
import org.androidtown.mysignalapplication.Fragments.PublisherPageFragment;

import java.util.ArrayList;
import java.util.List;

public class PublisherPageActivity extends AppCompatActivity
        implements PublisherPageFragment.OnFragmentInteractionListener {

    ImageView publisherImage;
    Button checkReviewButton, sendSignalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher_page);

        checkReviewButton = (Button) findViewById(R.id.review_check_button);
        sendSignalButton = (Button) findViewById(R.id.send_signal_button);

        checkReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PublisherPageActivity.this, CheckReviewActivity.class);
                startActivity(i);
                finish();
            }
        });

        sendSignalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PublisherPageActivity.this, SendSignalActivity.class);
                startActivity(i);
                finish();

            }
        });

        // 뒤로가기 하면 액티비티로 가는것 수정하기
        // 데이터 주고 받기



        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, PublisherPageFragment.newInstance("What","Ever"));
        transaction.commit();





    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
