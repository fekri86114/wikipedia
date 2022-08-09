package com.app.wikipedia.ux.interfaces

import com.app.wikipedia.ux.data.ItemPost

interface ItemEvents {

    fun onItemClicked( itemPost: ItemPost )

}