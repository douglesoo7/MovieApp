package dougles.project.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dougles.project.myapplication.repository.MovieRepository
import dougles.project.myapplication.models.ResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.getMovies("1")
        }
    }

    val movies: LiveData<ResponseDTO>
        get() = movieRepository.movies

}