package com.rahul.lifecycleexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FragmentSecond : Fragment(R.layout.fragment_second) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSecondFragment = view.findViewById<Button>(R.id.btnSubmitSecond)
        val textView2 = view.findViewById<TextView>(R.id.tv2)

        btnSecondFragment.setOnClickListener{

            val editText2 = view.findViewById<EditText>(R.id.et2)
            val text2 = editText2.text.toString()
            val bundle =Bundle()
            bundle.putString("data", text2)

            val fragment2 = FragmentFirst()
            fragment2.arguments = bundle
            parentFragmentManager.beginTransaction().replace(R.id.container1View,fragment2).commit()

        }
        val args = this.arguments
        val recData = args?.getString("data")

        if (recData.isNullOrEmpty()){
            textView2.text = "Second Fragment"
        }
        else
            textView2.text = recData
    }


}