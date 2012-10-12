package agricloud

class UserController {
    static scaffold = true

    def login = {
        render (contentType: 'text/json') {
            [
                success: true,
                session: new Date().toString().encodeAsMD5()
            ]
        }
    }
}
