// Косенко Кароліна, ІМ-23
// Варіант завдання 14, варіант у списку 82
package com.example.android1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerBooks: Spinner = findViewById(R.id.spinnerBooks)
        val radioGroupYears: RadioGroup = findViewById(R.id.radioGroupYears)
        val buttonOk: Button = findViewById(R.id.buttonOk)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        val books = arrayOf("Володар перснів", "Гаррі Поттер і келих вогню", "Маг", "Нічна Варта")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, books)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBooks.adapter = adapter

        buttonOk.setOnClickListener {
            val selectedBook = spinnerBooks.selectedItem.toString()
            val selectedYearId = radioGroupYears.checkedRadioButtonId

            if (selectedBook.isEmpty() || selectedYearId == -1) {
                Toast.makeText(this, "Будь ласка, введіть усі дані!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedYear = findViewById<RadioButton>(selectedYearId).text.toString()
            textViewResult.text = "Ви обрали: $selectedBook ($selectedYear)"
        }
    }
}