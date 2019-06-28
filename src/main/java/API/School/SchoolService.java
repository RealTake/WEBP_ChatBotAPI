package API.School;

import kr.go.neis.api.School;
import kr.go.neis.api.SchoolException;
import kr.go.neis.api.SchoolMenu;
import kr.go.neis.api.SchoolSchedule;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SchoolService {
    private Date date = new Date();
    private School SCHOOL;
    private String SCHOOL_CODE = "B100000662";
    private String SCHOOL_NAME = "한세사이버보안고등학교";

    SchoolService() throws SchoolException {
        SCHOOL = School.find(School.Region.SEOUL, SCHOOL_NAME);
    }

    private int getDate(String point){
        return Integer.parseInt(new SimpleDateFormat(point).format(date));
    }

    public String getLunch(){
        try {
            int year = getDate("yyyy");
            int month = getDate("MM");
            int day = getDate("dd");

            List<SchoolMenu> menu = SCHOOL.getMonthlyMenu(year, month);

            return menu.get(day - 1).lunch;

        } catch (SchoolException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSchedule(int year, int month, int day){
        try {
            List<SchoolSchedule> schedule = SCHOOL.getMonthlySchedule(year, month);

            return schedule.get(day - 1).toString();

        } catch (SchoolException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSchedule(){
        try {
            int year = getDate("yyyy");
            int month = getDate("MM");
            int day = getDate("dd");

            List<SchoolSchedule> schedule = SCHOOL.getMonthlySchedule(year, month);

            return schedule.get(day - 1).toString();

        } catch (SchoolException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLunch(int year, int month, int day){
        try {
            List<SchoolMenu> menu = SCHOOL.getMonthlyMenu(year, month);

            return menu.get(day - 1).lunch;

        } catch (SchoolException e) {
            e.printStackTrace();
            return null;
        }
    }
}
