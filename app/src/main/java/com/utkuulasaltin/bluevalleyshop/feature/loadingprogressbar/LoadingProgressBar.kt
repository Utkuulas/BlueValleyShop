package com.utkuulasaltin.bluevalleyshop.feature.loadingprogressbar

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.utkuulasaltin.bluevalleyshop.R

class LoadingProgressBar(context: Context): Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.loading_progress_bar)
        window?.setBackgroundDrawableResource(R.color.transparent)
        setCancelable(false)
    }
}