package com.example.mynews.Fragments_Search


import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mynews.R
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CalendarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // 1) Calendar
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)


        // 2) Listener on the ImageView Begin
        date_begin_picker_button.setOnClickListener{
            val datebegin = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                // set to TextView
                selected_date.setText("" + mDay + "/" + mMonth + "/" + mYear)
            }, year, month, day)
            //show dialog
            datebegin.show()
        }

        // 2) Listener on the ImageView End
        date_end_picker_button.setOnClickListener{
            val dateEnd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                // set to TextView
                selected_end_date.setText("" + mDay + "/" + mMonth + "/" + mYear)
            }, year, month, day)
            //show dialog
            dateEnd.show()
        }

        super.onViewCreated(view, savedInstanceState)
    }


}
