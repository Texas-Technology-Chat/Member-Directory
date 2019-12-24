package memberdirectory

import memberDirectory.Role
import memberDirectory.Skill
import memberDirectory.User
import memberDirectory.UserRole

class BootStrap {
    def skillService

    def init = { servletContext ->
        environments {
            development {
                Role userRole = new Role(authority: 'ROLE_USER').save()
                Role adminRole = new Role(authority: 'ROLE_ADMIN').save()

                List<String> userList = ['admin', 'user_1', 'user_2']
                userList.each {
                    User user = new User(username: it, password: "password").save()
                    UserRole.create(user, userRole)
                    if (it == 'admin'){
                        UserRole.create(user, adminRole)
                    }
                }


                User user = User.findByUsername('user_1')
                List<String> skillList = ['Neo4J', 'Linux', 'Javascript', 'Python']
                skillList.each { skill ->
                    Skill currentSkill = new Skill(name: skill)
                    skillService.save(currentSkill)
                    user.addToSkills(currentSkill)
                }
            }
        }

    }
    def destroy = {
    }
}
