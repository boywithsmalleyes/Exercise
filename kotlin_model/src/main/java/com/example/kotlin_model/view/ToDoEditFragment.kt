package com.example.kotlin_model.view

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.kotlin_model.R
import com.example.kotlin_model.db.DBUtil
import com.example.kotlin_model.model.Todo
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.find
import java.util.*

class ToDoEditFragment : Fragment() {

    var todo: Todo? = null
    var dbUtil: DBUtil? = null

    companion object {

        val TODO_ID_KEY: String = "todo_id_key"

        fun newInstance(id: String): ToDoEditFragment {
            val args: Bundle = Bundle()
            args.putString(TODO_ID_KEY, id)
            val toDoEditFragment: ToDoEditFragment = newInstance()
            toDoEditFragment.arguments = args
            return toDoEditFragment
        }


        fun newInstance(): ToDoEditFragment {
            return ToDoEditFragment()
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dbUtil = DBUtil(context)
        if (arguments != null && arguments!!.containsKey(TODO_ID_KEY)) {
            val todoId = arguments!!.getString(TODO_ID_KEY)
            val cursor = dbUtil?.getDbInstants(context)?.rawQuery("select * from todo where id = $todoId", null)

            if (cursor != null) {
                // 27050
                cursor.moveToFirst()
                todo?.id = cursor.getString(1)
                todo?.title = cursor.getString(2)
                todo?.content = cursor.getString(3)
            }

            val todoTitle = find<EditText>(R.id.todo_title)
            todoTitle.setText(todo?.title)

            val todoContent = find<EditText>(R.id.todo_content)
            todoContent.setText(todo?.content)

            val add = find<Button>(R.id.todo_add)
            add.setText(R.string.save)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            verticalLayout {
                padding = dip(30)
                gravity = Gravity.CENTER
                val title = editText {
                    id = R.id.todo_title
                    hintResource = R.string.title_hint
                    maxLines = 2
                }
                val content = editText {
                    id = R.id.todo_content
                    maxLines = 4
                    hintResource = R.string.content_hint
                }
                button {
                    id = R.id.todo_add
                    textResource = R.string.add_todo
                    textColor = Color.WHITE
                    setBackgroundColor(Color.DKGRAY)
                    onClick { createTodoFrom(title, content) }
                }
            }
        }.view
    }

    private fun createTodoFrom(title: EditText, content: EditText) {

        val todoTitle = title.text
        val todoContent = content.text
        val sql = "insert into todo (id, title, content) values('" + UUID.randomUUID().toString() + "','" + todoTitle + "', '" + todoContent + "')"
        dbUtil?.getDbInstants(context)?.execSQL(sql)
        activity?.supportFragmentManager?.popBackStack()
    }


    override fun onDestroy() {
        dbUtil?.closeDb()
        super.onDestroy()
    }
}
