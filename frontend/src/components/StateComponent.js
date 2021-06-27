import axios from 'axios';
import React from 'react';
import {Link} from "react-router-dom";

import StateService from '../services/StateService';
import '../State.css';



class StateComponent extends React.Component{
	
	constructor(props){
		super(props)
		this.state = {
			states: [],
			countryName: '',
			
		}
	}
	
	componentDidMount(){
		this.state.countryName  = this.props.match.params.name;
		StateService.getStates(this.props.match.params.name).then((response) => {
			this.setState({states: response.data})
		
		});
	}

	handleClick = (e) => {
		this.setState({
			[e.target.name]: e.target.value
		  })
	}

	createStateTable(){
		//Time complexity = O(N)
		
		let table = []
		const numberOfStates = this.state.states.length;
		console.log("c name"+this.props.match.params.name);
		for(let i = 0; i < numberOfStates;i++){
			let children = []
			children.push(<td>{`${this.state.states[i]}`}</td>)
			children.push(<Link to =  {"/"+this.state.countryName+"/states/"+this.state.states[i]}><td><button type="button" class="btn btn-primary" ><i class="far fa-eye"></i>select</button></td></Link>)
		
			table.push(<tr>{children}</tr>)
		}
		return table
	  }
	
	render(){
		
		return(
			
			<div className="table-responsive">
				<h1 className = "text-center">States in {this.props.match.params.name}</h1>
				<table className = "stateTable">
					<tbody>
        				{this.createStateTable()}
					</tbody>
      			</table>
			</div>
		) 
	
	}

}
export default StateComponent;
