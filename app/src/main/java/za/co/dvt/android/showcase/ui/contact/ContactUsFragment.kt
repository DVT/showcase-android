package za.co.dvt.android.showcase.ui.contact


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import za.co.dvt.android.showcase.ShowcaseApplication
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.injection.ShowcaseFactory
import za.co.dvt.android.showcase.model.Office

class ContactUsFragment : Fragment() {

    lateinit var contactUsViewModel: ContactUsViewModel
    lateinit var adapter: OfficeAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_contact, container, false)
        setupRecyclerView(view)
        setupViewModel()
        return view
    }

    private fun setupViewModel() {
        contactUsViewModel = ViewModelProviders.of(this,
                ShowcaseFactory(activity.application as ShowcaseApplication))
                .get(ContactUsViewModel::class.java)
        contactUsViewModel.getOffices().subscribe { offices: List<Office>? ->
            offices?.let {
                adapter.setItems(it)
            }
        }
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById(R.id.recycler_view_offices) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adapter = OfficeAdapter(listOf())
        recyclerView.adapter = adapter

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
