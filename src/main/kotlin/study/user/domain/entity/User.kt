package study.user.domain.entity

class User (
    private var id: Long,
    private var name: String?,
    private var mobilePhoneNumber: String){

    companion object{
        fun register(id:Long, name:String?, mobilePhoneNumber: String): User {
            return User(id=id, name=name, mobilePhoneNumber=mobilePhoneNumber)
        }
    }
    public fun getId():Long = id
}