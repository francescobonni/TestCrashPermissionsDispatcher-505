package francescobonni.checkbugpermissiondispatcher

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.support.annotation.RequiresApi
import android.widget.Button
import android.widget.Toast

const val CODE_REQUEST_WINDOW_PERMISSIONS = 123

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(OverlayPermission.hasRuntimePermissionToDrawOverlay(applicationContext)) {
                    showMessage()
                } else {
                    val intent = OverlayPermission.createIntentToRequestOverlayPermission(applicationContext)
                    startActivityForResult(intent, CODE_REQUEST_WINDOW_PERMISSIONS)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CODE_REQUEST_WINDOW_PERMISSIONS) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                showMessage()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun showMessage() {
        Toast.makeText(this,
                if(Settings.canDrawOverlays(this))
                    "can draw overlays : true"
                else
                    "can draw overlays : false", Toast.LENGTH_LONG).show()
    }
}
