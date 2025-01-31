package ru.myitschool.lab22toast;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String DESTROY_COUNT_KEY = "destroy_count";
    private int destroyCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Восстановление состояния при повороте экрана
        if (savedInstanceState != null) {
            destroyCount = savedInstanceState.getInt(DESTROY_COUNT_KEY, 0);
        }

        showToast(R.string.ncreate);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast(R.string.nstart);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast(R.string.nresume);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyCount++;
        if (destroyCount % 2 == 0) {
            showToast(R.string.ndestroy);
        }
    }

    private void showToast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(DESTROY_COUNT_KEY, destroyCount);
    }
}

