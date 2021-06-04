package pl.itto.tapversus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_multi_play.*

class MultiPlayActivity : AppCompatActivity() {
    var player1Point = 0
    var player2Point = 0

    companion object {
        const val WIN_POINT = 25
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_play)
        btn_play1.callBack = {
            player1Point++
            checkResult()
        }
        btn_play2.callBack = {
            player2Point++
            checkResult()
        }
    }

    private fun checkResult() {
        tv_player1_point.text = player1Point.toString()
        tv_player2_point.text = player2Point.toString()
        if (player1Point != player2Point && (player1Point > WIN_POINT || player2Point > WIN_POINT)) {
            btn_play1.callBack = null
            btn_play2.callBack = null
            if (player1Point > player2Point) {
                tv_winner_1.visibility = View.VISIBLE
                tv_winner_2.visibility = View.GONE
            } else {
                tv_winner_2.visibility = View.VISIBLE
                tv_winner_1.visibility = View.GONE
            }
        }
    }
}