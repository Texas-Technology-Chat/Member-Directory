package memberdirectory

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SkillServiceSpec extends Specification {

    SkillService skillService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Skill(...).save(flush: true, failOnError: true)
        //new Skill(...).save(flush: true, failOnError: true)
        //Skill skill = new Skill(...).save(flush: true, failOnError: true)
        //new Skill(...).save(flush: true, failOnError: true)
        //new Skill(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //skill.id
    }

    void "test get"() {
        setupData()

        expect:
        skillService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Skill> skillList = skillService.list(max: 2, offset: 2)

        then:
        skillList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        skillService.count() == 5
    }

    void "test delete"() {
        Long skillId = setupData()

        expect:
        skillService.count() == 5

        when:
        skillService.delete(skillId)
        sessionFactory.currentSession.flush()

        then:
        skillService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Skill skill = new Skill()
        skillService.save(skill)

        then:
        skill.id != null
    }
}
