import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.RecyclerView.BaseballViewHolder
import com.example.baseball.databinding.ItemRecyclerviewBinding

class BaseballAdapter(private val counts: List<Count> = mutableListOf()) :
    RecyclerView.Adapter<BaseballViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseballViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseballViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseballViewHolder, position: Int) {
        holder.bind(counts[position])
    }

    override fun getItemCount(): Int {
        return counts.size
    }
}
