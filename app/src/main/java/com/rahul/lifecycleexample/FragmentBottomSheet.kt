package com.rahul.lifecycleexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.d_bottom_sheet.view.*

class FragmentBottomSheet : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.d_bottom_sheet, container, false)
        val btnSubmit = view.btn_bottom_submit
        val edFileName = view.ed_file

        btnSubmit.setOnClickListener {
            if (edFileName.text?.trim().toString().isNotEmpty()) {
                val fileName = edFileName.text?.trim().toString()
                Toast.makeText(requireContext(), "text: $fileName submitted",  Toast.LENGTH_SHORT).show()
                dismiss()
            }
            else {
                Toast.makeText(requireContext(), "Input Required",  Toast.LENGTH_SHORT).show()
            }
        }



        return view
    }

}