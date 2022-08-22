package kg.erjan.tz.presentation.fragment.gallery

import android.Manifest
import android.content.Context
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kg.erjan.core.base.BaseFragment
import kg.erjan.core.extensions.Utils
import kg.erjan.tz.appComponent
import kg.erjan.tz.databinding.FragmentGalleryBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class GalleryFragment : BaseFragment<GalleryViewModel, FragmentGalleryBinding>(
    FragmentGalleryBinding::inflate
) {

    override val viewModel: GalleryViewModel by lazy {
        ViewModelProvider(requireActivity(), vmFactory)[GalleryViewModel::class.java]
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.getImage()
        }
    }

    private val adapter: GalleryAdapter by lazy {
        GalleryAdapter()
    }

    @Inject
    lateinit var vmFactory: GalleryViewModelFactory

    override fun initialize() {
        binding.recycler.apply {
            adapter = this@GalleryFragment.adapter
            layoutManager = GridLayoutManager(context, 3)
        }
        if (Utils.checkedReadPermissionForGallery(requireContext())) {
            viewModel.getImage()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun setupObservers() {
        lifecycleScope.launch {
            viewModel.getImageState.collect {
                adapter.submitList(it)
            }
        }
    }
}