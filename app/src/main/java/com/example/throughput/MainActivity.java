package com.example.throughput;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.WorkManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ToggleButton button;
//    private Context context;
//    private Activity activity;
    private ConstraintLayout layout;
    private TextView textView;
    private NotificationManager notificationManager;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        textView = findViewById(R.id.text);
        button = findViewById(R.id.default_activity_button);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N) { //min build 24
            Log.e(TAG, "onCreate: unsupported build");
        }

//        checkIfNotificationAccessGranted();

//        schedule();

//        final NotificationsController controller = new NotificationsController();

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
//                    controller.activateAttentionMode();
//                    activateAttentionMode();
//                    activateZen();
                    activateAttentionMode();
                    layout.setBackgroundColor(Color.DKGRAY);
                    textView.setText("At peace");
                } else {
                    disableAttentionMode();
//                    controller.disableAttentionMode();
                    layout.setBackgroundColor(Color.WHITE);
                    textView.setText("Attention under attack!");
                }
            }
        });


//        notificationManager.setAutomaticZenRuleState(); // for custom-defined notification policy
//        notificationManager.getAutomaticZenRule()
//        notificationManager.getCurrentInterruptionFilter()

    }
//
//    public void disableAttentionMode() {
        private void disableAttentionMode() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { //min build 2
        checkIfNotificationAccessGranted();
        notificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);
        }
    }
//
//    public void activateAttentionMode() {
        private void activateAttentionMode() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { //min build 24
            checkIfNotificationAccessGranted();
            notificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
        }
    }

    private void checkIfNotificationAccessGranted() { // todo fix this guy
        if (!notificationManager.isNotificationPolicyAccessGranted()) {
            Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(intent);
        }
    }

    protected void activateZen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (notificationManager.isNotificationPolicyAccessGranted()) {
                notificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
            } else {
                Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                startActivity(intent);
            }

        }
    }
//    }

//    private final ScheduledExecutorService scheduler =
//                Executors.newScheduledThreadPool(1);
//
//    public void schedule() {
//        final Runnable zenMode = new Runnable() {
//            @Override
//            public void run() {
//                activateAttentionMode();
//            }
//        };
//        final ScheduledFuture zenModeHandle =
//                scheduler.scheduleAtFixedRate(zenMode, 3, 3, TimeUnit.SECONDS);
//        scheduler.schedule(new Runnable() {
//            @Override
//            public void run() {
//                zenModeHandle.cancel(true);
//            }
//        }, 20, TimeUnit.SECONDS);
//    }



}