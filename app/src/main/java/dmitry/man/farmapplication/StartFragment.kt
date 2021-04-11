package dmitry.man.farmapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class StartFragment : Fragment() {
    private var startFragmentClickListener: StartFragmentClickListener? = null
    private var btnSave: Button? = null
    private var radioGroupOperator: RadioGroup? = null
    private var radioGroupCustomer: RadioGroup? = null
    private var radioGroupFarm: RadioGroup? = null
    private var radioGroupField: RadioGroup? = null
    private var idRadioGroupOperator: Int = 0
    private var idRadioGroupCustomer: Int = 0
    private var idRadioGroupFarm: Int = 0
    private var idRadioGroupField: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is StartFragmentClickListener) {
            startFragmentClickListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b: Bundle? = arguments
        idRadioGroupOperator = b?.getInt("Operator", 0) ?: 0
        idRadioGroupCustomer = b?.getInt("Customer", 0) ?: 0
        idRadioGroupFarm = b?.getInt("Farm", 0) ?: 0
        idRadioGroupField = b?.getInt("Field", 0) ?: 0

        when (idRadioGroupOperator) {
            0 -> {
                val nameOperator = view.findViewById<RadioButton>(R.id.r_button_name_of_operator)
                nameOperator.isChecked = true
            }
            1 -> {
                val otherName = view.findViewById<RadioButton>(R.id.r_button_other_name)
                otherName.isChecked = true
            }
            else -> {
            }
        }
        when (idRadioGroupCustomer) {
            0 -> {
                val nameOfCustomer = view.findViewById<RadioButton>(R.id.r_button_name_of_customer)
                nameOfCustomer.isChecked = true
            }
            1 -> {
                val anotherNameOf = view.findViewById<RadioButton>(R.id.r_button_another_name_of)
                anotherNameOf.isChecked = true
            }
            else -> {
            }
        }
        when (idRadioGroupFarm) {
            0 -> {
                val farmName = view.findViewById<RadioButton>(R.id.r_button_farm_name)
                farmName.isChecked = true
            }
            1 -> {
                val nameOfAFarm = view.findViewById<RadioButton>(R.id.r_button_name_of_a_farm)
                nameOfAFarm.isChecked = true
            }
            else -> {
            }
        }
        when (idRadioGroupField) {
            0 -> {
                val fieldName = view.findViewById<RadioButton>(R.id.r_button_field_name)
                fieldName.isChecked = true
            }
            1 -> {
                val nameOfAField = view.findViewById<RadioButton>(R.id.r_button_name_of_a_field)
                nameOfAField.isChecked = true
            }
            2 -> {
                val fieldN1 = view.findViewById<RadioButton>(R.id.r_button_field_n1)
                fieldN1.isChecked = true
            }
            else -> {
            }
        }
        btnSave = view.findViewById(R.id.btn_start_save)
        btnSave?.setOnClickListener {
            startFragmentClickListener?.save(
                idRadioGroupOperator,
                idRadioGroupCustomer,
                idRadioGroupFarm,
                idRadioGroupField
            )
        }
        radioGroupOperator = view.findViewById(R.id.r_group_operator)
        radioGroupOperator?.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.r_button_name_of_operator -> {
                    idRadioGroupOperator = 0
                }
                R.id.r_button_other_name -> {
                    idRadioGroupOperator = 1
                }
                else -> {
                }
            }
        }
        radioGroupCustomer = view.findViewById(R.id.r_group_customer)
        radioGroupCustomer?.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.r_button_name_of_customer -> {
                    idRadioGroupCustomer = 0
                }
                R.id.r_button_another_name_of -> {
                    idRadioGroupCustomer = 1
                }
                else -> {
                }
            }
        }
        radioGroupFarm = view.findViewById(R.id.r_group_farm)
        radioGroupFarm?.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.r_button_farm_name -> {
                    idRadioGroupFarm = 0
                }
                R.id.r_button_name_of_a_farm -> {
                    idRadioGroupFarm = 1
                }
                else -> {
                }
            }
        }
        radioGroupField = view.findViewById(R.id.r_group_field)
        radioGroupField?.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.r_button_field_name -> {
                    idRadioGroupField = 0
                }
                R.id.r_button_name_of_a_field -> {
                    idRadioGroupField = 1
                }
                R.id.r_button_field_n1 -> {
                    idRadioGroupField = 2
                }
                else -> {

                }
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        startFragmentClickListener = null
    }

    companion object {
        fun newInstance(
            idFromMainOperator: Int,
            idFromMainCustomer: Int,
            idFromMainFarm: Int,
            idFromMainField: Int
        ): StartFragment {
            val f = StartFragment()
            val bundleFromMain = Bundle()
            bundleFromMain.putInt("Operator", idFromMainOperator)
            bundleFromMain.putInt("Customer", idFromMainCustomer)
            bundleFromMain.putInt("Farm", idFromMainFarm)
            bundleFromMain.putInt("Field", idFromMainField)
            f.arguments = bundleFromMain
            return f
        }
    }
}

interface StartFragmentClickListener {
    fun save(idOperator: Int, idCustomer: Int, idFarm: Int, idField: Int)
}

