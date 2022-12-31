package com.mahomud.khabeertask.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cn.pedant.SweetAlert.SweetAlertDialog
import com.mahomud.khabeertask.R
import com.mahomud.khabeertask.data.Raw
import com.mahomud.khabeertask.databinding.FragmentLoginBinding
import com.mahomud.khabeertask.ui.UserViewModel
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loadingBar = SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
        loadingBar.titleText = getString(R.string.wait)
        loadingBar.contentText = getString(R.string.login)
        loadingBar.setCancelable(false)
        loadingBar.setCanceledOnTouchOutside(false)

        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding.loginBtn.setOnClickListener {
            loadingBar.show()
            var token = ""
            lifecycleScope.launch {
                viewModel.loginUser(raw = Raw(MobileNumber = "01068962997", Password = 123456)).observe(viewLifecycleOwner){
                    token = "Bearer ${it.Token}"
                    Log.e("xxLOGxx", "LoginCall: Token: $token")

                    val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(token)
                    findNavController().navigate(action)
                    loadingBar.dismiss()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}