package com.twoccs.flixster

import org.json.JSONArray

data class Movie (
    val movieId: Int,
    val posterPath: String,
    val title: String,
    val overview: String,
) {

    companion object {

        fun fromJsonArray(movieJSONArray: JSONArray): List<Movie> {

            val movies = mutableListOf<Movie>()

            for(mov in 0 until movieJSONArray.length()) {
                val movieJSON = movieJSONArray.getJSONObject(mov)

                movies.add(
                    Movie(
                        movieJSON.getInt("id"),
                        movieJSON.getString("poster_path"),
                        movieJSON.getString("title"),
                        movieJSON.getString("overview")
                    )
                )

            }

            return movies

        }

    }

}