package za.co.dvt.android.showcase.model


data class Office(val name: String? = null,
                  val telephone: String? = null,
                  val emailAddress: String? = null,
                  val longitude: Double? = null,
                  val latitude: Double? = null,
                  val address: String? = null,
                  val image: String? = null,
                  val googleMapsPlaceId: String? = null,
                  val googleMapsName: String? = null)