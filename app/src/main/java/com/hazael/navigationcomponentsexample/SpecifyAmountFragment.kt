package com.hazael.navigationcomponentsexample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hazael.navigationcomponentsexample.databinding.FragmentSpecifyAmountBinding
import java.math.BigDecimal


/**
 * A simple [Fragment] subclass.
 * Use the [SpecifyAmountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecifyAmountFragment : Fragment(), View.OnClickListener {

	private lateinit var binding: FragmentSpecifyAmountBinding
	private lateinit var navController: NavController
	private lateinit var recipient: String

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		recipient = requireArguments().getString("recipient")!!
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)

		// Inflate the layout for this fragment
		return binding.root
	}


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		// Initializing navigation controller.
		navController = Navigation.findNavController(view)

		// Setting click listeners.
		view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
		view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)

		val message = "Sending money to $recipient"
		view.findViewById<TextView>(R.id.recipient).text = message
	}

	override fun onClick(v: View?) {
		when (v?.id) {
			R.id.send_btn -> {
				val text = binding.inputAmount.text.toString()
				if (!TextUtils.isEmpty(text)) {
					navController.navigate(
						R.id.action_specifyAmountFragment_to_confirmationFragment,
						bundleOf(
							"recipient" to recipient,
							"amount" to Money(BigDecimal(text))))
				} else {
					Toast.makeText(activity, "Enter an amount!", Toast.LENGTH_SHORT).show()
				}
			}
			R.id.cancel_btn -> activity?.onBackPressed()
		}
	}

}