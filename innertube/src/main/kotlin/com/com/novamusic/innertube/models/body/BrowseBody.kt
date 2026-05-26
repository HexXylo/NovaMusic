package com.novamusic.innertube.models.body

import com.novamusic.innertube.models.Context
import com.novamusic.innertube.models.Continuation
import kotlinx.serialization.Serializable

@Serializable
data class BrowseBody(
    val context: Context,
    val browseId: String?,
    val params: String?,
    val continuation: String?
)
