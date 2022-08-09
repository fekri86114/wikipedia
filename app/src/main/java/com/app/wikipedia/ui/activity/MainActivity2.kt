package com.app.wikipedia.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.app.wikipedia.databinding.ActivityMain2Binding
import com.app.wikipedia.ui.fragments.SEND_DATA_TO_SECOND_ACTIVITY
import com.app.wikipedia.ux.data.ItemPost
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate( layoutInflater )
        setContentView( binding.root )
        setSupportActionBar( binding.toolbarMain2 )
        binding.collapsingMain.setExpandedTitleColor(ContextCompat.getColor( this, android.R.color.transparent ))
        binding.collapsingMain.title = binding.txtDetailTitle.text // you can set title with this code! or at CollapsingToolbarLayout (xml) part with app:title="Universe"
        supportActionBar!!.setHomeButtonEnabled( true )
        supportActionBar!!.setDisplayHomeAsUpEnabled( true )

        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
        if ( dataPost != null ) {

            showData( dataPost )

        }

    }

    private fun showData(itemPost: ItemPost) {

        Glide
            .with(this)
            .load( itemPost.imgUrl )
            .into(binding.imgDetail)

        binding.txtDetailTitle.text = itemPost.txtTitle
        binding.txtDetailSubtitle.text = itemPost.txtSubtitle
        binding.txtDetailText.text = itemPost.txtDetail

        binding.fabDetailOpenWikipedia.setOnClickListener {

            // open website
            val url = "https://en.wikipedia.org/wiki/Main_Page"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            startActivity(intent)

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if ( item.itemId == android.R.id.home ) {
            onBackPressed()
        }

        return true
    }

}