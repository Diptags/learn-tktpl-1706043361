package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.utils.ViewModelKey

//import me.ibrahimsn.viewmodel.ui.list.ListViewModel;
//import me.ibrahimsn.viewmodel.ui.detail.DetailsViewModel;
//import me.ibrahimsn.viewmodel.di.util.ViewModelKey;
//import me.ibrahimsn.viewmodel.util.ViewModelFactory;

// Module untuk dependency injection tingkat ViewModel
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}