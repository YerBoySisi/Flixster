package com.twoccs.flixster

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.json.JSONArray

@Parcelize
data class Movie (
    val movieId: Int,
    val posterPath: String,
    val backdropPath: String,
    val title: String,
    val overview: String,
    var voteAverage: Double,
) : Parcelable {

    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    val backdropImageUrl = "https://image.tmdb.org/t/p/w342/$backdropPath"

    companion object {

        fun fromJsonArray(movieJSONArray: JSONArray): List<Movie> {

            val movies = mutableListOf<Movie>()

            for(mov in 0 until movieJSONArray.length()) {
                val movieJSON = movieJSONArray.getJSONObject(mov)

                movies.add(
                    Movie(
                        movieJSON.getInt("id"),
                        movieJSON.getString("poster_path"),
                        movieJSON.getString("backdrop_path"),
                        movieJSON.getString("title"),
                        movieJSON.getString("overview"),
                        movieJSON.getDouble("vote_average")
                    )
                )

            }

            return movies

        }

    }

}