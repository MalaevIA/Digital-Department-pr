package ru.myitschool.lab23;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final long mTimeLimitSec = 60;
    private final long mFileSizeLimitBytes = 1920 * 1080 * 10L;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityResultLauncher<Intent> photoResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        setImage(data);
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        // TODO handle cancelled status
                    }
                });

        ((Button) findViewById(R.id.capture_video)).setOnClickListener(v ->
                SystemCameraCall.callSystemCameraPhoto(this,
                        Directories.PICTURE,
                        "",
                        getPackageName(),
                        mTimeLimitSec,
                        mFileSizeLimitBytes,
                        photoCallback,
                        photoResultLauncher
                )
        );
    }

    private final SystemCameraCall.CallbackVideo photoCallback = new SystemCameraCall.CallbackVideo() {
        private File mTempFile;

        @Override
        public File getCurrentFile() {
            return mTempFile;
        }

        @Override
        public void setCurrentFile(File tempFile) {
            mTempFile = tempFile;
        }

        @Override
        public void noCameraHandler() {

        }

        @Override
        public void noCameraPermission() {

        }

        @Override
        public void noStoragePermission() {

        }
    };

    private void setImage(Intent data) {
        // TODO set image
    }
}

enum Directories {
    PICTURE,
    MOVIE,
    OTHER
}

class SystemCameraCall {

    public interface CallbackVideo {
        // A callback interface for states
        File getCurrentFile();

        void setCurrentFile(File tempFile);

        void noCameraHandler();

        void noCameraPermission();

        void noStoragePermission();
    }

    /**
     * @param mContext          A Context (Activity) for the current component.
     * @param directory         Directory enum
     * @param fileName          The filename with prefix
     * @param authority         The authority of a FileProvider (applicationId) defined in the manifest
     * @param videoTimeLimitSec A limit for video in seconds (not applicable to photos)
     * @param sizeBytes         The maximum file size
     * @param callback          A callback for photos and videos
     * @param launcher          A launcher
     */
    public static void callSystemCameraPhoto(@NonNull ComponentActivity mContext,
                                             Directories directory,
                                             String fileName,
                                             String authority,
                                             Long videoTimeLimitSec,
                                             Long sizeBytes,
                                             CallbackVideo callback,
                                             @NonNull ActivityResultLauncher<Intent> launcher) {
        // TODO check permissions
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        /*if (videoTimeLimitSec != null && videoTimeLimitSec > 0) {
            pictureIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, videoTimeLimitSec);
        }*/
        if (sizeBytes != null && sizeBytes > 0) {
            pictureIntent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, sizeBytes);
        }
        if (pictureIntent.resolveActivity(mContext.getPackageManager()) != null) {
            File photoFile;
            try {
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
                String imageFileName = "IMG_" + timeStamp + "_";
                File storageDir;
                if (directory.equals(Directories.PICTURE)) {
                    storageDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                } else if (directory.equals(Directories.MOVIE)) {
                    storageDir = mContext.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
                } else {
                    throw new NotDirectoryException("unsupported directory type");
                }
                photoFile = File.createTempFile(imageFileName, ".jpg", storageDir);
                String imageFilePath = photoFile.getAbsolutePath();
                callback.setCurrentFile(photoFile);
            } catch (IOException e) {
                callback.noStoragePermission();
                return;
            }
            Uri photoUri = FileProvider.getUriForFile(mContext, authority + ".provider", photoFile);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            launcher.launch(pictureIntent);
        } else {
            if (callback != null) callback.noCameraHandler();
        }

    }
}

