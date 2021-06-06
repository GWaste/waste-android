package com.bangkit.waste.utils

import android.Manifest
import android.content.Context
import pub.devrel.easypermissions.EasyPermissions

object CameraUtility {

    fun hasPermission(context: Context) =
        EasyPermissions.hasPermissions(
            context,
            Manifest.permission.CAMERA,
        )
}