package adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcustommultitypeadapter_2inkotlin.R
import model.Member

class CustomAdapter(val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_AVIALABLE_YES = 0
    private val TYPE_AVAILABLE_NO = 1
    private val TYPE_AVAILABLE_BG_COLOR = 2

    override fun getItemCount(): Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (members.get(position).available == 0) {
            TYPE_AVIALABLE_YES
        }else if (members.get(position).available == 2) {
            TYPE_AVAILABLE_BG_COLOR
        }
        else TYPE_AVAILABLE_NO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_AVIALABLE_YES) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_yes,parent,false)
            return CustomViewYesHolder(view)
        }
        if (viewType == TYPE_AVAILABLE_BG_COLOR) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_bg_color,parent,false)
            return CustomViewBgColorHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_not,parent,false)
            return CustomViewNotHolder(view)
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member = members.get(position)

        if (holder is CustomViewYesHolder) {
            holder.first_name.setText(member.first_name.toString())
            holder.last_name.setText(member.last_name.toString())
        }

        if (holder is CustomViewNotHolder) {
            holder.first_name.setText("this firstname is not availabler")
            holder.last_name.setText("this lastname is not available")
        }

        if(holder is CustomViewBgColorHolder) {
            holder.first_name.setText(member.first_name.toString())
            holder.last_name.setText(member.last_name.toString())
        }
    }


    class CustomViewYesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val first_name = itemView.findViewById<TextView>(R.id.first_name)
        val last_name = itemView.findViewById<TextView>(R.id.last_name)
    }
    
    class CustomViewNotHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val first_name = itemView.findViewById<TextView>(R.id.first_name)
        val last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

    class CustomViewBgColorHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val first_name = itemView.findViewById<TextView>(R.id.first_name)
        val last_name = itemView.findViewById<TextView>(R.id.last_name)
    }
}