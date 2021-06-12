import axios from 'axios';
import {HOST_URL} from '../Constants'


class CountryService{
	
	
	getCountryData(){
		const country_vacc_url = HOST_URL + '/country';
		return axios.get(country_vacc_url);
	}

	
	

}

export default new CountryService();