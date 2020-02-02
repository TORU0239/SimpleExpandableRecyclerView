package sg.toru.simpleexpandablerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val itemList:List<ExpandableModel>):RecyclerView.Adapter<MovieViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_expandable, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {
        val item = itemList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            item.expanded = !item.expanded
            notifyItemChanged(position)
        }
    }
}


class MovieViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val titleTxt = view.findViewById<TextView>(R.id.item_title)
    private val subItemView = view.findViewById<LinearLayout>(R.id.sub_item)
    private val subItemGenreTxt = view.findViewById<TextView>(R.id.sub_item_genre)
    private val subItemYearTxt = view.findViewById<TextView>(R.id.sub_item_year)

    fun bind(model:ExpandableModel){
        subItemView.visibility = if(model.expanded){
            View.VISIBLE
        }
        else{
            View.GONE
        }

        titleTxt.text = model.movieName
        subItemGenreTxt.text = model.movieGenre
        subItemYearTxt.text = model.directorName
    }
}