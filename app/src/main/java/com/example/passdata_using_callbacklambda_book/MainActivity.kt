package com.example.passdata_using_callbacklambda_book

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passdata_using_callbacklambda_book.AVH.ActionBook
import com.example.passdata_using_callbacklambda_book.AVH.BookAdapter
import com.example.passdata_using_callbacklambda_book.VM.BookVM
import com.example.passdata_using_callbacklambda_book.databinding.ActivityMainBinding
import com.example.passdata_using_callbacklambda_book.modle.Book
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm: BookVM by viewModels()
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  إنشاء adapter
        adapter = BookAdapter()

        //  استقبال الأحداث من الـ adapter
        adapter.setOnBookAction { book, actionBook ->
            when (actionBook) {
                ActionBook.EDIT -> openDialog(book)
                ActionBook.DELETE -> vm.remove(book.id)
            }
        }

        //  زر إضافة كتاب جديد
        binding.btnNewTaskId.setOnClickListener {
            openDialog(null) // تمرير null لإضافة جديدة
        }

        //  ربط الـ RecyclerView
        binding.todoListRecyclerViewActMainId.adapter = adapter
        binding.todoListRecyclerViewActMainId.layoutManager = LinearLayoutManager(this)

        //  ملاحظة البيانات القادمة من الـ ViewModel
        vm.bookAll.observe(this) {
            adapter.submitList(it)
        }
        vm.fetchAllBook()
    }

    //  دالة فتح الـ Dialog
    private fun openDialog(book: Book?) {
        val dialog = Frag_dialog_EditAdd()
        dialog.setBookData(book)
        dialog.setOnSaveClickListener { newBook ->
            if (book == null) {
                vm.addNewBook(newBook)
            } else {
                vm.update(newBook.id, newBook)
            }
        }
        dialog.show(supportFragmentManager, "BookDialog")
    }
}
