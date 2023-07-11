package com.example.authorisation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.authorisation.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModelNew by activityViewModels()  //TODO изучить данную конструкцию, откуда берется и что делает activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnlogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_feedFragment)
            viewModel.token.value = "ourToken"
        }
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
}