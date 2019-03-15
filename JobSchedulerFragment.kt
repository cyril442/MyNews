package com.example.mynews.Fragments_Notification


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import android.widget.ViewSwitcher

import com.example.mynews.R
import java.lang.ClassCastException


private lateinit var listener :JobSchedulerFragment.onJobSchedulerFragmentSelected

class JobSchedulerFragment : Fragment() {

    companion object {
        fun newInstance() = JobSchedulerFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_job_scheduler, container, false)
        return view

    }

    interface onJobSchedulerFragmentSelected {
        fun onJobSchedulerFragmentSelected (jobSchedulerFragment: JobSchedulerFragment)
    }

    override fun onAttach(context: Context?) {

        if(context is onJobSchedulerFragmentSelected ){
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement onJobSchedulerFragmentSelected.")
        }

        super.onAttach(context)
    }

}
