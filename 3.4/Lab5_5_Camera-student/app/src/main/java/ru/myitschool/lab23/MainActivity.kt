package ru.myitschool.lab23

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding
import java.io.File


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mTimeLimitSec: Long = 60
    private val mFileSizeLimitBytes = 1920 * 1080 * 10L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val photoResultLauncher = registerForActivityResult(
            StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                setImage(data)
            } else if (result.resultCode == RESULT_CANCELED) {
                // TODO handle cancelled status
            }
        }
        binding.container.captureVideo.setOnClickListener { v: View? ->
            SystemCameraCall.callSystemCameraPhoto(
                this,
                Directories.MOVIE,
                "",
                packageName,
                mTimeLimitSec,
                mFileSizeLimitBytes,
                photoCallback,
                photoResultLauncher
            )
        }
    }

    private val photoCallback: SystemCameraCall.CallbackVideo = object :
        SystemCameraCall.CallbackVideo {
        override var currentFile: File? = null

        override fun noCameraHandler() {
        }

        override fun noCameraPermission() {
        }

        override fun noStoragePermission() {
        }
    }

    private fun setImage(data: Intent?) {
        // TODO set image
    }
}





