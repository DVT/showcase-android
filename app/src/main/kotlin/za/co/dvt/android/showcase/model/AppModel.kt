package za.co.dvt.android.showcase.model



data class AppModel(var id: String? = null,
                    var name: String? = null,
                    var shortDescription: String? = null,
                    var enabled: Boolean = false,
                    var iconUrl: String? = null,
                    var functionality: String? = null,
                    var technologyUsed: String? = null,
                    var client: String? = null,
                    var androidPackageName: String? = null,
                    var screenshots: List<String>? = null)

