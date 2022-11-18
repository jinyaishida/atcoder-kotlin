### 問題13

Learn about null safety and safe calls in Kotlin and rewrite the following Java code so that it only has one if expression:

    public void sendMessageToClient(
    @Nullable Client client,
    @Nullable String message,
    @NotNull Mailer mailer
    ) {
    if (client == null || message == null) return;
    ​
    PersonalInfo personalInfo = client.getPersonalInfo();
    if (personalInfo == null) return;
    ​
    String email = personalInfo.getEmail();
    if (email == null) return;
    ​
    mailer.sendMessage(email, message);
    }

解答

    fun sendMessageToClient(
    client: Client?, 
    message: String?, 
    mailer: Mailer
    ) {
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
    mailer.sendMessage(
    email, message
    )
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
    email: String, 
    message: String
    )
    }

知識

    null許容型を使っているので、clientとmessageのnullチェックは不要
    
    val email = client?.personalInfo?.emailで、
    clientとpersonalInfoの両方がnullでなければ、emailを代入。
    
    emailとmessageがnullでなければ、sendMessageメソッドに値を渡す


