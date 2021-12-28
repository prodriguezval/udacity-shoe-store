package com.udacity.shoestore.shoe.repository

import com.udacity.shoestore.shoe.models.Shoe

class ShoeRepository {
    var shoeList = arrayListOf(
        Shoe(
            "Classic",
            38.0,
            "Skochers",
            "Classic to go to your office",
            listOf("classic_shoe_img")
        ),
        Shoe(
            "Boxing",
            40.0,
            "Adidos",
            "Punch your enemies with the best outfit",
            listOf("boxing_shoe_img")
        ),
        Shoe(
            "Running",
            38.0,
            "Niko",
            "To run away of your problems",
            listOf("running_shoe_img")
        ),
    )

    fun getShoes(): List<Shoe> {
        return shoeList
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
    }
}