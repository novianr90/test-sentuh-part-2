package id.novian.test_sentuh_part_2.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.novian.test_sentuh_part_2.databinding.ItemJokeBinding
import id.novian.test_sentuh_part_2.domain.Jokes

class JokeAdapter: RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Jokes>() {
        override fun areItemsTheSame(oldItem: Jokes, newItem: Jokes): Boolean {
            return oldItem.value == newItem.value
        }

        override fun areContentsTheSame(oldItem: Jokes, newItem: Jokes): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitJokes(jokes: List<Jokes>) = differ.submitList(jokes)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val binding = ItemJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokeViewHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class JokeViewHolder(
        private val binding: ItemJokeBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(joke: Jokes) {
            with(binding) {
                tvJokeValue.text = joke.value
                tvJokeSource.text = joke.url
            }
        }

    }

}