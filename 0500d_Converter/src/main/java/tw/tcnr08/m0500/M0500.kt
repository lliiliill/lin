package tw.tcnr08.m0500

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class M0500 : AppCompatActivity() {
    private var e001: EditText? = null
    private var b001: Button? = null
    private var t003: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m0500) //抓取LAYOUT的XML
        setupViewComponent()
    }

    private fun setupViewComponent() {
        // 設定LAYOUT的配置
        e001 = findViewById<View>(R.id.m0500_e001) as EditText //輸入公斤
        b001 = findViewById<View>(R.id.m0500_b001) as Button //執行程式
        t003 = findViewById<View>(R.id.m0500_t003) as TextView //輸出磅
        b001!!.setOnClickListener(b001On) //宣告按鈕的監聽程式
    }

    private val b001On = View.OnClickListener {
        val lbFormat = DecimalFormat(".0000") //顯示到小數點後四位補0
        val outputNum = lbFormat.format(e001!!.text.toString().toFloat() * 2.20462262) //公斤轉磅
        t003!!.text = outputNum
    }
}