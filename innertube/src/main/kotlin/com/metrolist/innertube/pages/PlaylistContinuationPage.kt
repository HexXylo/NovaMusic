package com.novamusic.innertube.pages

import com.novamusic.innertube.models.SongItem

data class PlaylistContinuationPage(
    val songs: List<SongItem>,
    val continuation: String?,
)
