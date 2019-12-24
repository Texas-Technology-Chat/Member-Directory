package memberdirectory

class Skill {
    String name

    static hasMany = [users:User]
    static belongsTo = [User]

    static constraints = {
        name unique: true
    }
}
