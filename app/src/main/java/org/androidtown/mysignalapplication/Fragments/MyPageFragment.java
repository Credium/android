package org.androidtown.mysignalapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.androidtown.mysignalapplication.Adapter.RecyclerAdapter;
import org.androidtown.mysignalapplication.CheckSignalActivity;
import org.androidtown.mysignalapplication.DataSetting.CardItem;
import org.androidtown.mysignalapplication.LoginActivity;
import org.androidtown.mysignalapplication.MainActivity;
import org.androidtown.mysignalapplication.MakeMeetingActivity;
import org.androidtown.mysignalapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyPageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    final int ITEM_SIZE = 5;

    public MyPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyPageFragment newInstance(String param1, String param2) {
        MyPageFragment fragment = new MyPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (container == null) {
            return null;
        }
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);

        Button makeMeetingButton = (Button) view.findViewById(R.id.make_meeting_button);
        Button checkSignalButton = (Button) view.findViewById(R.id.signal_check_button);

        makeMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment에서는 this 사용 불가능
                //context 받아오는 getActivity() 사용
                Intent i = new Intent(getActivity(), MakeMeetingActivity.class);
                startActivity(i);

            }
        });

        checkSignalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CheckSignalActivity.class);
                startActivity(i);
            }
        });


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.myPageFragmentRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<CardItem> items = new ArrayList<>();
        CardItem[] item = new CardItem[ITEM_SIZE];
        // Item (image, userName, userTitle, meetingTitle, meetingContents)
        item[0] = new CardItem(R.drawable.p1, "김수현", "배우", "볼링치러 가요", "abc");
        item[1] = new CardItem(R.drawable.p6, "김수현", "배우", "같이 노래해요", "abc");
        item[2] = new CardItem(R.drawable.p7, "김수현", "배우", "독서 피크닉 떠나요", "abc");
        item[3] = new CardItem(R.drawable.p8, "김수현", "배우", "연극보러 갈까요?", "abc");
        item[4] = new CardItem(R.drawable.p9, "김수현", "배우", "루프탑 카페에서 디저트 먹어요", "abc");

        for (int i = 0; i < ITEM_SIZE; i++) {
            items.add(item[i]);
        }

        recyclerView.setAdapter(new RecyclerAdapter(getActivity().getApplicationContext(), items, R.layout.fragment_my_page));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
