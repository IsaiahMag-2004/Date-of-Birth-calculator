package us.tutorial.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var userSelectedDate : TextView? = null //Created here bc if not the date picker function won't see it | make private so that you cant see this while workig with the UI bc it will crash the program
    private var dateInMin: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker : Button = findViewById(R.id.date_pick_button) //Gives us access to the button in the UI

        buttonDatePicker.setOnClickListener {
            userSelectedDate = findViewById(R.id.selected_date)
            dateInMin = findViewById(R.id.Minutes_till)
            clickDatePicker()
        }

    }
    /**
     * Just as discussed we are creating method for the date picker so the code is organized
     */
    private fun clickDatePicker() {
        val myCalander = Calendar.getInstance()
        val year = myCalander.get(Calendar.YEAR)
        val month = myCalander.get(Calendar.MONTH)
        val day = myCalander.get(Calendar.DAY_OF_MONTH)
        lateinit var dpd: Any

        dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{_, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "$selectedMonth/$selectedDayOfMonth/$selectedYear"
                userSelectedDate?.text = selectedDate
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                theDate?.let {
                    val selectedDateInMinutes = theDate.time/ 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time/ 60000
                        val diffrenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                        dateInMin?.text = diffrenceInMinutes.toString()
                    }
                }
            }, year, month, day) //The class used to get dates in our app
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}