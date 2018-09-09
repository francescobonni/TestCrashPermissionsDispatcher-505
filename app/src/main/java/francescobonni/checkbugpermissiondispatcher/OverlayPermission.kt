package francescobonni.checkbugpermissiondispatcher

import android.content.Context
import android.provider.Settings.canDrawOverlays
import android.os.Build
import android.provider.Settings
import android.support.annotation.NonNull
import android.content.Intent
import android.net.Uri
import android.support.annotation.RequiresApi





object OverlayPermission {

    fun hasRuntimePermissionToDrawOverlay(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Settings.canDrawOverlays(context)
        } else {
            true
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun createIntentToRequestOverlayPermission(context: Context): Intent {
        return Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + context.packageName)
        )
    }
}