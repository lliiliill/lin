package tw.tcnr08.m0501

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity

class M0501 : AppCompatActivity() {
    private var e001: EditText? = null
    private var s001: Spinner? = null
    private var f000: TextView? = null
    private var b001: Button? = null
    private var sSex: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m0501)
        setupViewComponent()
    }

    private fun setupViewComponent() {
        e001 = findViewById<View>(R.id.m0501_e001) as EditText
        s001 = findViewById(R.id.m0501_s001) as Spinner
        b001 = findViewById(R.id.m0501_b001) as Button
        f000 = findViewById<View>(R.id.m0501_f000) as TextView

        //設定spinner item選項
        val adapSexList = ArrayAdapter.createFromResource(
            this,
            R.array.m0501_a001,
            android.R.layout.simple_spinner_item
        ) //設定spinner樣式(還沒按時)
        adapSexList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) //設定spinner樣式(按下時)
        s001!!.adapter = adapSexList
        s001!!.onItemSelectedListener = s001On
        //-----------------------------------------------------------------------------------------------------------------------------
        b001!!.setOnClickListener(b001On)
    }

    private val s001On: OnItemSelectedListener = object : OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            sSex = parent.selectedItem.toString()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
    private val b001On = View.OnClickListener {
        var strSug = getString(R.string.m0501_f000)
        if (e001!!.text.toString().trim { it <= ' ' }.length != 0) {
            val iAge = e001!!.text.toString().toInt()
            strSug += if (sSex == getString(R.string.chk)) { //男生
                if (iAge < 28) {
                    getString(R.string.m0501_f001)
                } else if (iAge > 33) {
                    getString(R.string.m0501_f003)
                } else {
                    getString(R.string.m0501_f002)
                }
            } else { //女生
                if (iAge < 25) {
                    getString(R.string.m0501_f001)
                } else if (iAge > 30) {
                    getString(R.string.m0501_f003)
                } else {
                    getString(R.string.m0501_f002)
                }
            }
            f000!!.text = strSug
        } else f000!!.text = "請勿輸入空白"
    }
}