package com.udacity.shoestore.shoe.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.shoe.models.Shoe
import timber.log.Timber


class ShoeDetailFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.saveButton.setOnClickListener {
            save()
        }

        binding.cancelButton.setOnClickListener {
            cancel()
        }

        return binding.root
    }

    private fun save() {
        val viewModel: ShoeViewModel by activityViewModels()
        Timber.i("Pressed save button")
        val img = arrayListOf("default_shoe_img")
        val shoe = Shoe(
            binding.txtShoeName.text.toString(),
            binding.txtSize.text.toString().toDouble(),
            binding.txtCompanyName.text.toString(),
            binding.txtDescription.text.toString(),
            img
        )
        viewModel.saveShoe(shoe)
        findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
    }
    private fun cancel() {
        Timber.i("Pressed cancel button")
        findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
    }
}