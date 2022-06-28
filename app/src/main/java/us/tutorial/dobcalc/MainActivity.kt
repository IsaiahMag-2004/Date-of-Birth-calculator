package us.tutorial.dobcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker : Button = findViewById(R.id.date_pick_button) //Gives us access to the button in the UI

        buttonDatePicker.setOnClickListener {
            Toast.makeText(this, "button date picker pressed", Toast.LENGTH_LONG).show()
        }

    }
}