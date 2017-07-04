package za.co.dvt.android.showcase.model

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */

data class AppModel(var id: String? = null, var name: String? = null,
                    var shortDescription: String? = null,
                    var enabled: Boolean = false, var iconUrl: String? = null,
                    var functionality: String? = null, var technologyUsed: String? = null,
                    var client: String? = null){

    fun getFullIconUrl() : StorageReference? {
        if (iconUrl == null){
            return null
        }
        return FirebaseStorage.getInstance().getReference(iconUrl!!)
    }
}

