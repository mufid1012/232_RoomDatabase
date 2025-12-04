package com.example.roomdb.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavType
import androidx.navigation.navArgument

import com.example.roomdb.view.route.DestinasiHome
import com.example.roomdb.view.route.DestinasiEntry
import com.example.roomdb.view.route.DestinasiDetailSiswa
import com.example.roomdb.view.route.DestinasiEditSiswa

import com.example.roomdb.view.HomeScreen
import com.example.roomdb.view.uicontroller.EntrySiswaScreen
import com.example.roomdb.view.DetailSiswaScreen
import com.example.roomdb.view.EditSiswaScreen

@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(
        navController = navController,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {

        // HOME
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                navigateToItemDetail = { id ->
                    navController.navigate(DestinasiDetailSiswa.buatRouteDenganId(id))
                }
            )
        }

        // ENTRY
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        // DETAIL
        composable(
            route = "${DestinasiDetailSiswa.route}/{${DestinasiDetailSiswa.itemIdArg}}",
            arguments = listOf(
                navArgument(DestinasiDetailSiswa.itemIdArg) { type = NavType.IntType }
            )
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate(DestinasiEditSiswa.buatRouteDenganId(id))
                },
                navigateBack = { navController.popBackStack() }
            )
        }

        // EDIT ← INI YANG BELUM ADA DAN WAJIB!
        composable(
            route = "${DestinasiEditSiswa.route}/{${DestinasiEditSiswa.itemIdArg}}",
            arguments = listOf(
                navArgument(DestinasiEditSiswa.itemIdArg) { type = NavType.IntType }
            )
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.popBackStack() }
            )
        }
    }
}
