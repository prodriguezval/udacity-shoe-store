package com.udacity.shoestore.shoe.screens

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentShoeListDetailBinding


class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        val shoeListLayout = binding.layoutShoes
        val viewModel: ShoeViewModel by activityViewModels()


        viewModel.getShoes().observe(viewLifecycleOwner, { shoes ->
            shoes.forEach { shoe ->
                val shoeItemBinding = DataBindingUtil.inflate<FragmentShoeListDetailBinding>(
                    inflater,
                    R.layout.fragment_shoe_list_detail,
                    container,
                    false
                )
                val imageName = resources.getIdentifier(
                    "com.udacity.shoestore:drawable/${shoe.images[0]}",
                    null,
                    null
                )
                shoeItemBinding.imgShoe.setImageResource(imageName)
                shoeItemBinding.txtShoeName.text = (shoe.name)
                shoeItemBinding.txtShoeDescription.text = (shoe.description)
                shoeListLayout.addView(shoeItemBinding.root)
            }
        })

        setHasOptionsMenu(true)

        binding.btnAddShoe.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}