package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                       dice_roller_app()
                }
            }
        }
    }


@Preview
@Composable
fun dice_roller_app(){
   Dicewithimageandbutton(modifier = Modifier
       .fillMaxSize()
       .wrapContentSize(Alignment.Center))
}
//ui and backend work
@Composable
fun Dicewithimageandbutton(modifier: Modifier = Modifier){

    var result by remember {
        mutableStateOf(1)

    }
    val imageResource = when(result){
        1 -> R.drawable.dice_1__1_
        2 -> R.drawable.dice_1__2_
        3 -> R.drawable.dice_1__3_
        4 -> R.drawable.dice_1__4_
        5 -> R.drawable.dice_1__5_
        else -> R.drawable.dice_1__6_

    }



  Column(
      modifier = Modifier,
      horizontalAlignment = Alignment.CenterHorizontally
  ) {
      Image(painter = painterResource(imageResource) ,contentDescription = "result.toString()")

      Spacer(modifier = Modifier.height(16.dp))

      Button(onClick =  { result = (1..6).random()}){
         Text(text = stringResource(R.string.roll), fontSize = 24.sp)
      }
  }
}

