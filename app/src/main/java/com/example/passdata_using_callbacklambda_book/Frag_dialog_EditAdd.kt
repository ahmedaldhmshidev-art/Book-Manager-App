package com.example.passdata_using_callbacklambda_book

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.passdata_using_callbacklambda_book.databinding.FragmentFragDialogEditAddBinding
import com.example.passdata_using_callbacklambda_book.modle.Book
import java.util.UUID
class Frag_dialog_EditAdd : DialogFragment() {

    private lateinit var binding: FragmentFragDialogEditAddBinding

    private var book: Book? = null
    var onSave: ((Book) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentFragDialogEditAddBinding.inflate(layoutInflater)

        //  لو الكتاب موجود (يعني تعديل)
        book?.let {
            binding.titleFragEditId.setText(it.title)
            binding.contentFragEditId.setText(it.content)
            binding.authorFragEditId.setText(it.author)
            binding.saveFragEditId.text = "Update"
        }

        //  زر الحفظ
        binding.saveFragEditId.setOnClickListener {
            val title = binding.titleFragEditId.text.toString().trim()
            val content = binding.contentFragEditId.text.toString().trim()
            val author = binding.authorFragEditId.text.toString().trim()

            if (title.isEmpty() || content.isEmpty() || author.isEmpty())
                return@setOnClickListener

            val newBook = Book(
                id = book?.id ?: UUID.randomUUID().toString(),
                title = title,
                content = content,
                author = author,
                releaseAt = System.currentTimeMillis()
            )

            //  استدعاء lambda
            Log.d("BookDialog", "Book to save: $newBook , book was null? ${book == null}")
            onSave?.invoke(newBook)
            dismiss()
        }

        //  إنشاء الـ Dialog وعرض التصميم
        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()
    }

    //  تمرير الكتاب من الخارج
    fun setBookData(book: Book?) {
        this.book = book
    }

    //  تمرير lambda من الخارج-
    fun setOnSaveClickListener(listener: (Book) -> Unit) {
        onSave = listener
    }
}



