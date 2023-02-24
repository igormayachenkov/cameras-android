package ru.igormayachenkov.eprotection_cameras

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.eprotection_cameras.user.LoginPage
import ru.igormayachenkov.eprotection_cameras.workspace.WorkspacePage

@Composable
fun AppScreen(){
    val viewModel:AppViewModel = viewModel()
    when(viewModel.page){
        AppPage.WORKSPACE -> WorkspacePage()
        AppPage.LOGIN -> LoginPage()
        AppPage.WORK -> WorkPage()
    }
}