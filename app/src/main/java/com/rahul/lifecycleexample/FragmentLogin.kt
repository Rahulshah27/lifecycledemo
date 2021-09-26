package com.rahul.lifecycleexample

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.rahul.lifecycleexample.databinding.FragmentLoginBinding


class FragmentLogin : Fragment() {
    private var _binding: FragmentLoginBinding?=null
    private val binding get() = _binding!!
    private var sharedPreference:SharedPreferences?=null
    private var editor: SharedPreferences.Editor?=null
    private var SHARED_PREFER_NAME = "Reg"

    private var SHARED_PREFER_MODE = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        initView()
        return binding.root
    }

    private fun initView(){
        binding.tvSign.setOnClickListener {
            (activity as AuthActivity).addReplaceFragment(FragmentRegister(), 2, "fragmentLogin")
        }
        sharedPreference = activity?.getSharedPreferences(SHARED_PREFER_NAME, SHARED_PREFER_MODE)


        binding.loginBtn.setOnClickListener {
            if (binding.edtUsername.text.toString().trim().isEmpty()){
                binding.edtUsername.error = "Username is required"
                return@setOnClickListener
            }
            if (binding.edtUsername.text.toString().trim().isEmpty()){
                binding.edtPassword.error = "Password is required"
                return@setOnClickListener
            }
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            if (sharedPreference!!.contains("username") && sharedPreference!!.contains("password"))
            {
                val sName = sharedPreference!!.getString("username", "")
                val sPassword = sharedPreference!!.getString("password","")
                if (username != sName){
                    Snackbar.make(binding.loginFragment, "Invalid User", Snackbar.LENGTH_SHORT).show()
                    return@setOnClickListener
                }else if (password != sPassword){
                    Snackbar.make(binding.loginFragment, "Invalid Password",Snackbar.LENGTH_SHORT).show()
                    return@setOnClickListener
                }else{
                    Snackbar.make(binding.loginFragment, "Logged in successfully", Snackbar.LENGTH_SHORT).show()
                    startActivity(Intent(context, ActivityTrans::class.java))
                    activity?.finish()

                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}