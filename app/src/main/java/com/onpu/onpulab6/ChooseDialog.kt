package com.onpu.onpulab6

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ChooseDialog(
    private val model: ItemModel
    ) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Number")
            .setMessage("You have chosen number: ${model.number}")
            .setPositiveButton("Ok", null)
            .create()
    }

}