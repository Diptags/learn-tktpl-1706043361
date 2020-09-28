package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.presentation.presenters

import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.presentation.contracts.MainActivityContract.*
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.data.MainActivityModel

class MainActivityPresenter(_view: View) : Presenter {

    private var view: View = _view
    private var model: Model = MainActivityModel()

    init {
        view.initView()
    }

    override fun submitDataToModel(data: Map<String, Any>) {
        model.saveData(data)
        view.updateViewData()
    }

    override fun getDataFromModel() {
        model.getData()
    }
}