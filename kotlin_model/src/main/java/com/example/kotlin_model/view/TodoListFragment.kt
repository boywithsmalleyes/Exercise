package com.example.kotlin_model.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_model.R
import com.example.kotlin_model.db.DBUtil
import com.example.kotlin_model.model.Todo
import com.example.kotlin_model.view.adapter.TodoAdapter

/**
 * @author wangxu
 * @date 2019/3/8
 */
class TodoListFragment : Fragment(), TodoAdapter.TodoItemClickListener {
    override fun onCLick(caller: View, todo: Todo) {
        (activity as MainActivity).hindFab()
        val toDoEditFragment = ToDoEditFragment.newInstance(todo.id)

        (activity as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.content_main, toDoEditFragment, toDoEditFragment.javaClass.simpleName)
                .addToBackStack(toDoEditFragment.javaClass.simpleName)
                .commit()
    }


    lateinit var rvTodolist: RecyclerView

    var dbUtil: DBUtil? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dbUtil = DBUtil(activity)
        val rootView = inflater.inflate(R.layout.fragment_todos, null)
        rvTodolist = rootView.findViewById(R.id.rv_todo_list)
        rvTodolist.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        return rootView
    }

    override fun onResume() {
        super.onResume()
        val adapterTodoList = TodoAdapter()
        val sql = "select * from todo"
        val cursor = dbUtil?.getDbInstants(activity)?.rawQuery(sql, null)

        val list = arrayListOf<Todo>()

        while (cursor?.moveToNext()!!) {
            val todo = Todo()
            todo.id = cursor.getString(0)
            todo.title = cursor.getString(1)
            todo.content = cursor.getString(2)
            list.add(todo)
        }
        cursor.close()

        // 设置 adapter
        rvTodolist.adapter = adapterTodoList
        adapterTodoList.data = list
        adapterTodoList.notifyDataSetChanged()

    }

}