package francescobonni.checkbugpermissiondispatcher

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.support.annotation.RequiresApi
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
