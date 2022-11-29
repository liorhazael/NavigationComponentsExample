package com.hazael.navigationcomponentsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hazael.navigationcomponentsexample.databinding.FragmentConfirmationBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ConfirmationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfirmationFragment : Fragment() {

	private lateinit var binding: FragmentConfirmationBinding

	private lateinit var recipient: String
	private lateinit var money: Money

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		recipient = requireArguments().getString("recipient")!!
		money = requireArguments().getParcelable<Money>("amount")!!
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		binding = FragmentConfirmationBinding.inflate(layoutInflater, container, false)

		// Inflate the layout for this fragment
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val message = "You have sent ${money.amount} to $recipient"
		binding.confirmationMessage.text = message
	}

}