import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.databinding.ItemRecyclerviewBinding

class BaseballAdapter(val countList: ArrayList<Count>) :
    RecyclerView.Adapter<BaseballAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseballAdapter.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.ballCount.text = countList[position].ballCount
        holder.strikeCount.text = countList[position].strikeCount
    }

    override fun getItemCount(): Int {
        return countList.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){
        val strikeCount = binding.strikeCount
        val ballCount = binding.ballCount
    }
}
