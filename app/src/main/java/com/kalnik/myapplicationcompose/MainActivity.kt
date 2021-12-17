package com.kalnik.myapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.kalnik.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onOpenDialogClicked()

        setContent {
            val showDialogState: Boolean by viewModel.showDialog.collectAsState()

            MyApplicationComposeTheme {
                SimpleAlertDialog(
                    show = showDialogState,
                    onDismiss = viewModel::onDialogDismiss,
                    onConfirm = viewModel::onDialogConfirm
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationComposeTheme {
        Greeting("Android")
    }
}