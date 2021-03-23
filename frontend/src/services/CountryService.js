import axios from 'axios';


const country_vacc_url = 'http://localhost:8080/api/covid';

class CountryService{

	getCountryData(){
		
		return axios.get(country_vacc_url);
	}

}

export default new CountryService();