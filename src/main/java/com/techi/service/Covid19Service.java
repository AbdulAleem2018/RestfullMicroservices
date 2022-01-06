package com.techi.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.techi.bindings.AllDailyCovid;
import com.techi.bindings.Covid19;
import com.techi.bindings.DailyCovid;

import reactor.core.Disposable;

@Service
public class Covid19Service {
	
	private static final String IN_COVID19_URL="https://covid-19-data.p.rapidapi.com/country/code?code=IN";
	private static final String SA_COVID19_URL="https://covid-19-data.p.rapidapi.com/country/code?code=SA";
	
	public void getLatestCountryDataByCode() {
		
		WebClient webclient=WebClient.create();
		
		Covid19[] covid19=webclient.get()
				 .uri(IN_COVID19_URL)
				 .header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
				 .header("x-rapidapi-key", "0bb714115bmsh00c2fdfeba2078ep156d63jsn49cb1ea6536f")
				 //.accept(MediaType.APPLICATION_JSON)
				 .retrieve()
				 .bodyToMono(Covid19[].class)
				 .block();
		
		System.out.println("getLatestCountryDataByCode length :"+covid19.length);
		Stream.of(covid19).forEach(System.out::println);
		
	}
	//Covid19 length :1
	//Covid19(country=India, code=IN, confirmed=34887983, recovered=34275312, critical=8944, deaths=481519, latitude=20, longitude=78, lastChange=2022-01-01T23:01:31+01:00, lastUpdate=2022-01-02T03:45:03+01:00)
	
	
	public void getDailyReportByCountryName() {
		
		WebClient webclient=WebClient.create();
		
		DailyCovid[] dailyCovid=webclient.get()
				 .uri("https://covid-19-data.p.rapidapi.com/report/country/name?name=India&date=2022-01-01")
				 .header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
				 .header("x-rapidapi-key", "0bb714115bmsh00c2fdfeba2078ep156d63jsn49cb1ea6536f")
				 .retrieve()
				 .bodyToMono(DailyCovid[].class)
				 .block();
		
		System.out.println("getDailyReportByCountryName :"+dailyCovid.length);
		Stream.of(dailyCovid).forEach(System.out::println);
		
	}
	//DailyReport Covid19 length :1
	//DailyCovid(country=India, provinces=[Provinces(province=India, confirmed=0, recovered=0, deaths=0, active=0)], latitude=20, longitude=78, date=2022-01-01)


	public void getDailyReportByCountryCode() {

		WebClient webclient = WebClient.create();

		AllDailyCovid[] allDailyCovid = webclient.get()
				.uri("https://covid-19-data.p.rapidapi.com/report/country/code?date=2022-01-04&code=it")
				.header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
				.header("x-rapidapi-key", "0bb714115bmsh00c2fdfeba2078ep156d63jsn49cb1ea6536f").retrieve()
				.bodyToMono(AllDailyCovid[].class).block();

		System.out.println("getDailyReportByCountryCode length :" + allDailyCovid.length);
		Stream.of(allDailyCovid).forEach(System.out::println);

	}
	//getDailyReportByCountryCode length :1
	//DailyCovid(country=Italy, provinces=[Provinces(province=Italy, confirmed=0, recovered=0, deaths=0, active=0)], latitude=41, longitude=12, date=2022-01-04)

	public void getLatestCountryDataByName() {

		WebClient webclient = WebClient.create();

		Covid19[] dailyCovid = webclient.get()
				.uri("https://covid-19-data.p.rapidapi.com/country?name=India")
				.header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
				.header("x-rapidapi-key", "0bb714115bmsh00c2fdfeba2078ep156d63jsn49cb1ea6536f").retrieve()
				.bodyToMono(Covid19[].class).block();

		System.out.println("getLatestCountryDataByName length :" + dailyCovid.length);
		Stream.of(dailyCovid).forEach(System.out::println);

	}
	//getLatestCountryDataByName length :1
	//Covid19(country=India, code=IN, confirmed=35018358, recovered=34321803, critical=8944, deaths=482551, latitude=20, longitude=78, lastChange=2022-01-05T05:05:06+01:00, lastUpdate=2022-01-05T05:45:04+01:00)
	
	public void getDailyReportAllCountries() {

		WebClient webclient = WebClient.create();

		AllDailyCovid[] allDailyCovid = webclient.get()
				.uri("https://covid-19-data.p.rapidapi.com/report/country/all?date=2022-01-04")
				.header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
				.header("x-rapidapi-key", "0bb714115bmsh00c2fdfeba2078ep156d63jsn49cb1ea6536f").retrieve()
				.bodyToMono(AllDailyCovid[].class).block();
		
		//List<DailyCovid> covidList=allDailyCovid.getAllDailyCovid();
		//System.out.println("getDailyReportAllCountries length :" + covidList.size());
		//covidList.forEach(System.out::println);
		System.out.println("getDailyReportAllCountries length :" + allDailyCovid.length);
		Stream.of(allDailyCovid).forEach(System.out::println);
	}
	
	public void getLatestAllCountries() {

		WebClient webclient = WebClient.create();

		Covid19[] dailyCovid = webclient.get()
				.uri("https://covid-19-data.p.rapidapi.com/country/all")
				.header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
				.header("x-rapidapi-key", "0bb714115bmsh00c2fdfeba2078ep156d63jsn49cb1ea6536f").retrieve()
				.bodyToMono(Covid19[].class).block();

		System.out.println("getLatestAllCountries length :" + dailyCovid.length);
		Stream.of(dailyCovid).forEach(System.out::println);

	}
	
	
	public void getASyncCovid19Info() {
		
		WebClient webclient=WebClient.create();
		
		Disposable disposable=webclient.get()
				 .uri(SA_COVID19_URL)
				 .header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
				 .header("x-rapidapi-key", "0bb714115bmsh00c2fdfeba2078ep156d63jsn49cb1ea6536f")
				 .retrieve()
				 .bodyToMono(Covid19[].class)
				 .subscribe(System.out::println);
		System.out.println("disposable :"+disposable.toString());
	}
}