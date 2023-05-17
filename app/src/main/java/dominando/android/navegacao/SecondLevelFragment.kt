package dominando.android.navegacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dominando.android.navegacao.databinding.FragmentSecondLevelBinding

class SecondLevelFragment : Fragment() {

    private var _binding: FragmentSecondLevelBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondLevelBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(EXTRA_TEXT)?.let {
            binding?.textView?.text = it
        }
        arguments?.getInt(EXTRA_TEXT_COLOR)?.let {
            binding?.textView?.setTextColor(it)
        }
        arguments?.getInt(EXTRA_BG_COLOR)?.let {
            view.setBackgroundColor(it)
        }
    }

    companion object {
        private const val EXTRA_TEXT = "texto"
        private const val EXTRA_BG_COLOR = "corBg"
        private const val EXTRA_TEXT_COLOR = "corTexto"

        fun newInstance(text: String, background: Int, textColor: Int): SecondLevelFragment {
            val params = Bundle()
            params.putString(EXTRA_TEXT, text)
            params.putInt(EXTRA_BG_COLOR, background)
            params.putInt(EXTRA_TEXT_COLOR, textColor)
            val slf = SecondLevelFragment()
            slf.arguments = params
            return slf
        }
    }

}