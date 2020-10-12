package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.repositories

import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user.UserHelper
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.User
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user.UserService
import io.reactivex.Single

class UserRepository(private val userHelper: UserHelper) {

    fun getUsers(): Single<List<User>> {
        return userHelper.getUsers()
    }
}

//class LocalRepository @Inject constructor(studentDao: StudentDao, compositeDisposable: CompositeDisposable) {
//
//    // Dependency Injection yang didefinisikan di berkas ApplicationModule
//    var stDao: StudentDao = studentDao
//    var comp: CompositeDisposable = compositeDisposable
//
//    fun getAllData(): LiveData<List<Student>> {
//        return LiveDataReactiveStreams.fromPublisher(stDao.getAll()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.computation()))
//    }
//
//    fun insertData(student: Student) {
//        comp.add(Observable.fromCallable { stDao.insert(student) }
//            .subscribeOn(Schedulers.computation())
//            .subscribe())
//    }
//
//    fun getDataById(id: String): LiveData<Student> {
//        return LiveDataReactiveStreams.fromPublisher(stDao.getById(id)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.computation()))
//    }
//
//    fun deleteData(student: Student) {
//        comp.add(Observable.fromCallable { stDao.delete(student) }
//            .subscribeOn(Schedulers.computation())
//            .subscribe())
//    }
//
//    fun updateData(id: Long, name: String, nim: String, gen: String) {
//        comp.add(Observable.fromCallable { stDao.update(id, name, nim, gen) }
//            .subscribeOn(Schedulers.computation())
//            .subscribe())
//    }
//}