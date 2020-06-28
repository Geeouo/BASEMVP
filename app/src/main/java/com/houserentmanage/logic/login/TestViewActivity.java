package com.houserentmanage.logic.login;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.houserentmanage.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Create by Gee on 2020/6/21.
 */
public class TestViewActivity extends AppCompatActivity {
    LoginView loginView ;
    private View viewById;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        loginView = findViewById(R.id.login_view);
        viewById = findViewById(R.id.btn);
        //ValueAnimator;
        //ObjectAnimator;
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginView.startScroll(-1000,-1000,10000);
            }
        });

        loginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestViewActivity.this,"clickMoveView",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
