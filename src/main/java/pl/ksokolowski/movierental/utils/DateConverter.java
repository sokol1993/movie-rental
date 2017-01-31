package pl.ksokolowski.movierental.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.ksokolowski.movierental.service.RentService;

public class DateConverter implements Converter<String, Date> {

	@Autowired
	RentService rentService;
	
	@Override
	public Date convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            return null;
        }
	}
}