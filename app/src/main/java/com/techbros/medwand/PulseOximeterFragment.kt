package com.techbros.medwand

import android.animation.ValueAnimator
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PulseOximeterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PulseOximeterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_pulse_oximeter, container, false)

        val pulseBtn = view.findViewById<Button>(R.id.btnSave)
        val spo2Val = view.findViewById<EditText>(R.id.spo2)
        val prVal = view.findViewById<EditText>(R.id.pulseRate)

        pulseBtn.setOnClickListener {
            val random = Random.Default
            MainActivity.spO2 = random.nextInt(95, 101)
//            val spo2Editable: Editable =
//                Editable.Factory.getInstance().newEditable(MainActivity.spO2.toString())
//            spo2Val.text = spo2Editable
            val valueAnimator = ValueAnimator.ofInt(0, MainActivity.spO2)
            valueAnimator.duration = 5000
            valueAnimator.addUpdateListener { valueAnimator -> spo2Val.setText(valueAnimator.animatedValue.toString()) }
            valueAnimator.start()

            MainActivity.pulseRate = random.nextInt(60, 121)
//            val prEditable: Editable =
//                Editable.Factory.getInstance().newEditable(MainActivity.pulseRate.toString())
//            prVal.text = prEditable
            //            val prEditable: Editable =
//                Editable.Factory.getInstance().newEditable(MainActivity.diastolic.toString())
//            diastolic.text = prEditable
            val valueAnimator1 = ValueAnimator.ofInt(0, MainActivity.pulseRate)
            valueAnimator1.duration = 5000
            valueAnimator1.addUpdateListener { valueAnimator -> prVal.setText(valueAnimator.animatedValue.toString()) }
            valueAnimator1.start()
        }

        return  view    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PulseOximeterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PulseOximeterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}