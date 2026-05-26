package com.novamusic.innertube.pages

import com.novamusic.innertube.models.YTItem
import com.novamusic.innertube.models.filterExplicit
import com.novamusic.innertube.models.filterVideoSongs
import com.novamusic.innertube.models.filterYoutubeShorts

data class BrowseResult(
    val title: String?,
    val items: List<Item>,
) {
    data class Item(
        val title: String?,
        val items: List<YTItem>,
    )

    fun filterExplicit(enabled: Boolean = true) =
        if (enabled) {
            copy(
                items =
                    items.mapNotNull {
                        it.copy(
                            items =
                                it.items
                                    .filterExplicit()
                                    .ifEmpty { return@mapNotNull null },
                        )
                    },
            )
        } else {
            this
        }

    fun filterVideoSongs(disableVideos: Boolean = false) =
        if (disableVideos) {
            copy(
                items =
                    items.mapNotNull {
                        it.copy(
                            items =
                                it.items
                                    .filterVideoSongs(true)
                                    .ifEmpty { return@mapNotNull null },
                        )
                    },
            )
        } else {
            this
        }

    fun filterYoutubeShorts(enabled: Boolean = false) =
        if (enabled) {
            copy(
                items =
                    items.mapNotNull {
                        it.copy(
                            items =
                                it.items
                                    .filterYoutubeShorts(true)
                                    .ifEmpty { return@mapNotNull null },
                        )
                    },
            )
        } else {
            this
        }
}
