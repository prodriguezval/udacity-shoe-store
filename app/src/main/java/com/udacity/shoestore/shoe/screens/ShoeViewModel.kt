package com.udacity.shoestore.shoe.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.shoe.models.Shoe
import com.udacity.shoestore.shoe.repository.ShoeRepository
import timber.log.Timber

class ShoeViewModel: ViewModel() {
    private val shoeRepository: ShoeRepository = ShoeRepository();
    private val shoes: MutableLiveData<MutableList<Shoe>> = MutableLiveData()

    init {
        shoes.value = ArrayList()
    }

    fun getShoes(): LiveData<MutableList<Shoe>> {
        Timber.i("Getting shoe List from repository")
        shoes.value = shoeRepository.getShoes().toMutableList()
        return shoes;
    }

    fun saveShoe(shoe: Shoe) {
        Timber.i("Adding shoe $shoe")
        shoeRepository.addShoe(shoe)
    }


}