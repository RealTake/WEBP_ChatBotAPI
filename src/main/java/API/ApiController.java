package API;

import API.School.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @Autowired
    SchoolService service;

    @ResponseBody
    @GetMapping(value = "/lunch", produces = "application/json; charset=UTF-8")
    public String lunch(){ return service.getLunch(); }

    @ResponseBody
    @GetMapping(value = "/lunch/{year}/{month}/{day}", produces = "application/json; charset=UTF-8")
    public String lunch(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day") int day){
            return  service.getLunch(year, month, day);
    }

    @ResponseBody
    @GetMapping(value = "/schedule", produces = "application/json; charset=UTF-8")
    public String Schedule(){ return service.getSchedule(); }

    @ResponseBody
    @GetMapping(value = "/schedule/{year}/{month}/{day}", produces = "application/json; charset=UTF-8")
    public String Schedule(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day") int day){
        return  service.getSchedule(year, month, day);
    }
}
