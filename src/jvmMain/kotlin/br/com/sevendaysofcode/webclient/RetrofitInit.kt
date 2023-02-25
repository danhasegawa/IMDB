package br.com.sevendaysofcode.webclient

import br.com.sevendaysofcode.webclient.service.MovieService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInit {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com/en/API/Top250Movies/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val movieService: MovieService get() = retrofit.create(MovieService::class.java)
}