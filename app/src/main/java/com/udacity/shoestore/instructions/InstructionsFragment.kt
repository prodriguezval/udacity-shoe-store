package com.udacity.shoestore.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.login.LoginViewModel

class InstructionsFragment : Fragment() {
    lateinit var binding: FragmentInstructionsBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)

        binding.nextButton.setOnClickListener {
            toShoeList()
        }

        return binding.root
    }

    private fun toShoeList() {
        val viewModel: LoginViewModel by activityViewModels()
        viewModel.onOnboardingFinished()
        findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)
    }
}