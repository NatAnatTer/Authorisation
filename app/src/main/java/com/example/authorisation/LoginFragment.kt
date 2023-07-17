package com.example.authorisation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.authorisation.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com").client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val mainApi = retrofit.create(MainAPI::class.java)

        binding.apply {
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_feedFragment)
                CoroutineScope(Dispatchers.IO).launch {
                    val user = mainApi.auth(
                        AuthRequest(
                            binding.username.text.toString(),
                            binding.password.text.toString()
                        )
                    )
//                  runOnUITread{
//                      binding.apply {
//
//                      }
//                  }
                }

                viewModel.token.value = "ourToken"
            }

        }

//        binding.btnLogin.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_feedFragment)
//            viewModel.token.value = "ourToken"
//        }
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
}