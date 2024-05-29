import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.RecyclerView.BaseballViewHolder
import com.example.baseball.databinding.ItemRecyclerviewBinding

class BaseballAdapter(
    baseballCountUiModels: List<BaseballCountUiModel> = mutableListOf()
) : RecyclerView.Adapter<BaseballViewHolder>() {

    private val _baseballCountUiModels = baseballCountUiModels.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseballViewHolder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseballViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseballViewHolder, position: Int) {
        holder.bind(_baseballCountUiModels[position])
    }

    override fun getItemCount(): Int = _baseballCountUiModels.size

    fun submitList(baseballCountUiModels: List<BaseballCountUiModel>) {
        _baseballCountUiModels.clear()
        _baseballCountUiModels.addAll(baseballCountUiModels)
        notifyDataSetChanged()
    }
}
