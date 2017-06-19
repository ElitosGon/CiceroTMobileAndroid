package com.example.ian.myapplication.CuentaGuia.Main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ian.myapplication.R;

/**
 * Created by Ian on 18-06-2017.
 */
public class dashBoardActivity extends Fragment {

    ProgressBar myprogressBar;
    TextView progressingTextView;
    TextView progressText2;
    TextView progressText3;
    TextView progressText4;
    ProgressBar progressDos;
    Handler progressHandler = new Handler();
    int i = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dashboard, container, false);


        myprogressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressingTextView = (TextView) view.findViewById(R.id.progress_circle_text);
        progressDos = (ProgressBar)view.findViewById(R.id.progressBar3);
        progressText2 = (TextView)view.findViewById(R.id.progress_circle_text1);
        progressText3 = (TextView)view.findViewById(R.id.progress_circle_text3);
        progressText4 = (TextView)view.findViewById(R.id.progress_circle_text4);

        new Thread(new Runnable() {
            public void run() {
                while (i < 85) {
                    i += 1;
                    progressHandler.post(new Runnable() {
                        public void run() {
                            myprogressBar.setProgress(i);
                            progressDos.setProgress(i / 2);
                            progressingTextView.setText("" + i + "%");
                            progressText2.setText("$"+(i*40000)+"");
                            progressText3.setText(""+(i/2)+"%");
                            progressText4.setText("$"+(i*5000)+"");
                        }
                    });
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return view;
    }

}
