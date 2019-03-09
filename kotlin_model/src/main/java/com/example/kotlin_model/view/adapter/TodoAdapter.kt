package com.example.kotlin_model.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlin_model.R
import com.example.kotlin_model.model.Todo

/**
 * @author wangxu
 * @date 2019/3/8
 */
class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    var data: List<Todo> = emptyList()

    var clickListener: TodoItemClickListener? = null


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_todo, null, false))
    }


    override fun getItemCount(): Int {
        return data.size
    }


    fun getItem(position: Int): Todo {
        return data[position]
    }

    override fun onBindViewHolder(holder: TodoViewHolder, positon: Int) {
        holder.bindView(getItem(positon))
    }

    interface TodoItemClickListener {
        fun onCLick(caller: View, todo: Todo)
    }


    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View?) {
            clickListener?.onCLick(v!!, getItem(v.tag as Int))
        }

        @BindView(R.id.tv_todo_title)
        lateinit var todoTitle: TextView
        @BindView(R.id.tv_todo_content)
        lateinit var todoContent: TextView


        init {
            ButterKnife.bind(this, itemView)
            itemView.setOnClickListener(this)
        }

        fun bindView(todo: Todo) {
            todoTitle.text = todo.title
            todoContent.text = todo.content
        }
    }
}


