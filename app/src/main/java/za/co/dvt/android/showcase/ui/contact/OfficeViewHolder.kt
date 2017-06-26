package za.co.dvt.android.showcase.ui.contact

import android.support.v7.widget.RecyclerView
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import za.co.dvt.android.showcase.databinding.ListItemOfficeBinding
import za.co.dvt.android.showcase.model.Office


/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */
class OfficeViewHolder(view: View, val binding: ListItemOfficeBinding) : RecyclerView.ViewHolder(view), OnMapReadyCallback {

    var map: GoogleMap? = null

    fun bind(office: Office) {
        binding.office = office
        binding.executePendingBindings()
        val namedLocation = NamedLocation(office.name, LatLng(office.latitude, office.longitude))
        binding.mapView.tag = namedLocation
        setMapLocation(namedLocation)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val context = itemView?.context
        MapsInitializer.initialize(context)
        map = googleMap
        val data = binding.mapView.tag as NamedLocation

        setMapLocation(data)

    }

    private fun setMapLocation(data: NamedLocation) {
        map?.let {
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(data.location, 15f))
            it.addMarker(MarkerOptions().position(data.location))

            it.mapType = GoogleMap.MAP_TYPE_NORMAL
        }

    }

    fun initializeMapView() {
        binding.mapView.onCreate(null)
        binding.mapView.getMapAsync(this)

    }

}

data class NamedLocation(val name: String, val location: LatLng)