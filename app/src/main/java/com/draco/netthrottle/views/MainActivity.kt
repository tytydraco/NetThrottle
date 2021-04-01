package com.draco.netthrottle.views

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.draco.netthrottle.fragments.MainPreferenceFragment
import com.draco.netthrottle.R
import com.draco.netthrottle.utils.PermissionUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var preferences: FragmentContainerView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = findViewById(R.id.preferences)
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        /* If we are missing a permission, lock the user in the permission activity */
        if (!PermissionUtils.isPermissionsGranted(this, android.Manifest.permission.WRITE_SECURE_SETTINGS))
            goToPermissionActivity()

        firstLaunchDialog()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.preferences, MainPreferenceFragment())
            .commit()
    }

    private fun firstLaunchDialog() {
        if (sharedPreferences.getBoolean(getString(R.string.pref_key_first_launch), true)) {
            sharedPreferences.edit().also {
                it.putBoolean(getString(R.string.pref_key_first_launch), false)
                it.apply()
            }

            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title_warn)
                .setMessage(R.string.dialog_message_warn)
                .setPositiveButton(R.string.dialog_ok) { _, _ -> }
                .setCancelable(false)
                .show()
        }
    }

    private fun goToPermissionActivity() {
        val intent = Intent(this, PermissionActivity::class.java)
        startActivity(intent)
    }
}