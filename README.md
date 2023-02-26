<h1 align="center"> IMDB API </h1>

![Badge Kotlin](https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white)
![Badge completed](https://img.shields.io/static/v1?label=Status&message=Completed&color=GREEN&style=for-the-badge)

In this project, the goal at the end of the seven days will be to develop a desktop application with a graphical interface that shows the Top 250 movies from the IMDB Web API.

A different task will be performed each day.

## ✔️ Technologies

- ``Kotlin ``
- ``IntelliJ IDE``
- ``Compose Multiplataform``
- ``Retrofit``
- ``okHttp``

## :bulb: Project Features

- `First Day`

Create a Desktop App that shows the following information about any movie:
- Title
- Poster movie
- Rating
- Year

For this taks I downloaded the poster image and saved ir inside the Resources folder.

![imdb](https://user-images.githubusercontent.com/105471213/219254886-a37efaf2-66ff-4558-95f8-cc30cf35f554.png)

- `Second Day`

For this first sample, I presented the image that was loaded directly from my project. However, when implementing an application that consumes a web API (in this case, with general information about the films), I will have access to the poster images of each film from an HTTP address.

The second day's task will be to load the movie poster image from a URL.

- `Third Day`

For this task I am customized the look of the movie showing.

During customization, my goal will be to modify colors, font sizes, spacing between visual components, etc.

![LOFTR_black](https://user-images.githubusercontent.com/105471213/219827803-0158d7c2-eb54-412c-bd03-3953d069ab35.png)

- `Fourth Day`

The challenge was to adjust the code to be able to display more than one movie on the screen.

![day4](https://user-images.githubusercontent.com/105471213/221380169-e148331a-1f0f-4573-8f16-4a5375378870.gif)

- `Fifth Day`

For this task we are finally going to get the information of all the top 250 movies from the IMDB Web API.
As an Http client and to obtain the JSON of the request, I used the Retrofit and okHttp libraries.

```kotlin
class RetrofitInit {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com/API/Top250Movies/")
        .build()

    val movieService: MovieService
        get() = retrofit.create(MovieService::class.java)
}
 ```


-- Service responsible for making the request

```kotlin
interface MovieService {

    @GET(IMDB_API_KEY)
    fun findTop250Movies(): Call
}
 ```

- `Sixth Day`

Implementing the next steps:

- Convert the received JSON to a Kotlin object that receives all fields;

- Convert this Kotlin object with all the information to an object that represents a movie;

- Modify the screen code to receive the list of movies obtained from the IMDB API search.

Receiving all fields of the request:

```kotlin
data class Top250Data(
    val items: List,
     val errorMessage: String
)

data class Top250DataDetail(
     val id: String,
     val rank: String,
     val title: String,
     val fullTitleval: String,
     val year: String,
     val image: String,
     val crew: String,
     val imDbRating: String,
     val imDbRatingCount: String
)

fun Top250DataDetail.toMovie(): Movie = Movie(
     title = this.title,
     image = this.image,
     rating = imDbRating.toDouble(),
     year = year.toInt()
)
```

Some HTTP clients have automatic JSON to Kotlin object converters, in this project I used Moshi's converter:

```kotlin
class RetrofitInit {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com/en/API/Top250Movies/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val movieService: MovieService get() = retrofit.create(MovieService::class.java)
}
```

```kotlin
interface MovieService {

    @GET(IMDB_API_KEY)
    fun findTop250Movies(): Top250Data
}
```

This way, it is no longer necessary to deal with the JSON as a String. The converter itself is responsible for returning an object with the expected data.

- `Seventh Day`

Refactoring the code and applying screen improvements, instead of using a single column list, you can adapt the code to be a grid layout.

![day 7](https://user-images.githubusercontent.com/105471213/221391821-6d30d62a-c5ce-4b3c-82ea-8c0a80c2851b.gif)



