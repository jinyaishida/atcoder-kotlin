package coder13

class Coder13 {
    fun main(args: Array<String>) {
        fun sendMessageToClient(
            client: Client?,
            message: String?,
            mailer: Mailer
        ) {
            val email = client?.personalInfo?.email
            if (email != null && message != null) {
                mailer.sendMessage(email, message)
            }
        }
    }
        class Client(
            val personalInfo: PersonalInfo?
            )
        class PersonalInfo(
            val email: String?
            )
        interface Mailer {
            fun sendMessage(
                email: String, message: String
            )
        }
}