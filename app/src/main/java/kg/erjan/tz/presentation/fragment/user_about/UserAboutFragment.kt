package kg.erjan.tz.presentation.fragment.user_about

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import kg.erjan.core.base.BaseFragment
import kg.erjan.tz.R
import kg.erjan.tz.appComponent
import kg.erjan.tz.databinding.FragmentUserAboutBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserAboutFragment : BaseFragment<UserAboutViewModel, FragmentUserAboutBinding>(
    FragmentUserAboutBinding::inflate
) {

    override val viewModel: UserAboutViewModel by lazy {
        ViewModelProvider(requireActivity(), vmFactory)[UserAboutViewModel::class.java]
    }

    @Inject
    lateinit var vmFactory: UserAboutViewModelFactory

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun setupObservers() {
        lifecycleScope.launch {
            viewModel.getUserInfoState.collect {
                it?.let {
                    binding.ivPhoto.load(it.photo)
                    binding.tvFirstName.text = it.firstName
                    binding.tvSecondName.text = it.secondName
                    binding.tvEducation.text = it.education
                    binding.tvExperience.text = it.experience
                    binding.tvCompany.text = it.company[0].name
                    binding.tvPosition.text = it.company[0].position
                }
            }
        }
    }

    override fun setupListeners() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.galleryFragment)
        }
    }
}