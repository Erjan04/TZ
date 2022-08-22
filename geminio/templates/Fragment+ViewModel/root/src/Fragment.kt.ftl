package ${packageName}

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import kg.erjan.core.base.BaseFragment
import kg.erjan.tz.databinding.${fragmentBinding}
import javax.inject.Inject

class ${fragmentName} : BaseFragment<${viewModelName}, ${fragmentBinding}>(
    ${fragmentBinding}::inflate
) {

    override val viewModel: ${viewModelName} by lazy {
        ViewModelProvider(requireActivity(), vmFactory)[${viewModelName}::class.java]
    }

    @Inject
    lateinit var vmFactory: ${viewModelFactoryName}

    override fun initialize() {

    }

    override fun onAttach(context: Context) {

    }

    override fun setupObservers() {

    }

    override fun setupListeners() {

    }
}