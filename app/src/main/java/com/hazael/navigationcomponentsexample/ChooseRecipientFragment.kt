package com.hazael.navigationcomponentsexample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation


class ChooseRecipientFragment : Fragment(), View.OnClickListener {

	private var navController: NavController? = null

	private lateinit var input_recipient: EditText

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		// Initializing navigation controller.
		navController = Navigation.findNavController(view)

		// Setting click listeners.
		view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
		view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)

		// Initialize edit text.
		input_recipient = view.findViewById(R.id.input_recipient)
	}

	override fun onClick(v: View?) {
		when (v?.id) {
			R.id.next_btn -> {
				val text = input_recipient.text.toString()
				if (!TextUtils.isEmpty(text)) {
					navController?.navigate(
						R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
						bundleOf("recipient" to text)
					)
				}
			}
			R.id.cancel_btn -> activity?.onBackPressed()
		}
	}
}