package dominando.android.navegacao

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dominando.android.navegacao.databinding.FragmentFirstLevelBinding

class FirstLevelFragment : Fragment() {

    private var navigationType: String? = null
    private var actions = mutableMapOf<String,Class<*>>()

    private var _binding: FragmentFirstLevelBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actions.put(getString(R.string.option_tab), TabsActivity::class.java)
        actions.put(getString(R.string.option_bottom), BottomNavActivity::class.java)
        actions.put(getString(R.string.option_pager), PagerActivity::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstLevelBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationType = arguments?.getString(EXTRA_TYPE)
        binding?.button?.setOnClickListener {
            val key = navigationType
            val clazz = actions[key]
            startActivity(Intent(activity, clazz))
        }
        binding?.textView?.text = navigationType
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val EXTRA_TYPE = "tipoNavegacao"

        fun newInstance(type: String): FirstLevelFragment {
            val params = Bundle()
            params.putString(EXTRA_TYPE, type)
            val f = FirstLevelFragment()
            f.arguments = params
            return f
        }
    }

}