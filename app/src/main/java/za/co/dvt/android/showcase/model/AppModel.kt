package za.co.dvt.android.showcase.model

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */

data class AppModel(var id: String = "", var name: String = "", var shortDescription: String = "",
                    var enabled: Boolean = false, var iconUrl: String = "",
                    var functionality: String = "", var technologyUsed: String = "",
                    var client: String = "")
