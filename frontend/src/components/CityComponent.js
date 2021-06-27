import axios from 'axios';
import React from 'react';
import {HOST_URL} from '../Constants'

import '../State.css';



class CityComponent extends React.Component{
	
	constructor(props){
		super(props)
		this.state = {
            cities : [],
			stateName : "",
            countryName : "",
        }
	}
	
	componentDidMount(){
        this.state.countryName = this.props.match.params.CountryName;
		this.state.stateName = this.props.match.params.stateName;
		console.log("HEyyy,"+`${this.state.countryName}`);
        const city_url = HOST_URL + `${this.state.countryName}/states/${this.state.stateName}`;
		axios.get(city_url).then((response) => {
			this.setState({cities: response.data})
		});
	
	}

	handleClick = (e) => {
		this.setState({
			[e.target.name]: e.target.value
		  })
	}

	createCityTable(){
		//Time complexity = O(N)
		
		let table = []
		const numberOfCities = this.state.cities.length;
		console.log(numberOfCities);
		for(let i = 0; i < numberOfCities;i++){
			let children = []
			children.push(<td>{`${this.state.cities[i].name}`}</td>)
			children.push(<td><button type="button" class="btn btn-primary" ><i class="far fa-eye"></i>select</button></td>)
			
			table.push(<tr>{children}</tr>)
		}
		return table
	  }
	
	render(){
		
		return(
			
			<div class="table-responsive">
				<h1 className = "text-center">Cities in {this.state.stateName}</h1>
				<table class = "stateTable">
					<tbody>
        				{this.createCityTable()}
					</tbody>
      			</table>
			</div>
		) 
	
	}

}
export default CityComponent;
