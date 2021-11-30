package dougles.project.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.item_layout_movie.*
import kotlinx.android.synthetic.main.item_layout_movie.ivMoviePoster
import kotlinx.android.synthetic.main.item_layout_movie.tvTitle

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        setDataFromMainActivity()
    }

    private fun setDataFromMainActivity() {
        val imagePath = "https://image.tmdb.org/t/p/w500/" + intent?.getStringExtra("Image")
        if (imagePath == null) {
            Toast.makeText(this@MovieDetailsActivity, "Success", Toast.LENGTH_SHORT).show()
        } else {
            Glide.with(ivMoviePoster)
                .load(imagePath)
                .into(ivMoviePoster)
        }
         tvTitle.text = intent?.getStringExtra("Title")
         tvSynopsis.text = intent?.getStringExtra("Synopsis")
         tvGenre.text = intent?.getStringExtra("Genre")
         tvLanguage.text = intent?.getStringExtra("Language")
    }
}