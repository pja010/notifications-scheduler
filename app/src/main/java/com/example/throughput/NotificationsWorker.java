//package com.example.throughput;
//
//import android.content.Context;
//import android.util.Log;
//import androidx.annotation.NonNull;
//import androidx.lifecycle.ViewModel;
//import androidx.work.PeriodicWorkRequest;
//import androidx.work.WorkManager;
//import androidx.work.Worker;
//import androidx.work.WorkerParameters;
//
//public class NotificationsWorker extends Worker {
//    public NotificationsWorker(
//            @NonNull Context context,
//            @NonNull WorkerParameters params) {
//            super(context, params);
//    }
//
//    private static final String TAG = NotificationsWorker.class.getSimpleName();
//
//    @NonNull
//    @Override
//    public Result doWork() {
//        try {
////        startZenRule(); //todo implement this method
////            activateAttentionMode();
//            return Result.success();
//        } catch (Throwable throwable) {
//            Log.e(TAG, "Failed to start Zen rule", throwable);
//            return Result.failure();
//        }
//    }
//
//    private WorkManager workManager;
//
////    public ViewModel(@NonNull Application application)
////    super(applicaton);
////    workManager = WorkManager.getInstance(application);
//
//    void startZenRule() {
////        workManager.enqueue(PeriodicWorkRequest.from(NotificationsWorker.class));
//    }
//
//
//}
