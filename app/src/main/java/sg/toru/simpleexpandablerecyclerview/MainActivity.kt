package sg.toru.simpleexpandablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf(
            ExpandableModel(false).apply {
                movieName = "Star Wars 1"
                movieGenre = "SF"
                directorName = "USA"
                year ="1988"
            },
            ExpandableModel(false).apply {
                movieName = "Star Wars 2"
                movieGenre = "SF"
                directorName = "USA"
                year ="1989"
            },
            ExpandableModel(false).apply {
                movieName = "X-MEN"
                movieGenre = "SF"
                directorName = "USA"
                year ="1990"
            },
            ExpandableModel(false).apply {
                movieName = "Ash"
                movieGenre = "Drama"
                directorName = "Korea"
                year ="2020"
            },
            ExpandableModel(false).apply {
                movieName = "Parasite"
                movieGenre = "Drama"
                directorName = "Korea"
                year ="2019"
            }
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
//        (recyclerview.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = null
        recyclerView.setHasFixedSize(true)

        val adapter = MovieAdapter(list)
        recyclerView.adapter = adapter
    }
}
