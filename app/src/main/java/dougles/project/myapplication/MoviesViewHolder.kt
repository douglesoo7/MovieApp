package dougles.project.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dougles.project.myapplication.models.ResultsDTO
import kotlinx.android.synthetic.main.item_layout_movie.view.*

class MoviesViewHolder(val view: View, val itemClickListener: ItemClickListener) :
    RecyclerView.ViewHolder(view) {

    fun setData(resultsDTO: ResultsDTO, position: Int) {
        itemView.apply {
            Glide.with(ivMoviePoster)
                .load("https://image.tmdb.org/t/p/w500/" + resultsDTO.posterPath)
                .into(ivMoviePoster)
            tvTitle.text = resultsDTO.originalTitle.toString()
            tvPopularity.text = resultsDTO.popularity.toString()

            cvMovie.setOnClickListener {
                itemClickListener.itemClickListener(resultsDTO, position)
            }
        }
    }


}