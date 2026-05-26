/**
 * Nova Music Project (C) 2026
 * Licensed under GPL-3.0 | Forked from Metrolist
 */

package com.novamusic.app.ui.utils

import androidx.navigation.NavController
import com.novamusic.app.ui.screens.Screens

fun NavController.backToMain() {
    val mainRoutes = Screens.MainScreens.map { it.route }

    while (previousBackStackEntry != null &&
        currentBackStackEntry?.destination?.route !in mainRoutes
    ) {
        popBackStack()
    }
}
