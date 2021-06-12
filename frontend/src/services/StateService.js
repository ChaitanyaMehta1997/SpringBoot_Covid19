import axios from 'axios';
import {HOST_URL} from '../Constants'


class StateService{
	
    getStates(country){
        const state_url = HOST_URL + `${country}/states`;
        console.log(state_url);
        return axios.get(state_url, {
            headers: { "Content-Type": "application/json" }
          });
    
    }
}

export default new StateService();