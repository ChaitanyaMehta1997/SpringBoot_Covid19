import logo from './logo.svg';

import CountryComponent from './components/CountryComponent';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import StateComponent from './components/StateComponent';
import CityComponent from './components/CityComponent';
function App() {
  return (
    
    <Router>
    <div className="App">
      <header className="App-header">
        <Switch>
          <Route exact  path = "/"  exact component={CountryComponent}></Route>
          <Route exact  path = "/:name/states"  exact component={StateComponent}></Route>
          <Route exact  path = "/:CountryName/states/:stateName"  exact component={CityComponent}></Route>
        </Switch>
      
        
      </header>
    </div>
    </Router>
  );
}

export default App;
