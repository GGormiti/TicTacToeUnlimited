package com.example.tictactoeunlimited

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tictactoeunlimited.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val bundle = Bundle()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString("Winner")
        val tagGame = arguments?.getString("TagGame")
        binding.textView2.text = text

        binding.retryButton.setOnClickListener {
            bundle.putString("TagGame", tagGame)
            it.findNavController().navigate(R.id.action_resultFragment_to_gameWithFriendFragment, bundle)
        }
        binding.mainManuButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_resultFragment_to_startFragment)
        }
    }


}