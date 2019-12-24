package memberdirectory

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import memberDirectory.Skill
import memberDirectory.SkillService

import static org.springframework.http.HttpStatus.*


@Secured(['permitAll'])
class SkillController {

    SkillService skillService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond skillService.list(params), model:[skillCount: skillService.count()]
    }

    def show(Long id) {
        respond skillService.get(id)
    }

    def save(Skill skill) {
        if (skill == null) {
            render status: NOT_FOUND
            return
        }

        try {
            skillService.save(skill)
        } catch (ValidationException e) {
            respond skill.errors, view:'create'
            return
        }

        respond skill, [status: CREATED, view:"show"]
    }

    def update(Skill skill) {
        if (skill == null) {
            render status: NOT_FOUND
            return
        }

        try {
            skillService.save(skill)
        } catch (ValidationException e) {
            respond skill.errors, view:'edit'
            return
        }

        respond skill, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        skillService.delete(id)

        render status: NO_CONTENT
    }
}
