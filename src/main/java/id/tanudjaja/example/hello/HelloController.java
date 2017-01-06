
package id.tanudjaja.example.hello;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class HelloController
{
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public ResponseEntity<String> auth(
        @RequestParam(value="name", required=false) String aName)
    {
        // compose head
        final String head="<head><title>Spring Hello</title></head>";
        
        // get time
        final int hour=LocalDateTime.now().getHour();
        String greeting="";
        if(hour >= 4 && hour <= 10)
        {
            greeting="Good morning, %s!";
        }
        else if(hour >= 11 && hour <= 15)
        {
            greeting="Good day, %s!";
        }
        else if(hour >= 16 && hour <= 18)
        {
            greeting="Good afternoon, %s!";
        }
        else if(hour >= 19 && hour <= 22)
        {
            greeting="Good evening, %s!";
        }
        else
        {
            greeting="Good night, %s!";
        }
        
        // compose body
        final String body=String.format("<body>"+greeting+"</body>",
            (aName!=null && aName.length() > 0) ? aName : "hoo-man");

        // compose html
        final String html="<html>"+head+body+"</html>";
        
        return new ResponseEntity<String>(html, HttpStatus.OK);
    }
};
