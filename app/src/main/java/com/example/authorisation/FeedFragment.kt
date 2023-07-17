package com.example.authorisation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.authorisation.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private val viewModel: LoginViewModelNew by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
viewModel.token.observe(viewLifecycleOwner){token ->

}
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}