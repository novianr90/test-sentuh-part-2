package id.novian.test_sentuh_part_2.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.Shimmer
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory
import id.novian.test_sentuh_part_2.R
import id.novian.test_sentuh_part_2.common.DataState
import id.novian.test_sentuh_part_2.databinding.ActivityMainBinding
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var jokeAdapter: JokeAdapter
    private lateinit var recyclerView: RecyclerView

    private val customShimmer = Shimmer.AlphaHighlightBuilder()
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        userSearch()
        observeJokes()
    }

    private fun setRecyclerView() {
        recyclerView = binding.rvJokes
        jokeAdapter = JokeAdapter()
        recyclerView.apply {
            adapter = jokeAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun userSearch() {
        with(binding) {
            btnSearch.setOnClickListener {
                val etSearch = etSearch.text
                if (!etSearch.isNullOrBlank()) {
                    viewModel.fetchData(etSearch.toString())
                }
            }
        }
    }

    private fun observeJokes() {
        lifecycleScope.launch {

            viewModel.data.collect { data ->

                when(data) {

                    is DataState.Initial -> {}

                    is DataState.Loading -> {
                        recyclerView.loadSkeleton(R.layout.item_joke) {
                            shimmer(customShimmer)
                        }
                    }

                    is DataState.Empty -> {
                        // Show Empty Screen. Not implemented yet.
                    }

                    is DataState.Error -> {
                        Toast.makeText(this@MainActivity, "Got error with message: ${data.message}", Toast.LENGTH_SHORT).show()
                    }

                    is DataState.Success -> {
                        recyclerView.hideSkeleton()
                        jokeAdapter.submitJokes(data.data)
                    }
                }

            }
        }
    }
}