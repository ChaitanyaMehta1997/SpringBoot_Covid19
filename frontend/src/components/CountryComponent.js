import axios from 'axios';
import React from 'react';
import CountryService from '../services/CountryService';
import {Link} from "react-router-dom";
import '../Country.css';


class CountryComponent extends React.Component{
	
	constructor(props){
		super(props)
		this.state = {
			data: [],
			countryName: '',
			
		}
	}
	
	componentDidMount(){
		CountryService.getCountryData().then((response) => {
			this.setState({data: response.data})
		
		});
	
	}

	componentDidUpdate(){}

	handleClick = (e) => {
		 this.setState({
			[e.target.name]: e.target.value
		  });
		
	
		 
	}
	render(){
		
		return(
			
			<div>
				<h1 className = "text-center">Country List</h1>
				<Link to = {this.state.data.map(data=>data.name)+"/states"}>
					<button class="button" name="countryName" onClick={this.handleClick} value ={this.state.data.map(data=>data.name)}>{this.state.data.map(data=>data.name)}</button>					
				</Link> 
			</div>
		) 
	
	}

}
export default CountryComponent;
