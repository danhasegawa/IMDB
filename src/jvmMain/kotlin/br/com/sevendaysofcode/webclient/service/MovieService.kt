package br.com.sevendaysofcode.webclient.service

import br.com.sevendaysofcode.webclient.IMDB_API_KEY
import br.com.sevendaysofcode.webclient.Top250Data
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET(IMDB_API_KEY)
    fun findTop250Movies(): Call<Top250Data>

}