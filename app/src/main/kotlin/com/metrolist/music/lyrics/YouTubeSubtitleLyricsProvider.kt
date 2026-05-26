/**
 * Nova Music Project (C) 2026
 * Licensed under GPL-3.0 | Forked from Metrolist
 */

package com.novamusic.app.lyrics

import android.content.Context
import com.novamusic.innertube.YouTube

object YouTubeSubtitleLyricsProvider : LyricsProvider {
    override val name = "YouTube Subtitle"

    override fun isEnabled(context: Context) = true

    override suspend fun getLyrics(
        context: Context,
        id: String,
        title: String,
        artist: String,
        duration: Int,
        album: String?,
    ): Result<String> = YouTube.transcript(id)
}
