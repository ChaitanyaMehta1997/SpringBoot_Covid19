import React from 'react';
import CountryService from '../services/CountryService';

class CountryComponent extends React.Component{
	
	constructor(props){
		super(props)
		this.state = {
			data: []
		}
	}
	
	componentDidMount(){
		CountryService.getCountryData().then((response) => {
			this.setState({data: response.data})
		
		});
	
	}

	render(){
		
		return(
			
			<div>
				<h1 className = "text-center">Country List</h1>
				<table className = "table table-striped">
					<thread>
						<tr>
			
							<td>Country name</td>
							<td>Number of Vaccinations</td>
						</tr>
					</thread>
					<tbody>
						{
							this.state.data.map(
								data =>
								<tr key = {data.id}>
									
									<td>{data.name}</td>
									<td>{data.people_vaccinated}</td>
								</tr>
							
							)
						}
					</tbody>
				</table>
			</div>
		) 
	
	}

}
export default CountryComponent;
