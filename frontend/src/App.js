import logo from './logo.svg';

import CountryComponent from './components/CountryComponent';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import StateComponent from './components/StateComponent';
function App() {
  return (
    
    <Router>
    <div className="App">
      <header className="App-header">
        <Switch>
          <Route path = "/" exact component={CountryComponent}></Route>
          <Route path = "/:name/states" exact component={StateComponent}></Route>
        </Switch>
      
        
      </header>
    </div>
    </Router>
  );
}

export default App;
