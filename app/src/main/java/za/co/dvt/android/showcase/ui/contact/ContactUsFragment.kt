package za.co.dvt.android.showcase.ui.contact


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import za.co.dvt.android.showcase.R

class ContactUsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_contact, container, false)
        return view
    }

    companion object {

        fun newInstance(): ContactUsFragment {
            val args = Bundle()

            val fragment = ContactUsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
