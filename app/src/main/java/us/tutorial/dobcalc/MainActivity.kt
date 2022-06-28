package us.tutorial.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker : Button = findViewById(R.id.date_pick_button) //Gives us access to the button in the UI

        buttonDatePicker.setOnClickListener {
            clickDatePicker()
        }

    }
    /**
     * Just as discussed we are creating method for the date picker so the code is organized
     */
    fun clickDatePicker() {
        val myCalander = Calendar.getInstance()
        val year = myCalander.get(Calendar.YEAR)
        val month = myCalander.get(Calendar.MONTH)
        val day = myCalander.get(Calendar.DAY_OF_MONTH)

        //With the .OnDateSetListener stuff we are basicly using a lamda expression to get 4 parameters all filled with the data the user gives us but we will explain more in future
        //Anything you put after the -> will be run
        //The Toast will only run when you click ok after choosing a date
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth -> Toast.makeText(this, "Date Picker works", Toast.LENGTH_LONG).show()},
            year,
            month,
            day
        ).show() //The class used to get dates in our app
    }
}