/*
Загрузите, распакуйте и импортируйте проект Android-приложения по ссылке

Интерфейс содержит следующие элементы:

EditText  (id number) - конвертируемое число.
EditText   (id systemOfCalculus) - система исчисления в которую переводим число.
TextView (id convertResult) - результат конвертации.
Button      (id convertButton) - кнопка для конвертации.
Пользователь вводит целое число для конвертации и систему исчисления, в которую хочет перевести введенное число.

Далее нажимается кнопка convertButton и в поле convertResult появляется результат конвертации.

Если в процессе конвертации происходит ошибка в поле convertResult выводится "Error".
*/

package com.example.company.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number: EditText = findViewById(R.id.number)
        val system: EditText = findViewById(R.id.systemOfCalculus)
        val result: TextView = findViewById(R.id.convertResult)
        val button: Button = findViewById(R.id.convertButton)

        button.setOnClickListener {
            val numberInt = number.text.toString().toIntOrNull()
            val systemInt = system.text.toString().toIntOrNull()

            try {
                if (numberInt != null && systemInt !=null && systemInt in 2..36) {
                    result.text =
                        numberInt.toString(systemInt)
                }
                else {
                    result.text = "Error"
                }
            } catch (e: Exception) {
                result.text = "Error"
            }
        }
        number.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                number.setText("")
            }
        }
        system.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                system.setText("")
            }
        }
    }
}
