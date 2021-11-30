package dougles.project.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dougles.project.myapplication.models.ResponseDTO
import dougles.project.myapplication.models.ResultsDTO

class MoviesAdapter(val responseDTO: ResponseDTO, val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_movie, parent, false)
        return MoviesViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie: ResultsDTO = responseDTO.results?.get(position)!!
        holder.setData(movie, position)

    }

    override fun getItemCount(): Int {
        return responseDTO.results!!.size
    }
}