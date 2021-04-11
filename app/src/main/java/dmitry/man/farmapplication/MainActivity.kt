package dmitry.man.farmapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),
    StartFragmentClickListener {

    private var savedSettingsStart: SharedPreferences? = null
    private val PREFS_FILE = "Account"
    private val PREF_OPERATOR = "Operator"
    private val PREF_CUSTOMER = "Customer"
    private val PREF_FARM = "Farm"
    private val PREF_FIELD = "Field"
    private var mainIdOperator: Int = 0
    private var mainIdCustomer: Int = 0
    private var mainIdFarm: Int = 0
    private var mainIdField: Int = 0
    private var prefEditor: SharedPreferences.Editor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedSettingsStart = getSharedPreferences(PREFS_FILE, MODE_PRIVATE)
        getSettings()

        supportFragmentManager.beginTransaction()
            .add(
                R.id.container_activity_main,
                StartFragment.newInstance(mainIdOperator, mainIdCustomer, mainIdFarm, mainIdField)
            )
            .commit()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun save(idOperator: Int, idCustomer: Int, idFarm: Int, idField: Int) {
        prefEditor = savedSettingsStart!!.edit()
        prefEditor?.putInt(PREF_OPERATOR, idOperator)
        prefEditor?.putInt(PREF_CUSTOMER, idCustomer)
        prefEditor?.putInt(PREF_FARM, idFarm)
        prefEditor?.putInt(PREF_FIELD, idField)
        prefEditor?.apply()

        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }

    fun getSettings() {
        mainIdOperator = savedSettingsStart?.getInt(PREF_OPERATOR, 0) ?: 0
        mainIdCustomer = savedSettingsStart?.getInt(PREF_CUSTOMER, 0) ?: 0
        mainIdFarm = savedSettingsStart?.getInt(PREF_FARM, 0) ?: 0
        mainIdField = savedSettingsStart?.getInt(PREF_FIELD, 0) ?: 0
    }
}
