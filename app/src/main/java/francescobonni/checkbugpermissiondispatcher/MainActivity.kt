package francescobonni.checkbugpermissiondispatcher

import android.Manifest
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.support.annotation.RequiresApi
import android.widget.Button
import android.widget.Toast
import permissions.dispatcher.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions
import android.content.Intent

@RuntimePermissions
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener { _ ->
            // NOTE: delegate the permission handling to generated method
            showMessageOverlayWithPermissionCheck()
        }
        findViewById<Button>(R.id.button2).setOnClickListener { _ ->
            // NOTE: delegate the permission handling to generated method
            showMessageWriteSettingsWithPermissionCheck()
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        onActivityResult(requestCode)
    }

    @NeedsPermission(Manifest.permission.SYSTEM_ALERT_WINDOW)
    fun showMessageOverlay() {
        Toast.makeText(this, "can draw overlays : true", Toast.LENGTH_LONG).show()
    }

    @NeedsPermission(Manifest.permission.WRITE_SETTINGS)
    fun showMessageWriteSettings() {
        Toast.makeText(this, "write settings : true", Toast.LENGTH_LONG).show()
    }
}
