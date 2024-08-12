package es.tipolisto.breeds.ui.components

import android.app.Dialog
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.tipolisto.breeds.R
import es.tipolisto.breeds.ui.navigation.AppScreens



fun onBackPressed(onDismiss:()->Unit,navController: NavController, context: Context) {
    //quizListener.playButton("click")
    val builder= android.app.AlertDialog.Builder (context)
    builder.setTitle(context.getString(R.string.breeds_says))
    builder.setMessage(context.getString(R.string.are_you_sure_you_want_to_go_out))
    builder.setPositiveButton("Yes") { dialog, id ->
        dialog.cancel()
        onDismiss()
        navController.popBackStack()
        navController.navigate(AppScreens.MenuScreen.route)
    }
    val dialog: Dialog = builder.create()
    dialog.show()
}

@Composable
fun MyAlertDialogNewRecord(show:Boolean, onDismiss:()->Unit, onConfirm:(name:String)->Unit){
    var name by remember {mutableStateOf("")}
    AlertDialog(
        onDismissRequest = {onDismiss()},
        confirmButton = {
            TextButton(onClick ={onConfirm(name)}){
                Column {
                    TextField(value = name, onValueChange = {name=it},placeholder = { Text(text="Name") })
                    Text(
                        text = stringResource(R.string.create_new_record),
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .background(Color.Blue),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        },
        dismissButton = {
            TextButton(onClick ={onDismiss()}){
                Text(text = "Cancel")
            }
        },
        title = { Text(text = stringResource(R.string.congratulations)) },
        text = { Text(text = stringResource(R.string.you_have_achieved_a_new_record))},
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyAlertDialogNewRecordPreview(){
    MyAlertDialogNewRecord(true,{},{})
}
@Composable
fun MyAlertDialogNotInternet(shouldShowDialog: MutableState<Boolean>) {
    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = stringResource(R.string.please_wait)) },
            text = { Text(text = stringResource(R.string.no_internet_connection) ) },
            confirmButton = {}
        )
    }
}





