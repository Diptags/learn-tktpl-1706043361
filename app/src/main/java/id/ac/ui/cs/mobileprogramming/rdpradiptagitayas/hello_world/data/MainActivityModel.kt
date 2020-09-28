package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.data

import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.presentation.contracts.MainActivityContract.Model

class MainActivityModel : Model {

    private var formData = ""

    override fun saveData(data: Map<String, Any>) {
        formData = """
        Nama        : ${data.getValue("name")}
        NPM         : ${data.getValue("npm")}
        Username    : ${data.getValue("username")}
        Email       : ${data.getValue("email")}
        """.trimIndent()
    }

    override fun getData(): String = formData
}