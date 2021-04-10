package dmitry.man.farmapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class StartFragment : Fragment() {
    private var startFragmentClickListener: StartFragmentClickListener? = null
    private var btnSave: Button? = null

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
        btnSave = view.findViewById<Button>(R.id.btn_start_save)
        btnSave?.setOnClickListener {
            startFragmentClickListener?.save()
        }
    }

    override fun onDetach() {
        super.onDetach()
        startFragmentClickListener = null
    }

    companion object {
        fun newInstance() = StartFragment()
    }
}

interface StartFragmentClickListener {
    fun save()
}