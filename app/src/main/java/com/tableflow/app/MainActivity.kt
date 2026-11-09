package com.tableflow.app


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tableflow.app.ui.theme.TableFlowTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            TableFlowTheme {
                Scaffold { innerPadding ->
                    MenuScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}