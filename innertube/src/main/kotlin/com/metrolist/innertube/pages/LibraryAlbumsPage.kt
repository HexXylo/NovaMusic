package com.novamusic.innertube.pages

import com.novamusic.innertube.models.Album
import com.novamusic.innertube.models.AlbumItem
import com.novamusic.innertube.models.Artist
import com.novamusic.innertube.models.ArtistItem
import com.novamusic.innertube.models.MusicResponsiveListItemRenderer
import com.novamusic.innertube.models.MusicTwoRowItemRenderer
import com.novamusic.innertube.models.PlaylistItem
import com.novamusic.innertube.models.SongItem
import com.novamusic.innertube.models.YTItem
import com.novamusic.innertube.models.oddElements
import com.novamusic.innertube.utils.parseTime

data class LibraryAlbumsPage(
    val albums: List<AlbumItem>,
    val continuation: String?,
) {
    companion object {
        fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): AlbumItem? {
            return AlbumItem(
                        browseId = renderer.navigationEndpoint.browseEndpoint?.browseId ?: return null,
                        playlistId = renderer.thumbnailOverlay?.musicItemThumbnailOverlayRenderer?.content
                            ?.musicPlayButtonRenderer?.playNavigationEndpoint
                            ?.watchPlaylistEndpoint?.playlistId ?: return null,
                        title = renderer.title.runs?.firstOrNull()?.text ?: return null,
                        artists = null,
                        year = renderer.subtitle?.runs?.lastOrNull()?.text?.toIntOrNull(),
                        thumbnail = renderer.thumbnailRenderer.musicThumbnailRenderer?.getThumbnailUrl() ?: return null,
                        explicit = renderer.subtitleBadges?.find {
                            it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
                        } != null
                    )
        }
    }
}
