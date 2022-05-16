package com.twoccs.flixster

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {

    private lateinit var ivPoster: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvOverview: TextView
    private lateinit var ratingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ivPoster = findViewById(R.id.poster)
        tvTitle = findViewById(R.id.title)
        tvOverview = findViewById(R.id.overview)
        ratingBar = findViewById(R.id.rating_avg)

        val movie = intent.getParcelableExtra<Movie>(MOVIE_EXTRA) as Movie
        Log.i(TAG, "Movie is $movie")

        tvTitle.text = movie.title
        tvOverview.text = movie.overview
        ratingBar.rating = movie.voteAverage.toFloat()

        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Glide.with(this).load(movie.posterImageUrl).into(ivPoster)
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Glide.with(this).load(movie.backdropImageUrl).into(ivPoster)
        }

    }
}