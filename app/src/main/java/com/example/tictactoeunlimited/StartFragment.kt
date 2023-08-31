package com.example.tictactoeunlimited

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tictactoeunlimited.databinding.FragmentStartBinding
import kotlin.system.exitProcess


class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()

        binding.startGameWithFriendBtn.setOnClickListener {
            bundle.putString("TagGame", "0")
            it.findNavController().navigate(R.id.action_startFragment_to_gameWithFriendFragment, bundle)
        }

        binding.startGameWithComputerBtn.setOnClickListener {
            bundle.putString("TagGame", "1")
            it.findNavController().navigate(R.id.action_startFragment_to_gameWithFriendFragment, bundle)
        }

        binding.options.setOnClickListener {
            it.findNavController().navigate(R.id.action_startFragment_to_optionsFragment)
        }

        binding.quit.setOnClickListener {
            activity?.finish()
            exitProcess(0)
        }
    }


}