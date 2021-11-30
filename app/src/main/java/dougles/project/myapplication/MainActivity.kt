package dougles.project.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dougles.project.myapplication.api.ApiClient
import dougles.project.myapplication.api.Network
import dougles.project.myapplication.models.ResponseDTO
import dougles.project.myapplication.models.ResultsDTO
import dougles.project.myapplication.repository.MovieRepository
import dougles.project.myapplication.viewmodels.MainViewModel
import dougles.project.myapplication.viewmodels.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), ItemClickListener {

    lateinit var moviesAdapter: MoviesAdapter
    lateinit var mainViewModel: MainViewModel
    var movie: ResponseDTO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setData()

        swipeRecyclerView.setOnRefreshListener{
           // swipeRecyclerView.isRefreshing=false;
        }


    }

    private fun setData() {

        val apiClient = Network.getRetrofit().create(ApiClient::class.java)
        val movieRepository = MovieRepository(apiClient)

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(movieRepository)
        ).get(MainViewModel::class.java)


        mainViewModel.movies.observe(this, Observer {
            movie = it
            setRecyclerView()
            //Log.d("SachinModi", it.results.toString())
        })

    }

    private fun setRecyclerView() {
        moviesAdapter = MoviesAdapter(movie!!, this)
        moviesRecyclerView.adapter = moviesAdapter
        moviesRecyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
    }

    override fun itemClickListener(responseDTOItem: ResultsDTO, position: Int) {
        val intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
        intent.putExtra("Image", responseDTOItem.posterPath.toString())
        intent.putExtra("Title", responseDTOItem.originalTitle)
        intent.putExtra("Synopsis", responseDTOItem.overview)
        intent.putExtra("Language", responseDTOItem.originalLanguage)
        intent.putExtra("Genre", responseDTOItem.genreIds.toString())
        startActivity(intent)

    }
}