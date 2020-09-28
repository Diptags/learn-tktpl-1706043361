package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.presentation.contracts

interface MainActivityContract {

    interface Model {
        fun saveData(data: Map<String, Any>)
        fun getData() : String
    }

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun submitDataToModel(data: Map<String, Any>)
        fun getDataFromModel()
    }
}
