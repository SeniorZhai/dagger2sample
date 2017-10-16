package com.seniorzhai.dagger2sample.model

import java.io.Serializable
import java.util.*

/**
 * Created by zhai on 16/5/23.
 */

class Gank : Serializable {
    protected var id: Long = 0
    var objectId: String? = null

    var used: Boolean = false
    var type: String? = null
    var url: String? = null
    var who: String? = null
    var desc: String? = null
    var updatedAt: Date? = null
    var createdAt: Date? = null
    var publishedAt: Date? = null

    val is妹子: Boolean
        get() = "福利" == type
}
