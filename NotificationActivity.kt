package com.example.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.SwitchPreference
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mynews.Fragments_Notification.JobSchedulerFragment
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener, JobSchedulerFragment.onJobSchedulerFragmentSelected {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_notification_activity)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


    }
    override fun onJobSchedulerFragmentSelected(jobSchedulerFragment: JobSchedulerFragment) {
        Toast.makeText(this, "Hey, you selected !", Toast.LENGTH_SHORT).show()
    }
}
