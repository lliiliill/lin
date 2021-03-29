package tw.tcnr08.m0502

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class M0502 : AppCompatActivity() {
    private var f000: TextView? = null
    private var b001: Button? = null
    private var r002a: RadioButton? = null
    private var r002b: RadioButton? = null
    private var r002c: RadioButton? = null
    private var r001: RadioGroup? = null
    private var r002: RadioGroup? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m0502)
        setupViewComponent()
    }

    private fun setupViewComponent() {
//        e001 = (EditText)findViewById(R.id.m0502_e001);
//        s001 = (Spinner) findViewById((R.id.m0502_s001));
        b001 = findViewById<View>(R.id.m0502_b001) as Button
        f000 = findViewById<View>(R.id.m0502_f000) as TextView
        r001 = findViewById<View>(R.id.m0502_r001) as RadioGroup
        r002 = findViewById<View>(R.id.m0502_r002) as RadioGroup
        r002a = findViewById<View>(R.id.m0502_r002a) as RadioButton
        r002b = findViewById<View>(R.id.m0502_r002b) as RadioButton
        r002c = findViewById<View>(R.id.m0502_r002c) as RadioButton

//        //-----------------------------------------------------------------------------------------------------------------------------
        b001!!.setOnClickListener(b001On)
        r001!!.setOnCheckedChangeListener(r001On)
    }

    private val r001On = RadioGroup.OnCheckedChangeListener { group, checkedId ->
        when (checkedId) {
            R.id.m0502_r001a -> {
                //點男
                r002a!!.setText(R.string.m0502_r002aa)
                r002b!!.setText(R.string.m0502_r002ab)
                r002c!!.setText(R.string.m0502_r002ac)
            }
            R.id.m0502_r001b -> {
                //點女
                r002a!!.setText(R.string.m0502_r002ba)
                r002b!!.setText(R.string.m0502_r002bb)
                r002c!!.setText(R.string.m0502_r002bc)
            }
        }
    }
    private val b001On = View.OnClickListener {
        var strSug = getString(R.string.m0502_f000)
        when (r002!!.checkedRadioButtonId) {
            R.id.m0502_r002a -> {
                strSug += getString(R.string.m0502_f001)
            }
            R.id.m0502_r002b -> {
                strSug += getString(R.string.m0502_f002)
            }
            R.id.m0502_r002c -> {
                strSug += getString(R.string.m0502_f003)
            }
        }
        when (r001!!.checkedRadioButtonId) {
            R.id.m0502_r001a -> {
                //男
                strSug += getString(R.string.m0502_f0001)
            }
            R.id.m0502_r001b -> {
                //女
                strSug += getString(R.string.m0502_f0002)
            }
        }
        f000!!.text = strSug
        //            f000.setText("請勿輸入空白");
    }
}