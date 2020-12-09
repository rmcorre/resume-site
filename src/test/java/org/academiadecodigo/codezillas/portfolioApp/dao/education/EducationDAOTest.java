package org.academiadecodigo.codezillas.portfolioApp.dao.education;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = PortfolioApplication.class)
public class EducationDAOTest {

    @Autowired
    private EducationDAO educationDAO;

    @Test
    public void find_basic() {
        Education education = educationDAO.find(1);

        assertEquals("Concordia College University", education.getInstitution());
        assertEquals("Bachelor of Arts", education.getCourse());
        assertEquals("Sep 1992", education.getStartDate());
        assertEquals("May 1995", education.getEndDate());
    }

    @Test
    public void findAll_basic() {
        List<Education> educationList = educationDAO.findAll();

        assertEquals(1, educationList.get(0).getId());
        assertEquals(2, educationList.get(1).getId());
    }

    @Test
    @DirtiesContext
    public void save_basic() {
        Education education = new Education();

        education.setId(3);
        education.setVersion(0);
        education.setCreationTime(new Date());
        education.setUpdateTime(new Date());
        education.setInstitution("Freecodecamp");
        education.setCourse("Web Development");
        education.setStartDate("Apr 1996");
        education.setEndDate("Ongoing");
        educationDAO.saveOrUpdate(education);

        Education education1 = educationDAO.find(3);

        assertEquals("Freecodecamp", education1.getInstitution());
    }

    @Test
    @DirtiesContext
    public void update_basic() {
        Education education = educationDAO.find(1);
        education.setInstitution("Concordia College University of Edmonton");
        educationDAO.saveOrUpdate(education);

        Education education1 = educationDAO.find(1);

        assertEquals("Concordia College University of Edmonton", education1.getInstitution());
    }

    @Test
    @DirtiesContext
    public void delete_basic() {
        educationDAO.delete(2);

        assertNull(educationDAO.find(2));
    }
}
