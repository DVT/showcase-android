package za.co.dvt.android.showcase.model

/**
 * @author rebeccafranks
 * @since 2017/06/25.
 */

data class Office(val name: String = "", val telephone: String = "",
                  val emailAddress: String = "", val longitude: Double = 25.0,
                  val latitude: Double = 25.0, val address: String = "",
                  val image: String = "", val googleMapsPlaceId: String = "",
                  val googleMapsName: String = ""
)