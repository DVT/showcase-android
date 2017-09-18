package za.co.dvt.android.showcase.ui.contact


import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ShowcaseApplication
import za.co.dvt.android.showcase.injection.ShowcaseFactory
import za.co.dvt.android.showcase.model.Office

class ContactUsFragment : LifecycleFragment(), OfficeItemNavigator {


    lateinit var contactUsViewModel: ContactUsViewModel
    lateinit var adapter: OfficeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
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
        } //todo unsubscribe

        contactUsViewModel.openCall.observe(this, Observer { office ->
            office?.let {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + office.telephone)))
            }
        })

        contactUsViewModel.openEmail.observe(this, Observer { office ->
            office?.let {
                office.emailAddress?.let {
                    composeEmail(it, getString(R.string.email_subject_default))
                }
            }
        })

        contactUsViewModel.openNavigate.observe(this, Observer { office ->
            office?.let {
                startActivity(Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/dir/?api=1&destination_place_id="
                                + office.googleMapsPlaceId
                                + "&destination=" + office.googleMapsName)))
            }
        })
    }

    fun composeEmail(addresses: String, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayListOf(addresses))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        if (intent.resolveActivity(activity.packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_offices)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adapter = OfficeAdapter(listOf(), this)
        recyclerView.adapter = adapter

    }

    override fun email(office: Office) {
        contactUsViewModel.openEmail(office)
    }

    override fun call(office: Office) {
        contactUsViewModel.openCall(office)
    }

    override fun navigate(office: Office) {
        contactUsViewModel.openNavigation(office)
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
