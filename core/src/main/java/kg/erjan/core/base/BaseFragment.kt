package kg.erjan.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<ViewModel : BaseViewModel, Binding : ViewBinding>(
    private val inflate: Inflate<Binding>
) : Fragment() {

    protected abstract val viewModel: ViewModel

    private var _binding: Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListeners()
        setupObservers()
    }

    protected open fun initialize() {

    }

    protected open fun setupListeners() {

    }

    protected open fun setupObservers() {

    }
}
